package examen_JPA_cascada.examen_JPA_cascada.CabeceraFra.domain;

import examen_JPA_cascada.examen_JPA_cascada.Cliente.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraFra {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int cli_codi;

    @Column
    private Double importeFra;

    @ManyToOne
    @JoinColumn(name = "id")
    Cliente cliente;

}
