package block7crudvalidation.person.application;

import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.person.infraestructure.controller.dto.output.OutputPersonDto;
import block7crudvalidation.person.infraestructure.controller.dto.output.OutputPersonStudentDto;
import block7crudvalidation.person.infraestructure.controller.dto.output.OutputPersonTeacherDto;
import block7crudvalidation.person.infraestructure.repository.PersonRepository;
import block7crudvalidation.student.domain.Student;
import block7crudvalidation.student.infraestructure.repository.StudentRepository;
import block7crudvalidation.teacher.domain.Teacher;
import block7crudvalidation.teacher.infraestructure.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.*;


@Service
@AllArgsConstructor
public class ServicePerson implements  InterfaceServicePerson{

    @Autowired
    private final PersonRepository personRepository;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final TeacherRepository teacherRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public Person addPerson(InputPersonDto personDto) throws Exception {
        //I get an object type inputpersondto from RestController and
        // I mapped the inputpersonddto to Person object

        Person person ;


        try {
            if(!(personDto.getUsers()==null||personDto.getPassword()==null||personDto.getName() == null ||
                    personDto.getCompany_email() == null || personDto.getPersonal_email() == null || personDto.getCity() == null ||
                    personDto.getActive() == null || personDto.getUsers().length() > 10)){

                person = modelMapper.map(personDto, Person.class);
                // I get the date from system and add the date to Created_date and save
                // in database
                Date date = new Date();
                person.setCreated_date(date);


            }else{throw new UnsupportedOperationException() ;
            }
            return personRepository.save(person);
        } catch (Exception e) {
        throw new Exception(e.getMessage());
        }
    }


    @Override
    public Optional<Object> getPerson(Long id) throws Exception {
        // I search a new object type person in database, and then
        // I mapped the object person from database to object Outputpersondto
        Object returned = null;
        OutputPersonDto dtoPerson = null;
        OutputPersonStudentDto outputPersonStudentDto = null;
        OutputPersonTeacherDto outputPersonTeacherDto = null;
        Date date = new Date();
        try {


            /* in this case i return an object, this object can be:

                      1. if the person is student mapped a person to outPersonStudentDto
                           firs get all students and check if the person is in students

                      2. if the person is teacher mapped a person to outPersoneacherDto

                      3. if the person is not teacher and is not student mapped to personDto

                      4. if is not person call to exception


            */

            for(Student student : studentRepository.findAll()) {

                if (student.getPerson().getId_person().equals(id)) {

                    Optional<Person> person = personRepository.findById(id);
                    outputPersonStudentDto = modelMapper.map(person, OutputPersonStudentDto.class);
                    outputPersonStudentDto.setCreated_date(date);
                    outputPersonStudentDto.setStudent(student);
                    returned = outputPersonStudentDto;
                }
            }

            for (Teacher teacher : teacherRepository.findAll()) {

                if (teacher.getPerson().getId_person().equals(id)) {

                    Optional<Person> person = personRepository.findById(id);
                    outputPersonTeacherDto = modelMapper.map(person, OutputPersonTeacherDto.class);
                    outputPersonTeacherDto.setCreated_date(date);
                    outputPersonTeacherDto.setTeacher(teacher);
                    returned = outputPersonTeacherDto;
                }
            }
            if (outputPersonTeacherDto==null && outputPersonStudentDto==null){
                Optional<Person> person = personRepository.findById(id);
                dtoPerson = modelMapper.map(person, OutputPersonDto.class);
                dtoPerson.setCreated_date(date);
                returned = dtoPerson;
            }

            if (returned==null){throw new EntityNotFoundException();}


        return Optional.of(returned);

    } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Object> getPersonByNames(String name) throws Exception {

        List<Object> returned = null;
        List<OutputPersonDto> dtoPerson ;
        List<OutputPersonStudentDto> outputPersonStudentDto = null;
        List<OutputPersonTeacherDto> outputPersonTeacherDto = null;

        try {

            for(Student student : studentRepository.findAll()) {

                if (student.getPerson().getName().equals(name)) {

                    List<Person> person = personRepository.findByName(name);
                    outputPersonStudentDto = modelMapper.map(person, new TypeToken<List< OutputPersonStudentDto>>(){}.getType());
                   for ( OutputPersonStudentDto outputPersonStudentDto1 : outputPersonStudentDto){
                       outputPersonStudentDto1.setStudent(student);
                   }
                    returned = Collections.singletonList(outputPersonStudentDto);
                }
            }

            for (Teacher teacher : teacherRepository.findAll()) {

                if (teacher.getPerson().getId_person().equals(name)) {

                    List<Person> person = personRepository.findByName(name);
                    outputPersonTeacherDto = modelMapper.map(person, new TypeToken<List< OutputPersonTeacherDto>>(){}.getType());
                    for ( OutputPersonTeacherDto outputPersonTeacherDto1 : outputPersonTeacherDto){
                        outputPersonTeacherDto1.setTeacher(teacher);
                    }
                    returned = Collections.singletonList(outputPersonTeacherDto);
                }
            }

            if (outputPersonTeacherDto==null && outputPersonStudentDto==null){

                List<Person> person = personRepository.findByName(name);
                dtoPerson = modelMapper.map(person, new TypeToken<List<OutputPersonDto>>(){}.getType());
                returned = Collections.singletonList(dtoPerson);
            }

            if (returned==null){throw new EntityNotFoundException();}

            return returned;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Object> getAllPerson() throws Exception {

        List<Object> returned;
        List<OutputPersonDto> dtoPerson ;


        try {

                List<Person> person = personRepository.findAll();
                dtoPerson = modelMapper.map(person, new TypeToken<List<OutputPersonDto>>(){}.getType());
                returned = Collections.singletonList(dtoPerson);


            if (returned==null){throw new EntityNotFoundException();}

            return returned;


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Person updatePerson(Long id, InputPersonDto personDto) throws Exception {

        // we create a new object and then pass the parameter from controller

        try {
        // I get  object from database and put on personFind
            Person personFind = personRepository.findById(id).get();
            // if id > 1 mapped personDto to personfind
            if (personFind.getId_person()==id) {

                modelMapper.map(personDto, personFind);

            } else {

                throw new EntityNotFoundException();

            }
            return personRepository.save(personFind);

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }

    @Override
    public boolean deletePerson(Long id) {

        try {
            Optional<Person> person = personRepository.findById(id);
            if (person.isPresent()) {
                personRepository.deleteById(id);
                return true;
            }else {throw new EntityNotFoundException() ;}

        } catch (Exception e) {

        }
        return false;
    }

}
