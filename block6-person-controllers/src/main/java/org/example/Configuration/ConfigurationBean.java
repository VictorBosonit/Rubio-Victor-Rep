package org.example.Configuration;

import org.example.Model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {



    @Bean
    @Qualifier("bean1")
    public Person bean1(){
        Person person1 =  new Person("pepe", 10, "New York");
        return person1;
    }
    @Bean
    @Qualifier("bean2")
    public Person bean2(){
        Person person2 =  new Person("pepa", 11, "Munich");
        return person2;
    }
    @Bean
    @Qualifier("bean3")
    public Person bean3(){
        Person person3 =  new Person("Pepi", 12, "londres");
        return person3;
    }


}



