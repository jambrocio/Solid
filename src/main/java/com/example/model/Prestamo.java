package com.example.model;

import java.time.LocalDateTime;

public class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
    private boolean devuelto;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDateTime.now();
        this.fechaDevolucion = LocalDateTime.now().plusDays(14);
        this.devuelto = false;
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
    public LocalDateTime getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDateTime fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
    public boolean isDevuelto() { return devuelto; }
    public void setDevuelto(boolean devuelto) { this.devuelto = devuelto; }
}
