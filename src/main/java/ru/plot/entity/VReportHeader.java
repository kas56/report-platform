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
@Column(name = "id_report") private BigInteger idReport;
  // данные ответственного за формирование отчёта
  @Column(name = "responsible_pers") private String responsiblePers;
  // дата фрмирования отчёта
  @Column(name = "s_date_report") private String dateReport;
  // список организаций
  @Column(name = "list_org") private String listOrg;
  // список ИНН
  @Column(name = "list_inn") private String listInn;
  // фамилия
  @Column(name = "s_secondname") private String secondname;
  // имя
  @Column(name = "s_firstname") private String firstname;
  // отчество
  @Column(name = "s_middlename") private String middlename;
  // e-mail
  @Column(name = "s_user_email") private String userEmail;
  // телефон
  @Column(name = "s_user_phone") private String userPhone;

}
