package examen_JPA_cascada.examen_JPA_cascada.CabeceraFra.infraestructure.controller;

import examen_JPA_cascada.examen_JPA_cascada.CabeceraFra.domain.CabeceraFra;
import examen_JPA_cascada.examen_JPA_cascada.CabeceraFra.application.CabeceraFraService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cabeceraFra")
@AllArgsConstructor
public class CabeceraFraController {

    @Autowired
    private final CabeceraFraService cabeceraFraService;

    //with @Postmaping we can introduce dates in BB DD

    @PostMapping
    public ResponseEntity addCabeceraFra (@RequestBody CabeceraFra cabeceraFra){
        return new ResponseEntity<>(cabeceraFraService.addCabeceraFra(cabeceraFra), HttpStatus.CREATED);}

    }
