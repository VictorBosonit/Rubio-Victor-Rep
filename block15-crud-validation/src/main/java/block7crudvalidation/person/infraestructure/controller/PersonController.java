package block7crudvalidation.person.infraestructure.controller;

import block7crudvalidation.Feign.FeignsServer;


import block7crudvalidation.person.application.ServicePerson;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.teacher.domain.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persona")
@AllArgsConstructor
public class PersonController {

    @Autowired
    private ServicePerson servicePerson;

    @Autowired
    private FeignsServer feignsServer;

    //with @Postmaping we can introduce dates in BB DD

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    @CrossOrigin(origins = "https://cdpn.io")
    public ResponseEntity addPerson(@RequestBody InputPersonDto personDto) throws Exception {

        return new ResponseEntity<>(servicePerson.addPerson(personDto), HttpStatus.CREATED);
    }


    //with @Getmaping, we can get dates in BB DD in this case we use the "id"
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public ResponseEntity getPerson(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity(servicePerson.getPerson(id), HttpStatus.OK);
    }


    //with @Getmaping, we can get dates in BB DD in this case we use the "name"
    @GetMapping("/name/{users}")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public ResponseEntity getPersonByName(@PathVariable("users") String name) {
        try {
            return new ResponseEntity(servicePerson.getPersonByNames(name), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
        }
    }


    //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    @CrossOrigin(origins = "https://cdpn.io")
    public ResponseEntity getAllPerson() {
        try {
            return new ResponseEntity(servicePerson.getAllPerson(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
        }
    }

    // with @Putmaping, we can update dates in BB DD in this case we use the "id"
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public ResponseEntity updatePerson(@PathVariable("id") Long id, @RequestBody InputPersonDto personDto) throws Exception {
        return new ResponseEntity(servicePerson.updatePerson(id, personDto), HttpStatus.OK);
    }


    // with @Deletemaping, we can delete dates in BB DD in this case we use the "id"
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    public ResponseEntity deletePerson(@PathVariable("id") Long id) {

        boolean response = servicePerson.deletePerson(id);

        if (response == true) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"Borrado\":}");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, id no encontrada, por faavor vuelva a intentar.\"}");
        }
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> findByFeignId(@PathVariable Long id) throws Exception {
        return feignsServer.getTeacherById(id);
    }
}