package block7crudvalidation.student.infraestructure.controller.dto.output;

import block7crudvalidation.person.domain.Person;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OutputStudentFullDto implements Serializable {

 private  Long id_student;
 private int num_hours_week;
 private  String comments;
 private  String branch;
 private Person person;

 public void setPerson(Person person) {
  this.person = person;
  Date date =new Date();
  person.setTermination_date(date);
 }


}