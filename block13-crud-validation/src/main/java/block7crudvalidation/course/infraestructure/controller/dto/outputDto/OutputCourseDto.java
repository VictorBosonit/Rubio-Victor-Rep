package block7crudvalidation.course.infraestructure.controller.dto.outputDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data


public class OutputCourseDto implements Serializable {

    private  Long id_course;
    private  String course;
    private  String comments;
    private  Date initial_date;
    private  Date finish_date;
}