package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "reports", schema = "h2020")
public class Reports {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // id
  @Column(name = "id_report") private BigInteger id;
  // дата, на которую создан отчёт
  @Column(name = "dt_date_report") private LocalDate dateReport;
  // ссылка на пользователя
  @Column(name = "id_user") private BigInteger idUser;
  // комментарий
  @Column(name = "s_comment") private String comment;

}
