package ru.plot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.plot.entity.CurrencyRate;
import ru.plot.repo.CurrencyRateRepository;
import ru.plot.service.BankService;
import ru.plot.service.PermissionService;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;

@Controller
@RequestMapping("/catalog")
@RolesAllowed("ADMIN")
public class CatalogController {

    @Autowired
    CurrencyRateRepository currencyRateRepository;
    @Autowired
    private BankService bankService;


    private PermissionService permissionService;

    @Autowired
    public CatalogController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        model.addAttribute("message", "Noname foundation");
        model.addAttribute("perms", permissionService.getUserPermissions());
        System.out.println(permissionService.getUserPermissions().isAdmin());
        return "/catalog";
    }

    @GetMapping("/CurrencyRates")
    public String table1Page(Model model) {

        Iterable<CurrencyRate> currencyRates = currencyRateRepository.findAll();

        model.addAttribute("currencyRates", currencyRates);
        model.addAttribute("perms", permissionService.getUserPermissions());

        return "/catalog/CurrencyRates";
    }
    @PostMapping("/CurrencyRates")
    public String ratesUpload(Model model) {

        Iterable<CurrencyRate> currencyRates = currencyRateRepository.findAll();

        model.addAttribute("currencyRates", currencyRates);
        model.addAttribute("loadStatus", "Данные успешно загружены");

        return "/catalog/CurrencyRates";
    }

    @GetMapping("/Bics")
    public String bics(Model model) {
        model.addAttribute("bankBics", bankService.getBankBics());


        return "/catalog/Bics";
    }
    @GetMapping("/FinTrans")
    public String FinTrans(Model model) {
        model.addAttribute("finTrans", new ArrayList<>());
        return "/catalog/FinTrans.html";
    }
    @GetMapping("/Organizations")
    public String Organizations(Model model) {
        model.addAttribute("orgs", new ArrayList<>());
        return "/catalog/Organizations.html";
    }
}
