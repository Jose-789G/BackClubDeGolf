package com.jags.ClubDeGolf.Servicios;


import com.jags.ClubDeGolf.Modelo.Trabajador;
import com.jags.ClubDeGolf.Repositorio.RepositorioTrabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioTrabajador {
    @Autowired
    private RepositorioTrabajador repositorioTrabajador;


    public Optional<Trabajador> buscarPorId(String id) {return repositorioTrabajador.findById(id);}
    public Trabajador guardar(Trabajador trabajador) {
        return repositorioTrabajador.save(trabajador);
    }
    public List<Trabajador> buscarTodos() {
        return repositorioTrabajador.findAll();
    }
    public void eliminar(String dni) {
        repositorioTrabajador.deleteById(dni);
    }
}
