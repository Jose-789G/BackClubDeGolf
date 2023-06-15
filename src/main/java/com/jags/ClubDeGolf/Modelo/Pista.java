package com.jags.ClubDeGolf.Modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PISTA")
public class Pista {

    @Id
    @Column(name = "ID_PISTA")
    private String idPista;
    @Column(name = "N_PISTA")
    private String nPista;
    @Column(name = "DIMENSIONES")
    private String dimensiones;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "DISPONIBILIDAD")
    private boolean disponibilidad;

    //Creación de la relación entre pista y trabajador
    @ManyToMany(mappedBy = "pistas")
    private List<Trabajador> trabajadores = new ArrayList<>();

    //Creación de la relación entre la pista y el socio que la alquila
    @OneToMany(mappedBy = "pista", cascade = CascadeType.ALL)
    private List<Socio> socios;

    public Pista(String idPista, String nPista, String dimensiones, String estado, boolean disponibilidad) {
        this.idPista = idPista;
        this.nPista = nPista;
        this.dimensiones = dimensiones;
        this.estado = estado;
        this.disponibilidad = disponibilidad;
    }

    public Pista() {
    }

    public String getIdPista() {
        return idPista;
    }

    public void setIdPista(String idPista) {
        this.idPista = idPista;
    }

    public String getnPista() {
        return nPista;
    }

    public void setnPista(String nPista) {
        this.nPista = nPista;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
