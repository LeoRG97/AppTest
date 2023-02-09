package com.leonardo.apptest;

public class Calculadora {

    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplicacion(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        int res = 0;
        try {
            res = a / b;
        } catch (ArithmeticException ex) {
            System.out.println("Error " + ex.getMessage());
            throw new IllegalArgumentException("Argumento " + b + " es cero");
        }
        return res;
    }

}
