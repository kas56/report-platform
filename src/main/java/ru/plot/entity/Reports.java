package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "reports", schema = "h2020")
public class Reports {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_report") private BigInteger id;
  // дата, на которую создан отчёт
  @Column(name = "dt_date_report") private LocalDate dateReport;
  // ссылка на пользователя
  @Column(name = "id_user") private BigInteger idUser;
  // ссылка на пользователя
  @ManyToOne
  @JoinColumn(name = "id_user", updatable = false, insertable = false)
  private UserEntity user;
  // комментарий
  @Column(name = "s_comment") private String comment;

  // статус
  //@Column(name = "s_status") private Status status;

  @OneToMany (mappedBy = "report", cascade = CascadeType.ALL)
  private List<ReportDetails> reportDetails;

}
