package block10dockerizeapp.person.aplication;

import block10dockerizeapp.person.domain.Person;
import block10dockerizeapp.person.infraestructure.controller.inputDto.InputPersonDto;
import block10dockerizeapp.person.infraestructure.controller.outputDto.OutputPersonDto;


import java.util.List;
import java.util.Optional;

public interface PersonServiceInter {

    //This method add object from BB DD trow us id


    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Optional<OutputPersonDto> getPerson(Long id)throws  Exception;

    List<OutputPersonDto> getAllPerson()throws  Exception;

    //This method update the BB DD where id=id
    Person updatePerson(Long id, InputPersonDto personDto)throws  Exception;

    // This method delete Person where id=id
    boolean deletePersson (Long id)throws  Exception;
}
