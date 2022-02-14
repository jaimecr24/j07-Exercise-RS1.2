package com.spring.exercisers2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("persona")
public class Controlador {

    @Autowired
    ListaPersonaService lista;

    @PostMapping("/")
    public String addPersona(@RequestBody Map<String,Object> body){
        String error = "Error en los datos de entrada";
        if (body==null) return error;
        if (body.get("nombre")==null || body.get("nombre").toString().equals("")) return error;
        if (body.get("poblacion")==null || body.get("poblacion").toString().equals("")) return error;
        if (body.get("edad")==null) return error;
        else {
            long id = lista.addPersona(body.get("nombre").toString(),body.get("poblacion").toString(),Integer.parseInt(body.get("edad").toString()));
            return "Persona añadida a la lista con id = " + id;
        }
    }

    @PutMapping("/{id}")
    public String putPersona(@PathVariable long id, @RequestBody Map<String,Object> body) {
        String error = "Error en los datos de entrada";
        if (body==null) return "No hay datos de entrada";
        if (id<1) return "Valor incorrecto en el id";
        if (body.get("nombre")==null || body.get("nombre").toString().equals("")) return error;
        if (body.get("poblacion")==null || body.get("poblacion").toString().equals("")) return error;
        if (body.get("edad")==null) return error;
        else {
            int res = lista.setPersona(id,body.get("nombre").toString(),body.get("poblacion").toString(),Integer.parseInt(body.get("edad").toString()));
            return (res==1)?"Datos modificados.":"Error: el id no existe";
        }
    }

    @DeleteMapping("/{id}")
    public String delPersona(@PathVariable long id){
        int res = lista.delPersona(id);
        return (res==1)?"Persona borrada de la lista":"Error: el id no existe";
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable long id){
        Optional<Persona> optPersona = Optional.ofNullable(lista.getPersona(id));
        if (optPersona.isPresent()) return optPersona.get();
        else return ("Error: el id no existe");
    }

    @GetMapping("/nombre/{nombre}")
    public Object getById(@PathVariable String nombre){
        return lista.getPersona(nombre);
    }
}
