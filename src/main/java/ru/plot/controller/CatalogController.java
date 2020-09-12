package ru.plot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/catalog")
public class CatalogController {

    @GetMapping("/CurrencyRates")
    public String table1Page(Model model) {

        return "/catalog/CurrencyRates";
    }
}
