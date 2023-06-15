package com.jags.ClubDeGolf.Repositorio;


import com.jags.ClubDeGolf.Modelo.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositorioTrabajador extends JpaRepository<Trabajador, String> {

    //Métodos personalizados
    Optional<Trabajador> findById(String id);

    <T extends Trabajador> T save(T trabajador);
    void deleteById(String id);
}
