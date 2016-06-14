/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dario
 */
public class GestorLlamadasTest {
    private TesteableGestorLlamadas gestorllamadas = new TesteableGestorLlamadas();
    private CalendarioStub calendario = new CalendarioStub();
    private int hora, minutos;
    private double resultadoEsperado, resultadoReal;
    
    @Test
    public void TestC1() {
        hora = 10;
        minutos = 15;
        calendario.setHora(hora);
        gestorllamadas.setCalendario(calendario);
        
        resultadoEsperado = 208.00f;
        resultadoReal = gestorllamadas.calculaConsumo(minutos);
        
        assertEquals(resultadoReal, resultadoEsperado, 0.002f);
    }
    
    @Test
    public void TestC2() {
        hora = 10;
        minutos = 22;
        calendario.setHora(hora);
        gestorllamadas.setCalendario(calendario);
        
        resultadoEsperado = 105.00f;
        resultadoReal = gestorllamadas.calculaConsumo(minutos);
        
        assertEquals(resultadoReal, resultadoEsperado, 0.002f);
    }
}
