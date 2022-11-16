package block7crudvalidation.Repository;

import block7crudvalidation.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    // This sentence is for get List of Person which the column name is same "name"
    // This method is implemented from JpaREpository
    List<Person> findByUsers(String users);

}