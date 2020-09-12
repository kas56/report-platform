package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
