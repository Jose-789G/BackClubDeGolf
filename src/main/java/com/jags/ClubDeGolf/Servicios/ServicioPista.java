package com.jags.ClubDeGolf.Servicios;


import com.jags.ClubDeGolf.Modelo.Pista;
import com.jags.ClubDeGolf.Repositorio.RepositorioPista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPista {
    @Autowired
    private RepositorioPista repositorioPista;


    public Optional<Pista> buscarPorId(String id) {return repositorioPista.findById(id);}
    public Pista guardar(Pista pista) {return repositorioPista.save(pista);}
    public List<Pista> buscarTodos() {return repositorioPista.findAll();}
    public void eliminar(String dni) {repositorioPista.deleteById(dni);}
}
