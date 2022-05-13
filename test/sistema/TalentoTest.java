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
public class TalentoTest {
    
    public TalentoTest() {
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
     * Test of setValorAtaque method, of class Talento.
     * test que prueba que el valor del ataque esta dentro de los limites permitidos
     */
    @Test
    public void testSetValorAtaque() {
        try{
            int valorAtaque = 2;
            Talento talento = new Talento();
            talento.setValorAtaque(valorAtaque);
            assertEquals(valorAtaque,talento.getValorAtaque());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de ataque");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setValorAtaque method, of class Talento.
     * test que prueba que el valor del ataque supera en 1 unidad el valor del limite de valores permitidos
     */
    @Test
    public void testSetValorAtaque1() {
        try{
            int valorAtaque = 4;
            Talento talento = new Talento();
            talento.setValorAtaque(valorAtaque);
            assertEquals(valorAtaque,talento.getValorAtaque());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de ataque");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setValorAtaque method, of class Talento.
     * test que prueba que el valor del ataque supera en varias unidades el valor limite del ataque
     */
    @Test
    public void testSetValorAtaque2() {
        try{
            int valorAtaque = 9;
            Talento talento = new Talento();
            talento.setValorAtaque(valorAtaque);
            assertEquals(valorAtaque,talento.getValorAtaque());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de ataque");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setValorDefensa method, of class Talento.
     * test que prueba que el valor de defensa esta dentro de los limites permitidos
     */
    @Test
    public void testSetValorDefensa() {
        try{
            int valorDefensa = 2;
            Talento talento = new Talento();
            talento.setValorDefensa(valorDefensa);
            assertEquals(valorDefensa,talento.getValorDefensa());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de defensa");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setValorDefensa method, of class Talento.
     * test que prueba que el valor de defensa supera en 1 unidad el valor del limite de valores permitidos
     */
    @Test
    public void testSetValorDefensa1() {
        try{
            int valorDefensa = 4;
            Talento talento = new Talento();
            talento.setValorDefensa(valorDefensa);
            assertEquals(valorDefensa,talento.getValorDefensa());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de defensa");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setValorDefensa method, of class Talento.
     * test que prueba que el valor de defensa supera en varias unidades el valor limite de defensa
     */
    @Test
    public void testSetValorDefensa2() {
        try{
            int valorDefensa = 9;
            Talento talento = new Talento();
            talento.setValorDefensa(valorDefensa);
            assertEquals(valorDefensa,talento.getValorDefensa());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"se sobrepasa el valor limite de valor de defensa");
            System.out.println("CP3 correcto");
        }
    }
    
    /**
     * Test of setEdad method, of class Talento.
     * test que prueba la edad de adquisicion de la habilidad, y que tiene un valor positivo
     */
    @Test
    public void testSetEdad() {
        try{
            int edad = 24;
            Talento talento = new Talento();
            talento.setEdad(edad);
            assertEquals(edad,talento.getEdad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"la edad de adquisicion no puede tomar un valor negativo");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setEdad method, of class Talento.
     * test que prueba que la edad de adquisicion de la habilidad no puede ser negativa
     */
    @Test
    public void testSetEdad1() {
        try{
            int edad = -12;
            Talento talento = new Talento();
            talento.setEdad(edad);
            assertEquals(edad,talento.getEdad());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"la edad de adquisicion no puede tomar un valor negativo");
            System.out.println("CP2 correcto");
        }
    }

    /**
     * Test of setCostePuntosSangre method, of class Talento.
     * test que prueba que la habilidad no tiene un coste de puntos de sangre
     */
    @Test
    public void testSetCostePuntosSangre() {
        try{
            int costePuntosSangre = 0;
            Talento talento = new Talento();
            talento.setCostePuntosSangre(costePuntosSangre);
            assertEquals(costePuntosSangre,talento.getCostePuntosSangre());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene un coste");
            System.out.println("CP1 correcto");
        }
    }

    /**
     * Test of setRabiaMin method, of class Talento.
     * esta habilidad no tiene una edad
     */
    @Test
    public void testSetRabiaMin() {
        try{
            int rabiaMin = 0;
            Talento talento = new Talento();
            talento.setRabiaMin(rabiaMin);
            assertEquals(rabiaMin,talento.getRabiaMin());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene rabia minima");
            System.out.println("CP1 correcto");
        }
    }
    
}
