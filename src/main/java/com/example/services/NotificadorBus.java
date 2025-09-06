package com.example.services;

public interface NotificadorBus {

    boolean enviar(String mensaje, String destinatario);
    
}
