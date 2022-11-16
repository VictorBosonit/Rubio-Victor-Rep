package examen_JPA_cascada.examen_JPA_cascada.LineasFra.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class LineasFra {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int idFra;

    @NotNull
    @Column(name = "proNomb")
    private String proNomb;

    @Column(name = "cantidad")
    private Double cantidad;

    @Column(name = "precio")
    private Double precio;
}
