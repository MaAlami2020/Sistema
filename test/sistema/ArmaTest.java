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
public class ArmaTest {
    
    public ArmaTest() {
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
     * Test of setModificadorAtaque method, of class Arma.
     * test para comprobar que el siguiente valor al rango superior
     * sobrepasa el valor maximo de modificador al ataque
     */
    @Test
    public void setModificadorAtaque(){
        Arma a = new Arma();
        try {
            a.setModificadorAtaque(4);
            assertEquals(5,a.getModificadorAtaque());
            System.out.println("CP1 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP1 correcto");
            //fail("sobrepasó el límite de modificador de ataque");
        }       
    }
    /**
     * test para comprobar que el valor del limite del modifcador al ataque del rango [1-3]
     */
    @Test
    public void setModificadorAtaque1(){
        Arma a1 = new Arma();        
        try {
             a1.setModificadorAtaque(3);
             assertEquals(3,a1.getModificadorAtaque());
             System.out.println("CP2 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP2 correcto");
        }
    }
    /**
     * test para comprobar que el anterior valor al rango inferior
     * esta fuera del valor minimo de modificador al ataque
     */
    @Test
    public void anadirModifAtaque2(){
        Arma a2 = new Arma();
        try {
             a2.setModificadorAtaque(0);
             assertEquals(1,a2.getModificadorAtaque());
             System.out.println("CP3 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP3 correcto");
        }
    }
    /**
     * test para comprobar que el valor del rango [1-3] del modifcador al ataque sin incluir los extremos
     */
    @Test
    public void anadirModifAtaque3(){
        Arma a3 = new Arma();
        try {
             a3.setModificadorAtaque(2);
             assertEquals(2,a3.getModificadorAtaque());
             System.out.println("CP4 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP4 correcto");
        }
    }
    /**
     * test para comprobar que un valor que esta fuera del limite superior de modificador al ataque y no es el siguiente
     */
    @Test
    public void anadirModifAtaque4(){
        Arma a4 = new Arma();
        try {
             a4.setModificadorAtaque(8);
             assertEquals(8,a4.getModificadorAtaque());
             System.out.println("CP5 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP5 correcto");
        }
    }
    /**
     * test para comprobar que un valor que esta fuera del limite inferior de modificador al ataque y no es el anterior
     */
    @Test
    public void anadirModifAtaque5(){
        Arma a5 = new Arma();
        try {
             a5.setModificadorAtaque(-5);
             assertEquals(-5,a5.getModificadorAtaque());
             System.out.println("CP6 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP6 correcto");
        }
    }
    
    @Test
    public void anadirModifDefensa(){
        Arma a3 = new Arma();
        Exception e = null;
        try {
             a3.setModificadorDefensa(0);
        } catch(Exception ex) {
             e = ex;
        } 
        assertNull(e);
    }
}
