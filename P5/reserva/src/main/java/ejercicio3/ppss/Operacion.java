/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.ppss;

import ejercicio3.ppss.excepciones.IsbnInvalidoException;
import ejercicio3.ppss.excepciones.JDBCException;
import ejercicio3.ppss.excepciones.SocioInvalidoException;

/**
 *
 * @author dario
 */
class Operacion implements IOperacionBO {

    public Operacion() {
    }

    @Override
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, SocioInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
