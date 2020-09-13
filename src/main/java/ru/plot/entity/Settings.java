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
@Table(name = "settings", schema = "h2020")
public class Settings {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_settings") private BigInteger id;
  // дата последней модификации записи
  @Column(name = "key") private String key;
  // пользователь, последний изменивший запись
  @Column(name = "value") private String value;

}
