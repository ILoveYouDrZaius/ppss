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
public class GestorLlamadasPartialMockTest {
    private Calendario calendariomock;
    private GestorLlamadas gestorllamadasmock;
    
    @Test
    public void testC1() {
        int minutos = 10;
        double resultadoEsperado = 208.00f;
        calendariomock = EasyMock.createMock(Calendario.class);
        EasyMock.expect(calendariomock.getHoraActual()).andReturn(15);
        gestorllamadasmock = EasyMock.createMockBuilder(GestorLlamadas.class).addMockedMethod("getCalendario").createMock();
        EasyMock.expect(gestorllamadasmock.getCalendario()).andReturn(calendariomock);
        EasyMock.replay(calendariomock, gestorllamadasmock);
        
        double resultadoReal = gestorllamadasmock.calculaConsumo(minutos);
        Assert.assertEquals(resultadoReal, resultadoEsperado, 0.002f);
    }

    @Test
    public void testC2() {
        int minutos = 10;
        double resultadoEsperado = 105.00f;
        calendariomock = EasyMock.createMock(Calendario.class);
        EasyMock.expect(calendariomock.getHoraActual()).andReturn(22);
        
        gestorllamadasmock = EasyMock.createMockBuilder(GestorLlamadas.class).addMockedMethod("getCalendario").createMock();
        EasyMock.expect(gestorllamadasmock.getCalendario()).andReturn(calendariomock);
        
        EasyMock.replay(calendariomock, gestorllamadasmock);

        
        double resultadoReal = gestorllamadasmock.calculaConsumo(minutos);
        Assert.assertEquals(resultadoReal, resultadoEsperado, 0.002f);
    }
}
