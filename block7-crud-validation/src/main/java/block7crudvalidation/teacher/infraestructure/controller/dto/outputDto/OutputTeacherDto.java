package block7crudvalidation.teacher.infraestructure.controller.dto.outputDto;

import block7crudvalidation.person.domain.Person;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class OutputTeacherDto {

    private  Long id_teacher;
    private  String comments;
    private  String branch;
    private Person person;
}
