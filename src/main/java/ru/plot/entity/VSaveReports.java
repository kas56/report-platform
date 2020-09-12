package com.sample;

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
@Table(name = "v_save_reports", schema = "h2020")
public class VSaveReports {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // id отчёта
  @Column(name = "id_report") private BigInteger idReport;
  // null
  @Column(name = "dt_date_report") private Timestamp dtDateReport;
  // null
  @Column(name = "id_user") private BigInteger idUser;
  // null
  @Column(name = "s_comment") private String comment;
  // номер строки по порядку
  @Column(name = "i_npp") private BigInteger npp;
  // внешний ID
  @Column(name = "external_id") private String externalId;
  // ИНН организации
  @Column(name = "s_org_inn") private String orgInn;
  // КПП организации
  @Column(name = "s_org_kpp") private String orgKpp;
  // наименование организации
  @Column(name = "s_org_name") private String orgName;
  // признак головной организации ГО/ФЛ
  @Column(name = "s_main") private String main;
  // БИК банка
  @Column(name = "s_bank_bik") private String bankBik;
  // наименование банка
  @Column(name = "s_bank_name") private String bankName;
  // валюта счетов в банке
  @Column(name = "s_val_code") private String valCode;
  // баланс счетов
  @Column(name = "f_balance_summ") private BigDecimal balanceSumm;
  // тип договора
  @Column(name = "s_type_dog") private String typeDog;
  // дата подписания договора
  @Column(name = "d_sign_dog") private Date signDog;
  // дата начала действия договора
  @Column(name = "d_start_dog") private Date startDog;
  // дата окончания действия договора
  @Column(name = "d_end_dog") private Date endDog;
  // процентнаЯ ставка по договору
  @Column(name = "f_percent") private BigDecimal percent;
  // null
  @Column(name = "s_val_code_dog") private String valCodeDog;
  // сумма фин.операции
  @Column(name = "f_oper_sum") private BigDecimal operSum;

}
