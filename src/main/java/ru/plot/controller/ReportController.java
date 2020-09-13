package ru.plot.controller;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import ru.plot.entity.ReportDetails;
import ru.plot.repo.DataDayReportRepository;
import ru.plot.service.PermissionService;
import ru.plot.entity.Okv;
import ru.plot.entity.Organizations;
import ru.plot.repo.OkvRepository;
import ru.plot.repo.OrganizationsRepository;

import javax.annotation.security.RolesAllowed;
import java.io.*;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/report")
@RolesAllowed("ROLE_ADMIN")
public class ReportController {

    @Autowired
    private OrganizationsRepository organizationsRepository;

    @Autowired
    private OkvRepository okvRepository;

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
        //Справочник организаций
        List<Organizations> organizations = organizationsRepository.findAll();
        model.addAttribute("organizations", organizations);

        //Справочник валют
        Iterable<Okv> okvCodes = okvRepository.findAll();
        model.addAttribute("okvCodes", okvCodes);
        model.addAttribute("perms", permissionService.getUserPermissions());

        model.addAttribute("reportDetails", new ReportDetails());

        return "/report/balance-form";
    }

    @RequestMapping(value="/reportDetails", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute ReportDetails rep, Model model) {
        model.addAttribute("reportDetails", rep);
        return "result";
    }

    @GetMapping("/downloadXls")
    public ResponseEntity<StreamingResponseBody> getFile() throws IOException {
        FileInputStream file = new FileInputStream(new File("src/main/resources/xls/finReport.xlsx"));
        Workbook workBook = new XSSFWorkbook(file);

        Sheet sheet = workBook.getSheet("Данные");
        Row row = sheet.createRow(11);
        row.createCell(0).setCellValue("Hello World");

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"123.xlsx\"")
                .body(workBook::write);
    }
}
