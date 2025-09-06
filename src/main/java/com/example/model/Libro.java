package com.example.model;

public class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible = true;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

}
