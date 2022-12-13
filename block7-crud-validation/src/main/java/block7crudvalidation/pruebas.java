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
import org.springframework.stereotype.Component;


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



        person2.setUsers("User");
        person2.setPassword("123");
        person2.setName("Jaun");
        person2.setSurname("Alonso");
        person2.setCompany_email("juanalonso@ortiz.com");
        person2.setPersonal_email("jaun@alonso.es");
        person2.setActive(true);
        person2.setCity("Madrid");
        person2.setImagen_url("WW.cosecha.com");

        person3.setUsers("User");
        person3.setPassword("123");
        person3.setName("pepe");
        person3.setSurname("Escribano");
        person3.setCompany_email("pepeescrivbano@ortiz.com");
        person3.setPersonal_email("pepe@escribano.es");
        person3.setActive(true);
        person3.setCity("Vitoria");
        person3.setImagen_url("WW.cosecha.com");



        person4.setUsers("User");
        person4.setPassword("123");
        person4.setName("Maria");
        person4.setSurname("Elena");
        person4.setCompany_email("mariaelena@ortiz.com");
        person4.setPersonal_email("maria@elena.es");
        person4.setActive(true);
        person4.setCity("cadiz");
        person4.setImagen_url("WW.cosecha.com");

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);


        // Creo algunos profesores y los guardo.
//
//        Teacher teacher1 = new Teacher();
//        teacher1.setComments("Buen profesor");
//        teacher1.setBranch("profesor 1");
//        teacher1.setPerson(person1);
//
//       teacherRepository.save(teacher1);
//
//        Teacher teacher2 = new Teacher();
//        teacher2.setComments("Mal profesor");
//        teacher2.setBranch("profesor 2");
//        teacher2.setPerson(person2);
//
//        teacherRepository.save(teacher2);





//
//        // Creo algunos estudiantes y les asigno su profesor. Métodos implementados en el controlador.

//        Student student1 = new Student();
//        student1.setComments("Buen estudiante");
//        student1.setBranch("estudiante 1");
//        student1.setNum_hours_week(10);
//        student1.setPerson(person3);
//        student1.setTeacher(teacher1);
//
//
//
//        Student student2 = new Student();
//        teacher2.setComments("Mal estudiante");
//        teacher2.setBranch("estudiante 2");
//        student2.setNum_hours_week(5);
//        teacher2.setPerson(person4);
//        student2.setTeacher(teacher2);
//        studentRepository.save(student1);
//        studentRepository.save(student2);
//
//
//
////            // Creo las asignaturas.
//
//
//        Course course1 =new Course();
//
//        course1.setCourse("Matematicas");
//        course1.setComments("Asignatura dificil");
//        course1.setTeacher(teacher1);
//
//        Course course2 =new Course();
//
//        course2.setCourse("Gimansia");
//        course2.setComments("Asignatura facil");
//        course2.setTeacher(teacher2);


//
//            // Creo una colección con las ids de las asignaturas para asignárselas a los estudiantes.
//            List<Long> subjects = new ArrayList<>();
//            subjects.add(subject1Entity.getId());
//            subjects.add(subject2Entity.getId());
//
//            studentServiceImpl.addSubjects(subjects, student1Out.getId());
//            studentServiceImpl.addSubjects(subjects, student2Out.getId());
    }
}