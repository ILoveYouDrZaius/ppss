/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import excepciones.ClienteWebServiceException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.easymock.EasyMock;
import org.junit.Assert;

import excepciones.ClienteWebServiceException;

/**
 *
 * @author dario
 */
public class PremioMockTest {
    ClienteWebService clientemock;
    Premio premiomock;
    float numeroAleatorio;
    String resultadoReal, resultadoEsperado;
    
    
    @Test
    public void testC1() throws ClienteWebServiceException {
        resultadoEsperado = "Premiado con pez de goma";
        numeroAleatorio = 0.01f;
        clientemock = EasyMock.createMock(ClienteWebService.class);
        EasyMock.expect(clientemock.obtenerPremio()).andReturn("pez de goma");
        
        premiomock = EasyMock.createMockBuilder(Premio.class).addMockedMethod("generaNumero").createMock();
        EasyMock.expect(premiomock.generaNumero()).andReturn(numeroAleatorio);
        premiomock.cliente = clientemock;
        
        EasyMock.replay(premiomock, clientemock);
        
        resultadoReal = premiomock.compruebaPremio();
        Assert.assertEquals(resultadoReal, resultadoEsperado);
    }
    
    @Test
    public void testC2() throws ClienteWebServiceException {
        resultadoEsperado = "Premiado";
        numeroAleatorio = 0.01f;
        clientemock = EasyMock.createMock(ClienteWebService.class);
        EasyMock.expect(clientemock.obtenerPremio()).andThrow(new ClienteWebServiceException());
        
        premiomock = EasyMock.createMockBuilder(Premio.class).addMockedMethod("generaNumero").createMock();
        EasyMock.expect(premiomock.generaNumero()).andReturn(numeroAleatorio);
        premiomock.cliente = clientemock;
        
        EasyMock.replay(premiomock, clientemock);
        
        resultadoReal = premiomock.compruebaPremio();
        Assert.assertEquals(resultadoReal, resultadoEsperado);
    }
}
