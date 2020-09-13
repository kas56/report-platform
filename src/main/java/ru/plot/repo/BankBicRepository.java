package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.Bank;
import ru.plot.entity.BankBic;

import java.util.Optional;

public interface BankBicRepository extends CrudRepository<BankBic, Long> {
    Optional<BankBic> findByBic(String bic);
}
