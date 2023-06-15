package com.jags.ClubDeGolf.Modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador {

    @Id
    @Column(name = "ID_ADMINISTRADOR")
    private String idAdministrador;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "EDAD")
    private String edad;

    //Creación de la relación entre Administrador y trabajador
    @OneToMany(mappedBy = "jefe", cascade = CascadeType.ALL)
    private List<Trabajador> trabajadores;

    public Administrador(String idAdministrador, String dni, String nombre, String apellidos, String edad) {
        this.idAdministrador = idAdministrador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Administrador() {
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
