package ru.plot.service.impl;

import org.springframework.stereotype.Service;
import ru.plot.entity.Table1;
import ru.plot.pojo.Pojo1;
import ru.plot.repo.Table1Repository;
import ru.plot.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {
    private Table1Repository table1Repository;

    public BusinessServiceImpl(Table1Repository table1Repository) {
        this.table1Repository = table1Repository;
    }

    @Override
    public Pojo1 businessMethod1(Table1 table1) {
        return null;
    }
}
