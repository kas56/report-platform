package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "v_report_header", schema = "h2020")
public class VReportHeader {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // id отчёта, для которого формируется шапка)
  @Column(name = "id_report") private BigInteger id;
  // данные ответственного за формирование отчёта
  @Column(name = "responsible_pers") private String responsiblePers;
  // дата фрмирования отчёта
  @Column(name = "s_date_report") private String dateReport;
  // список организаций
  @Column(name = "list_org") private String listOrg;
  // список ИНН
  @Column(name = "list_inn") private String listInn;

}
