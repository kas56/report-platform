package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plot.entity.Reports;

import java.math.BigInteger;
@Repository
public interface ReportRepository extends CrudRepository<Reports, BigInteger> {
}
