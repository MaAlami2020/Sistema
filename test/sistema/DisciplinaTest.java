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
public class DisciplinaTest {
    
    public DisciplinaTest() {
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
     * Test of setCostePuntosSangre method, of class Disciplina.
     * test que prueba que el valor del coste esta dentro de los limites permitidos
     */
    @Test
    public void testSetCostePuntosSangre() {
        try{
            int costePuntosSangre = 2;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,3);
            disciplina.setCostePuntosSangre(costePuntosSangre);
            assertEquals(costePuntosSangre,disciplina.getCostePuntosSangre());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("se sobrepasa el valor limite del coste de puntos de sangre");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setCostePuntosSangre method, of class Disciplina.
     * test que prueba que el valor del coste supera en 1 unidad el valor del limite de valores permitidos
     */
    @Test
    public void testSetCostePuntosSangre1() {
        try{
            int costePuntosSangre = 4;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,2);
            disciplina.setCostePuntosSangre(costePuntosSangre);
            fail("el valor del coste de puntos de sangre esta entre 1 y 3");
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite del coste de puntos de sangre");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setCostePuntosSangre method, of class Disciplina.
     * test que prueba que el valor del coste supera en varias unidades el valor limite del coste
     */
    @Test
    public void testSetCostePuntosSangre2() {
        try{
            int costePuntosSangre = 9;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,3);
            disciplina.setCostePuntosSangre(costePuntosSangre);
            fail("el valor del coste de puntos de sangre esta entre 1 y 3");
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite del coste de puntos de sangre");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setValorAtaque method, of class Disciplina.
     * test que prueba que el valor del ataque esta dentro de los limites permitidos
     */
    @Test
    public void testSetValorAtaque() {
        try{
            int valorAtaque = 2;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,1);
            disciplina.setValorAtaque(valorAtaque);
            assertEquals(valorAtaque,disciplina.getValorAtaque());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("se sobrepasa el valor limite de valor de ataque");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setValorAtaque method, of class Disciplina.
     * test que prueba que el valor del ataque supera en 1 unidad el valor del limite de valores permitidos
     */
    @Test
    public void testSetValorAtaque1() {
        try{
            int valorAtaque = 4;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,2);
            disciplina.setValorAtaque(valorAtaque);
            fail("el valor de ataque esta entre 1 y 3");
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de ataque");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setValorAtaque method, of class Disciplina.
     * test que prueba que el valor del ataque supera en varias unidades el valor limite del ataque
     */
    @Test
    public void testSetValorAtaque2() {
        try{
            int valorAtaque = 9;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,2);
            disciplina.setValorAtaque(valorAtaque);
            fail("el valor de ataque esta entre 1 y 3");
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de ataque");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setValorDefensa method, of class Disciplina.
     * test que prueba que el valor de defensa esta dentro de los limites permitidos
     */
    @Test
    public void testSetValorDefensa() {
        try{
            int valorDefensa = 2;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,1);
            disciplina.setValorDefensa(valorDefensa);
            assertEquals(valorDefensa,disciplina.getValorDefensa());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("se sobrepasa el valor limite de valor de defensa");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setValorDefensa method, of class Disciplina.
     * test que prueba que el valor de defensa supera en 1 unidad el valor del limite de valores permitidos
     */
    @Test
    public void testSetValorDefensa1() {
        try{
            int valorDefensa = 4;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,1);
            disciplina.setValorDefensa(valorDefensa);
            fail("el valor de defensa esta entre 1 y 3");
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de defensa");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setValorDefensa method, of class Disciplina.
     * test que prueba que el valor de defensa supera en varias unidades el valor limite de defensa
     */
    @Test
    public void testSetValorDefensa2() {
        try{
            int valorDefensa = 9;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,3);
            disciplina.setValorDefensa(valorDefensa);
            fail("el valor de defensa esta entre 1 y 3");
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de defensa");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setRabiaMin method, of class Disciplina.
     * test que prueba que el personaje no tiene un valor de rabia minima 
     */
    @Test
    public void testSetRabiaMin() {
        try{
            int rabiaMin = 0;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,3);
            disciplina.setRabiaMin(rabiaMin);
            fail("la habilidad tiene rabia minima");
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene rabia minima");
            System.out.println("CP1 correcto");
        }
    }

    /**
     * Test of setEdad method, of class Disciplina.
     * test que prueba que la disciplina no tiene una edad de adquisicion
     */
    @Test
    public void testSetEdad() {
        try{
            int edad = 0;
            Disciplina disciplina = new Disciplina("adkgxv",3,1,2);
            disciplina.setEdad(edad);
            fail("la habilidad tiene edad de adquisicion");
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene una edad de adquisicion");
            System.out.println("CP1 correcto");
        }
    }

}
