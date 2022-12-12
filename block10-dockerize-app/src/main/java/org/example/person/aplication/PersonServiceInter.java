package org.example.person.aplication;

import org.example.person.domain.Person;
import org.example.person.infraestructure.controller.inputDto.InputPersonDto;
import org.example.person.infraestructure.controller.outputDto.OutputPersonDto;

import java.util.List;
import java.util.Optional;

public interface PersonServiceInter {

    //This method add object from BB DD trow us id
    Person addPerson(InputPersonDto personDto)throws  Exception;

    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Optional<OutputPersonDto> getPerson(Long id)throws  Exception;

    List<OutputPersonDto> getAllPerson()throws  Exception;

    //This method update the BB DD where id=id
    Person updatePerson(Long id, InputPersonDto personDto)throws  Exception;

    // This method delete Person where id=id
    boolean deletePersson (Long id)throws  Exception;
}
