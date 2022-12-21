package block7crudvalidation.person;
import block7crudvalidation.person.application.ServicePerson;
import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.PersonController;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Filter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@DataJpaTest
public class PersonTest {


    @Mock
    ServicePerson servicePerson;

    @InjectMocks
    PersonController personController;

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

    }



    @Test
    void saveTest() throws Exception {

        when(servicePerson.addPerson(any(InputPersonDto.class))).thenReturn(person);
        assertNotNull(personController.addPerson(new InputPersonDto()));

    }

    @Test
    void getByIdTest() throws Exception {

        when(servicePerson.getPerson(any(Long.class))).thenReturn(Optional.ofNullable(person));
        long l = 1L;
        assertNotNull(personController.getPerson((l)));

    }

    @Test
    void getByNameTest() throws Exception {

        when(servicePerson.getPersonByNames(any(String.class))).thenReturn(Collections.singletonList(Optional.ofNullable(person)));
        String name= "Victor";
        assertNotNull(personController.getPersonByName((name)));

    }

    @Test
    void getAllTest() throws Exception {

        when(servicePerson.getAllPerson()).thenReturn(List.of(person));
        assertNotNull(personController.getAllPerson());

    }

    @Test
    void getDeleteTest() throws Exception {

        when(servicePerson.deletePerson(any())).thenReturn(person.getActive());
        long l = 1L;
        assertNotNull(personController.deletePerson(l));


    }
    @Test
    void addTestException() throws Exception {

        when(servicePerson.addPerson(new InputPersonDto())).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> servicePerson.addPerson(new InputPersonDto()));

    }

    @Test
    void getTestException() throws Exception {

        when(servicePerson.getPerson(any(Long.class))).thenThrow(EntityNotFoundException.class);

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> servicePerson.getPerson(1l));

    }

    @Test
    void getAllTestException() throws Exception {

        when(servicePerson.getAllPerson()).thenThrow(EntityNotFoundException.class);

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> servicePerson.getAllPerson());

    }

    @Test
    void deleteTestException() throws Exception {

        when(servicePerson.deletePerson(1L)).thenThrow(EntityNotFoundException.class);
        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(()-> servicePerson.deletePerson(1L));

    }
}
