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
@Table(name = "v_data_day_report", schema = "h2020")
public class VDataDayReport {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // дата баланса счетов (по ней получаются и операции)
  @Column(name = "d_date_balance") private LocalDate dateBalance;
  // номер строки по порядку
  @Column(name = "npp") private BigInteger npp;
  // ID организации из внешней системы
  @Column(name = "external_id") private String externalId;
  // ИНН организации
  @Column(name = "s_org_inn") private String orgInn;
  // КПП организации
  @Column(name = "s_org_kpp") private String orgKpp;
  // наименование организации
  @Column(name = "s_org_name") private String orgName;
  // признак ГО/ФЛ организации
  @Column(name = "s_main") private String main;
  // БИК банка
  @Column(name = "s_bank_bik") private String bankBik;
  // наименование банка
  @Column(name = "s_bank_name") private String bankName;
  // комментарий
  @Column(name = "s_comment") private String comment;
  // валюта счетов в банке
  @Column(name = "s_val_code") private String valCode;
  // баланс счетов в банке
  @Column(name = "f_balance_summ") private BigDecimal balanceSumm;
  // тип договора
  @Column(name = "s_type_dog") private String typeDog;
  // дата подписания договора
  @Column(name = "d_sign_dog") private Date signDog;
  // дата начала действия договора
  @Column(name = "d_start_dog") private Date startDog;
  // дата окончания действия договора
  @Column(name = "d_end_dog") private Date endDog;
  // процентная ставка по договору
  @Column(name = "f_percent") private BigDecimal percent;
  // валюта операции
  @Column(name = "s_val_code_dog") private String valCodeDog;
  // сумма операции
  @Column(name = "f_oper_summ") private BigDecimal operSumm;

}
