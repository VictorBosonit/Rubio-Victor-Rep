package examen_JPA_cascada.examen_JPA_cascada.LineasFra.infraestructure.controller;

import examen_JPA_cascada.examen_JPA_cascada.LineasFra.domain.LineasFra;
import examen_JPA_cascada.examen_JPA_cascada.LineasFra.aplication.LineasFraService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lineasFraController")
@AllArgsConstructor
public class LineasFraController {

    @Autowired
    private final LineasFraService lineasFraService;




   /* @GetMapping("/name/{name}")
    public ResponseEntity getPersonByName (@PathVariable("name") String name){
        return new ResponseEntity(lineasFraService.);}
*/

}
