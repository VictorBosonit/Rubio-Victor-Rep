package block7crudvalidation.course.application;

import block7crudvalidation.course.domain.Course;
import block7crudvalidation.course.infraestructure.controller.dto.inputDto.InputCourseDto;
import block7crudvalidation.course.infraestructure.controller.dto.outputDto.OutputCourseDto;

import java.util.List;
import java.util.Optional;

public interface InterfaceServiceCourse {


    // this method add object ourse to BB DD
    //Student_Course addCourse(Student_Course student_course) throws  Exception;
    Course addCourse(InputCourseDto courseDto)throws  Exception;

    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Optional<OutputCourseDto> getCourse(Long id)throws  Exception;

    List<OutputCourseDto> getAllCourse()throws  Exception;

    //This method update the BB DD where id=id
    Course updateCourse(Long id, InputCourseDto courseDto)throws  Exception;

    // This method delete Person where id=id
    boolean deleteCourse (Long id)throws  Exception;

    List<Course> getAllCourses (Long id);

}
