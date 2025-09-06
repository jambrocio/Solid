package com.example.model;

public class Usuario {

    private String nombre;
    private String idUsuario;

    public Usuario(String nombre, String idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    public String getNombre() { return nombre; }
    public String getIdUsuario() { return idUsuario; }
    
}
