package org.example.person.infraestructure.controller.controller;


import lombok.AllArgsConstructor;
import org.example.person.aplication.PersonService;
import org.example.person.domain.Person;
import org.example.person.infraestructure.controller.inputDto.InputPersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@AllArgsConstructor


public class PersonController {

    @Autowired
    private PersonService personService;

    //with @Postmaping we can introduce dates in BB DD
    @PostMapping
    public ResponseEntity addPerson (@RequestBody InputPersonDto personDto) throws Exception {
        return new ResponseEntity<>(personService.addPerson(personDto), HttpStatus.CREATED);
    }


    //with @Getmaping, we can get dates in BB DD in this case we use the "id"
    @GetMapping("/{id}")
    public ResponseEntity getPerson (@PathVariable("id") Long id, Person person) throws Exception {
        return new ResponseEntity(personService.getPerson(id), HttpStatus.OK);
    }




    //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
    @GetMapping("/teachers")
    public ResponseEntity getAllPerson() {
        try {
            return new ResponseEntity(personService.getAllPerson(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
        }
    }
    // with @Putmaping, we can update dates in BB DD in this case we use the "id"
    @PutMapping("/{id}")
    public ResponseEntity updatePerson(@PathVariable("id")Long id, @RequestBody InputPersonDto personDto) throws Exception {
        return new ResponseEntity(personService.updatePerson(id, personDto), HttpStatus.OK);}

    // with @Deletemaping, we can delete dates in BB DD in this case we use the "id"
    @DeleteMapping ("/{id}")
    public ResponseEntity deletePerson(@PathVariable("id")Long id) throws Exception {

        boolean response = personService.deletePersson(id);

        if(response==true) {return ResponseEntity.status(HttpStatus.OK).body("{\"Borrado\":}");

        } else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, id no encontrada, por faavor vuelva a intentar.\"}");}
    }
}

