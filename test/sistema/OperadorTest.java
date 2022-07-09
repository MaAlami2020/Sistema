/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mimit
 */
public class OperadorTest {
    
    public OperadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPassword method, of class Operador.
     * test para probar que la longitud de la contrasenia es menor que la longitud minima
     */
    @Test
    public void testSetPassword() {
        MenuInicio menu = new MenuInicio();
        Operador operator = new Operador(menu);
        try{
            String password = "micontr";
            operator.setPassword(password);            
            fail("la longitud de la contraseña esta dentro del rango(8-12)");
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"longitud de la contrasenia fuera del rango[8-12]");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setPassword method, of class Operador.
     * test para probar que la longitud de la contrasenia es mayor que la longitud maxima
     */
    @Test
    public void testSetPassword1() {
        MenuInicio menu = new MenuInicio();
        Operador operator1 = new Operador(menu);
        try{
            String password = "micontrasenia";
            operator1.setPassword(password);
            fail("la contraseña esta dentro del limite (8-12)");
            System.out.println("CP2 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"longitud de la contrasenia fuera del rango[8-12]");
            System.out.println("CP2 correcto");
        }
    }

    /**
     * Test of setPassword method, of class Operador.
     * test para probar que la longitud de la contrasenia esta dentro del rango de  la longitud requerida
     */
    @Test
    public void testSetPassword2() {
        MenuInicio menu = new MenuInicio();
        Operador operator2 = new Operador(menu);
        try{
            String password = "mypassword";
            operator2.setPassword(password);
            assertEquals(password,operator2.getPassword());
            System.out.println("CP3 incorrecto");
        }catch(RuntimeException e){
            fail("longitud de la contrasenia fuera del rango[8-12]");
            System.out.println("CP3 correcto");
        }
    }
}
