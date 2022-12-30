package block7crudvalidation.person.infraestructure.controller.dto.output;

import block7crudvalidation.student.domain.Student;
import block7crudvalidation.teacher.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputPersonDto implements Serializable {

    private Long id;
    private String users;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private Date termination_date;

}