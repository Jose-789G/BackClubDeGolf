package com.jags.ClubDeGolf.Repositorio;

import com.jags.ClubDeGolf.Modelo.Pista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioPista extends JpaRepository<Pista, String> {

    //Métodos personalizados
    Optional<Pista> findById(String id);

    <P extends Pista> P save(P pista);
    void deleteById(String id);
}
