package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.plot.entity.CurrencyRate;

@Repository
public interface CurrencyRateRepository extends CrudRepository<CurrencyRate, Long> {
}
