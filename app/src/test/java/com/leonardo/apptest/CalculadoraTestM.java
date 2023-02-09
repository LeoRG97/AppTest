package com.leonardo.apptest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// agregar siguiente línea para usar Mockito en lugar de JUnit para las pruebas
@RunWith(MockitoJUnitRunner.class)
public class CalculadoraTestM {

    private Calculadora calc;

    @Before
    public void setUp() throws Exception {
        calc = mock(Calculadora.class);
        when(calc.suma(2,2)).thenReturn(4);
        when(calc.resta(2, 4)).thenReturn(-2);
        when(calc.multiplicacion(3, 5)).thenReturn(15);
        when(calc.division(10, 2)).thenReturn(5);
        when(calc.division(10, 0)).thenThrow(ArithmeticException.class); // cuando 10 / 0, arroja una instancia de clase ArithmeticException
    }

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void divisionMEx2(){
        int res = calc.division(10, 0);
    }

    @Test
    public void sumaM(){
        calc.suma(2, 2);
        verify(calc).suma(2, 2);
        // verificar que la función se haya ejecutado con los parámetros indicados
    }

    @Test
    public void restaM() throws Exception {
        calc.resta(2, 4);
        verify(calc).resta(2, 4);
    }

    @Test
    public void multiplicacionM() throws Exception {
        calc.multiplicacion(3, 5);
        verify(calc).multiplicacion(3, 5);
    }

    @Test
    public void divisionM() throws Exception {
        calc.division(10, 2);
        verify(calc).division(10, 2);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionMEx(){
        int res = calc.division(10, 0);
    }

    @Test
    public void sumaMAtLeast() throws Exception {
        calc.suma(2, 2);
        calc.suma(2, 4);
        verify(calc, atLeast(2)).suma(anyInt(), anyInt());
        // verificar que la función haya sido llamada el número de veces indicado
    }

    @Test
    public void sumNever() throws Exception {
        verify(calc, never()).suma(2, 2);
        // verificar que la función no haya sido llamada
    }
}
