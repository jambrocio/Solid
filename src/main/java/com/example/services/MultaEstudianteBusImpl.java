package com.example.services;

public class MultaEstudianteBusImpl implements CalculadoraMultaBus{

    public double calcular(long diasRetraso) {
        return diasRetraso * 5;
    }
    
}
