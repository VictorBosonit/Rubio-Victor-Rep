package block7crudvalidation.teacher.infraestructure.controller.dto.inputDto;

import block7crudvalidation.person.domain.Person;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class InputTeacherDto {

    private  String comments;
    private String branch;
    private Long id_person;
}
