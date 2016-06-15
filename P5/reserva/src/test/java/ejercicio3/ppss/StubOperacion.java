/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.ppss;

import ejercicio3.ppss.excepciones.IsbnInvalidoException;
import ejercicio3.ppss.excepciones.JDBCException;
import ejercicio3.ppss.excepciones.SocioInvalidoException;
import java.util.ArrayList;
import java.util.List;
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
public class StubOperacion extends Operacion{
    private List<String> socios, isbns;
    private boolean bd;
    
    public StubOperacion() {
        socios = new ArrayList();
        socios.add("Luis");
        
        isbns = new ArrayList();
        isbns.add("11111");
        isbns.add("22222");
        
        bd = true;
    }   
    
    @Override
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, SocioInvalidoException {
        if(!socios.contains(socio)) throw new SocioInvalidoException();
        if(!isbns.contains(isbn)) throw new IsbnInvalidoException();
        if(!bd) throw new JDBCException();
    }
    
    public void setBd(boolean bd){
        this.bd = bd;
    }
}
