package org.example.Objeto;

public class City {
// this is city class and we have the atributes ,the constructors and setter y getter methods
    private String name;
    private int numberHab;

    public City() {
    }

    public City(String name, int numberHab) {
        this.name = name;
        this.numberHab = numberHab;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberHab() {
        return numberHab;
    }

    public void setNumberHab(int numberHab) {
        this.numberHab = numberHab;
    }
}
