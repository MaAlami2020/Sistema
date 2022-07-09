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
     * test para comprobar que el siguiente valor al limite superior del rango [1-3]
     * sobrepasa el valor maximo de modificador al ataque
     */
    @Test
    public void setModificadorAtaque(){
        Arma a = new Arma(null,0,0,null,null);
        try {
            a.setModificadorAtaque(4);
            fail("el valor del modificador al ataque esta dentro del limite (1-3)");
            System.out.println("CP1 incorrecto");
        } catch(Exception ex) {
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP1 correcto");
        }       
    }
    /**
     * test para probar el valor del limite superior del rango [1-3] del modifcador al ataque
     */
    @Test
    public void setModificadorAtaque1(){
        Arma a1 = new Arma(null,0,0,null,null);        
        try {
             a1.setModificadorAtaque(3);
             assertEquals(3,a1.getModificadorAtaque());
             System.out.println("CP2 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            fail("se sobrepasó el límite de modificador de ataque");
            System.out.println("CP2 correcto");
        }
    }
    /**
     * test para comprobar que el anterior valor del limite inferior del rango [1-3]
     * esta fuera del valor minimo de modificador al ataque
     */
    @Test
    public void anadirModifAtaque2(){
        Arma a2 = new Arma(null,0,0,null,null);
        try {
             a2.setModificadorAtaque(0);
             fail("no se sobrepasó el límite de modificador de ataque");
             System.out.println("CP3 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP3 correcto");
        }
    }
    /**
     * test para probar un valor del rango [1-3] del modifcador al ataque sin incluir los extremos
     */
    @Test
    public void anadirModifAtaque3(){
        Arma a3 = new Arma(null,0,0,null,null);
        try {
             a3.setModificadorAtaque(2);
             assertEquals(2,a3.getModificadorAtaque());
             System.out.println("CP4 incorrecto");
        } catch(Exception ex) {
            fail("se sobrepasó el límite de modificador de ataque");
            System.out.println("CP4 correcto");
        }
    }
    /**
     * test para probar un valor que esta fuera del limite superior de modificador al ataque
     * y no es el siguiente
     */
    @Test
    public void anadirModifAtaque4(){
        Arma a4 = new Arma(null,0,0,null,null);
        try {
             a4.setModificadorAtaque(8);
             fail("no se sobrepasó el límite de modificador de ataque");
             System.out.println("CP5 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite de modificador de ataque");
            System.out.println("CP5 correcto");
        }
    }
    /**
     * test para probar que un valor que esta por debajo del limite inferior de modificador al ataque
     * y no es el anterior
     */
    @Test
    public void anadirModifAtaque5(){
        Arma a5 = new Arma(null,0,0,null,null);
        try {
             a5.setModificadorAtaque(-5);
             fail("no se sobrepasó el límite de modificador de ataque");
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
        Arma a = new Arma(null,0,0,null,null);
        try {
            a.setModificadorDefensa(4);
            fail("no se sobrepasó el límite de modificador de defensa");
            System.out.println("CP1 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite del modificador de defensa");
            System.out.println("CP1 correcto");
        }       
    }
    /**
     * test para probar un valor de los extremos del rango [1-3] del modifcador a la defensa
     */
    @Test
    public void setModificadorDefensa1(){
        Arma a1 = new Arma(null,0,0,null,null);        
        try {
             a1.setModificadorDefensa(3);
             assertEquals(3,a1.getModificadorDefensa());
             System.out.println("CP2 incorrecto");
        } catch(Exception ex) {
            fail("se sobrepasó el límite de modificador de defensa");
            System.out.println("CP2 correcto");
        }
    }
    /**
     * test para probar el valor minimo del limite inferior del rango [1-3] del modificador a la defensa,
     * el valor minimo es 0, lo que significa que el arma no tiene modificador a la defensa
     */
    @Test
    public void anadirModifDefensa2(){
        Arma a2 = new Arma(null,0,0,null,null);
        try {
             a2.setModificadorDefensa(0);
             assertEquals(0,a2.getModificadorDefensa());
             System.out.println("CP3 incorrecto");
        } catch(Exception ex) {
            fail("se sobrepasó el límite de modificador de defensa");
            System.out.println("CP3 correcto");
        }
    }
    /**
     * test para comprobar que el anterior del limite inferior del rango [1-3]
     * esta fuera del valor minimo de modificador a la defensa
     */
    @Test
    public void anadirModifDefensa3(){
        Arma a3 = new Arma(null,0,0,null,null);
        try {
             a3.setModificadorDefensa(-1);
             fail("no se sobrepasó el límite de modificador de defensa");
             System.out.println("CP4 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite del modificador de defensa");
            System.out.println("CP4 correcto");
        }
    }
    /**
     * test para probar que un valor del rango [1-3] del modifcador a la defensa sin incluir los extremos
     */
    @Test
    public void anadirModifDefensa4(){
        Arma a4 = new Arma(null,0,0,null,null);
        try {
             a4.setModificadorDefensa(2);
             assertEquals(2,a4.getModificadorDefensa());
             System.out.println("CP5 incorrecto");
        } catch(Exception ex) {
            fail("se sobrepasó el límite de modificador de defensa");
            System.out.println("CP5 correcto");
        }
    }
    /**
     * test para probar un valor que esta fuera del limite superior de modificador a la defensa y no es el siguiente
     */
    @Test
    public void anadirModifDefensa5(){
        Arma a5 = new Arma(null,0,0,null,null);
        try {
             a5.setModificadorDefensa(8);
             fail("no se sobrepasó el límite de modificador de defensa");
             System.out.println("CP6 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite del modificador de defensa");
            System.out.println("CP6 correcto");
        }
    }
    /**
     * test para probar un valor que esta fuera del limite inferior del rango [1-3] de modificador de defensa
     * y no es el anterior
     */
    @Test
    public void anadirModifDefensa6(){
        Arma a6 = new Arma(null,0,0,null,null);
        try {
             a6.setModificadorDefensa(-5);
             fail("no se sobrepasó el límite de modificador de defensa");
             System.out.println("CP7 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"sobrepasó el límite del modificador de defensa");
            System.out.println("CP7 correcto");
        }
    }
    /**
     * test para comprobar que el nombre del arma no es un espacio en blanco
     */
    @Test
    public void setNombreTest(){
        Arma a = new Arma(null,0,0,null,null);
        try {
             a.setNombre("asdrubal");
             assertEquals("asdrubal",a.getNombre());
             System.out.println("CP1 incorrecto");
        } catch(Exception ex) {
            fail("el nombre no es valido");
            System.out.println("C1 correcto");
        }
    }
    /**
     * test para comprobar que el nombre del arma es un espacio en blanco
     */
    @Test
    public void setNombreTest1(){
        Arma a1 = new Arma(null,0,0,null,null);
        try {
             a1.setNombre(" ");
             fail("el nombre es valido");
             System.out.println("CP2 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"nombre invalido");
            System.out.println("CP2 correcto");
        }
    }
    /**
     * test para comprobar que el manejo del arma puede ser de 1 mano
     */
    @Test
    public void setManejoTest(){
        Arma a = new Arma(null,0,0,null,null);
        try {
             a.setManejo("1 mano");
             assertEquals("1 mano",a.getManejo());
             System.out.println("CP1 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            fail("el manejo del arma no puede ser de 1 mano");
            System.out.println("CP1 correcto");
        }
    }
    /**
     * test para comprobar que el manejo del arma puede ser de 2 manos
     */
    @Test
    public void setManejoTest1(){
        Arma a1 = new Arma(null,0,0,null,null);
        try {
             a1.setManejo("2 manos");
             assertEquals("2 manos",a1.getManejo());
             System.out.println("CP2 incorrecto");
        } catch(Exception ex) {
            fail("el manejo del arma no puede ser de 2 manos");
            System.out.println("CP2 correcto");
        }
    }
    /**
     * test para comprobar que el manejo del arma puede ser de ninguna mano
     */
    @Test
    public void setManejoTest2(){
        Arma a2 = new Arma(null,0,0,null,null);
        try {
             a2.setManejo("ninguna");
             fail("el manejo del arma puede ser de ninguna mano");
             System.out.println("CP3 incorrecto");
        } catch(Exception ex) {
            Exception e = null;
            e = ex;
            assertEquals(e.getMessage(),"valor invalido");
            System.out.println("CP3 correcto");
        }
    }

}
