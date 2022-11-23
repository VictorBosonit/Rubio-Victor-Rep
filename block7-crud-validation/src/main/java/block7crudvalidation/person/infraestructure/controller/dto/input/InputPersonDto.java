package block7crudvalidation.person.infraestructure.controller.dto.input;

import lombok.Data;

import java.io.Serializable;


@Data
public class InputPersonDto implements Serializable {
    private final Long id;
    private final String users;
    private final String password;
    private final String name;
    private final String surname;
    private final String company_email;
    private final String personal_email;
    private final String city;
    private final Boolean active;
    private final String imagen_url;
}