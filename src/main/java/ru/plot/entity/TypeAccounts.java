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
@Table(name = "type_accounts", schema = "h2020")
public class TypeAccounts {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // id
  @Column(name = "id_type_accounts") private BigInteger id;
  // код вида счёта
  @Column(name = "s_code") private String code;
  // наименование вида счёта
  @Column(name = "s_name") private String name;

}
