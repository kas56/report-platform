package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.Bank;

import java.math.BigInteger;

public interface BankRepository extends CrudRepository<Bank, BigInteger> {
}
