package ru.plot.repo;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.VSaveReportsOrgsXml;

import java.math.BigInteger;
import java.util.List;

@Reference
public interface VSaveReportsOrgsXmlRepository extends CrudRepository<VSaveReportsOrgsXml, BigInteger> {
    List<VSaveReportsOrgsXml> findByIdReport(BigInteger idReport);
}
