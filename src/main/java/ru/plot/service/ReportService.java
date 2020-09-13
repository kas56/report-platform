package ru.plot.service;

import ru.plot.dto.ReportDto;
import ru.plot.entity.VSaveReportsValbalXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plot.entity.*;
import ru.plot.jaxb.rosatom.*;
import ru.plot.jaxb.rosatom.Bank;
import ru.plot.repo.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    ReportsRepository reportRepository;
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

    public ReportBalance convertToXml(Reports report) throws DatatypeConfigurationException {

        ReportBalance reportBalance = new ReportBalance();

        Optional<VReportHeader> vReportHeader = vReportHeaderRepository.findById(report.getId());
        if (vReportHeader.isPresent()) {
            VReportHeader reportHeader = vReportHeader.get();

            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(reportHeader.getDateReport());
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
        details.setBankBik(rep.getBankBik());
        details.setBankName(rep.getBankName());
        details.setComment(rep.getComment());
        details.setEndDog(rep.getEndDog());
        details.setOperSum(rep.getOperSum());
       // details.set(rep.getOrgId());
        details.setPercent(rep.getPercent());
        details.setSignDog(rep.getSignDog());
        details.setStartDog(rep.getStartDog());
        details.setTypeDog(rep.getTypeDog());
        details.setValCode(rep.getValCode());
        details.setValCodeDog(rep.getValCodeDog());
        details.setReport(report);
        report.getReportDetails().add(details);
        reportRepository.save(report);
    }
}
