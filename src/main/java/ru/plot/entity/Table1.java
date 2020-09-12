package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "table_1")
public class Table1 {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "table_1_id_seq", sequenceName = "table_1_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "table_1_id_seq")
    private long id;

    @Column(name = "field_1")
    private String field1;

    @Column(name = "field_2")
    private String field2;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "table1"
    )
    private List<Table2> table2s;
}
