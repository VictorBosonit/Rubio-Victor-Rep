package examen_JPA_cascada.examen_JPA_cascada.Cliente.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;

    @Size(message = "100")
    @Column(nullable = false)
    private String nombre;

}
