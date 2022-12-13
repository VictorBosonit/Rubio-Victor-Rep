package block7crudvalidation.student.infraestructure.controller.dto.input;

import block7crudvalidation.course.domain.Course;
import block7crudvalidation.person.domain.Person;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class InputStudentDto implements Serializable {

        private  int num_hours_week;
        private  String comments;
        private  String branch;
        private Long id_person;
        private Long id_teacher;
        private List<Long> courses;

}