package com.jags.ClubDeGolf.Repositorio;

import com.jags.ClubDeGolf.Modelo.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioAdministrador extends JpaRepository<Administrador, String> {

    //Métodos personalizados
    Optional<Administrador> findById(String id);

    <A extends Administrador> A save(A administrador);
    void deleteById(String id);
}
