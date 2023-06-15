package com.jags.ClubDeGolf.Repositorio;

import com.jags.ClubDeGolf.Modelo.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioSocio extends JpaRepository<Socio, String> {

    //Métodos personalizados
    Optional<Socio> findById(String dni);

    <S extends Socio> S save(S socio);
    void deleteById(String dni);

}
