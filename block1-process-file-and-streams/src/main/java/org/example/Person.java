package org.example;

public class Person {

    String nombre;
    String ciudad;
    String edad;

    int edadEntero;
    public Person(String nombre, String ciudad, String edad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad =edad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {

        if (ciudad  == ""){ ciudad = "unknown";}

        return ciudad;
    }

    public void setCiudad(String ciudad) {

        this.ciudad = ciudad;
    }

    public int getEdad() {

       edadEntero= Integer.parseInt(edad);

        return edadEntero;
    }

    public void setEdad(String edad) {

        if (edad == "") {edad = "0";}

        this.edad =edad;
    }


    @Override
    public String toString() {
        return
                "nombre: " + nombre + ". " +
                        " ciudad:" + ciudad  + ". " +
                        " edad: " + edad  + ". "
                        ;
    }
}
