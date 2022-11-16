package examen_JPA_cascada.examen_JPA_cascada.LineasFra.infraestructure.outputDto;

import com.sun.istack.NotNull;
import examen_JPA_cascada.examen_JPA_cascada.LineasFra.domain.LineasFra;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class LineasFraDto implements Serializable {

    private final int idFra;
    @NotNull
    private final String proNomb;
    private final Double cantidad;
    private final Double precio;

}