package org.example.Controller;

import org.example.Object.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {



    // Petition POST from HTTP objet type JSON is sent and received
    @PostMapping("/greeting")
    public Greeting greeting(@RequestBody Greeting greeting) {
        return greeting;
    }

    // Petition GET from HTTP parameters is sent and String is received

    @GetMapping("/user/{id}")
    public String greeting(@PathVariable(value="id") String id) {

        return "The id of greeting is " + id;
    }
    // Petition PUT from HTTP parameters is sent and String is received

    @PutMapping("/post")

    public String updategreeting(@RequestParam int id, @RequestParam String content ){
        Greeting greting =new Greeting();
        greting.setId(id);
        greting.setContent(content);
        return "The dates of greeting have been changed, now are id: " +id +" content: " + content;
    }

}
