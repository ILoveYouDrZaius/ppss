/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.ejercicio1;

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
    private int minutos, hora;
    private TesteableGestorLlamadas gestorllamadas = new TesteableGestorLlamadas();
    private double resultadoEsperado, resultadoReal;
    
    public GestorLlamadasTest() {
    }
    
    /**
     * Test of calculaConsumo method, of class GestorLlamadas.
     */
    @Test
    public void testCalculaConsumoC1() {
        hora = 15;
        minutos = 10;
        
        gestorllamadas.setHora(hora);
        resultadoReal = gestorllamadas.calculaConsumo(minutos);
        resultadoEsperado = 208.00f;
        
        assertEquals(resultadoReal, resultadoEsperado, 0.002f);
    }
    
    @Test
    public void testCalculaConsumoC2() {
        hora = 15;
        minutos = 10;
        
        gestorllamadas.setHora(hora);
        resultadoReal = gestorllamadas.calculaConsumo(minutos);
        resultadoEsperado = 208.00f;
        
        assertEquals(resultadoReal, resultadoEsperado, 0.002f);
    }
    
}
