package block7crudvalidation.student.infraestructure.controller.dto.output;

import block7crudvalidation.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
public class OutputStudentDto implements Serializable {

 private  Long id_student;
 private int num_hours_week;
 private  String comments;
 private  String branch;

}