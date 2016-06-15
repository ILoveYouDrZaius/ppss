/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.ppss;

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
public class TestableReserva extends Reserva {
    @Override
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
        return login.equals("ppss") && password.equals("ppss");
    }
}
