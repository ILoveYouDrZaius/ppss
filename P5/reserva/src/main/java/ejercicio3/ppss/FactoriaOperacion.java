/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.ppss;

/**
 *
 * @author dario
 */
public class FactoriaOperacion {
    private static IOperacionBO ioperacionbo;
    
    public static IOperacionBO create(){
        if(ioperacionbo == null){
            return new Operacion();
        }else{
            return ioperacionbo;
        }
    }
    
    public void setIoperacionbo (IOperacionBO ioperacionbo){
        this.ioperacionbo = ioperacionbo;
    }
    
}
