package ru.plot.repo;

import com.sample.VSaveReportsValbalXml;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface VSaveReportsValbalXmlRepository extends CrudRepository<VSaveReportsValbalXml, BigInteger> {
    List<VSaveReportsValbalXml> findByIdReportAndExternalIdAndBankBikAndBankName(BigInteger reportId,
                                                                                    String externalId,
                                                                                    String bankBik,
                                                                                    String bankName);
}
