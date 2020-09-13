package ru.plot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.plot.entity.BankDog;

import java.math.BigInteger;

public interface BankDogRepository extends JpaRepository<BankDog, BigInteger> {
}
