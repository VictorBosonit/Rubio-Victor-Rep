package block7crudvalidation.person.infraestructure.repository;

import block7crudvalidation.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // This sentence is for get List of Person which the column name is same "name"
    // This method is implemented from JpaREpository
    List<Person> findByName(String name);

    @Query(value = "SELECT user, name, surname, created_date FROM Person p where p.created_Date > ?date", nativeQuery = true )
    List<Person> findByDate(Date date);



}