package org.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;


@SpringBootApplication

public class Main implements EnvironmentAware, CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Value("${greeting}")
    private String greeting;
    @Value("${my.number}")
    private int myNumber;


//intentamos leer el valor del new.property que no existe
    @Value("${new.property:#{null}}")
    private String newProperty;


    @Override
    public void run(String... args) throws Exception {

            System.out.println("El valor de greeting es : "+ greeting);
            System.out.println("El valor de my.number es : "+ myNumber);
            System.out.println();
            if(newProperty==null){newProperty= "new.property no tiene valor";}
            System.out.println("El valor de new.property es : "+ newProperty);

    }

    private String greeting2;
    @Override
    public void setEnvironment(Environment environment) {
        this.greeting2 = environment.getProperty("greeting2");

    }
}