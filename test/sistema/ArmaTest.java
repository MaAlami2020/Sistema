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
            assertEquals(4,a.getModificadorAtaque());
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
             assertEquals(0,a2.getModificadorAtaque());
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
    
    /**
     * Test of setModificadorDefensa method, of class Arma.
     * test para comprobar que el siguiente valor al rango superior [1-3]
     * sobrepasa el valor maximo de modificador a la defensa
     */
    @Test
    public void setModificadorDefensa(){
        Arma a = new Arma();
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
     * test para comprobar el valor del limite del modifcador a la defensa del rango [1-3]
     */
    @Test
    public void setModificadorDefensa1(){
        Arma a1 = new Arma();        
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
     * test para comprobar el valor minimo del rango inferior del modificador a la defensa,
     * el valor minimo es 0, lo que significa que el arma no tiene modificador a la defensa
     */
    @Test
    public void anadirModifDefensa2(){
        Arma a2 = new Arma();
        try {
             a2.setModificadorDefensa(0);
             assertEquals(0,a2.getModificadorDefensa());
             System.out.println("CP9 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP9 correcto");
        }
    }
    /**
     * test para comprobar que el anterior valor al rango inferior
     * esta fuera del valor minimo de modificador a la defensa
     */
    @Test
    public void anadirModifDefensa3(){
        Arma a3 = new Arma();
        try {
             a3.setModificadorDefensa(-1);
             assertEquals(-1,a3.getModificadorDefensa());
             System.out.println("CP10 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite del modificador de defensa");
            System.out.println("CP10 correcto");
        }
    }
    /**
     * test para comprobar que el valor del rango [1-3] del modifcador a la defensa sin incluir los extremos
     */
    @Test
    public void anadirModifDefensa4(){
        Arma a4 = new Arma();
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
        Arma a5 = new Arma();
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
        Arma a6 = new Arma();
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
    /**
     * test para comprobar que el nombre del arma no es un espacio en blanco
     */
    @Test
    public void setNombreTest(){
        Arma a = new Arma();
        try {
             a.setNombre("asdrubal");
             assertEquals("asdrubal",a.getNombre());
             System.out.println("CP14 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"nombre invalido");
            System.out.println("C14 correcto");
        }
    }
    /**
     * test para comprobar que el nombre del arma es un espacio en blanco
     */
    @Test
    public void setNombreTest1(){
        Arma a1 = new Arma();
        try {
             a1.setNombre(" ");
             assertEquals(" ",a1.getNombre());
             System.out.println("CP15 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"nombre invalido");
            System.out.println("C15 correcto");
        }
    }
    /**
     * test para comprobar que el manejo del arma es de 1 mano
     */
    @Test
    public void setManejoTest(){
        Arma a = new Arma();
        try {
             a.setManejo("1 mano");
             assertEquals("1 mano",a.getManejo());
             System.out.println("CP16 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"valor manejo invalido");
            System.out.println("C16 correcto");
        }
    }
    /**
     * test para comprobar que el manejo del arma es de 2 manos
     */
    @Test
    public void setManejoTest1(){
        Arma a1 = new Arma();
        try {
             a1.setManejo("2 manos");
             assertEquals("2 manos",a1.getManejo());
             System.out.println("CP17 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"valor manejo invalido");
            System.out.println("C17 correcto");
        }
    }
    /**
     * test para comprobar que el manejo del arma no es ni de 1 mano ni de 2 manos
     */
    @Test
    public void setManejoTest2(){
        Arma a2 = new Arma();
        try {
             a2.setManejo("ninguna");
             assertEquals("ninguna",a2.getManejo());
             System.out.println("CP18 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"valor manejo invalido");
            System.out.println("C18 correcto");
        }
    }

}
