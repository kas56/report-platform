package ru.plot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.plot.entity.CurrencyRate;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Controller
@RequestMapping("/user/catalog")
public class CatalogController {

    @GetMapping("/CurrencyRates")
    public String table1Page(Model model) {

        List<CurrencyRate> currencyRates = new ArrayList<>();
        CurrencyRate rate = new CurrencyRate("R01010", "036", "AUD", "1", "Австралийский доллар", "54,5870");
        currencyRates.add(rate);

        model.addAttribute("currencyRates", currencyRates);

        return "/catalog/CurrencyRates";
    }
}
