package com.example.Object;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private long Age;
    @Column (nullable = false)
    private String city;

}
