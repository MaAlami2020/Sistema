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
public class DebilidadTest {
    
    public DebilidadTest() {
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
     * Test of setSensibilidad method, of class Debilidad.
     * test que prueba que el valor de la sensibilidad esta dentro del rango de valores permitidos
     */
    @Test
    public void testSetSensibilidad() {
        try{
            Debilidad debilidad = new Debilidad("marea alta",4);
            int sensib = 4;
            debilidad.setSensibilidad(sensib);
            assertEquals(4,debilidad.getSensibilidad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("sobrepasa el valor limite de sensibilidad");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setSensibilidad method, of class Debilidad.
     * test que prueba que el valor de la sensibilidad supera en 1 unidad el valor limite 
     */
    @Test
    public void testSetSensibilidad1() {
        try{
            Debilidad debilidad = new Debilidad("marea alta",6);
            int sensib = 6;
            debilidad.setSensibilidad(sensib);
            fail("la sensibilidad esta entre 1 y 5");
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor limite de sensibilidad");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setSensibilidad method, of class Debilidad.
     * test que prueba que el valor de la sensibilidad es uno de los valores limite
     */
    @Test
    public void testSetSensibilidad2() {
        try{
            Debilidad debilidad = new Debilidad("marea alta",5);
            int sensib = 5;
            debilidad.setSensibilidad(sensib);
            assertEquals(5,debilidad.getSensibilidad());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            fail("sobrepasa el valor limite de sensibilidad");
            System.out.println("CP3 correcto");
        }
    }
    
}
