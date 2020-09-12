package ru.plot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/table1")
public class Table1Controller {

    @GetMapping(value = { "", "/" })
    public String reestrPage(Model model) {
        model.addAttribute("message", "table1");

        return "/table1/table1s";
    }
    @GetMapping("/{id}")
    public String table1Page(Model model) {
        return "/table1/table1";
    }

    @GetMapping({"/form", "/form/{id}"})
    public String table1Form(@PathParam("id") Long id, Model model) {
        return "/table1/table1-form";
    }
}
