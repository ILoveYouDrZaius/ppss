/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppss.matriculacion.dao;

import java.util.Calendar;
import org.apache.log4j.BasicConfigurator;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppss.matriculacion.to.*;

/**
 *
 * @author dario
 */
public class IAlumnoDAOIT {
    private JdbcDatabaseTester databaseTester;
    private IAlumnoDAO _factoriaAlumno;
    private AlumnoTO alumno;
    
    @BeforeClass
    public static void only_once() {
      BasicConfigurator.configure();  // Para evitar Warning
    }
    
    public IAlumnoDAOIT() {
    }
    
    @Before
    public void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                            "jdbc:mysql://localhost:3306/matriculacion", "root", "root");

        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet dataSet = loader.load("/tabla2.xml");	 

        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }
    
    @Test
    public void testA1() throws DAOException, Exception {
        alumno = new AlumnoTO();
        alumno.setNif("33333333C");
        alumno.setNombre("Elena Aguirre Juarez");
        alumno.setEmail("");
        alumno.setDireccion("");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, 1985);
        cal.set(Calendar.MONTH, 1); // Nota: en la clase Calendar, el primer mes es 0
        cal.set(Calendar.DATE, 22);
        alumno.setFechaNacimiento(cal.getTime());
        
        _factoriaAlumno =  new FactoriaDAO().getAlumnoDAO();
        _factoriaAlumno.addAlumno(alumno);

        IDatabaseConnection conexion = databaseTester.getConnection();
        
        DatabaseConfig dbconfig = conexion.getConfig();
        dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
        
        IDataSet databaseDataSet = conexion.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");
        
        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/tabla3.xml");
        
        ITable expectedTable = expectedDataSet.getTable("alumnos");
        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Test(expected = DAOException.class)
    public void testA2() throws DAOException, Exception {
        alumno = new AlumnoTO();
        alumno.setNif("11111111A");
        alumno.setNombre("Alfonso Ramirez Ruiz");
        alumno.setEmail("");
        alumno.setDireccion("");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, 1982);
        cal.set(Calendar.MONTH, 1); // Nota: en la clase Calendar, el primer mes es 0
        cal.set(Calendar.DATE, 22);
        alumno.setFechaNacimiento(cal.getTime());
        
        _factoriaAlumno =  new FactoriaDAO().getAlumnoDAO();
        _factoriaAlumno.addAlumno(alumno);
    }
    
    @Test(expected = DAOException.class)
    public void testA3() throws DAOException, Exception {
        alumno = new AlumnoTO();
        alumno.setNif("44444444D");
        alumno.setNombre(null);
        alumno.setEmail("");
        alumno.setDireccion("");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, 1982);
        cal.set(Calendar.MONTH, 1); // Nota: en la clase Calendar, el primer mes es 0
        cal.set(Calendar.DATE, 22);
        alumno.setFechaNacimiento(cal.getTime());
        
        _factoriaAlumno =  new FactoriaDAO().getAlumnoDAO();
        _factoriaAlumno.addAlumno(alumno);
    }
    
    @Test(expected = DAOException.class)
    public void testA4() throws DAOException, Exception {
        alumno = null;
              
        _factoriaAlumno =  new FactoriaDAO().getAlumnoDAO();
        _factoriaAlumno.addAlumno(alumno);
    }
    
    @Test(expected = DAOException.class)
    public void testA5() throws DAOException, Exception {
        alumno = new AlumnoTO();
        alumno.setNif("44444444D");
        alumno.setNombre(null);
        alumno.setEmail("");
        alumno.setDireccion("");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, 1982);
        cal.set(Calendar.MONTH, 1); // Nota: en la clase Calendar, el primer mes es 0
        cal.set(Calendar.DATE, 22);
        alumno.setFechaNacimiento(cal.getTime());
        
        _factoriaAlumno =  new FactoriaDAO().getAlumnoDAO();
        _factoriaAlumno.addAlumno(alumno);
    }
    
    public void testB1() throws DAOException, Exception {
        String nif = "11111111A";
        
        _factoriaAlumno =  new FactoriaDAO().getAlumnoDAO();
        _factoriaAlumno.delAlumno(nif);
        
        IDatabaseConnection conexion = databaseTester.getConnection();
        
        DatabaseConfig dbconfig = conexion.getConfig();
        dbconfig.setProperty("http://www.dbunit.org/properties/datatypeFactory", new MySqlDataTypeFactory());
        
        IDataSet databaseDataSet = conexion.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");
        
        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/tabla4.xml");
        
        ITable expectedTable = expectedDataSet.getTable("alumnos");
        Assertion.assertEquals(expectedTable, actualTable);
    }
    
    @Test(expected = DAOException.class)
    public void testB2() throws DAOException, Exception {
        String nif = "33333333C";
        
        _factoriaAlumno =  new FactoriaDAO().getAlumnoDAO();
        _factoriaAlumno.delAlumno(nif);
    }
}
