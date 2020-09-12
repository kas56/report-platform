package ru.plot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.plot.entity.DataDayReport;

public interface DataDayReportRepository extends JpaRepository<DataDayReport, Integer> {
}
