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
public class TesteableGestorLlamadas extends GestorLlamadas{
    private int hora;
       
    @Override
    public int getHoraActual(){
        return hora;
    }
    
    public void setHora(int hora){
        this.hora = hora;
    }
}
