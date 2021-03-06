package ru.plot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plot.dto.ReportDto;
import ru.plot.entity.*;
import ru.plot.jaxb.rosatom.Bank;
import ru.plot.jaxb.rosatom.*;
import ru.plot.repo.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    ReportsRepository reportRepository;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    TypeDogRepository typeDogRepository;
    @Autowired
    VReportHeaderRepository vReportHeaderRepository;
    @Autowired
    VSaveReportsOrgsXmlRepository vSaveReportsOrgsXmlRepository;
    @Autowired
    VSaveReportsBanksXmlRepository vSaveReportsBanksXmlRepository;
    @Autowired
    VSaveReportsValbalXmlRepository vSaveReportsValbalXmlRepository;
    @Autowired
    VSaveReportsDogsXmlRepository vSaveReportsDogsXmlRepository;




    @Autowired
    OrganizationsRepository organizationsRepository;

    public ReportBalance convertToJaxb(Reports report) throws DatatypeConfigurationException {

        ReportBalance reportBalance = new ReportBalance();

        Optional<VReportHeader> vReportHeader = vReportHeaderRepository.findById(report.getId());
        if (vReportHeader.isPresent()) {
            VReportHeader reportHeader = vReportHeader.get();

            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(report.getDateReport().toString());
            reportBalance.setOnDate(xmlDate);
            CompilerReport compilerReport = new CompilerReport();
            compilerReport.setOrgName(reportHeader.getListOrg());
            compilerReport.setInn(reportHeader.getListInn());
            reportBalance.setCompilerReport(compilerReport);
            Responsible responsible = new Responsible();
            responsible.setFIO(reportHeader.getSecondname() + " " + reportHeader.getFirstname() + " " + reportHeader.getMiddlename());
            responsible.setPhone(reportHeader.getUserPhone());
            responsible.setEmail(reportHeader.getUserEmail());
            reportBalance.setResponsible(responsible);
        }

        ReportBalance.Organizations organizations = new ReportBalance.Organizations();
        reportBalance.setOrganizations(organizations);

        List<VSaveReportsOrgsXml> vSaveReportsOrgsXmls = vSaveReportsOrgsXmlRepository.findByIdReport(report.getId());
        for (VSaveReportsOrgsXml vSaveReportsOrgsXml : vSaveReportsOrgsXmls){
            Organization organization = new Organization();
            organization.setId(vSaveReportsOrgsXml.getExternalId());
            organizations.getOrganization().add(organization);
            Organization.Banks banks = new Organization.Banks();
            organization.setBanks(banks);
            List<VSaveReportsBanksXml> vSaveReportsBanksXmls = vSaveReportsBanksXmlRepository.findByIdReportAndExternalId(vSaveReportsOrgsXml.getIdReport(), vSaveReportsOrgsXml.getExternalId());
            for (VSaveReportsBanksXml vSaveReportsBanksXml : vSaveReportsBanksXmls) {
                Bank bank = new Bank();
                bank.setBankName(vSaveReportsBanksXml.getBankName());
                bank.setBik(vSaveReportsBanksXml.getBankBik());
                banks.getBank().add(bank);
                Bank.Balances balances = new Bank.Balances();
                bank.setBalances(balances);
                List<VSaveReportsValbalXml> vSaveReportsValbalXmls = vSaveReportsValbalXmlRepository.findByIdReportAndExternalIdAndBankBikAndBankName(
                        vSaveReportsBanksXml.getIdReport(), vSaveReportsBanksXml.getExternalId(),
                        vSaveReportsBanksXml.getBankBik(), vSaveReportsBanksXml.getBankName());
                for (VSaveReportsValbalXml vSaveReportsValbalXml : vSaveReportsValbalXmls){
                    Balance balance = new Balance();
                    balance.setBalance(vSaveReportsValbalXml.getBalanceSumm().doubleValue());
                    balance.setCurrency(vSaveReportsValbalXml.getValCode());
                    balances.getBalance().add(balance);
                    Balance.Contracts contracts = new Balance.Contracts();
                    balance.setContracts(contracts);
                    List<VSaveReportsDogsXml> vSaveReportsDogsXmls = vSaveReportsDogsXmlRepository.findByIdReportAndExternalIdAndBankBikAndBankNameAndValCode(
                            vSaveReportsValbalXml.getIdReport(),
                            vSaveReportsValbalXml.getExternalId(),
                            vSaveReportsValbalXml.getBankBik(),
                            vSaveReportsValbalXml.getBankName(),
                            vSaveReportsValbalXml.getValCode()
                    );
                    for (VSaveReportsDogsXml vSaveReportsDogsXml : vSaveReportsDogsXmls) {
                        Contract contract = new Contract();
                        contract.setContractBalance(vSaveReportsDogsXml.getOperSum().doubleValue());
                        contract.setConractCurrency(vSaveReportsDogsXml.getValCodeDog());
                        contract.setContractPercent(vSaveReportsDogsXml.getPercent().doubleValue());
                        XMLGregorianCalendar createDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(vSaveReportsDogsXml.getSignDog().toInstant().toString());
                        contract.setContractCreateDate(createDate);
                        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(vSaveReportsDogsXml.getStartDog().toInstant().toString());
                        contract.setContractStartDate(startDate);
                        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(vSaveReportsDogsXml.getEndDog().toInstant().toString());
                        contract.setContractEndDate(endDate);
                        contract.setContractType(vSaveReportsDogsXml.getTypeDog());
                        contracts.getContract().add(contract);
                    }
                }

            }

        }

        return reportBalance;



    }

    public String getXmlString (String id) throws DatatypeConfigurationException, JAXBException {
        Optional<Reports> reportsO = reportRepository.findById(BigInteger.valueOf(Long.valueOf(id)));
        if (reportsO.isPresent()) {
            ReportBalance reportBalance = convertToJaxb(reportsO.get());
            JAXBContext jaxbContext = JAXBContext.newInstance(ReportBalance.class);
            ObjectFactory objectFactory = new ObjectFactory();
            JAXBElement<ReportBalance> response = objectFactory.createReportBalance(reportBalance);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(response, sw);
            return sw.toString();
        }
         return null;
    };

    public List<Reports> getAllReports () {
        return reportRepository.findAll();
    }


    /**
     * метод добавления детализации
     * @param rep
     */
    public void addDetails(ReportDto rep) {
        Optional<Reports> byId = reportRepository.findById(rep.getReportId());
        if (!byId.isPresent()) throw new IllegalStateException();
        Reports report = byId.get();
        ReportDetails details = new ReportDetails();
        details.setNpp(report.getReportDetails().size()+1);
        details.setBalanceSumm(rep.getBalanceSumm());
        Optional<ru.plot.entity.Bank> byId1 = bankRepository.findById(rep.getBankId());
        if(byId1.isPresent()) {
            ru.plot.entity.Bank bank = byId1.get();
            details.setBank(bank);
            details.setBankName(bank.getNamep());
            details.setBankBik(bank.getBik());
        }
        details.setComment(rep.getComment());
        details.setEndDog(rep.getEndDog());
        details.setOperSum(rep.getOperSum());
        Optional<Organizations> byId2 = organizationsRepository.findById(rep.getOrgId());
        if (byId2.isPresent()) {
            Organizations org = byId2.get();
            details.setOrganization(byId2.get());
            details.setOrgInn(org.getOrgInn());
            details.setOrgKpp(org.getOrgKpp());
            details.setOrgName(org.getFullName());
        }
        Optional<TypeDog> byId3 = typeDogRepository.findById(rep.getTypeDogId());
        if(byId3.isPresent()) {
            details.setTypeDog(byId3.get());
            details.setTypeDogName(byId3.get().getNameType());

        }
        details.setPercent(rep.getPercent());
        details.setSignDog(rep.getSignDog());
        details.setStartDog(rep.getStartDog());
        details.setValCode(rep.getValCode());
        details.setValCodeDog(rep.getValCodeDog());
        details.setReport(report);
        report.getReportDetails().add(details);
        reportRepository.save(report);
    }
}
