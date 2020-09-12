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
@Table(name = "v_save_reports_valbal_xml", schema = "h2020")
public class VSaveReportsValbalXml {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // null
  @Column(name = "id_report") private BigInteger idReport;
  // null
  @Column(name = "external_id") private String externalId;
  // null
  @Column(name = "s_bank_bik") private String bankBik;
  // null
  @Column(name = "s_bank_name") private String bankName;
  // null
  @Column(name = "s_val_code") private String valCode;
  // null
  @Column(name = "f_balance_summ") private BigDecimal balanceSumm;

}
