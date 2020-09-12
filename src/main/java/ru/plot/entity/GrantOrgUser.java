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
@Table(name = "grant_org_user", schema = "h2020")
public class GrantOrgUser {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_grant_org_user") private BigInteger id;
  // ссылка на организацию
  @Column(name = "id_user") private BigInteger idUser;
  // null
  @Column(name = "id_org") private BigInteger idOrg;

}
