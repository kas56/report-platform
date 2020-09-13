package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "h2020", name = "banks")
public class Banks {
    @Id
    @Column(name = "id_bank")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBank;
    @Column(name = "s_bik")
    private String bik;
    @Column(name = "s_swift")
    private String swift;
    @Column(name = "s_ksnp")
    private String ksnp;
    @Column(name = "s_namep")
    private String namep;
    @Column(name = "s_bank_full_name")
    private String bankNullName;
    @Column(name = "s_bank_short_name")
    private String bankShortName;
    @Column(name = "s_bank_jur_name")
    private String bankJurName;
    @Column(name = "i_uer")
    private int uer;
    @Column(name = "s_zip_code")
    private String zipCode;
    @Column(name = "i_tnp")
    private int tnp;
    @Column(name = "s_nnp")
    private String nnp;
    @Column(name = "s_real")
    private String real;
    @Column(name = "d_date_ch")
    private Date dateCh;
    @Column(name = "s_regn")
    private String regn;
    @Column(name = "i_status")
    private String status;
    @Column(name = "s_bank_inn")
    private String bankInn;
    @Column(name = "s_bank_kpp")
    private String bankKpp;
    @Column(name = "s_bank_address")
    private String bankAddress;
    @Column(name = "s_bank_jur_address")
    private String bankJurAddress;
    @Column(name = "s_bank_name_eng")
    private String bankNameEng;
    @Column(name = "s_bank_ben_name")
    private String bankBenName;
    @Column(name = " s_bank_ben_addr")
    private String bankBenAddr;
    @Column(name = "is_branch")
    private boolean isBranch;
    @Column(name = "is_not_rus")
    private boolean isNotRus;
    @Column(name = "s_contact_pers")
    private String contactPers;
    @Column(name = "s_tel_contact_pers")
    private String telContactPers;
}
