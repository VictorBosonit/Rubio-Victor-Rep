package block13mongodb.person.aplication;
import block13mongodb.person.domain.Person;
import block13mongodb.person.infraestructure.controller.inputDto.InputPersonDto;
import java.util.List;


public interface PersonServiceInter {

    //This method add object from BB DD trow us id


    Person addPerson(Person person) throws Exception;

    //This method get object from BB DD trow us id
    //Optional is for prevent error nullpointerexception
    Person getPerson(String name)throws  Exception;

    List<Person> getAllPerson()throws  Exception;

    //This method update the BB DD where id=id
    Person updatePerson(String name, InputPersonDto personDto)throws  Exception;

    // This method delete Person where id=id
    boolean deletePersson (String name)throws  Exception;
}
