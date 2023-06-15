package com.jags.ClubDeGolf.Servicios;


import com.jags.ClubDeGolf.Modelo.Administrador;
import com.jags.ClubDeGolf.Repositorio.RepositorioAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioAdministrador {
    @Autowired
    private RepositorioAdministrador repositorioAdministrador;


    public Optional<Administrador> buscarPorId(String id) {return repositorioAdministrador.findById(id);}
    public Administrador guardar(Administrador admin) {return repositorioAdministrador.save(admin);}
    public List<Administrador> buscarTodos() {return repositorioAdministrador.findAll();}
    public void eliminar(String dni) {repositorioAdministrador.deleteById(dni);}
}
