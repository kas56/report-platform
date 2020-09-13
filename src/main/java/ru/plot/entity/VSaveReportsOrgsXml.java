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
@Table(name = "v_save_reports_orgs_xml", schema = "h2020")
public class VSaveReportsOrgsXml {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // null
  @Column(name = "id_report") private BigInteger idReport;
  // null
  @Column(name = "external_id") private String externalId;
  // null
  @Column(name = "s_org_inn") private String orgInn;
  // null
  @Column(name = "s_org_kpp") private String orgKpp;
  // null
  @Column(name = "s_org_name") private String orgName;
  // null
  @Column(name = "s_main") private String main;

}
