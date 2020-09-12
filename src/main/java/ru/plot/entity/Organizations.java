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
  // id �����������
  @Column(name = "id_org") private BigInteger idOrg;
  // ������ �� �������� �����������
  @Column(name = "main_id_org") private BigInteger mainIdOrg;
  // ���� ��������� ����������� ������
  @Column(name = "dt_update") private Timestamp dtUpdate;
  // ������������, ��������� ���������� ������
  @Column(name = "s_user_modify") private String userModify;
  // ������� ������������ �����������
  @Column(name = "s_short_name") private String shortName;
  // ������ ������������ �����������
  @Column(name = "s_full_name") private String fullName;
  // ��� �����������
  @Column(name = "s_org_inn") private String orgInn;
  // ��� �����������
  @Column(name = "s_org_kpp") private String orgKpp;
  // ���� �����������
  @Column(name = "s_org_ogrn") private String orgOgrn;
  // ����������� ����� �����������
  @Column(name = "s_jur_address") private String jurAddress;
  // �������� ����� �����������
  @Column(name = "s_post_address") private String postAddress;
  // ���������� ����
  @Column(name = "s_contact_fio") private String contactFio;
  // ������� �����������
  @Column(name = "s_phone") private String phone;
  // ���� �����������
  @Column(name = "s_fax") private String fax;
  // e-mail �����������
  @Column(name = "s_email") private String email;
  // �������������� �������� ����� �����������
  @Column(name = "s_org_type") private String orgType;
  // ���� ����������� �� ���� � ��������� ������
  @Column(name = "d_registration") private Date registration;
  // ������ �� �������������� ������������� ����� ����
  @Column(name = "id_oksm") private BigInteger idOksm;
  // ����� �����������
  @Column(name = "s_okato") private String okato;
  // ����� �����������
  @Column(name = "s_oktmo") private String oktmo;
  // ���� �����������
  @Column(name = "s_okpo") private String okpo;
  // ������� ����� �����������
  @Column(name = "is_inside_org") private Boolean isInsideOrg;
  // ������� ����������� ����������� (��������� ���� ����������� ����� �������� �����������)
  @Column(name = "is_admin_org") private Boolean isAdminOrg;
  // ������������� �� ������� �������
  @Column(name = "external_id") private String externalId;

}
