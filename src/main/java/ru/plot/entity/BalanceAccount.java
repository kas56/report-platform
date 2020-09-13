package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "balance_account", schema = "h2020")
public class BalanceAccount {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
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
