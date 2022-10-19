package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // declaramos la lista que vamos a obtener

        List<Person> personas = new ArrayList<>();

        System.out.println();
        //llamamos al metodo lectura para leer el archivo e imprimos toda la lista
        lectura(personas);

        System.out.println();
        System.out.println();
        //llamamos al  metodo menores de 25 para mostrar la lista con menores de 25
        menores25(personas);

        System.out.println();
        System.out.println();
        //llamamos al metodo empizanA  y obtenemos la lista de todos los que no empiezan con A
        empiezanA(personas);

        System.out.println();
        System.out.println();
        //llamamos al metodo encontrarMadrid par obtener el primero de Madrid
        encuentraMadrid(personas);

        System.out.println();
        System.out.println();
        //llamamos al metodo encontrarMadrid par obtener el primero de Barcelona
        encuentraBarcelona(personas);

        System.out.println();
        System.out.println();
    }


    public static List<Person>  lectura(List<Person> personas)  {



        // declaramos el patch como ruta relativa
        String Lectura = "..\\bloque-1-jdk\\src\\main\\resources\\People.csv";
        try {

            // con la clase File leemos lo que tiene el archivo
            File nombreArchivo = new File(Lectura);

            //comprobamos que el archivo existe...si no esxiste imprimimos mensaje ne pantalla
            if (nombreArchivo.exists()) {


                BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));

                while (reader.ready()) {

                    String People = reader.readLine();

                    try {
                        String[] partes = People.split("\\:", -1);



                        if(partes[0] == ""){throw new InvalidLineFormatException("Surge un error de lectura");}

                        if (partes.length < 3) {

                            Person  listaPersona = new Person (partes[0], partes[1], "");
                            listaPersona.setNombre(partes[0]);
                            listaPersona.setCiudad(partes[1]);
                            listaPersona.setEdad("");
                            personas.add(listaPersona);

                            throw new InvalidLineFormatException("Surge un error de lectura");}else {

                            Person listaPersonas = new Person(partes[0], partes[1], partes[2]);

                            listaPersonas.setNombre(partes[0]);
                            listaPersonas.setCiudad(partes[1]);
                            listaPersonas.setEdad(partes[2]);
                            personas.add(listaPersonas);
                        }
                    }catch (Exception e) {

                        e.printStackTrace();
                    }

                }
                //es obligado cerrar la lectura una vez que esta hay terminado
                reader.close();
            } else {System.out.println(" El archivo no existe");}



            System.out.println("      ----Lista entera de lo que leemos del archivo mostrada----");

            //recorremos la lista de personas y la imprimimos por pantalla
            for (int i=0; i<personas.size(); i++){

                System.out.println(personas.get(i).toString());

            }

        }  catch (Exception e) {
            e.printStackTrace();
        }


        return personas;
    }
    public static class InvalidLineFormatException extends Exception {
        public InvalidLineFormatException (String errorMessage) {
            super(errorMessage);
        }
    }



    public static List<Person>  menores25(List<Person> personas) {

    System.out.println("                     ----Empieza el segundo metodo----");
    System.out.println();

    System.out.print(
            "a) Invocar a la función con un filtro que conserve únicamente\n " +
            "  las personas menores de 25 años. Imprimir la lista devuelta en la consola.\n " +
            "  Para los campos opcionales vacíos, imprimir: unknown. Nota: no deben aparecer las \n " +
            "  personas con 0 años, es decir, con edad desconocida.\n");
    System.out.println();

    personas
            .stream()
            .filter((Person p) -> p.getEdad() < 25)
            .filter((Person p) -> p.getEdad() != 0)
            .forEach((Person) -> System.out.println("Name: " + Person.getNombre() + ". Ciudad: " + Person.getCiudad() + ". Edad: " + Person.getEdad()));
    return personas;
}




    public static List<Person>  empiezanA(List<Person> personas) {

        System.out.println(
                "b) Invocar a la función con un filtro que elimine las personas cuyo\n  " +
                " nombre empiece con la letra A. Imprimir la lista devuelta en la consola. Para\n  " +
                " los campos opcionales vacíos, imprimir: unknown.\n" );

        System.out.println();

        personas.stream()
                .filter((Person p) -> !p.getNombre().startsWith("A"))
                .forEach((Person) -> System.out.println("Name: " + Person.getNombre() + ". Ciudad: " + Person.getCiudad() + ". Edad: " + Person.getEdad()));
        return personas;
    }


    public static Optional<Person>  encuentraMadrid(List<Person> personas) {

    System.out.println(
            "c) Usando el resultado del apartado a), crear un Stream a\n " +
            "  partir de la lista y obtener el primer elemento cuya ciudad sea Madrid.\n " +
            "  Si existe algún elemento imprimirlo. Tratar correctamente el Optional.\n");
        System.out.println();

   String city = String.valueOf(personas.stream()
            .filter((Person p)-> p.getCiudad().startsWith("Madrid"))
            .findFirst()
            .get());

        System.out.println(city);
        return null;
}
    public static Optional<Person>  encuentraBarcelona(List<Person> personas) {

        System.out.println(
                "d) Usando el resultado del apartado a), crear un Stream a partir de la lista y \n" +
                "  obtener el primer elemento cuya ciudad sea Barcelona. Si existe algún elemento imprimirlo.\n " +
                "  Tratar correctamente el Optional.\n");
        System.out.println();

        String city = String.valueOf(personas.stream()
                .filter((Person p)-> p.getCiudad().startsWith("Barcelona"))
                .findFirst()
                .get());

        System.out.println(city);

        return null;
    }
}