/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.ppss;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import ejercicio3.ppss.excepciones.*;

/**
 *
 * @author dario
 */
public class ReservaTest {
    private TestableReserva reserva = new TestableReserva();
    private StubOperacion operacion = new StubOperacion();
    private FactoriaOperacion factoriaoperacion = new FactoriaOperacion();
    private String login, password, socio, resultadoEsperado;
    private boolean bd;
    private String[] isbn;
    
    @Test
    public void testC1() {
        login = "xxxx";
        password = "xxxx";
        socio = "Luis";
        String[] isbns={"11111"};
        resultadoEsperado = "ERROR de permisos; ";
        bd = true;
        
        operacion.setBd(bd);
        factoriaoperacion.setIoperacionbo(operacion);
        
        try {
            reserva.realizaReserva(login, password, socio, isbns);
            fail("La excepcion no se ha lanzado");
        }catch (ReservaException ex){
           assertEquals(resultadoEsperado,ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ReservaTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Test
    public void testC2() {
        login = "ppss";
        password = "ppss";
        socio = "Luis";
        String[] isbns={"11111", "22222"};
        resultadoEsperado = "ERROR de permisos; ";
        bd = true;
        
        operacion.setBd(bd);
        factoriaoperacion.setIoperacionbo(operacion);
        
        try {
            reserva.realizaReserva(login, password, socio, isbns);
            assertTrue(true);
        }catch (Exception ex) {
            Logger.getLogger(ReservaTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Test
    public void testC3() {
        login = "ppss";
        password = "ppss";
        socio = "Luis";
        String[] isbns={"33333"};
        resultadoEsperado = "ISBN invalido:33333; ";
        bd = true;
        
        operacion.setBd(bd);
        factoriaoperacion.setIoperacionbo(operacion);
        
        try {
            reserva.realizaReserva(login, password, socio, isbns);
            fail("La excepcion no se ha lanzado");
        }catch (ReservaException ex){
            assertEquals(resultadoEsperado,ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ReservaTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Test
    public void testC4() {
        login = "ppss";
        password = "ppss";
        socio = "Pepe";
        String[] isbns={"11111"};
        resultadoEsperado = "SOCIO invalido; ";
        bd = true;
        
        operacion.setBd(bd);
        factoriaoperacion.setIoperacionbo(operacion);
        
        try {
            reserva.realizaReserva(login, password, socio, isbns);
            fail("La excepcion no se ha lanzado");
        }catch (ReservaException ex){
           assertEquals(resultadoEsperado,ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ReservaTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Test
    public void testC5() {
        login = "ppss";
        password = "ppss";
        socio = "Luis";
        String[] isbns={"11111"};
        resultadoEsperado = "CONEXION invalida; ";
        bd = false;
        
        operacion.setBd(bd);
        factoriaoperacion.setIoperacionbo(operacion);
        
        try {
            reserva.realizaReserva(login, password, socio, isbns);
            fail("La excepcion no se ha lanzado");
        }catch (ReservaException ex){
           assertEquals(resultadoEsperado,ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ReservaTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
