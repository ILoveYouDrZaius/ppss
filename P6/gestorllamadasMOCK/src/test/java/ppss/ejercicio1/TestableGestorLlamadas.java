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
public class TestableGestorLlamadas extends GestorLlamadas {
    private Calendario calendario;
    
    @Override
    public Calendario getCalendario() {
        return calendario;
    }
    
    public void setCalendario(Calendario calendario){
        this.calendario = calendario;
    }
}
