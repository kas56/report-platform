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
@Table(name = "bank_dog", schema = "h2020")
public class BankDog {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_bank_dog") private BigInteger id;
  // номер договора
  @Column(name = "s_num_dog") private String numDog;
  // ссылка на тип договора
  @Column(name = "id_type_dog") private BigInteger idTypeDog;
  // дата заключения
  @Column(name = "d_sign_dog") private LocalDate signDog;
  // дата начала
  @Column(name = "d_start_dog") private LocalDate startDog;
  // дата окончания
  @Column(name = "d_end_dog") private LocalDate endDog;
  // дата расторжения
  @Column(name = "d_term_dog") private LocalDate termDog;
  // сумма операции по договору
  @Column(name = "f_oper_summ") private String operSumm;
  // ссылка на счёт
  @Column(name = "id_account") private BigInteger idAccount;
  // ссылка на валюту договора (по идее должна совпадать с валютой счёта, но при необходимости можно и разные указать)
  @Column(name = "id_okv") private BigInteger idOkv;
  // процентная ставка (+ для депозита, - для кредита)
  @Column(name = "f_percent") private BigDecimal percent;

}
