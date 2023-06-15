package com.jags.ClubDeGolf.Modelo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TRABAJADOR")
public class Trabajador implements Serializable {

    @Id
    @Column(name = "ID_TRABAJADOR")
    private String idTrabajador;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "SUELDO")
    private String sueldo;

    //Creación de la relación entre el trabajador y la pista que gestiona
    @OneToMany
    @JoinTable(name = "trabajador_pista",
            joinColumns = @JoinColumn(name = "ID_TRABAJADOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_PISTA"))
    private List<Pista> pistas = new ArrayList<>();

    //Creación de la relación entre el administrador que contrata al trabajador
    @ManyToOne@JoinColumn(name = "ID_ADMINISTRADOR")
    private Administrador jefe;

    public Trabajador(String idTrabajador, String dni, String nombre, String apellidos, String sueldo,Administrador administrador) {
        this.idTrabajador = idTrabajador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
        this.jefe = administrador;
    }

    public Trabajador() {
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
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

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }
}
