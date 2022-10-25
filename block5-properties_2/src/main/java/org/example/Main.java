package org.example;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

public class Main implements  CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private YAMLConfig myConfig;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("El valor de greeting es : " + myConfig.getGreeting());
        System.out.println("El valor de my.number es : " + myConfig.getMyNumber());
        System.out.println("El valor de new.property es : " + myConfig.getNewProperty());

    }
}

