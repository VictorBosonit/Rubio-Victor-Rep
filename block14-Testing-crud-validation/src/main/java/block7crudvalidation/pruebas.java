package block7crudvalidation;

import block7crudvalidation.course.application.ServiceCourse;
import block7crudvalidation.course.domain.Course;
import block7crudvalidation.course.infraestructure.reposritory.CourseRepository;
import block7crudvalidation.person.application.ServicePerson;
import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.person.infraestructure.repository.PersonRepository;
import block7crudvalidation.student.application.ServiceStudent;
import block7crudvalidation.student.domain.Student;
import block7crudvalidation.student.infraestructure.controller.dto.input.InputStudentDto;
import block7crudvalidation.student.infraestructure.repository.StudentRepository;
import block7crudvalidation.teacher.application.ServiceTeacher;
import block7crudvalidation.teacher.domain.Teacher;
import block7crudvalidation.teacher.infraestructure.controller.dto.inputDto.InputTeacherDto;
import block7crudvalidation.teacher.infraestructure.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.logging.java.SimpleFormatter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
    public class pruebas implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public void run(String... args) throws Exception {

        // Cargo los datos para tenerlos disponibles en la aplicación.

        // Creo algunas personas.

        Date date = new Date();
        DateFormat newDate = DateFormat.getDateInstance(DateFormat.SHORT);

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        person1.setUsers("User");
        person1.setPassword("123");
        person1.setName("Pedro");
        person1.setSurname("Gutierez");
        person1.setCompany_email("pedrogutierrez@ortiz.com");
        person1.setPersonal_email("pedro@gutierrez.es");
        person1.setActive(true);
        person1.setCity("Valencia");
        person1.setImagen_url("WW.cosecha.com");
        person1.setCreated_date(date);



        person2.setUsers("User");
        person2.setPassword("123");
        person2.setName("Jaun");
        person2.setSurname("Alonso");
        person2.setCompany_email("juanalonso@ortiz.com");
        person2.setPersonal_email("jaun@alonso.es");
        person2.setActive(true);
        person2.setCity("Madrid");
        person2.setImagen_url("WW.cosecha.com");
        person2.setCreated_date(new Date ());

        person3.setUsers("User");
        person3.setPassword("123");
        person3.setName("pepe");
        person3.setSurname("Escribano");
        person3.setCompany_email("pepeescrivbano@ortiz.com");
        person3.setPersonal_email("pepe@escribano.es");
        person3.setActive(true);
        person3.setCity("Vitoria");
        person3.setImagen_url("WW.cosecha.com");
        person3.setCreated_date( new Date());



        person4.setUsers("User");
        person4.setPassword("123");
        person4.setName("Maria");
        person4.setSurname("Elena");
        person4.setCompany_email("mariaelena@ortiz.com");
        person4.setPersonal_email("maria@elena.es");
        person4.setActive(true);
        person4.setCity("cadiz");
        person4.setImagen_url("WW.cosecha.com");
        person4.setCreated_date( new Date());

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);

    }
}