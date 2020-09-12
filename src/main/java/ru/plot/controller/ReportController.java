package ru.plot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/report")
public class ReportController {

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        model.addAttribute("message", "Noname foundation");

        return "/report";
    }
    @GetMapping("/balance")
    public String balances() {
        return "/report/balances";
    }

    @GetMapping("/balance/{id}")
    public String balanceCard() {
        return "/report/balance";
    }

    @GetMapping("/balance/form")
    public String balanceForm(@RequestParam(required = false, value = "reportId") String reportId) {
        return "/report/balance-form";
    }
}
