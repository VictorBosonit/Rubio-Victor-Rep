package block13mongodb.person.aplication;
import block13mongodb.person.domain.Person;
import block13mongodb.person.infraestructure.controller.inputDto.InputPersonDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceInterface implements PersonServiceInter{

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public Person addPerson(Person person) throws Exception {

        try {
            return  mongoTemplate.save(person);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Person getPerson(String name) throws Exception {

        try {
        Query query = new Query();
            query.addCriteria(Criteria.where("name").is(name));
        Person person = mongoTemplate.findById(name, Person.class);

            return person;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> getAllPerson() throws Exception {

        try {

            List<Person> person = mongoTemplate.findAll(Person.class);

            return person ;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }


    @Override
    public Person updatePerson(String name, InputPersonDto personDto) throws Exception {

        // we create a new object and then pass the parameter from controller
        try {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        Update update = new Update();
        update.set("name", "Mohan");
        update.set("age", 25);
        update.set("city", "Roma");
        mongoTemplate.updateFirst(query, update, Person.class);


         Person person= modelMapper.map(update, Person.class);


            return person;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean deletePersson(String name) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        try {

                mongoTemplate.remove(query);
                return true;


        } catch (Exception e) {
        }
        return false;
    }


}
