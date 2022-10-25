package org.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.annotation.PostConstruct;


@SpringBootApplication
public class command_line_runner  implements  CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(command_line_runner.class, args);
    }


    @Bean
    CommandLineRunner Bean()
    {

        return p -> { System.out.println("Hola desde la clase secundaria");};

    }

    @Bean
    CommandLineRunner Bean2(String[] args) {

        return p ->
        {
            System.out.println("Hola desde la tercera clase");

        };

    }

    @PostConstruct
    private void postConstruct()

        {
            System.out.println("Hola desde la clase incial");
        };
    @Override
    public void run(String... args) throws Exception {

        for (int i =0; i< args.length;i++){
            System.out.print(args[i]);}
        System.out.println();
    }

}