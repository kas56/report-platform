package ru.plot.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "curs_val_cb", schema = "h2020")
public class CurrencyRate {

    @Id
    @Column(name = "id_curs_val_cb")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
    @JoinColumn(name = "id_okv")
    private Okv okv;

    @Column(name = "nominal")
    private Integer nominal;

    @Column(name = "value")
    private String value;

    public CurrencyRate() {
    }




}
