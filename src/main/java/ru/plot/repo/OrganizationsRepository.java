package ru.plot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.plot.entity.Organizations;

import java.math.BigInteger;

public interface OrganizationsRepository extends JpaRepository<Organizations, BigInteger> {
}
