package com.example.services;

public class NotificadorEmailImpl implements NotificadorBus{

    public boolean enviar(String mensaje, String destinatario) {
        System.out.println("📧 Email a " + destinatario + ": " + mensaje);
        return true;
    }
    
}
