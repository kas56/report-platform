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
@Table(name = "organizations", schema = "h2020")
public class Organizations {

@Id
//TODO: Define generator PK
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_...")
//@SequenceGenerator(name = "SEQ_...", sequenceName = "SEQ_...", allocationSize = 1)
  // id организации
  @Column(name = "id_org") private BigInteger id;
  // ссылка на головную организацию
  @Column(name = "main_id_org") private BigInteger mainIdOrg;
  // краткое наименование организации
  @Column(name = "s_short_name") private String shortName;
  // полное наименование организации
  @Column(name = "s_full_name") private String fullName;
  // ИНН организации
  @Column(name = "s_org_inn") private String orgInn;
  // КПП организации
  @Column(name = "s_org_kpp") private String orgKpp;
  // ОГРН организации
  @Column(name = "s_org_ogrn") private String orgOgrn;
  // юридический адрес организации
  @Column(name = "s_jur_address") private String jurAddress;
  // почтовый адрес организации
  @Column(name = "s_post_address") private String postAddress;
  // контактное лицо
  @Column(name = "s_contact_fio") private String contactFio;
  // телефон организации
  @Column(name = "s_phone") private String phone;
  // факс организации
  @Column(name = "s_fax") private String fax;
  // e-mail организации
  @Column(name = "s_email") private String email;
  // организационно правовая форма организации
  @Column(name = "s_org_type") private String orgType;
  // дата рпостановки на учет в налоговом органе
  @Column(name = "d_registration") private Date registration;
  // ссылка на общероссийский классификатор стран мира
  @Column(name = "id_oksm") private BigInteger idOksm;
  // ОКАТО организации
  @Column(name = "s_okato") private String okato;
  // ОКТМО организации
  @Column(name = "s_oktmo") private String oktmo;
  // ОКПО организации
  @Column(name = "s_okpo") private String okpo;
  // признак своей организации
  @Column(name = "is_inside_org") private Boolean isInsideOrg;
  // признак управляющей организации (сотрудник этой организации может изменять справочники)
  @Column(name = "is_admin_org") private Boolean isAdminOrg;
  // идентификатор из внешней системы
  @Column(name = "external_id") private String externalId;

}
