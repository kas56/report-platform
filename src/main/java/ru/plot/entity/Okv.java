package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "okv", schema = "h2020")
public class Okv {

    @Id
    @Column(name = "id_okv")
    private Long id;

    @Column(name = "charcode")
    private String charcode;

    @Column(name = "numcode")
    private String numcode;

    @Column(name = "s_name_currency")
    private String name;

    @Column(name = "s_name_country")
    private String nameCountry;

    public Okv() {
    }


}
