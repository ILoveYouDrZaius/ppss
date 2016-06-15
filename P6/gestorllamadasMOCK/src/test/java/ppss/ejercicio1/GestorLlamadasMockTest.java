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
import org.easymock.EasyMock;
import org.junit.Assert;


/**
 *
 * @author dario
 */
public class GestorLlamadasMockTest {
    private Calendario calendariomock;
    private TestableGestorLlamadas gestorllamadas = new TestableGestorLlamadas();
    
    @Test
    public void testC1() {
        int minutos = 10;
        double resultadoEsperado = 208.00f;
        calendariomock = EasyMock.createMock(Calendario.class);
        EasyMock.expect(calendariomock.getHoraActual()).andReturn(15);
        EasyMock.replay(calendariomock);
        
        gestorllamadas.setCalendario(calendariomock);
        double resultadoReal = gestorllamadas.calculaConsumo(minutos);
        Assert.assertEquals(resultadoReal, resultadoEsperado, 0.002f);
    }

    @Test
    public void testC2() {
        int minutos = 10;
        double resultadoEsperado = 105.00f;
        calendariomock = EasyMock.createMock(Calendario.class);
        EasyMock.expect(calendariomock.getHoraActual()).andReturn(22);
        EasyMock.replay(calendariomock);
        
        gestorllamadas.setCalendario(calendariomock);
        double resultadoReal = gestorllamadas.calculaConsumo(minutos);
        Assert.assertEquals(resultadoReal, resultadoEsperado, 0.002f);
    }
}
