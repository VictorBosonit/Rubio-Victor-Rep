package block7crudvalidation.person.aplication;

import block7crudvalidation.person.domain.Person;
import block7crudvalidation.person.infraestructure.controller.dto.input.InputPersonDto;
import block7crudvalidation.person.infraestructure.controller.dto.output.OutputPersonDto;

import java.util.List;
import java.util.Optional;

public interface InterfaceServicePerson {


    // this method add object person to BB DD
    Person addPerson(Person person) throws  Exception;

    Person addPerson(InputPersonDto person)throws  Exception;

    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Optional<OutputPersonDto> getPerson(Long id)throws  Exception;

    //This method get object from BB DD trow us name
    //List is for get one o more dates from BB DD
    List<OutputPersonDto> getPersonByNames(String users)throws  Exception;


    List<OutputPersonDto> getAllPerson()throws  Exception;





}
