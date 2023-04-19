package com.example.lab4_20192270.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Aerolinea {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idaerolinea")
    private int idaerolinea;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "codigo")
    private String codigo;

    public int getIdaerolinea() {
        return idaerolinea;
    }

    public void setIdaerolinea(int idaerolinea) {
        this.idaerolinea = idaerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aerolinea aerolinea = (Aerolinea) o;
        return idaerolinea == aerolinea.idaerolinea && Objects.equals(nombre, aerolinea.nombre) && Objects.equals(codigo, aerolinea.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idaerolinea, nombre, codigo);
    }
}
