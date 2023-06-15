package com.jags.ClubDeGolf.Controlador;


import com.jags.ClubDeGolf.Modelo.Administrador;
import com.jags.ClubDeGolf.Servicios.ServicioAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administrador")
public class ControladorAdministrador {

    @Autowired
    private ServicioAdministrador administradorServicio;

    @GetMapping("/{id}")
    public Administrador buscarPorID(@PathVariable String id) {
        Optional<Administrador> socioOptional = administradorServicio.buscarPorId(id);
        if (socioOptional.isPresent()) {
            Administrador admin = socioOptional.get();
            return admin;
        }
        return null;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Administrador> guardar(@RequestBody Administrador admin) {
        Administrador socioGuardado = administradorServicio.guardar(admin);
        return new ResponseEntity<>(socioGuardado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Administrador> leerRegistros() {
        return administradorServicio.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (administradorServicio.buscarPorId(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        administradorServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
