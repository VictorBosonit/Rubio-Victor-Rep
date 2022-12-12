package block7crudvalidation.course.application;


import block7crudvalidation.course.domain.Course;
import block7crudvalidation.course.infraestructure.controller.dto.inputDto.InputCourseDto;
import block7crudvalidation.course.infraestructure.controller.dto.outputDto.OutputCourseDto;
import block7crudvalidation.course.infraestructure.reposritory.CourseRepository;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceCourse implements InterfaceServiceCourse {

    @Autowired
    private final CourseRepository CourseRepository;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final TeacherRepository teacherRepository;

    @Override
    public Course addCourse(InputCourseDto courseDto) throws Exception {
        //I get an object type inputCourseDto from RestController and
        // I mapped the inputStudentCourseDto to Student_course object
        Course course ;
        Teacher teacher = teacherRepository.findById(courseDto.getId_teacher()).get();

        try {

                course = modelMapper.map(courseDto, Course.class);
                // I get the date from system and add the date to Created_date and save
                // in database
                Date date = new Date();
                course.setInitial_date(date);
                course.setTeacher(teacher);

            return CourseRepository.save(course);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<OutputCourseDto> getCourse(Long id) throws Exception {

        // I search a new object type student_course in database, and then
        // I mapped the object student_course from database to object OutputStudent_courseDto
        OutputCourseDto courseDto;

        try {
            Optional<Course> course = CourseRepository.findById(id);

            if(course.isPresent()) {

                courseDto = modelMapper.map(course, OutputCourseDto.class);
                //I put a new date in Termination_date when call this function and the value is not null
                Date date = new Date();
                courseDto.setFinish_date(date);

            }else{throw new EntityNotFoundException() ;}
            // I return an optional of object dtoPerson
            return Optional.of(courseDto);

        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<OutputCourseDto> getAllCourse() throws Exception {
        List<OutputCourseDto> dtoCourse = new ArrayList<>();
        try {
            // I get a list of object when I call to method getAllPerson
            List<Course> student_course = CourseRepository.findAll();
            // I mapped the list of person to list of objects type outputPersonDto using
            // TypeToken (TypeToken is used to map generic parameterized types.)
            dtoCourse = modelMapper.map(student_course, new TypeToken<List<OutputCourseDto>>(){}.getType());
            // I return a list of objects type OutputPersonDto
            return dtoCourse ;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Course updateCourse(Long id, InputCourseDto courseDto) throws Exception {
        // we create a new object and then pass the parameter from controller
        try {
            // I get  object from database and put on personFind
            Course courseFind = CourseRepository.findById(id).get();
            // if id > 1 mapped personDto to personfind
            if (courseFind.getId_course()==id) {
                modelMapper.map(courseDto, courseFind);
            } else {
                throw new EntityNotFoundException();
            }
            return CourseRepository.save(courseFind);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean deleteCourse(Long id) {

        try {
            Optional<Course> course= CourseRepository.findById(id);
            if (course.isPresent()) {
                CourseRepository.deleteById(id);
                return true;
            }else {throw new EntityNotFoundException() ;}
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public List<Course> getAllCourses(Long id) {

        Optional<Student> student = studentRepository.findById(id);

        List<Course> courses = student.get().getCourses();

        if(student.isEmpty()){
           throw new EntityNotFoundException();
        }
        return courses;
    }




}
