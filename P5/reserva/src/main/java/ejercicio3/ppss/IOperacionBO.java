/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.ppss;

import ejercicio3.ppss.excepciones.*;

/**
 *
 * @author dario
 */
public interface IOperacionBO {
    public void operacionReserva(String socio, String isbn)
        throws IsbnInvalidoException, JDBCException, SocioInvalidoException;
    
}

