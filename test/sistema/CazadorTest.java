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
public class CazadorTest {
    
    public CazadorTest() {
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
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que se pueden tener 2 armas activas de 1 mano
     */
    @Test
    public void testSetArmasActivas() {
        try{
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            Arma arma2 = new Arma("zimmer",1,2,"1 mano");
            Cazador cazador = new Cazador();
            cazador.setListaArmas(arma1);
            cazador.setListaArmas(arma2);
        
            cazador.setArmasActivas(arma1);
            cazador.setArmasActivas(arma2);
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("no se pueden tener 2 armas activas de 1 mano");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que no se pueden tener 3 armas activas de 1 mano
     */
    @Test
    public void testSetArmasActivas4() {
        try{
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            Arma arma2 = new Arma("zimmer",1,2,"1 mano");
            Arma arma3 = new Arma("killer",2,1,"1 mano");
            Cazador cazador = new Cazador();
            cazador.setListaArmas(arma1);
            cazador.setListaArmas(arma2);
            cazador.setListaArmas(arma3);
            
            cazador.setArmasActivas(arma1);
            cazador.setArmasActivas(arma2);
            cazador.setArmasActivas(arma3);
            fail("se pueden tener 3 armas activas de 1 mano");
            System.out.println("CP5 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"ha llegado al tope de armas activas");
            System.out.println("CP5 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que no se pueden tener 2 armas activas de 2 manos
     */
    @Test
    public void testSetArmasActivas5() {
        try{
            Arma arma2 = new Arma("zimmer",1,2,"2 manos");
            Arma arma3 = new Arma("killer",2,1,"2 manos");
            Cazador cazador = new Cazador();
            cazador.setListaArmas(arma2);
            cazador.setListaArmas(arma3);
            
            cazador.setArmasActivas(arma2);
            cazador.setArmasActivas(arma3);
            fail("se pueden tener 2 armas activas de 2 manos");
            System.out.println("CP6 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"ha llegado al tope de armas activas");
            System.out.println("CP6 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que se puede tener 1 arma activa de 1 mano
     */
    @Test
    public void testSetArmasActivas3() {
        try{
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            Cazador cazador = new Cazador();
            cazador.setListaArmas(arma1);
        
            cazador.setArmasActivas(arma1);
            System.out.println("CP4 incorrecto");
        }catch(Exception e){
            fail("no se pueden tener 1 arma activa de 1 mano");
            System.out.println("CP4 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que se pueden tener 1 arma activa de 2 manos
     */
    @Test
    public void testSetArmasActivas2() {
        try{
            Arma arma1 = new Arma("KFH121",2,1,"2 manos");
            Cazador cazador = new Cazador();
            cazador.setListaArmas(arma1);
        
            cazador.setArmasActivas(arma1);
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            fail("no se puede tener 1 arma activa de 2 manos");
            System.out.println("CP3 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que se puede cambiar un arma activa por otra que es del mismo manejo
     */
    @Test
    public void testSetNuevasArmasActivas() {
        try{          
            Cazador cazador = new Cazador();
            
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            cazador.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"1 mano");
            cazador.setListaArmas(arma2);
            Arma arma3 = new Arma("satan",3,3,"1 mano");
            cazador.setListaArmas(arma3);
        
            cazador.setArmasActivas(arma1);
            cazador.setArmasActivas(arma2);
            //cazador.setNuevasArmasActivas(0, arma3);
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("posicion fuera del rango del tamaño del array");
            System.out.println("CP1 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que no se puede cambiar un arma activa por otra que es de distinto mismo manejo
     */
    @Test
    public void testSetNuevasArmasActivas1() {
        try{          
            Cazador cazador = new Cazador();
            
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            cazador.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"1 mano");
            cazador.setListaArmas(arma2);
            Arma arma3 = new Arma("satan",3,3,"2 manos");
            cazador.setListaArmas(arma3);
        
            cazador.setArmasActivas(arma1);
            cazador.setArmasActivas(arma2);
            //cazador.setNuevasArmasActivas(0, arma3);
            fail("no se pueden intercambiar armas de distinto manejo");
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"no se pueden intercambiar las armas");
            System.out.println("CP1 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que no se puede cambiar un arma activa por otra porque el arma seleccionada
     * a cambiar esta fuera del rango del tamaño de la lista de armas activas
     */
    @Test
    public void testSetNuevasArmasActivas2() {
        try{          
            Cazador cazador = new Cazador();
            
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            cazador.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"1 mano");
            cazador.setListaArmas(arma2);
            Arma arma3 = new Arma("satan",3,3,"1 mano");
            cazador.setListaArmas(arma3);
        
            cazador.setArmasActivas(arma1);
            cazador.setArmasActivas(arma2);
            //cazador.setNuevasArmasActivas(2, arma3);
            fail("posicion dentro del rango del tamaño de la lista de armas activas");
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"posicion fuera del rango del tamaño de la lista de armas activas");
            System.out.println("CP2 correcto");
        }
    }

    /**
     * Test of setOro method, of class Cazador.
     * test para probar que la cantidad de oro introducida no es negativa
     */
    @Test
    public void testSetOro() {
        Cazador cazador = new Cazador();
        try{
            int oro = 32;     
            cazador.setOro(oro);
            assertEquals(oro,cazador.getOro(),0.1);
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            fail("la cantidad de oro no puede ser negativa");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setOro method, of class Cazador.
     * test para probar que la cantidad de oro introducida es el primer valor negativo
     */
    @Test
    public void testSetOro1() {
        Cazador cazador = new Cazador();
        try{
            int oro = -1;     
            cazador.setOro(oro);
            fail("la cantidad de oro puede ser negativa");
            System.out.println("CP2 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"la cantidad de oro no puede ser negativa");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setOro method, of class Cazador.
     * test para probar que la cantidad de oro introducida es 0
     */
    @Test
    public void testSetOro2() {
        Cazador cazador  = new Cazador();
        try{
            int oro = 0;     
            cazador.setOro(oro);
            assertEquals(0,cazador.getOro(),0.1);
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            fail("la cantidad de oro no puede ser negativa");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setRabia method, of class Cazador.
     * test en el que se intenta meter un valor de rabia cualquiera pese a que este personaje no tiene rabia
     */
    @Test
    public void testSetRabia() {
        try{
            int rabia = 8;
            Cazador cazador = new Cazador();
            cazador.setRabia(rabia);
            fail("este personaje tiene rabia");
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este personaje no tiene rabia");
            System.out.println("CP1 correcto");
        }
    }
/**
     * Test of setEdad method, of class Cazador.
     * test en el que se intenta meter un valor de edad cualquiera pese a que este personaje no tiene rabia
     */
    @Test
    public void testSetEdad() {
        try{
            int edad = 8;
            Cazador cazador = new Cazador();
            cazador.setEdad(edad);
            fail("este personaje tiene edad");
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este personaje no tiene una edad");
            System.out.println("CP1 correcto");
        }
    }/**
     * Test of setRabia method, of class Cazador.
     * test en el que se intenta meter un valor de reserva de puntos de sangre cualquiera pese a que este personaje no tiene rabia
     */
    @Test
    public void testSetReservaPutosSangre() {
        try{
            int reserva = 8;
            Cazador cazador = new Cazador();
            cazador.setReservaPuntosSangre(reserva);
            fail("este personaje tiene reserva");
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este personaje no tiene reserva de puntos de sangre");
            System.out.println("CP1 correcto");
        }
    }
    /**
     * Test of setVoluntad method, of class Cazador.
     * test en el que se actualiza la voluntad de este personaje restándole 1 unidad
     * sabiendo que el personaje tiene la maxima voluntad
     */
    @Test
    public void testSetVoluntad() {
        try{
            Cazador cazador = new Cazador();
            cazador.setVoluntad(3);
            int voluntad = cazador.getVoluntad();
            voluntad--;
            cazador.setVoluntad(voluntad);
            assertEquals(2,cazador.getVoluntad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("no se puede quitar mas voluntad");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setVoluntad method, of class Cazador.
     * test en el que se actualiza la voluntad de este personaje restándole 1 unidad  
     * y sabiendo que la voluntad actual del personaje es 1
     */
    @Test
    public void testSetVoluntad1() {
        try{
            Cazador cazador = new Cazador();
            int voluntad = 1;
            voluntad--;
            cazador.setVoluntad(voluntad);
            assertEquals(0,cazador.getVoluntad());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            fail("no se puede quitar mas voluntad");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setVoluntad method, of class Cazador.
     * test en el que se actualiza la voluntad de este personaje restándole 1 unidad  
     * y sabiendo que el personaje no tiene voluntad
     */
    @Test
    public void testSetVoluntad2() {
        try{
            Cazador cazador = new Cazador();
            int voluntad = 0;
            voluntad--;
            cazador.setVoluntad(voluntad);
            fail("se puede restar voluntad al personaje");
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"no se puede quitar mas voluntad");
            System.out.println("CP3 correcto");
        }
    }
  
}