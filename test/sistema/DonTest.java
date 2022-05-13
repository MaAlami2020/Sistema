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
public class DonTest {
    
    public DonTest() {
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
     * Test of setValorAtaque method, of class Don.
     * test que prueba que el valor del ataque esta dentro de los limites permitidos
     */
    @Test
    public void testSetValorAtaque() {
        try{
            int valorAtaque = 2;
            Don don = new Don();
            don.setValorAtaque(valorAtaque);
            assertEquals(valorAtaque,don.getValorAtaque());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de ataque");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setValorAtaque method, of class Don.
     * test que prueba que el valor del ataque supera en 1 unidad el valor del limite de valores permitidos
     */
    @Test
    public void testSetValorAtaque1() {
        try{
            int valorAtaque = 4;
            Don don = new Don();
            don.setValorAtaque(valorAtaque);
            assertEquals(valorAtaque,don.getValorAtaque());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de ataque");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setValorAtaque method, of class Don.
     * test que prueba que el valor del ataque supera en varias unidades el valor limite del ataque
     */
    @Test
    public void testSetValorAtaque2() {
        try{
            int valorAtaque = 9;
            Don don = new Don();
            don.setValorAtaque(valorAtaque);
            assertEquals(valorAtaque,don.getValorAtaque());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de ataque");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setValorDefensa method, of class Don.
     * test que prueba que el valor de defensa esta dentro de los limites permitidos
     */
    @Test
    public void testSetValorDefensa() {
        try{
            int valorDefensa = 2;
            Don don = new Don();
            don.setValorDefensa(valorDefensa);
            assertEquals(valorDefensa,don.getValorDefensa());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de defensa");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setValorDefensa method, of class Don.
     * test que prueba que el valor de defensa supera en 1 unidad el valor del limite de valores permitidos
     */
    @Test
    public void testSetValorDefensa1() {
        try{
            int valorDefensa = 4;
            Don don = new Don();
            don.setValorDefensa(valorDefensa);
            assertEquals(valorDefensa,don.getValorDefensa());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de defensa");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setValorDefensa method, of class Don.
     * test que prueba que el valor de defensa supera en varias unidades el valor limite de defensa
     */
    @Test
    public void testSetValorDefensa2() {
        try{
            int valorDefensa = 9;
            Don don = new Don();
            don.setValorDefensa(valorDefensa);
            assertEquals(valorDefensa,don.getValorDefensa());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de defensa");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setCostePuntosSangre method, of class Don.
     * test que prueba que esta habilidad no tiene un coste de puntos de sangre
     */
    @Test
    public void testSetCostePuntosSangre() {
        try{
            int costePuntosSangre = 0;
            Don don = new Don();
            don.setCostePuntosSangre(costePuntosSangre);
            assertEquals(costePuntosSangre,don.getCostePuntosSangre());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene un coste");
            System.out.println("CP1 correcto");
        }
    }

    /**
     * Test of setEdad method, of class Don.
     *test que prueba que esta habilidad no tiene una edad de adquisicion 
     */
    @Test
    public void testSetEdad() {
        try{
            int edad = 0;
            Don don = new Don();
            don.setEdad(edad);
            assertEquals(edad,don.getEdad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene una edad de adquisicion");
            System.out.println("CP1 correcto");
        }
    }
    
}
