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
import static sistema.Lealtad.ALTA;

/**
 *
 * @author mimit
 */
public class GhoulTest {
    
    public GhoulTest() {
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
     * Test of setSalud method, of class Demonio.
     * test que prueba que la salud esta dentro del rango de valores de salud
     */
    @Test
    public void testSetSalud() {
        try{
            int salud = 2;
            Ghoul ghoul = new Ghoul("ghalous",salud,4);
            ghoul.setSalud(salud);
            assertEquals(salud,ghoul.getSalud());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("sobrepasa el valor limite de salud");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Demonio.
     * test que prueba que la salud no alcanza por 1 unidad el valor minimo de salud
     */
    @Test
    public void testSetSalud1() {
        try{
            int salud = 0;
            Ghoul ghoul = new Ghoul("ghalous",salud,4);
            ghoul.setSalud(salud);
            fail("la salud esta entre 1 y 3");
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor limite de salud");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Demonio.
     * test que prueba que la salud supera en varias unidades el valor maximo de salud
     */
    @Test
    public void testSetSalud3() {
        try{
            int salud = 0;
            Ghoul ghoul = new Ghoul("ghalous",salud,4);
            ghoul.setSalud(salud);
            fail("la salud esta entre 1 y 3");
            System.out.println("CP4 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor limite de salud");
            System.out.println("CP4 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Demonio.
     * test que prueba que la salud es uno de los valores limite
     */
    @Test
    public void testSetSalud2() {
        try{
            int salud = 3;
            Ghoul ghoul = new Ghoul("ghalous",salud,4);
            ghoul.setSalud(salud);
            assertEquals(salud,ghoul.getSalud());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            fail("sobrepasa el valor limite de salud");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setDependencia method, of class Demonio.
     * tesst que prueba que la dependencia esta dentro del rango de valores de dependencia permitidos
     */
    @Test
    public void testSetDependencia() {
        try{
            int dependencia = 4;
            Ghoul ghoul = new Ghoul("lexus",1,dependencia);
            ghoul.setDependencia(dependencia);
            assertEquals(dependencia,ghoul.getDependencia());
            System.out.println("CP1 incorreccto");
        }catch(Exception e){
            fail("este esbirro  no tiene una dependencia");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setDependencia method, of class Demonio.
     * tesst que prueba que la dependencia supera en 1 unidad el valor maximo de dependencia
     */
    @Test
    public void testSetDependencia1() {
        try{
            int dependencia = 6;
            Ghoul ghoul = new Ghoul("lexus",1,dependencia);
            ghoul.setDependencia(dependencia);
            fail("el valor de dependencia esta entre 1 y 5");
            System.out.println("CP2 incorreccto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este esbirro  no tiene una dependencia");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setDependencia method, of class Demonio.
     * tesst que prueba que la dependencia es uno de los valores limite de dependencia
     */
    @Test
    public void testSetDependencia2() {
        try{
            int dependencia = 11;
            Ghoul ghoul = new Ghoul("lexus",1,dependencia);
            ghoul.setDependencia(dependencia);
            assertEquals(dependencia,ghoul.getDependencia());
            System.out.println("CP3 incorreccto");
        }catch(Exception e){
            fail("este esbirro  no tiene una dependencia");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setPacto method, of class Demonio.
     * test que prueba que este esbirro no tiene un pacto
     */
    @Test
    public void testSetPacto() {
        try{
            String pacto = " ";
            Ghoul ghoul = new Ghoul("lexus",1,3);
            ghoul.setPacto(pacto);
            fail("el esbirro tiene un pacto");
            System.out.println("CP1 incorreccto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este esbirro no tiene un pacto");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setLealtad method, of class Demonio.
     * test que prueba que este esbirro no tiene una lealtad
     */
    @Test
    public void testSetLealtad() {
        try{
            Lealtad lealtad = ALTA;
            Ghoul ghoul = new Ghoul("lexus",1,2);
            ghoul.setLealtad(lealtad);
            fail("el esbirro tiene una lealtad");
            System.out.println("CP1 incorreccto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este esbirro no tiene una lealtad");
            System.out.println("CP1 correcto");
        }
    }
    
}
