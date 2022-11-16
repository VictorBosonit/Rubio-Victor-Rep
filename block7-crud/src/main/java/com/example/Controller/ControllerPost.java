package com.example.Controller;

import com.example.Object.Person;
import com.example.Service.ServicePerson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@AllArgsConstructor
public class ControllerPost {


    // The  ResponseEntity is used for configuration og response HTTP
    // ResponseEntity is a generic type, and we can use any type as response body

    @Autowired
    private final ServicePerson servicePerson;


    //with @Postmaping we can introduce dates in BB DD

    @PostMapping
    public ResponseEntity addPerson (@RequestBody Person person){
        return new ResponseEntity<>(servicePerson.addPerson(person),HttpStatus.CREATED);}



    //with @Getmaping, we can get dates in BB DD in this case we use the "id"

    @GetMapping("/{id}")
    public ResponseEntity getPerson (@PathVariable("id") Long id){
        return new ResponseEntity(servicePerson.getPerson(id),HttpStatus.OK);}


    //with @Getmaping, we can get dates in BB DD in this case we use the "name"

    @GetMapping("/name/{name}")
    public ResponseEntity getPersonByName (@PathVariable("name") String name){
        return new ResponseEntity(servicePerson.getPersonByNames(name),HttpStatus.OK);}



    //with @Putmaping, we can change dates in BB DD

    @PutMapping ("/{id}")
    public ResponseEntity updatePerson(@PathVariable("id")Long id, @RequestBody Person person){
        return new ResponseEntity(servicePerson.updatePerson(id,person), HttpStatus.OK);}


    //with @Deletemaping, we can delete dates in BB DD

    @DeleteMapping ("/{id}")
    public ResponseEntity deletePerson(@PathVariable("id")Long id){

        boolean response = servicePerson.deletePerson(id);

        if(response==true) {return new ResponseEntity(HttpStatus.OK);

        } else {return new ResponseEntity(HttpStatus.NOT_FOUND);}}

}
