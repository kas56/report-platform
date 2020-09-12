package ru.plot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.plot.entity.Table1;
import ru.plot.repo.Table1Repository;

import java.util.List;

@RestController
@RequestMapping("/api/table1")
public class Table1RestController {

    @Autowired
    private Table1Repository table1Repository;

    @GetMapping
    public HttpEntity<?> getTable1List() {

        List<Table1> all = (List<Table1>) table1Repository.findAll();
        return new HttpEntity<>(all);
    }
}
