package block10dockerizeapp.person.aplication;

import block10dockerizeapp.person.domain.Person;
import block10dockerizeapp.person.infraestructure.controller.inputDto.InputPersonDto;
import block10dockerizeapp.person.infraestructure.controller.outputDto.OutputPersonDto;
import block10dockerizeapp.person.infraestructure.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PersonService implements PersonServiceInter{
    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public Person addPerson(InputPersonDto personDto) throws Exception {
        //I get an object type inputTeacherDto from RestController and
        // I mapped the inputTeacherDto to Person object
        Person person;


        try {
            person = modelMapper.map(personDto, Person.class);
            // I get the date from system and add the date to Created_date and save
            // in database

            return  personRepository.save(person);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<OutputPersonDto> getPerson(Long id) throws Exception {

        OutputPersonDto dtoPerson;
        try {
            Optional<Person> person = personRepository.findById(id);
            if(person.isPresent()) {

                dtoPerson = modelMapper.map(person, OutputPersonDto.class);


            }else{throw new EntityNotFoundException() ;}
            // I return an optional of object dtoTeacher
            return Optional.of(dtoPerson);

        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OutputPersonDto> getAllPerson() throws Exception {
        List<OutputPersonDto> dtoPerson = new ArrayList<>();
        try {
            // I get a list of object when I call to method getAllTeacher
            List<Person> person = personRepository.findAll();
            // I mapped the list of person to list of objects type outputTeacherDto using
            // TypeToken (TypeToken is used to map generic parameterized types.)
            dtoPerson = modelMapper.map(person, new TypeToken<List<OutputPersonDto>>(){}.getType());
            // I return a list of objects type OutputTeacherDto
            return dtoPerson ;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }


    @Override
    public Person updatePerson(Long id, InputPersonDto personDto) throws Exception {

        // we create a new object and then pass the parameter from controller

        try {
            // I get  object from database and put on personFind
            Person personFind = personRepository.findById(id).get();
            // if id > 1 mapped personDto to personfind
            if (personFind.getId()==id) {
                modelMapper.map(personDto, personFind);
            } else {
                throw new EntityNotFoundException();
            }
            return personRepository.save(personFind);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean deletePersson(Long id) throws Exception {
        try {
            Optional<Person> person = personRepository.findById(id);
            if (person.isPresent()) {
                personRepository.deleteById(id);
                return true;
            }else {throw new EntityNotFoundException() ;}

        } catch (Exception e) {
        }
        return false;
    }


}
