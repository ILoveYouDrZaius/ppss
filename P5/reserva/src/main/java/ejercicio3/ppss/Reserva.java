/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.ppss;

import java.util.ArrayList;
import ejercicio3.ppss.excepciones.*;

/**
 *
 * @author dario
 */
public class Reserva {
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void realizaReserva(String login, String password,
    String socio, String [] isbns) throws Exception {
        ArrayList<String> errores = new ArrayList<String>();
        if(!compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)) { //DEPENDENCIA EXTERNA
            errores.add("ERROR de permisos");
        } else {
            // IOperacionBO io = new Operacion();  //DEPENDENCIA EXTERNA, debemos convertir new Operacion a Factoría externa
            IOperacionBO io = FactoriaOperacion.create();
            try {
                for(String isbn: isbns) {
                    try {
                        io.operacionReserva(socio, isbn);
                    } catch (IsbnInvalidoException iie) {
                        errores.add("ISBN invalido" + ":" + isbn);
                    }
                }
            } catch (SocioInvalidoException sie) {
                errores.add("SOCIO invalido");
            } catch (JDBCException je) {
                errores.add("CONEXION invalida");
            }
        }
        if (errores.size() > 0) {
            String mensajeError = "";
        for(String error: errores) {
            mensajeError += error + "; ";
        }
        throw new ReservaException(mensajeError);
        }
    }
}
