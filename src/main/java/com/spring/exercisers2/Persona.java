package com.spring.exercisers2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Persona {
    private long id;
    private String nombre,poblacion;
    private int edad;
}
