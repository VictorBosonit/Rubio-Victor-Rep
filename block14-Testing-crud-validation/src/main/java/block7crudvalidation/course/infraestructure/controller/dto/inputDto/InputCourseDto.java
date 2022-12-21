package block7crudvalidation.course.infraestructure.controller.dto.inputDto;

import lombok.Data;

import java.io.Serializable;


@Data
public class InputCourseDto implements Serializable {


    private  String course;
    private  String comments;
    private  Long id_teacher;
    private Long id_student;

}