package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.ReportDetails;

import java.math.BigInteger;

public interface ReportDetailsRepository extends CrudRepository<ReportDetails, BigInteger> {
}
