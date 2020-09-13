package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.Bank;

public interface BankRepository extends CrudRepository<Bank, Long> {
}
