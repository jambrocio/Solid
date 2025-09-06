package com.example.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Libro;
import com.example.model.Prestamo;
import com.example.model.Usuario;

public class GestorPrestamos {

    private CalculadoraMultaBus calculadoraMulta;
    private NotificadorBus notificador;
    private List<Prestamo> prestamos = new ArrayList<>();

    public GestorPrestamos(CalculadoraMultaBus calculadoraMulta, NotificadorBus notificador) {
        this.calculadoraMulta = calculadoraMulta;
        this.notificador = notificador;
    }

    public Prestamo realizarPrestamo(Libro libro, Usuario usuario) {
        if (!libro.isDisponible()) {
            System.out.println("❌ El libro '" + libro.getTitulo() + "' no está disponible");
            return null;
        }

        libro.setDisponible(false);
        Prestamo prestamo = new Prestamo(libro, usuario);
        prestamos.add(prestamo);

        String mensaje = "Has prestado '" + libro.getTitulo() + "'. Fecha de devolución: " +
                prestamo.getFechaDevolucion().toLocalDate();
        notificador.enviar(mensaje, usuario.getNombre());

        System.out.println("✅ Préstamo realizado: '" + libro.getTitulo() + "' para " + usuario.getNombre());
        return prestamo;
    }

    public void devolverLibro(Prestamo prestamo) {
        if (prestamo.isDevuelto()) {
            System.out.println("❌ Este libro ya fue devuelto");
            return;
        }

        LocalDateTime fechaActual = LocalDateTime.now();
        if (fechaActual.isAfter(prestamo.getFechaDevolucion())) {
            long diasRetraso = ChronoUnit.DAYS.between(prestamo.getFechaDevolucion(), fechaActual);
            double multa = calculadoraMulta.calcular(diasRetraso);
            System.out.println("⚠️  Retraso de " + diasRetraso + " días. Multa: $" + multa);
        } else {
            System.out.println("✅ Libro devuelto a tiempo");
        }

        prestamo.setDevuelto(true);
        prestamo.getLibro().setDisponible(true);
        System.out.println("📚 '" + prestamo.getLibro().getTitulo() + "' devuelto por " + prestamo.getUsuario().getNombre());
    }

}
