/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

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
public class AlumnoSinParametrosTest {
    private String nif;
    private boolean resultadoEsperado, resultadoReal;
    private Alumno alu = new Alumno();
    
    public AlumnoSinParametrosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testC1(){
        nif = "123";
        
        resultadoEsperado = false;
        resultadoReal = alu.validaNif(nif);
        
        assertEquals(resultadoReal, resultadoEsperado);
    }
    
    @Test
    public void testC2(){
        nif = "1234567AA";
        
        resultadoEsperado = false;
        resultadoReal = alu.validaNif(nif);
        
        assertEquals(resultadoReal, resultadoEsperado);
    }
    
    @Test
    public void testC3(){
        nif = "-12345678";
        
        resultadoEsperado = false;
        resultadoReal = alu.validaNif(nif);
        
        assertEquals(resultadoReal, resultadoEsperado);
    }
    
    @Test
    public void testC4(){
        nif = "00000000X";
        
        resultadoEsperado = false;
        resultadoReal = alu.validaNif(nif);
        
        assertEquals(resultadoReal, resultadoEsperado);
    }
    
    @Test
    public void testC5(){
        nif = "00000000T";
        
        resultadoEsperado = true;
        resultadoReal = alu.validaNif(nif);
        
        assertEquals(resultadoReal, resultadoEsperado);
    }
}
