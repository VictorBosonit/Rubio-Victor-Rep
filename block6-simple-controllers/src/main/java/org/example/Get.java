package org.example;


import org.springframework.web.bind.annotation.*;

@RestController
public class Get {

    @ResponseBody
    @GetMapping(value= "/user/{name}") //You have to put your name in  http://localhost:8080/user/ "your name"
    public String name(@PathVariable String name) {
        return "Hola " + name;
    }

}
