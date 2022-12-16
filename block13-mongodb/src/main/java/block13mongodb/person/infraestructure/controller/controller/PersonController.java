package block13mongodb.person.infraestructure.controller.controller;
import block13mongodb.person.aplication.PersonServiceInterface;
import block13mongodb.person.domain.Person;
import block13mongodb.person.infraestructure.controller.inputDto.InputPersonDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@AllArgsConstructor


public class PersonController {

    @Autowired
    private PersonServiceInterface personService;

    //with @Postmaping we can introduce dates in BB DD
    @PostMapping
    public ResponseEntity addPerson (@RequestBody Person person) throws Exception {
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }


    //with @Getmaping, we can get dates in BB DD in this case we use the "id"
    @GetMapping("/{id}")
    public ResponseEntity getPerson (@PathVariable("id") String name, Person person) throws Exception {
        return new ResponseEntity(personService.getPerson(name), HttpStatus.OK);
    }




    //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
    @GetMapping("/all")
    public ResponseEntity getAllPerson() {
        try {
            return new ResponseEntity(personService.getAllPerson(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
        }
    }
    // with @Putmaping, we can update dates in BB DD in this case we use the "id"
    @PutMapping("/{id}")
    public ResponseEntity updatePerson(@PathVariable("id")String id, @RequestBody InputPersonDto personDto) throws Exception {
        return new ResponseEntity(personService.updatePerson(id, personDto), HttpStatus.OK);}

    // with @Deletemaping, we can delete dates in BB DD in this case we use the "id"
    @DeleteMapping ("/{id}")
    public ResponseEntity deletePerson(@PathVariable("id")String name) throws Exception {

        boolean response = personService.deletePersson(name);

        if(response==true) {return ResponseEntity.status(HttpStatus.OK).body("{\"Borrado\":}");

        } else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, id no encontrada, por faavor vuelva a intentar.\"}");}
    }
}

