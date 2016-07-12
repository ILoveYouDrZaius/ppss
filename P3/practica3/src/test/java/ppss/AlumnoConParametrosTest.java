/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author dario
 */
@RunWith(Parameterized.class)
public class AlumnoConParametrosTest {
    
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {"123", false},
            {"1234567AA", false},
            {"-12345678", false},
            {"00000000X", false},
            {"00000000T", true}
        });
    }
    
    private String nif;
    private boolean resultadoEsperado;
    private Alumno alu = new Alumno();
    
    public AlumnoConParametrosTest(String nif, boolean resultadoEsperado) {
        this.nif = nif;
        this.resultadoEsperado = resultadoEsperado;
    }
    
    @Test
    public void testCX(){
        Assert.assertEquals(resultadoEsperado, alu.validaNif(nif));
    }
}
