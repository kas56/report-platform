package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "table_2")
public class Table2 {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "table_2_id_seq", sequenceName = "table_2_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "table_2_id_seq")
    private long id;

    @Column(name = "field_1")
    private String field1;

    @ManyToOne
    @JoinColumn(name = "table_1_id")
    private Table1 table1;

}
