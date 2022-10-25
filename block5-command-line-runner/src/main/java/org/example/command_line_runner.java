package org.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.annotation.PostConstruct;

//definimos la clase como  Spring Boot por medio de la anotacion @SpringBootAplication
@SpringBootApplication
public class command_line_runner  implements  CommandLineRunner {

    //creamos la clase Main donde meteremos el metodo para arrancar la aplicacion spring
    public static void main(String[] args) {
        SpringApplication.run(command_line_runner.class, args);
    }

        // la primera funcion imprime por consola la frase correspondiente
    @Bean
    CommandLineRunner Bean()
    {

        return p -> { System.out.println("Hola desde la clase secundaria");};

    }
    // la segunda funcion imprime por consola la frase correspondiente
    @Bean
    CommandLineRunner Bean2(String[] args) {

        return p ->
        {
            System.out.println("Hola desde la tercera clase");

        };

    }
    //La anotacion @postConstruct hace que la funcion se ejecute antes de que se lance los bean


    @PostConstruct
    private void postConstruct()

        {
            System.out.println("Hola desde la clase incial");
        };

    // la funcion @overide sobreescribe el metodo run y la utilizamos para imprimir los argumentos 
    @Override
    public void run(String... args) throws Exception {

        for (int i =0; i< args.length;i++){
            System.out.print(args[i]);}
        System.out.println();
    }

}