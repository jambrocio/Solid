package com.example.services;

public class NotificadorSMSImpl implements NotificadorBus{

    public boolean enviar(String mensaje, String destinatario) {
        System.out.println("📱 SMS a " + destinatario + ": " + mensaje);
        return true;
    }
    
}
