package org.example.person.infraestructure.controller.inputDto;


import lombok.Data;

@Data
public class InputPersonDto {

    private  String name;
    private String surname;
    private int age;
    private Long city;
}
