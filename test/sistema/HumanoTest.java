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
import static sistema.Lealtad.BAJA;
import static sistema.Lealtad.NORMAL;

/**
 *
 * @author mimit
 */
public class HumanoTest {
    
    public HumanoTest() {
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
     * Test of setSalud method, of class Humano.
     * test que prueba que la salud esta dentro del rango de valores de salud
     */
    @Test
    public void testSetSalud() {
        try{
            int salud = 2;
            Humano humano = new Humano("asòd",salud,NORMAL);
            humano.setSalud(salud);
            assertEquals(salud,humano.getSalud());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("sobrepasa el valor limite de salud");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Humano.
     * test que prueba que la salud no alcanza por 1 unidad el valor minimo de salud
     */
    @Test
    public void testSetSalud1() {
        try{
            int salud = 0;
            Humano humano = new Humano("estropicus",salud,ALTA);
            humano.setSalud(salud);
            fail("el valor de salud esta entre 1 y 3");
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor limite de salud");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Humano.
     * test que prueba que la salud es uno de los valores limite
     */
    @Test
    public void testSetSalud2() {
        try{
            int salud = 3;
            Humano humano = new Humano("estropicus",salud,ALTA);
            humano.setSalud(salud);
            assertEquals(salud,humano.getSalud());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            fail("sobrepasa el valor limite de salud");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setDependencia method, of class Humano.
     * tesst que prueba que el humano no tiene dependencia
     */
    @Test
    public void testSetDependencia() {
        try{
            int dependencia = 4;
            Humano humano = new Humano("estropicus",1,NORMAL);
            humano.setDependencia(dependencia);
            fail("este esbirro tiene un valor de dependencia");
            System.out.println("CP1 incorreccto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este esbirro no tiene una dependencia");
            System.out.println("CP1 correcto");
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
            Humano humano = new Humano("estropicus",1,ALTA);
            humano.setPacto(pacto);
            fail("este esbirro tiene un pacto");
            System.out.println("CP1 incorreccto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este esbirro no tiene un pacto");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setLealtad method, of class Demonio.
     * test que prueba que este esbirro tiene una lealtad alta
     */
    @Test
    public void testSetLealtad() {
        try{
            Lealtad lealtad = ALTA;
            Humano humano = new Humano("estropicus",1,ALTA);
            assertEquals(lealtad,humano.getLealtad());
            System.out.println("CP1 incorreccto");
        }catch(Exception e){
            fail("este esbirro no tiene una lealtad");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setLealtad method, of class Demonio.
     * test que prueba que este esbirro tiene una lealtad normal
     */
    @Test
    public void testSetLealtad1() {
        try{
            Lealtad lealtad = NORMAL;
            Humano humano = new Humano("estropicus",1,NORMAL);
            assertEquals(lealtad,humano.getLealtad());
            System.out.println("CP2 incorreccto");
        }catch(Exception e){
            fail("este esbirro no tiene una lealtad");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setLealtad method, of class Demonio.
     * test que prueba que este esbirro tiene una lealtad baja
     */
    @Test
    public void testSetLealtad2() {
        try{
            Lealtad lealtad = BAJA;
            Humano humano = new Humano("estropicus",1,BAJA);
            assertEquals(lealtad,humano.getLealtad());
            System.out.println("CP3 incorreccto");
        }catch(Exception e){
            fail("este esbirro no tiene una lealtad");
            System.out.println("CP3 correcto");
        }
    }
    /**
     * Test of setLealtad method, of class Demonio.
     * test que prueba que el valor de lealtad es erroneo
     */
    @Test
    public void testSetLealtad3() {
        try{
            Lealtad lealtad = null;
            Humano humano = new Humano("estropicus",1,null);
            humano.setLealtad(lealtad);
            fail("el valor de lealtad es correcto");
            System.out.println("CP4 incorreccto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"valor de lealtad erroneo");
            System.out.println("CP4 correcto");
        }
    }
    
}
