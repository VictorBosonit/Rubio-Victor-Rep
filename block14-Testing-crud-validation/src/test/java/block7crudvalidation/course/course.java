package block7crudvalidation.course;
import block7crudvalidation.course.application.ServiceCourse;
import block7crudvalidation.course.domain.Course;
import block7crudvalidation.course.infraestructure.controller.CourseController;
import block7crudvalidation.course.infraestructure.controller.dto.inputDto.InputCourseDto;
import block7crudvalidation.person.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class course {
    @Mock
    ServiceCourse serviceCourse;

    @InjectMocks
    CourseController courseController;

    private Person person;

    private InputCourseDto course;


    @BeforeEach
    void personCreatePerson(){

        person = new Person();
        person.setId_person(1L);
        person.setUsers("users");
        person.setName("Victor");
        person.setSurname("Rubio");
        person.setCreated_date(new Date());
        person.setPersonal_email("victor@rubio.com");
        person.setCity("Pamplona");
        person.setActive(true);
        person.setTermination_date(new Date());
        person.setPassword("");
        person.setImagen_url("");

        course = new InputCourseDto();
        course.setCourse("mate");
        course.setComments("Buen curso");



    }



    @Test
    void saveTest() throws Exception {

        when(serviceCourse.addCourse(any(InputCourseDto.class))).thenReturn(new Course());
        assertNotNull(serviceCourse.addCourse(new InputCourseDto()));

    }








    @Test
    void addTestException() throws Exception {

        when(serviceCourse.addCourse(new InputCourseDto())).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> serviceCourse.addCourse(new InputCourseDto()));

    }

    @Test
    void getTestException() throws Exception {

        when(serviceCourse.getCourse(any(Long.class))).thenThrow(EntityNotFoundException.class);

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> serviceCourse.getCourse(1l));

    }

    @Test
    void getAllTestException() throws Exception {

        when(serviceCourse.getAllCourse()).thenThrow(EntityNotFoundException.class);

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> serviceCourse.getAllCourse());

    }

    @Test
    void deleteTestException() throws Exception {

        when(serviceCourse.deleteCourse(1L)).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> serviceCourse.deleteCourse(1L));

    }
}
