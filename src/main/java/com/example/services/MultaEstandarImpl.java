package com.example.services;

public class MultaEstandarImpl implements CalculadoraMultaBus{

    public double calcular(long diasRetraso) {
        return diasRetraso * 10;
    }
}
