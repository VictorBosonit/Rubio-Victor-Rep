package block7crudvalidation.security;


import block7crudvalidation.person.application.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecurityController {

    @Autowired
    ServicePerson servicePerson;

    //Insertar en consola localhost:8080/h2Console

    // admin: INSERT INTO person(usuario,name,company_email,personal_email,city,active,created_date,admin,password) VALUES ('josedelrio','jose','Correo@prueba.com','Correo@prueba.com','SdC',true,'2022-05-31T00:00:00',true,'1234');

    // user:  INSERT INTO person(usuario,name,company_email,personal_email,city,active,created_date,admin,password) VALUES ('jose','jose','Correo@prueba.com','Correo@prueba.com','SdC',true,'2022-05-31T00:00:00',false,'1234');


    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestParam String userName, @RequestParam String password) throws Exception {

        return new ResponseEntity<>(servicePerson.loginUser(userName,password), HttpStatus.OK);
    }


}