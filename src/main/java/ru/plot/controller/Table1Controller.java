package ru.plot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.plot.service.PermissionService;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/table1")
public class Table1Controller {

    private PermissionService permissionService;

    @Autowired
    public Table1Controller(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping(value = { "", "/" })
    public String reestrPage(Model model) {
        model.addAttribute("message", "table1");
        model.addAttribute("perms", permissionService.getUserPermissions());

        return "/table1/table1s";
    }
    @GetMapping("/{id}")
    public String table1Page(Model model) {
        model.addAttribute("perms", permissionService.getUserPermissions());
        return "/table1/table1";
    }

    @GetMapping({"/form", "/form/{id}"})
    public String table1Form(@PathParam("id") Long id, Model model) {
        model.addAttribute("perms", permissionService.getUserPermissions());
        return "/table1/table1-form";
    }
}
