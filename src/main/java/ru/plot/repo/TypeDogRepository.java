package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.TypeDog;

import java.math.BigInteger;

public interface TypeDogRepository extends CrudRepository<TypeDog, BigInteger> {
}
