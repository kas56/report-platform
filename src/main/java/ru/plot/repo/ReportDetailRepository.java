package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plot.entity.ReportDetails;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ReportDetailRepository extends CrudRepository<ReportDetails, BigInteger> {
}
