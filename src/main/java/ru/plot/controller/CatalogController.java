package ru.plot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.plot.entity.CurrencyRate;
import ru.plot.repo.CurrencyRateRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    CurrencyRateRepository currencyRateRepository;

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

    @GetMapping("/Bics")
    public String bics(Model model) {
        return "/catalog/Bics";
    }
}
