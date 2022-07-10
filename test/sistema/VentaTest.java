/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistema;

import java.time.LocalDate;
import java.util.List;
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
public class VentaTest {
    
    public VentaTest() {
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
     * Test of setPrecio method, of class Venta.
     * test que prueba que no se puede tener un precio nulo
     */
    @Test
    public void testSetPrecio() {
        Venta v = new Venta();
        try{
            v.setPrecio(0);
            fail("se puede tener un precio nulo");
            System.out.println("CP1 incorrecto");
        } catch(RuntimeException ex) {
            assertEquals(ex.getMessage(),"el precio debe ser positivo");
            System.out.println("CP1 correcto");
        } 
    }
    
    /**
     * Test of setPrecio method, of class Venta.
     * test que prueba que no se puede tener un precio negativo
     */
    @Test
    public void testSetPrecio1() {
        Venta v = new Venta();
        try{
            v.setPrecio(-5.3);
            fail("se puede tener un precio nulo");
            System.out.println("CP2 incorrecto");
        } catch(RuntimeException ex) {
            assertEquals(ex.getMessage(),"el precio debe ser positivo");
            System.out.println("CP2 correcto");
        } 
    }

    /**
     * Test of setPrecio method, of class Venta.
     * test para probar que el precio es un valor positivo
     */
    @Test
    public void testSetPrecio2() {
        Venta v = new Venta();
        try {
             v.setPrecio(10.99);
             assertEquals(10.99,v.getPrecio());
             System.out.println("CP2 incorrecto");
        } catch(RuntimeException ex) {
            fail("el precio no es positivo");
            System.out.println("CP3 correcto");
        }
    }
    
}
