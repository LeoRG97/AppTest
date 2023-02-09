package com.leonardo.apptest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculadoraTestJ {
    private static Calculadora calc;

    @BeforeClass
    public static void setUp() throws Exception {
        // se ejecuta antes de las pruebas
        calc = new Calculadora();
    }

    @Test
    public void sumaJ() throws Exception {
        int res = calc.suma(2, 2);
        int resEsperado = 4;
        Assert.assertEquals(resEsperado, res);
    }

    @Test
    public void restaJ() throws Exception {
        int res = calc.resta(2, 4);
        int resEsperado = -2;
        Assert.assertEquals(resEsperado, res);
    }

    @Test
    public void multiplicacionJ() throws Exception {
        int res = calc.multiplicacion(3, 5);
        int resEsperado = 15;
        Assert.assertEquals(resEsperado, res);
    }

    @Test
    public void divisionJ() throws Exception {
        int res = calc.division(10, 2);
        int resEsperado = 5;
        Assert.assertEquals(resEsperado, res);
    }

    @Test
    public void sumaJNotEqual() throws Exception {
        int res = calc.suma(2, 2);
        int resEsperado = 5;
        Assert.assertNotEquals(resEsperado, res);
    }

    @Test
    public void sumaJTrue() throws Exception {
        int res = calc.suma(2, 2);
        int resEsperado = 4;
        Assert.assertTrue(resEsperado == res);
    }

    @Ignore // añadir esta anotación para ignorar una prueba
    @Test
    public void testQueFallara() throws Exception {
        fail("Falla porque está pendiente de implementar");
    }
}