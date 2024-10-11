package com.example.calculadora;

public class Division extends CalculadoraBase{
    @Override
    public double calcular(double valor1, double valor2) {
        if (valor2 != 0) {
            return valor1 / valor2;
        } else {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
    }
}
