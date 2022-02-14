package com.spring.exercisers2;

import java.util.List;

public interface ListaPersonaService {
    long addPersona(String nombre, String poblacion, int edad);  // Add a new person. Returns his id
    int setPersona(long id, String nombre, String poblacion, int edad); // Update person identified by id
    int delPersona(long id); // Delete a person by id
    Persona getPersona(long id); // Return a person by id
    List<Persona> getPersona(String nombre); // Return a list of person by nombre
}
