package com.example;

import java.time.LocalDateTime;

import com.example.model.Libro;
import com.example.model.Prestamo;
import com.example.model.Usuario;
import com.example.services.GestorPrestamos;
import com.example.services.MultaEstandarImpl;
import com.example.services.MultaEstudianteBusImpl;
import com.example.services.NotificadorEmailImpl;
import com.example.services.NotificadorSMSImpl;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("🏛️  SISTEMA DE BIBLIOTECA - PRINCIPIOS SOLID");
        System.out.println("==================================================");

        // Crear libros
        Libro libro1 = new Libro("1984", "George Orwell", "978-0-452-28423-4");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-84-376-0494-7");

        // Crear usuarios
        Usuario usuario1 = new Usuario("Ana García", "U001");
        Usuario usuario2 = new Usuario("Carlos López", "U002");

        // Crear diferentes gestores
        System.out.println("\n📋 GESTOR PARA USUARIOS REGULARES:");
        GestorPrestamos gestorRegular = new GestorPrestamos(
                new MultaEstandarImpl(),
                new NotificadorEmailImpl()
        );

        System.out.println("\n📋 GESTOR PARA ESTUDIANTES:");
        GestorPrestamos gestorEstudiante = new GestorPrestamos(
                new MultaEstudianteBusImpl(),
                new NotificadorSMSImpl()
        );

        // Realizar préstamos
        System.out.println("\n🔄 REALIZANDO PRÉSTAMOS:");
        Prestamo prestamo1 = gestorRegular.realizarPrestamo(libro1, usuario1);
        Prestamo prestamo2 = gestorEstudiante.realizarPrestamo(libro2, usuario2);

        // Simular devolución tardía
        System.out.println("\n📅 SIMULANDO DEVOLUCIÓN TARDÍA:");
        prestamo1.setFechaDevolucion(LocalDateTime.now().minusDays(3));
        gestorRegular.devolverLibro(prestamo1);

        // Devolución a tiempo
        System.out.println("\n📅 DEVOLUCIÓN A TIEMPO:");
        gestorEstudiante.devolverLibro(prestamo2);
    }
}