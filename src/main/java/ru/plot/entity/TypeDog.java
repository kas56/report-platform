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
@Table(name = "type_dog", schema = "h2020")
public class TypeDog {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // id
  @Column(name = "id_type_dog") private BigInteger id;
  // наименование типа
  @Column(name = "s_code_type") private String codeType;
  // null
  @Column(name = "s_name_type") private String nameType;

}
