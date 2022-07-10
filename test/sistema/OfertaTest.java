/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistema;

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
public class OfertaTest {
    
    public OfertaTest() {
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
     * Test of setPrecio method, of class Oferta.
     * test que prueba que no se puede tener un precio nulo
     */
    @Test
    public void testSetPrecio() {
        Oferta o = new Oferta();
        try{
            o.setPrecioVenta(0);
            fail("se puede tener un precio nulo");
            System.out.println("CP1 incorrecto");
        } catch(RuntimeException ex) {
            assertEquals(ex.getMessage(),"el precio debe ser positivo");
            System.out.println("CP1 correcto");
        } 
    }
    
    /**
     * Test of setPrecio method, of class Oferta.
     * test que prueba que no se puede tener un precio negativo
     */
    @Test
    public void testSetPrecio1() {
        Oferta o = new Oferta();
        try{
            o.setPrecioVenta(-5.3);
            fail("se puede tener un precio nulo");
            System.out.println("CP2 incorrecto");
        } catch(RuntimeException ex) {
            assertEquals(ex.getMessage(),"el precio debe ser positivo");
            System.out.println("CP2 correcto");
        } 
    }

    /**
     * Test of setPrecio method, of class Oferta.
     * test para probar que el precio es un valor positivo
     */
    @Test
    public void testSetPrecio2() {
        Oferta o = new Oferta();
        try {
             o.setPrecioVenta(10.99);
             assertEquals(10.99,o.getPrecioVenta());
             System.out.println("CP3 incorrecto");
        } catch(RuntimeException ex) {
            fail("el precio no es positivo");
            System.out.println("CP3 correcto");
        }
    }
}
