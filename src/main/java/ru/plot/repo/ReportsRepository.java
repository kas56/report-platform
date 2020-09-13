package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.Reports;
import ru.plot.entity.UserEntity;

import java.math.BigInteger;
import java.util.List;

public interface ReportsRepository extends CrudRepository<Reports, BigInteger> {
    List<Reports> findByUser(UserEntity entity);
}
