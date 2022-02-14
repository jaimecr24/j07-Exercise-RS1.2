package com.spring.exercisers2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ListaPersonaServiceImp implements ListaPersonaService{

    List<Persona> lista = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public long addPersona(String nombre, String poblacion, int edad) {
        lista.add(new Persona(counter.incrementAndGet(),nombre,poblacion,edad));
        return counter.get();
    }

    public int setPersona(long id, String nombre, String poblacion, int edad) {
        Optional<Persona> optPersona = lista.stream().filter(e -> e.getId()==id).findFirst();
        if (optPersona.isEmpty()) return 0;
        else {
          Persona p = optPersona.get();
          p.setNombre(nombre);
          p.setPoblacion(poblacion);
          p.setEdad(edad);
          return 1;
        }
    }

    public int delPersona(long id) {
        Optional<Persona> optPersona = lista.stream().filter(e -> e.getId()==id).findFirst();
        if (optPersona.isEmpty()) return 0;
        else {
            Persona p = optPersona.get();
            lista.remove(p);
            return 1;
        }
    }

    public Persona getPersona(long id) {
        Optional<Persona> optPersona = lista.stream().filter(e -> e.getId()==id).findFirst();
        return optPersona.orElse(null);
    }

    public List<Persona> getPersona(String nombre) {
        return lista.stream().filter(e -> e.getNombre().equals(nombre)).toList();
    }
}
