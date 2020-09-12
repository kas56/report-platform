package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @Column(name = "id_bank")
    @SequenceGenerator(name = "banks_id_seq", sequenceName = "banks_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banks_id_seq")
    private long id;

    @Column(name = "s_swift")
    private String swift;
    @Column(name = "s_ksnp")
    private String ksnp;
    @Column(name = "s_namep")
    private String namep;
    @Column(name = "s_bank_full_name")
    private String bankFullName;

}
