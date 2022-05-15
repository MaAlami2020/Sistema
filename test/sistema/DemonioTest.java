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
public class DemonioTest {
    
    public DemonioTest() {
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
            Demonio demonio = new Demonio("lexus",salud," ");
            demonio.setSalud(salud);
            assertEquals(salud,demonio.getSalud());
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
            Demonio demonio = new Demonio("lexus",salud," ");
            demonio.setSalud(salud);
            fail("la salud esta entre 1 y 3");
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor limite de salud");
            System.out.println("CP2 correcto");
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
            Demonio demonio = new Demonio("lexus",salud," ");
            demonio.setSalud(salud);
            assertEquals(salud,demonio.getSalud());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor limite de salud");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setDependencia method, of class Demonio.
     * tesst que prueba que este esbirro no tiene dependencia
     */
    @Test
    public void testSetDependencia() {
        try{
            int dependencia = 8;
            Demonio demonio  = new Demonio("lexus",1," ");
            demonio.setDependencia(dependencia);
            assertEquals(dependencia,demonio.getDependencia());
            System.out.println("CP1 incorreccto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este esbirro  no tiene una dependencia");
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
            Demonio demonio  = new Demonio("lexus",1," ");
            demonio.setLealtad(lealtad);
            assertEquals(lealtad,demonio.getLealtad());
            System.out.println("CP1 incorreccto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este esbirro no tiene una lealtad");
            System.out.println("CP1 correcto");
        }
    }
    
}
