package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plot.entity.VSaveReportsDogsXml;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface VSaveReportsDogsXmlRepository extends CrudRepository<VSaveReportsDogsXml, BigInteger> {
    List<VSaveReportsDogsXml> findByIdReportAndExternalIdAndBankBikAndBankNameAndValCode(
            BigInteger reportId,
            String externalId,
            String bankBik,
            String bankName,
            String valCode
    );
}
