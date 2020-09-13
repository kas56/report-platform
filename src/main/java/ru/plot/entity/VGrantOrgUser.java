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
@Table(name = "v_grant_org_user", schema = "h2020")
public class VGrantOrgUser {

@Id
@Column(name = "id_users") private BigInteger id;
  // имя пользователя
  @Column(name = "s_firstname") private String firstname;
  // фамилия пользователя
  @Column(name = "s_secondname") private String secondname;
  // отчество пользователя
  @Column(name = "s_middlename") private String middlename;
  // должность пользователя
  @Column(name = "s_position") private String position;
  // id организации пользователя
  @Column(name = "id_user_org") private BigInteger idUserOrg;
  // id головной организации организации пользователя
  @Column(name = "main_id_user_org") private BigInteger mainIdUserOrg;
  // наименование организации пользователя
  @Column(name = "user_org") private String userOrg;
  // id доступной организации
  @Column(name = "id_grant_org") private BigInteger idGrantOrg;
  // id головной организации доступной организации
  @Column(name = "main_id_grant_org") private BigInteger mainIdGrantOrg;
  // наименование доступной организации
  @Column(name = "grant_org_name") private String grantOrgName;

}
