package ru.plot.controller;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import ru.plot.dto.ReportDto;
import ru.plot.entity.Okv;
import ru.plot.entity.Organizations;
import ru.plot.entity.*;
import ru.plot.repo.OkvRepository;
import ru.plot.repo.OrganizationsRepository;
import ru.plot.repo.*;
import ru.plot.service.PermissionService;
import ru.plot.repo.OkvRepository;
import ru.plot.repo.OrganizationsRepository;
import ru.plot.service.ReportService;

import javax.annotation.security.RolesAllowed;
import java.io.*;
import java.math.BigInteger;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
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
    private ReportsRepository reportRepository;

    @Autowired
    private ReportDetailRepository reportDetailsRepository;

    @Autowired
    private ReportsRepository reportsRepository;
    @Autowired
    private ReportService reportService;

    private PermissionService permissionService;

    @Autowired
    public ReportController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        model.addAttribute("message", "Noname foundation");
        model.addAttribute("perms", permissionService.getUserPermissions());

        return "/report";
    }
    @GetMapping("/balance")
    public String balances(Model model) {
        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Reports> reports = reportsRepository.findByUser(principal);
        model.addAttribute("reports", reports);
        model.addAttribute("perms", permissionService.getUserPermissions());
        return "/report/balances";
    }

    @GetMapping("/balance/{id}")
    public String balanceCard(Model model) {
        model.addAttribute("perms", permissionService.getUserPermissions());

        return "/report/balance";
    }

    @GetMapping("/balance/form")
    public String balanceForm(@RequestParam(required = false, value = "reportId") String reportId, Model model) {
        UserEntity principal = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (reportId==null || reportId.isEmpty()) {
            Reports report = new Reports();
            report.setDateReport(LocalDate.now());
            report.setIdUser(principal.getIdUser());
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

            //Справочник организаций
        List<Organizations> organizations = organizationsRepository.findAll();
        model.addAttribute("organizations", organizations);

        //Справочник валют
        Iterable<Okv> okvCodes = okvRepository.findAll();
        model.addAttribute("okvCodes", okvCodes);
        model.addAttribute("userId", principal.getIdUser());
        model.addAttribute("userId", principal.getIdUser());
        model.addAttribute("perms", permissionService.getUserPermissions());

        model.addAttribute("perms", permissionService.getUserPermissions());

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
            row.createCell(11).setCellValue(reportDetail.getSignDog().toString());
            row.createCell(12).setCellValue(reportDetail.getStartDog().toString());
            row.createCell(13).setCellValue(reportDetail.getEndDog().toString());
            row.createCell(14).setCellValue(reportDetail.getPercent().toString());
            row.createCell(15).setCellValue(reportDetail.getValCodeDog());
            row.createCell(16).setCellValue(reportDetail.getOperSum().toString());

        }


        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"123.xlsx\"")
                .body(workBook::write);
    }
}
