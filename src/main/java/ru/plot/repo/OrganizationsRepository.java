package ru.plot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.plot.entity.Organizations;

public interface OrganizationsRepository extends JpaRepository<Organizations, Long> {
}
