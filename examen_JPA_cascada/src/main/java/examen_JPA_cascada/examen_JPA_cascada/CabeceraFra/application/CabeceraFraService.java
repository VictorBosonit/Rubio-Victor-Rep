package examen_JPA_cascada.examen_JPA_cascada.CabeceraFra.application;

import examen_JPA_cascada.examen_JPA_cascada.CabeceraFra.domain.CabeceraFra;
import examen_JPA_cascada.examen_JPA_cascada.CabeceraFra.infraestructure.repository.CabeceraFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabeceraFraService implements CabeceraFraSrviceInt {

    @Autowired
    private CabeceraFraRepository clienteRepository;


    @Override
    public CabeceraFra addCabeceraFra(CabeceraFra cabeceraFra) {
        return cabeceraFra;
    }
}
