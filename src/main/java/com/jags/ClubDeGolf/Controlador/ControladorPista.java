package com.jags.ClubDeGolf.Controlador;


import com.jags.ClubDeGolf.Modelo.Pista;
import com.jags.ClubDeGolf.Servicios.ServicioPista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pista")
public class ControladorPista {
    @Autowired
    private ServicioPista pistaServicio;

    @GetMapping("/{id}")
    public Pista buscarPorID(@PathVariable String id) {
        Optional<Pista> pistaOptional = pistaServicio.buscarPorId(id);
        if (pistaOptional.isPresent()) {
            Pista pista = pistaOptional.get();
            return pista;
        }
        return null;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Pista> guardar(@RequestBody Pista pista) {
        Pista pistaGuardado = pistaServicio.guardar(pista);
        return new ResponseEntity<>(pistaGuardado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Pista> leerRegistros() {
        return pistaServicio.buscarTodos();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (pistaServicio.buscarPorId(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pistaServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
