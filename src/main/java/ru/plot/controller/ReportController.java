package ru.plot.controller;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import ru.plot.dto.ReportDto;
import ru.plot.entity.*;
import ru.plot.repo.*;
import ru.plot.service.ReportService;

import javax.annotation.security.RolesAllowed;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/report")
@RolesAllowed("ROLE_ADMIN")
public class ReportController {

    @Autowired
    private OrganizationsRepository organizationsRepository;

    @Autowired
    private OkvRepository okvRepository;
    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private ReportsRepository reportRepository;

    @Autowired
    private ReportDetailRepository reportDetailsRepository;

    @Autowired
    private ReportsRepository reportsRepository;

    @Autowired
    private ReportService reportService;
    @Autowired
    private TypeDogRepository typeDogRepository;

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        model.addAttribute("message", "Noname foundation");

        return "/report";
    }
    @GetMapping("/balance")
    public String balances(Model model) {
        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Reports> reports = reportsRepository.findByUser(principal);
        model.addAttribute("reports", reports);
        return "/report/balances";
    }

    @GetMapping("/all")
    public String reportAll(Model model) {

//        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Reports> reports = reportService.getAllReports();
        model.addAttribute("reportsList", reports);

        return "/report/all";
    }

    @GetMapping("/balance/{id}")
    public String balanceCard(Model model) {

        return "/report/balance";
    }

    @GetMapping("/balance/form")
    public String balanceForm(@RequestParam(required = false, value = "reportId") String reportId, Model model) {
        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (reportId==null || reportId.isEmpty()) {
            Reports report = new Reports();
            report.setDateReport(LocalDate.now());
            report.setIdUser(principal.getIdUser());
            report.setStatus(Status.DRAFT);
            Reports save = reportsRepository.save(report);
            return "redirect:/report/balance/form?reportId="+save.getId();
        } else {

            Optional<Reports> save = reportsRepository.findById(new BigInteger(reportId));
            Reports report = save.get();
            model.addAttribute("report", report);
            ReportDto reportDetail = new ReportDto();
            reportDetail.setUserId(principal.getIdUser());
            reportDetail.setDateReport(report.getDateReport());
            reportDetail.setReportId(report.getId());
            model.addAttribute("reportDetail", reportDetail);

        model.addAttribute("organizations", principal.getGrantOrgs());
        model.addAttribute("banks", bankRepository.findAll());
        model.addAttribute("typeDogs", typeDogRepository.findAll());

        //Справочник валют
        Iterable<Okv> okvCodes = okvRepository.findAll();
        model.addAttribute("okvCodes", okvCodes);
        model.addAttribute("userId", principal.getIdUser());
        model.addAttribute("userId", principal.getIdUser());

        return "/report/balance-form";
        }
    }

    @RequestMapping(value="/reportDetails", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute ReportDto rep, Model model) {
        reportService.addDetails(rep);
        model.addAttribute("reportDetails", rep);
        return "redirect:/report/balance/form?reportId="+rep.getReportId();
    }

    @GetMapping("/downloadXls")
    public ResponseEntity<StreamingResponseBody> getFile(@RequestParam String id) throws IOException {
        Long reportId = Long.valueOf(id);
        FileInputStream file = new FileInputStream(new File("src/main/resources/xls/finReport.xlsx"));
        Workbook workBook = new XSSFWorkbook(file);

        Sheet sheet = workBook.getSheetAt(0);

        Optional<Reports> reportsOpt = reportRepository.findById(BigInteger.valueOf(reportId));
        Reports reports = reportsOpt.get();
        List<ReportDetails> reportDetails = reports.getReportDetails();
        int rowInt = 10;
        for (ReportDetails reportDetail : reportDetails) {
            rowInt++;
            Row row = sheet.createRow(rowInt);
            row.createCell(0).setCellValue(reportDetail.getNpp().toString());
            row.createCell(1).setCellValue(reportDetail.getExternalId());
            row.createCell(2).setCellValue(reportDetail.getOrgInn());
            row.createCell(3).setCellValue(reportDetail.getOrgKpp());
            row.createCell(4).setCellValue(reportDetail.getOrgName());
            row.createCell(5).setCellValue(reportDetail.getMain());
            row.createCell(6).setCellValue(reportDetail.getBankBik());
            row.createCell(7).setCellValue(reportDetail.getBankName());
            row.createCell(8).setCellValue(reportDetail.getComment());
            row.createCell(9).setCellValue(reportDetail.getValCode());
            row.createCell(10).setCellValue(reportDetail.getBalanceSumm().toString());
            row.createCell(11).setCellValue(reportDetail.getTypeDogName());
            row.createCell(12).setCellValue(reportDetail.getSignDog().toString());
            row.createCell(13).setCellValue(reportDetail.getStartDog().toString());
            row.createCell(14).setCellValue(reportDetail.getEndDog().toString());
            row.createCell(15).setCellValue(reportDetail.getPercent().toString());
            row.createCell(16).setCellValue(reportDetail.getValCodeDog());
            row.createCell(17).setCellValue(reportDetail.getOperSum().toString());

        }


        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"report_"+reportId+".xlsx\"")
                .body(workBook::write);
    }

    @GetMapping( value = "/sendXml", produces ={"application/json"})
    public HttpEntity<byte[]> sendXml(@RequestParam String id) throws IOException, JAXBException, DatatypeConfigurationException {
        String xml = reportService.getXmlString(id);

        File file = new File("src/main/resources/xls/finReport_"+id+".xml");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(xml);
        fileWriter.close();

        InputStream inputStream = new FileInputStream(file);

        byte[] out = IOUtils.toByteArray(inputStream);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(new MediaType("finReport"+id+".xml", "xml"));
        responseHeaders.setContentLength(xml.getBytes().length);


        return new HttpEntity<>(xml.getBytes(), responseHeaders);

    }
}
