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
@Table(name = "bank_bic", schema = "h2020")
public class BankBic {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_bank_bic") private BigInteger id;
  // краткое наименование банка
  @Column(name = "shortname") private String shortname;
  // БИК банка
  @Column(name = "bic") private String bic;
  // регистрационный номер БИК
  @Column(name = "regnum") private String regnum;

}
