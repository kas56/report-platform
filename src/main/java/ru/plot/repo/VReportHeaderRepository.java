package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plot.entity.VReportHeader;

import java.math.BigInteger;

@Repository
public interface VReportHeaderRepository extends CrudRepository<VReportHeader, BigInteger> {
}
