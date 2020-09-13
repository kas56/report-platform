package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "v_data_day_report", schema = "h2020")
public class DataDayReport {
    @Id
    @Column(name = "npp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer npp;
    @Column(name = "d_date_balance")
    private Date dateBalance;
    @Column(name = "external_id")
    private Integer externalId;
    @Column(name = "s_org_inn")
    private String orgInn;
    @Column(name = "s_org_kpp")
    private String orgKpp;
    @Column(name = "s_org_name")
    private String orgName;
    @Column(name = "s_main")
    private String main;
    @Column(name = "s_bank_bik")
    private String bankBik;
    @Column(name = "s_bank_name")
    private String bankName;
    @Column(name = "s_comment")
    private String comment;
    @Column(name = "s_val_code")
    private String valCode;
    @Column(name = "f_balance_summ")
    private Double balanceSumm;
    @Column(name = "s_type_dog")
    private String typeDog;
    @Column(name = "d_sign_dog")
    private Date signDog;
    @Column(name = "d_start_dog")
    private Date startDog;
    @Column(name = "d_end_dog")
    private Date endDog;
    @Column(name = "f_percent")
    private Double percent;
    @Column(name = "s_val_code_dog")
    private String valCodeDog;
    @Column(name = "f_oper_summ")
    private Double operSumm;
}
