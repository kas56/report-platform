package ru.plot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.plot.entity.BankDog;
import ru.plot.entity.CurrencyRate;
import ru.plot.entity.Organizations;
import ru.plot.repo.BankDogRepository;
import ru.plot.repo.CurrencyRateRepository;
import ru.plot.repo.OrganizationsRepository;
import ru.plot.service.BankService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/catalog")
@RolesAllowed("ADMIN")
public class CatalogController {

    @Autowired
    CurrencyRateRepository currencyRateRepository;
    @Autowired
    private BankService bankService;
    @Autowired
    private OrganizationsRepository organizationsRepository;
    @Autowired
    private BankDogRepository bankDogRepository;


    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        model.addAttribute("message", "Noname foundation");

        return "/catalog";
    }

    @GetMapping("/CurrencyRates")
    public String table1Page(Model model) {

        Iterable<CurrencyRate> currencyRates = currencyRateRepository.findAll();

        model.addAttribute("currencyRates", currencyRates);

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
        List<BankDog> finTrans = bankDogRepository.findAll();
        model.addAttribute("finTrans", finTrans);
        return "/catalog/FinTrans.html";
    }
    @GetMapping("/Organizations")
    public String Organizations(Model model) {
        List<Organizations> orgs =  organizationsRepository.findAll();
        model.addAttribute("orgs", orgs);
        return "/catalog/Organizations.html";
    }
}
