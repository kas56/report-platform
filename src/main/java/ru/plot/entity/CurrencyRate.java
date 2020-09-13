package ru.plot.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "curs_val_cb", schema = "h2020")
public class CurrencyRate {

    @Id
    @Column(name = "id_curs_val_cb")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "id_okv")
    private Okv okv;

    @Column(name = "nominal")
    private Integer nominal;

    @Column(name = "value")
    private BigDecimal value;

    public CurrencyRate() {
    }




}
