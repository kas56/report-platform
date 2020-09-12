package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "h2020", name = "accounts")
public class Account {
    @Id
    @Column(name = "id_accounts")
    private Long idAccounts;

    @Column(name = "s_number")
    private String number;

    @Column(name = "f_balance_summ")
    private Double balanceSumm;

    @Column(name = "s_comment")
    private String comment;
}
