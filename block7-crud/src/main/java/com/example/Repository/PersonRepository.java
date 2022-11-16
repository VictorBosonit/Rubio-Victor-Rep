package com.example.Repository;
import com.example.Object.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



// PersonRepository extends from JpaRepository and implements all his methods
public interface PersonRepository extends JpaRepository <Person,Long> {

    // This is a @Query that we use for get object with parameter index
    // We can use List<Person> findByName()
    @Query (value = "SELECT * FROM Person p where p.name = ?1", nativeQuery = true )
    List<Person> findbyName(String name);

}
