package org.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class command_line_runner  {

    public static void main(String[] args) {


        SpringApplication.run(command_line_runner.class, args);



    }
    @Bean
    CommandLineRunner Bean()
    {
        return p ->
        {
            new SegundaClase();
            new TerceraClase();
        };
    }


    @PostConstruct
    private void postConstruct()

        {
            System.out.println("Hola desde la clase incial");
        };


}