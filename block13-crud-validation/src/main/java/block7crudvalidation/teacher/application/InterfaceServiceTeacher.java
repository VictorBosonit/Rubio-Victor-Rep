package block7crudvalidation.teacher.application;

import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.person.infraestructure.controller.dto.output.OutputPersonDto;
import block7crudvalidation.teacher.domain.Teacher;
import block7crudvalidation.teacher.infraestructure.controller.dto.inputDto.InputTeacherDto;
import block7crudvalidation.teacher.infraestructure.controller.dto.outputDto.OutputTeacherDto;

import java.util.List;
import java.util.Optional;

public interface InterfaceServiceTeacher {

    //This method add object from BB DD trow us id
    Teacher addTeacher(InputTeacherDto teacherDto)throws  Exception;

    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Optional<OutputTeacherDto> getTeacher(Long id)throws  Exception;

    List<OutputTeacherDto> getAllTeacher()throws  Exception;

    //This method update the BB DD where id=id
    Teacher updateTeacher(Long id, InputTeacherDto teacherDto)throws  Exception;

    // This method delete Person where id=id
    boolean deleteTeacher (Long id)throws  Exception;
}
