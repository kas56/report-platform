package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.BankBic;
import ru.plot.entity.TypeDog;

import java.math.BigInteger;
import java.util.Optional;

public interface TypeDogRepository extends CrudRepository<TypeDog, BigInteger> {
}
