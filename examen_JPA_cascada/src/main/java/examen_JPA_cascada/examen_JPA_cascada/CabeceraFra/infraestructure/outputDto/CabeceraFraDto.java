package examen_JPA_cascada.examen_JPA_cascada.CabeceraFra.infraestructure.outputDto;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class CabeceraFraDto  {

    private final int id;
    private final int cli_codi;
    private final Double importeFra;


}