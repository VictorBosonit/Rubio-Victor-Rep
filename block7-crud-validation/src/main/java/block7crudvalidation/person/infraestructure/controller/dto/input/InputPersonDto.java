package block7crudvalidation.person.infraestructure.controller.dto.input;

import lombok.Data;

import java.io.Serializable;

@Data
public class InputPersonDto implements Serializable {

    private  String users;
    private  String password;
    private  String name;
    private  String surname;
    private  String company_email;
    private  String personal_email;
    private  String city;
    private  Boolean active;
    private  String imagen_url;


}