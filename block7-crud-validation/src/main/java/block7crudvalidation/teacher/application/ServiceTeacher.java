package block7crudvalidation.teacher.application;

import block7crudvalidation.person.application.InterfaceServicePerson;
import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.person.infraestructure.controller.dto.output.OutputPersonDto;
import block7crudvalidation.person.infraestructure.repository.PersonRepository;
import block7crudvalidation.student.domain.Student;
import block7crudvalidation.student.infraestructure.repository.StudentRepository;
import block7crudvalidation.teacher.domain.Teacher;
import block7crudvalidation.teacher.infraestructure.controller.dto.inputDto.InputTeacherDto;
import block7crudvalidation.teacher.infraestructure.controller.dto.outputDto.OutputTeacherDto;
import block7crudvalidation.teacher.infraestructure.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceTeacher implements InterfaceServiceTeacher{


    @Autowired
    private final TeacherRepository teacherRepository;

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final ModelMapper modelMapper;



    @Override
    public Teacher addTeacher(InputTeacherDto teacherDto) throws Exception {
        //I get an object type inputTeacherDto from RestController and
        // I mapped the inputTeacherDto to Person object
        Teacher teacher;
        Person person = personRepository.findById(teacherDto.getId_person()).get();

        try {
                teacher = modelMapper.map(teacherDto, Teacher.class);
                // I get the date from system and add the date to Created_date and save
                // in database
            teacher.setPerson(person);

            return  teacherRepository.save(teacher);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<OutputTeacherDto> getTeacher(Long id) throws Exception {

        OutputTeacherDto dtoTeacher;


        try {
            Optional<Teacher> teacher = teacherRepository.findById(id);
            if(teacher.isPresent()) {

                dtoTeacher = modelMapper.map(teacher, OutputTeacherDto.class);


            }else{throw new EntityNotFoundException() ;}
            // I return an optional of object dtoTeacher
            return Optional.of(dtoTeacher);

        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<OutputTeacherDto> getAllTeacher() throws Exception {
        List<OutputTeacherDto> dtoTeacher = new ArrayList<>();
        try {
            // I get a list of object when I call to method getAllTeacher
            List<Teacher> teacher = teacherRepository.findAll();
            // I mapped the list of person to list of objects type outputTeacherDto using
            // TypeToken (TypeToken is used to map generic parameterized types.)
            dtoTeacher = modelMapper.map(teacher, new TypeToken<List<OutputTeacherDto>>(){}.getType());
            // I return a list of objects type OutputTeacherDto
            return dtoTeacher ;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Teacher updateTeacher(Long id, InputTeacherDto teacherDto) throws Exception {

        // we create a new object and then pass the parameter from controller

        try {
            // I get  object from database and put on personFind
            Teacher teacherFind = teacherRepository.findById(id).get();
            // if id > 1 mapped personDto to personfind
            if (teacherFind.getId_teacher()==id) {
                modelMapper.map(teacherDto, teacherFind);
            } else {
                throw new EntityNotFoundException();
            }
            return teacherRepository.save(teacherFind);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean deleteTeacher(Long id) {

        try {
            Optional<Teacher> teacher = teacherRepository.findById(id);
            if (teacher.isPresent()) {
                teacherRepository.deleteById(id);
                return true;
            }else {throw new EntityNotFoundException() ;}

        } catch (Exception e) {
        }
        return false;
    }


}
