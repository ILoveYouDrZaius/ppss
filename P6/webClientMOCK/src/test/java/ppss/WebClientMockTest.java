/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
public class WebClientMockTest {
    WebClient mockwebclient;
    URL url;
    String resultadoEsperado, resultadoReal;
    HttpURLConnection httpurlmock;
    
    @Before
    public void Before() throws IOException{
        httpurlmock = EasyMock.createMock(HttpURLConnection.class);
        mockwebclient = EasyMock.createMockBuilder(WebClient.class).addMockedMethod("createHttpURLConnection").createMock();
        url = new URL("http://www.ua.es");
    }
    
    @Test
    public void testC1() throws IOException {
        InputStream is = new ByteArrayInputStream("Funciona".getBytes());

        EasyMock.expect(httpurlmock.getInputStream()).andReturn(is);        
        mockwebclient = EasyMock.createMockBuilder(WebClient.class).addMockedMethod("createHttpURLConnection").createMock();
        
        EasyMock.expect(mockwebclient.createHttpURLConnection(url)).andReturn(httpurlmock);
        
        EasyMock.replay(mockwebclient, httpurlmock);
        
        resultadoEsperado = "Funciona";
        resultadoReal = mockwebclient.getContent(url);
        
        Assert.assertEquals(resultadoEsperado, resultadoReal);        
    }
    
    @Test
    public void testC2() throws IOException {
        InputStream is = new ByteArrayInputStream("Funciona".getBytes());

        EasyMock.expect(httpurlmock.getInputStream()).andReturn(is);        
        mockwebclient = EasyMock.createMockBuilder(WebClient.class).addMockedMethod("createHttpURLConnection").createMock();
        
        EasyMock.expect(mockwebclient.createHttpURLConnection(url)).andThrow(new IOException());
        
        EasyMock.replay(mockwebclient, httpurlmock);
        
        resultadoReal = mockwebclient.getContent(url);
        
        Assert.assertEquals(null, resultadoReal);        
    }
}
