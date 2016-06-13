/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss;

import java.lang.reflect.Array;
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
public class MatriculaConParametrosTest {
    
    @Parameterized.Parameters(name = "Caso C{index}: calcularTasa ({0},{1},{2})={3}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {20, false, true, 2000.00f}, //C0
            {70, false, true, 250.00f}, //C1
            {20, true, true, 250.00f}, //C2
            {20, false, false, 500.00f}, //C3
            {60, false, true, 400.00f}  //C4       
        });
    }
    
    private int edad;
    private boolean familiaNumerosa, repetidor;
    private Matricula mat = new Matricula();
    private float esperado;
    
    public MatriculaConParametrosTest(int edad, boolean familiaNumerosa,
                                    boolean repetidor, float esperado) {
        this.edad = edad;
        this.familiaNumerosa = familiaNumerosa;
        this.repetidor = repetidor;
        this.esperado = esperado;
    }
    
    @Test
    public void testMatricula(){
        Assert.assertEquals(esperado, mat.calculaTasaMatricula(edad, familiaNumerosa, repetidor), 0.002f);
    }
}
