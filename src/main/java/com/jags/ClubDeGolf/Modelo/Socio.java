package com.jags.ClubDeGolf.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "SOCIO")
public class Socio {

    @Id
    @Column(name = "ID_SOCIO")
    private String idSocio;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDOS")
    private String apellidos;

    //Creación de la relación entre el socio y la pista
    @ManyToOne
    @JoinColumn(name = "ID_PISTA")
    private Pista pista;


    public Socio(String idSocio, String dni, String nombre, String apellidos,Pista pista) {
        this.idSocio = idSocio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pista = pista;
    }

    public Socio() {
    }

    public String getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(String idSocio) {
        this.idSocio = idSocio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
