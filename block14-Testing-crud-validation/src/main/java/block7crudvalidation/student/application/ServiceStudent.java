package block7crudvalidation.student.application;

import block7crudvalidation.course.domain.Course;
import block7crudvalidation.course.infraestructure.reposritory.CourseRepository;
import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.repository.PersonRepository;
import block7crudvalidation.student.domain.Student;
import block7crudvalidation.student.infraestructure.controller.dto.input.InputStudentDto;
import block7crudvalidation.student.infraestructure.controller.dto.output.OutputStudentDto;
import block7crudvalidation.student.infraestructure.controller.dto.output.OutputStudentFullDto;
import block7crudvalidation.student.infraestructure.repository.StudentRepository;
import block7crudvalidation.teacher.domain.Teacher;
import block7crudvalidation.teacher.infraestructure.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@AllArgsConstructor
public class ServiceStudent implements InterfaceServiceStudent {


    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final PersonRepository personRepository;
    @Autowired
    private final TeacherRepository teacherRepository;
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public Student addStudent(Student student) throws Exception {
        return null;
    }

    @Override
    public Student addStudent(InputStudentDto studentDto) throws Exception {

        //I get an object type inputStudentDto from RestController and
        // I mapped the inputStudentDto to Person object
        Student student ;

        Person person = personRepository.findById(studentDto.getId_person()).get();
        Teacher teacher = teacherRepository.findById(studentDto.getId_teacher()).get();
        List<Course> courses = new ArrayList<>();

        if (studentDto.getCourses()!=null) {
            for (Long course: studentDto.getCourses()){
                Course course1 =courseRepository.findById(course).get();
                courses.add(course1);
            }
        }


        try {
            //I mapped studentDto to student  then I save in database
            student = modelMapper.map(studentDto, Student.class);
            Date date  = new Date ();
            person.setCreated_date(date);
            student.setPerson(person);
            student.setTeacher(teacher);
            student.setCourses(courses);

            return studentRepository.save(student);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public Optional<OutputStudentDto> getStudent(Long id) throws Exception {
        // I search a new object type student in database, and then
        // I mapped the object student from database to object OutputStudentDto
        OutputStudentDto dtoStudent ;
        try {
            Optional<Student> student = studentRepository.findById(id);
            if(student.isPresent()) {

                //I mapped student to studentDto  then I send restController petition
                dtoStudent = modelMapper.map(student, OutputStudentDto.class);

            }else{throw new EntityNotFoundException() ;}

            return Optional.of(dtoStudent);

        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public Optional<OutputStudentFullDto> getStudentFull(Long id) throws Exception {
        // I search a new object type student in database, and then
        // I mapped the object student from database to object OutputStudentDto
        OutputStudentFullDto dtoStudentFull ;
        try {
            Optional<Student> student = studentRepository.findById(id);
            if(student.isPresent()) {

                //I mapped student to studentDto  then I send restController petition
                dtoStudentFull = modelMapper.map(student, OutputStudentFullDto.class);


            }else{throw new EntityNotFoundException() ;}

            return Optional.of(dtoStudentFull);

        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }


    }



    @Override
    public List<OutputStudentDto> getAllStudents() throws Exception {

        List<OutputStudentDto> dtoStudent = new ArrayList<>();
        try {
            // I get a list of object when I call to method getAllStudents
            List<Student> student = studentRepository.findAll();
            // I mapped the list of students to list of objects type outputStudentDto using
            // TypeToken (TypeToken is used to map generic parameterized types.)
            dtoStudent = modelMapper.map(student, new TypeToken<List<OutputStudentDto>>(){}.getType());
            // I return a list of objects type OutputStudentDto
            return dtoStudent ;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Student updateStudent(Long id, InputStudentDto studentDto) throws Exception {
        // we create a new object and then pass the parameter from controller
        try {
            // I get  object from database and put on personFind
            Student studentFind = studentRepository.findById(id).get();
            // if id > 1 mapped personDto to personfind
            if (studentFind.getId_student()==id) {
                modelMapper.map(studentDto, studentFind);
            } else {
                throw new EntityNotFoundException();
            }
            return studentRepository.save(studentFind);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean deleteStudent(Long id) {

        try {
            Optional<Student> student = studentRepository.findById(id);
            if (student.isPresent()) {
                studentRepository.deleteById(id);
                return true;
            }else {throw new EntityNotFoundException() ;}

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public Student updateCourses(Long id, InputStudentDto studentDto) throws Exception {

        // I create a list of courses
        List<Course> courses = new ArrayList<>();

        try {
            //I get the student that I want to modify by id
        Student student = studentRepository.findById(id).get();

        // if the list of courses from studentDto is not null
            // I add the courses to list courses
        if (studentDto.getCourses()!=null) {
            for (Long course: studentDto.getCourses()){

                Course course1 =courseRepository.findById(course).get();
                courses.add(course1);
            }
        }
       // I add the new list to student
        student.setCourses(courses);

            return studentRepository.save(student);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
