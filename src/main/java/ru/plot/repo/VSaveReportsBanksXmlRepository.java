package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plot.entity.VSaveReportsBanksXml;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface VSaveReportsBanksXmlRepository extends CrudRepository<VSaveReportsBanksXml, BigInteger> {
    List<VSaveReportsBanksXml> findByIdReportAndExternalId(BigInteger id , String extrenalId);
}
