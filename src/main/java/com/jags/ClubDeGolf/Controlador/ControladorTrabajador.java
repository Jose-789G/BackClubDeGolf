package com.jags.ClubDeGolf.Controlador;


import com.jags.ClubDeGolf.Modelo.Trabajador;
import com.jags.ClubDeGolf.Servicios.ServicioTrabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trabajador")
public class ControladorTrabajador {

    @Autowired
    private ServicioTrabajador trabajadorServicio;

    @GetMapping("/{id}")
    public Trabajador buscarPorID(@PathVariable String id) {
        Optional<Trabajador> trabajadorOptional = trabajadorServicio.buscarPorId(id);
        if (trabajadorOptional.isPresent()) {
            Trabajador trabajador = trabajadorOptional.get();
            return trabajador;
        }
        return null;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Trabajador> guardar(@RequestBody Trabajador trabajador) {
        Trabajador trabajadorGuardado = trabajadorServicio.guardar(trabajador);
        return new ResponseEntity<>(trabajadorGuardado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Trabajador> leerRegistros() {
        return trabajadorServicio.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (trabajadorServicio.buscarPorId(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        trabajadorServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
