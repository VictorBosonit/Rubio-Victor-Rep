package block7crudvalidation.student.application;

import block7crudvalidation.course.infraestructure.controller.dto.outputDto.OutputCourseDto;
import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.person.infraestructure.controller.dto.output.OutputPersonDto;
import block7crudvalidation.student.domain.Student;
import block7crudvalidation.student.infraestructure.controller.dto.input.InputStudentDto;
import block7crudvalidation.student.infraestructure.controller.dto.output.OutputStudentDto;
import block7crudvalidation.student.infraestructure.controller.dto.output.OutputStudentFullDto;

import java.util.List;
import java.util.Optional;

public interface InterfaceServiceStudent {


    // this method add object person to BB DD
    Student addStudent(Student student) throws  Exception;

    Student addStudent(InputStudentDto student)throws  Exception;

    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Optional<OutputStudentDto> getStudent(Long id)throws  Exception;
    Optional<OutputStudentFullDto> getStudentFull(Long id)throws  Exception;
    List<OutputStudentDto> getAllStudents()throws  Exception;

    //This method update the BB DD where id=id
    Student updateStudent(Long id, InputStudentDto student)throws  Exception;

    // This method delete Person where id=id
    boolean deleteStudent (Long id)throws  Exception;

    Student updateCourses(Long id, InputStudentDto student)throws  Exception;


}
