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
public class FortalezaTest {
    
    public FortalezaTest() {
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
     * Test of setSensibilidad method, of class Fortaleza.
     * test que prueba que el valor de la sensibilidad esta dentro del rango de valores permitidos
     */
    @Test
    public void testSetSensibilidad() {
        try{
            Fortaleza fortaleza = new Fortaleza("luz solar",2);
            int sensib = 2;
            fortaleza.setSensibilidad(sensib);
            assertEquals(2,fortaleza.getSensibilidad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor limite de sensibilidad");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setSensibilidad method, of class Fortaleza.
     * test que prueba que el valor de la sensibilidad supera en 1 unidad el valor limite 
     */
    @Test
    public void testSetSensibilidad1() {
        try{
            Fortaleza fortaleza = new Fortaleza("luz solar",6);
            int sensib = 6;
            fortaleza.setSensibilidad(sensib);
            assertEquals(6,fortaleza.getSensibilidad());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor limite de sensibilidad");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setSensibilidad method, of class Fortaleza.
     * test que prueba que el valor de la sensibilidad es uno de los valores limite
     */
    @Test
    public void testSetSensibilidad2() {
        try{
            Fortaleza fortaleza = new Fortaleza("luz solar",1);
            int sensib = 1;
            fortaleza.setSensibilidad(sensib);
            assertEquals(1,fortaleza.getSensibilidad());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor limite de sensibilidad");
            System.out.println("CP3 correcto");
        }
    }
}