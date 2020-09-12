package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plot.entity.Okv;

import java.math.BigInteger;

@Repository
public interface OkvRepository extends CrudRepository<Okv, BigInteger> {
    Okv findOkvByCharcode(String charcode);
}
