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
@Table(name = "report_details", schema = "h2020")
public class ReportDetails {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_report_details") private BigInteger id;
  // ссылка на отчёт
  @Column(name = "id_report") private BigInteger idReport;
  // ID из внешней системы (откуда обновляется список организаций)
  @Column(name = "external_id") private String externalId;
  // ИНН оганизации
  @Column(name = "s_org_inn") private String orgInn;
  // КПП организации
  @Column(name = "s_org_kpp") private String orgKpp;
  // наименование организации
  @Column(name = "s_org_name") private String orgName;
  // признак ГО/ФЛ
  @Column(name = "s_main") private String main;
  // БИК банка
  @Column(name = "s_bank_bik") private String bankBik;
  // наименование банка
  @Column(name = "s_bank_name") private String bankName;
  // комментарий
  @Column(name = "s_comment") private String comment;
  // валюта счетов в банке
  @Column(name = "s_val_code") private String valCode;
  // остаток по счетам в банке
  @Column(name = "f_balance_summ") private BigDecimal balanceSumm;
  // вид договора
  @Column(name = "s_type_dog") private String typeDog;
  // дата подписания договора
  @Column(name = "d_sign_dog") private LocalDate signDog;
  // дата начал действия договора
  @Column(name = "d_start_dog") private LocalDate startDog;
  // дата окончания действия договора
  @Column(name = "d_end_dog") private LocalDate endDog;
  // расчётная ставка годовых
  @Column(name = "f_percent") private BigDecimal percent;
  // валюта договора (такая же как валюта счетов в банке)
  @Column(name = "s_val_code_dog") private String valCodeDog;
  // сумма по договору
  @Column(name = "f_oper_sum") private BigDecimal operSum;
  // номер строки по порядку (для одинакового показа архивных отчётов требуется сортировка по данному полю)
  @Column(name = "i_npp") private BigInteger npp;

}
