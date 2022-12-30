package block7crudvalidation.student;
import block7crudvalidation.person.domain.Person;
import block7crudvalidation.student.application.ServiceStudent;
import block7crudvalidation.student.domain.Student;
import block7crudvalidation.student.infraestructure.controller.StudentController;
import block7crudvalidation.student.infraestructure.controller.dto.input.InputStudentDto;
import block7crudvalidation.student.infraestructure.controller.dto.output.OutputStudentDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DataJpaTest
public class studentTest {

    @Mock
    ServiceStudent serviceStudent;

    @InjectMocks
    StudentController studentController;

    private OutputStudentDto student;
    private Person person;

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

        student= new OutputStudentDto();

        student.setId_student(1L);
        student.setNum_hours_week(10);
        student.setComments("Perfecto");
        student.setBranch("");

    }

    @Test
    void saveTest() throws Exception {

        when(serviceStudent.addStudent(any(InputStudentDto.class))).thenReturn(new Student());
        assertNotNull(studentController.addPerson(new InputStudentDto()));

    }

    @Test
    void getByIdTest() throws Exception {

        when(serviceStudent.getStudent(any(Long.class))).thenReturn(Optional.ofNullable(student));
        long l = 1L;
        assertNotNull(studentController.getStudent(l, "simple".describeConstable()));

    }

    @Test
    void getAllTest() throws Exception {

        when(serviceStudent.getAllStudents()).thenReturn(List.of(student));
        assertNotNull(studentController.getAllStudent());

    }

    @Test
    void getDeleteTest() throws Exception {

        when(serviceStudent.deleteStudent(any())).thenReturn(true);
        long l = 1L;
        assertNotNull(studentController.deleteStudent(l));

    }
    @Test
    void addTestException() throws Exception {

        when(serviceStudent.addStudent(new InputStudentDto())).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> serviceStudent.addStudent(new InputStudentDto()));

    }

    @Test
    void getTestException() throws Exception {

        when(serviceStudent.getStudent(any(Long.class))).thenThrow(EntityNotFoundException.class);

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> serviceStudent.getStudent(1l));

    }

    @Test
    void getAllTestException() throws Exception {

        when(serviceStudent.getAllStudents()).thenThrow(EntityNotFoundException.class);

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> serviceStudent.getAllStudents());

    }

    @Test
    void deleteTestException() throws Exception {

        when(serviceStudent.deleteStudent(1L)).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> serviceStudent.deleteStudent(1L));

    }
}
