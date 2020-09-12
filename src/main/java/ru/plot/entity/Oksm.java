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
@Table(schema = "h2020", name = "oksm")
public class Oksm {
    @Id
    @Column(name = "id_oksm")
    private Long idOksm;
    @Column(name = "s_code")
    private String code;
    @Column(name = "s_short_name")
    private String shortName;
    @Column(name = "s_full_name")
    private String fullName;
     @Column(name = "s_alfa2")
    private String alfa2;
    @Column(name = "s_alfa3")
    private String alfa3;
}
