package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "balance_account", schema = "h2020")
public class BalanceAccount {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // id
  @Column(name = "id_balance_account") private BigInteger id;
  // ссылка на счёт
  @Column(name = "id_account") private BigInteger idAccount;
  // дата баланса (дата предоставления информации)
  @Column(name = "d_date_balance") private LocalDate dateBalance;
  // баланс счёта
  @Column(name = "f_balance_summ") private BigDecimal balanceSumm;
  // комментарий к внесению баланса
  @Column(name = "s_comment") private String comment;

}
