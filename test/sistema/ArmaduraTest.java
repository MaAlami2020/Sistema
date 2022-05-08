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
public class ArmaduraTest {
    
    public ArmaduraTest() {
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
     * Test of setModificadorAtaque method, of class Armadura.
     * test para comprobar el siguiente valor que sobrepasa el valor maximo de modificador al ataque
     */
    @Test
    public void testSetModificadorAtaque(){
        System.out.println("setModificadorAtaque");
        Armadura armadura = new Armadura();
        try {
             armadura.setModificadorAtaque(4);
             assertEquals(4,armadura.getModificadorAtaque());
             System.out.println("CP1 incorrecto");
        } catch(Exception ex){
             Exception e = null;
             e = ex;
             assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
             System.out.println("CP1 correcto");
             
        }
    }
    /**
     * test para comprobar el valor minimo del rango del modificador al ataque.
     * El valor minimo es 0, lo que significa que el armadura no tiene modificador al ataque
     */
    @Test
    public void setModificadorAtaque1(){
        Armadura a1 = new Armadura();
        try {
             a1.setModificadorAtaque(0);
             assertEquals(0,a1.getModificadorAtaque());
             System.out.println("CP2 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP2 correcto");
        }
    }
    /**
     * test para comprobar el valor limite del rango [1-3] del modificador al ataque
     */
    @Test
    public void setModificadorAtaque2(){
        Armadura a2 = new Armadura();        
        try {
             a2.setModificadorAtaque(3);
             assertEquals(3,a2.getModificadorAtaque());
             System.out.println("CP3 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP3 correcto");
        }
    }
    /**
     * test para comprobar que el valor anterior que esta fuera del valor minimo de modificador al ataque
     */
    @Test
    public void setModificadorAtaque3(){
        Armadura a3 = new Armadura();
        try {
             a3.setModificadorAtaque(-1);
             assertEquals(-1,a3.getModificadorAtaque());
             System.out.println("CP4 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP4 correcto");
        }
    }
    /**
     * test para comprobar que el valor del rango [1-3] del modificador al ataque sin incluir los extremos
     */
    @Test
    public void setModificadorAtaque4(){
        Armadura a4 = new Armadura();
        try {
             a4.setModificadorAtaque(2);
             assertEquals(2,a4.getModificadorAtaque());
             System.out.println("CP5 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP5 correcto");
        }
    }
    /**
     * test para comprobar que un valor que esta fuera del limite superior de modificador al ataque
     * y no es el siguiente valor
     */
    @Test
    public void setModificadorAtaque5(){
        Armadura a5 = new Armadura();
        try {
             a5.setModificadorAtaque(8);
             assertEquals(8,a5.getModificadorAtaque());
             System.out.println("CP5 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP5 correcto");
        }
    }
    /**
     * test para comprobar que un valor que esta fuera del limite inferior de modificador al ataque
     * y no es el anterior valor
     */
    @Test
    public void setModificadorAtaque6(){
        Armadura a6 = new Armadura();
        try {
             a6.setModificadorAtaque(-5);
             assertEquals(-5,a6.getModificadorAtaque());
             System.out.println("CP6 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP6 correcto");
        }
    }
    
    /**
     * Test of setModificadorDefensa method, of class Armadura.
     * test para comprobar el siguiente valor que sobrepasa el valor maximo de modificador a la defensa
     */
    @Test
    public void setModificadorDefensa(){
        Armadura a = new Armadura();
        try {
            a.setModificadorDefensa(4);
            assertEquals(4,a.getModificadorDefensa());
            System.out.println("CP7 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite del modificador de defensa");
            System.out.println("CP7 correcto");
            //fail("sobrepasó el límite del modificador de defensa");
        }       
    }
    /**
     * test para comprobar el valor del limite superior del modifcador a la defensa del rango [1-3]
     */
    @Test
    public void setModificadorDefensa1(){
        Armadura a1 = new Armadura();        
        try {
             a1.setModificadorDefensa(3);
             assertEquals(3,a1.getModificadorDefensa());
             System.out.println("CP8 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP8 correcto");
        }
    }
    /**
     * test para comprobar el valor del limite inferior del modifcador a la defensa del rango [1-3]
     */
    @Test
    public void setModificadorDefensa2(){
        Armadura a2 = new Armadura();
        try {
             a2.setModificadorDefensa(1);
             assertEquals(1,a2.getModificadorDefensa());
             System.out.println("CP9 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP9 correcto");
        }
    }
    /**
     * test para comprobar que el anterior valor al rango [1-3] del modificador de defensa
     * esta fuera del valor minimo
     */
    @Test
    public void setModificadorDefensa3(){
        Armadura a3 = new Armadura();
        try {
             a3.setModificadorDefensa(0);
             assertEquals(0,a3.getModificadorDefensa());
             System.out.println("CP10 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite del modificador de defensa");
            System.out.println("CP10 correcto");
        }
    }
    /**
     * test para comprobar el valor del rango [1-3] del modifcador a la defensa sin incluir los extremos
     */
    @Test
    public void anadirModifDefensa4(){
        Armadura a4 = new Armadura();
        try {
             a4.setModificadorDefensa(2);
             assertEquals(2,a4.getModificadorDefensa());
             System.out.println("CP11 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP11 correcto");
        }
    }
    /**
     * test para comprobar que un valor que esta fuera del limite superior de modificador a la defensa y no es el siguiente
     */
    @Test
    public void anadirModifDefensa5(){
        Armadura a5 = new Armadura();
        try {
             a5.setModificadorDefensa(8);
             assertEquals(8,a5.getModificadorDefensa());
             System.out.println("CP12 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite del modificador de defensa");
            System.out.println("CP12 correcto");
        }
    }
    /**
     * test para comprobar que un valor que esta fuera del limite inferior de modificador a la defensa y no es el anterior
     */
    @Test
    public void anadirModifDefensa6(){
        Armadura a6 = new Armadura();
        try {
             a6.setModificadorDefensa(-5);
             assertEquals(-5,a6.getModificadorDefensa());
             System.out.println("CP13 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite del modificador de defensa");
            System.out.println("C13 correcto");
        }
    }
    
}
