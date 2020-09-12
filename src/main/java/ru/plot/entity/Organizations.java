package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "organizations", schema = "h2020")
public class Organizations {
    @Id
    @Column(name = "id_org")
    private Long idOrg;
    @Column(name = "s_short_name")
    private String shortName;
    @Column(name = "s_full_name")
    private String full_name;
    @Column(name = "s_org_inn")
    private String orgInn;
    @Column(name = "s_org_kpp")
    private String orgKpp;
    @Column(name = "s_org_ogrn")
    private String orgOgrn;
    @Column(name = "s_jur_address")
    private String jurAddress;
    @Column(name = "s_post_address")
    private String postAddress;
    @Column(name = "s_contact_fio")
    private String contactFio;
    @Column(name = "s_phone")
    private String phone;
    @Column(name = "s_fax")
    private String fax;
    @Column(name = "s_email")
    private String email;
    @Column(name = "s_org_type")
    private String orgType;
    @Column(name = "d_registration")
    private Date registration;
    @Column(name = "s_okato")
    private String okato;
    @Column(name = "s_oktmo")
    private String oktmo;
    @Column(name = "s_okpo")
    private String okpo;
    @Column(name = "is_inside_org")
    private boolean isInsideOrg;
    @Column(name = "is_admin_org")
    private boolean isAdminOrg;
}
