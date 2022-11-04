package org.example;


import org.springframework.web.bind.annotation.*;

@RestController

public class Post {


    @PostMapping("/useradd") //you have to introduce your Person object in format Json
    public Person useradd(@RequestBody Person person) {
        return  person;
    }

    //and the result is  object Person

}