package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.Reports;

import java.math.BigInteger;

public interface ReportsRepository extends CrudRepository<Reports, BigInteger> {
}
