package block7crudvalidation.person.infraestructure.controller;
import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.aplication.ServicePerson;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persona")
@AllArgsConstructor
public class PersonController {

    @Autowired
    private final ServicePerson servicePerson;

    //with @Postmaping we can introduce dates in BB DD
    @PostMapping
    public ResponseEntity addPerson (@RequestBody InputPersonDto personDto) throws Exception {
            return new ResponseEntity<>(servicePerson.addPerson(personDto), HttpStatus.CREATED);
        }


    //with @Getmaping, we can get dates in BB DD in this case we use the "id"
    @GetMapping("/{id}")
    public ResponseEntity getPerson (@PathVariable("id") Long id, Person person) throws Exception {
            return new ResponseEntity(servicePerson.getPerson(id), HttpStatus.OK);
    }


    //with @Getmaping, we can get dates in BB DD in this case we use the "name"
    @GetMapping("/name/{users}")
    public ResponseEntity getPersonByName (@PathVariable("users") String name){
        try {
            return new ResponseEntity(servicePerson.getPersonByNames(name), HttpStatus.OK);
        } catch(Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
            }
        }


    //with @Getmaping, we can get dates in BB DD in this case we use the "users" and we can get all dates from database
    @GetMapping("/users")
    public ResponseEntity getAllPerson() {
        try {
            return new ResponseEntity(servicePerson.getAllPerson(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por faavor vuelva a intentar.\"}");
        }
    }
    }
