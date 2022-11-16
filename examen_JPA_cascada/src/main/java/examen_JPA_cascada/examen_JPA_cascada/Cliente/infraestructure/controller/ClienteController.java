package examen_JPA_cascada.examen_JPA_cascada.Cliente.infraestructure.controller;

import examen_JPA_cascada.examen_JPA_cascada.Cliente.domain.Cliente;
import examen_JPA_cascada.examen_JPA_cascada.Cliente.aplication.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    //with @Postmaping we can introduce dates in BB DD

    @PostMapping
    public ResponseEntity addCliente (@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.addCliente(cliente), HttpStatus.CREATED);}


}
