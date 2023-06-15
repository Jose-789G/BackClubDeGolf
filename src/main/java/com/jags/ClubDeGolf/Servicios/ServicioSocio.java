package com.jags.ClubDeGolf.Servicios;


import com.jags.ClubDeGolf.Modelo.Socio;
import com.jags.ClubDeGolf.Repositorio.RepositorioSocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioSocio {
    @Autowired
    private RepositorioSocio RepositorioSocio;

    public Optional<Socio> buscarPorId(String id) {
        return RepositorioSocio.findById(id);
    }
    public Socio guardar(Socio socio) {
        return RepositorioSocio.save(socio);
    }
    public List<Socio> buscarTodos() {
        return RepositorioSocio.findAll();
    }
    public void eliminar(String dni) {
        RepositorioSocio.deleteById(dni);
    }
}
