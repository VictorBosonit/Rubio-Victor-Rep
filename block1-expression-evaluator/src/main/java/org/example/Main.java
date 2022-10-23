package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {

        System.out.println(
                "Crear un programa que reciba la ruta de un fichero\n" +
                "y evalúe las expresiones línea a línea.\n" +
                "El evaluador de expresiones reconocerá 3 tipos de datos:\n" +
                "números enteros, cadenas de texto y fechas.\n");


        lecturayevaluacion();


    }



    public static void lecturayevaluacion(){
        try {

            //se crean las expresiones que deberemos reconoces (nos pide el ejercico)

            String regexpEntero = "-?[0-9]+";
            String regexpCadena = ".*[a-z].*";
            String regexpFecha = "\\d{4}/\\d{2}/\\d{2}";


            // creamos el metodo para leer el archcivo
            File archivo =new File("..\\block1-expression-evaluator\\src\\main\\resources\\evaluador.csv");
            System.out.println();
            BufferedReader reader = new BufferedReader(new FileReader(archivo));


            //recorremos  el archivo y evaluamos si coincide con una de las expresiones declaradas con anterioridad

            while (reader.ready()) {

                String Linea = reader.readLine();

                String[] partes = Linea.split(" ");

                //System.out.println(Linea);

                //dependiendo de la evaluacion llamamos al metodo determinado

                    if (partes[0].matches(regexpFecha)){formatoFecha(partes);}
                    if (partes[0].matches(regexpEntero)){formatoNumero(partes);}
                    if (partes[0].matches(regexpCadena)){formatoCadena(partes);}

            }

        }catch (Exception e){}

    }
    public static void formatoNumero(String[] partes) throws ParseException {

        System.out.println("Operaciones permitidas con enteros:\n " +
                "Suma, con el símbolo: + . \n" +
                " Resta, con el símbolo: - .\n " +
                "Multiplicación, con el símbolo: * .\n " +
                "División, con el símbolo: / .\n");


        int digitonum1 =Integer.parseInt(partes[0]);
        int digitonum2 =Integer.parseInt(partes[2]);

       switch(partes [1]){

           case "+"://funcion perteneciente a la suma

               System.out.println(digitonum1 + digitonum2);
            break;

           case "-"://funcion perteneciente a la resta

               System.out.println(digitonum1 - digitonum2);
               break;

           case "*"://funcion perteneciente a la multiplicaion

               System.out.println(digitonum1 * digitonum2);
               break;

           case "/"://funcion perteneciente a la division

               System.out.println(digitonum1 / digitonum2);
               break;

       }
        System.out.println();

    }
    public static void formatoCadena(String[] partes){

        System.out.println("Las cadenas de texto estarán siempre envueltas " +
                "con comillas dobles. Por ejemplo: “Hello world”.\n" +
                "Operaciones permitidas con cadenas de texto:\n" +
                "Concatenación, con el símbolo: + .\n" +
                "Repetición, con el símbolo: * .\n");


            String resultado = "";

            for (int i=0; i< partes.length;i++){


                if (i%2 != 0) {

                    switch (partes[i]){

                        case "+": // concatenacion con el simbolo +

                            resultado = "\"" + partes[i-1].replace("�", "") + " " + partes [i+1].replace("�", "")+ "\"";
                            System.out.println(resultado);
                            break;

                        case "*": // repeticion con el simbolo *

                            resultado = "\"" + partes[i-1].replace("�", "") + " " + partes [i-1].replace("�", "")+ "\"";
                            System.out.println(resultado);
                            break;
                    }
                }
            }

       // System.out.println("Cadena");
}
    public static void formatoFecha(String[] partes){System.out.println("fecha");}
}