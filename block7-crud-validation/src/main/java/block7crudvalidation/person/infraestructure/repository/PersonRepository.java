package block7crudvalidation.person.infraestructure.repository;

import block7crudvalidation.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // This sentence is for get List of Person which the column name is same "name"
    // This method is implemented from JpaREpository
    List<Person> findByName(String name);



}