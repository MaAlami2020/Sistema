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
     * test que prueba que se puede seleccionar un arma activa de 1 mano
     */
    @Test
    public void testSetArmasActivas() {
        try{
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            Cazador cazador = new Cazador();
            cazador.setListaArmas(arma1);
        
            cazador.setArmasActivas(arma1);
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"ha llegado al tope de armas activas");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que se ha llegado al tope de armas activas
     */
    @Test
    public void testSetArmasActivas1() {
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
            cazador.setArmasActivas(arma3);
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"ha llegado al tope de armas activas");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que se puede cambiar un arma activa por otra
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
            cazador.setNuevasArmasActivas(0, arma3);
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"posicion fuera del rango del tamaño del array");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Cazador.
     * test que prueba que no se puede cambiar un arma activa por otra porque el arma seleccionada
     * a cambiar esta fuera del rango del array
     */
    @Test
    public void testSetNuevasArmasActivas1() {
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
            cazador.setNuevasArmasActivas(2, arma3);
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"posicion fuera del rango del tamaño del array");
            System.out.println("CP2 correcto");
        }
    }

    /**
     * Test of setHabilidad method, of class Cazador.
     * test para probar que este personaje tiene como habilidad especial el talento
     */
    @Test

    public void testSetHabilidad() {
        try{
            Talento talento = new Talento("extirpacion",3,1,219);
            Cazador cazador = new Cazador();
            cazador.setHabilidad(talento);
            assertSame(talento,cazador.getHabilidad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene una edad de  adquisicion");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setHabilidad method, of class Cazador.
     * test para probar que este personaje no tiene como habilidad especial el don 
     * porque esa habilidad no tiene una edad de adquiscion
     */
    @Test
    public void testSetHabilidad1() {
        try{
            Don don = new Don();
            Cazador cazador = new Cazador(); 
            cazador.setHabilidad(don);
            assertSame(don,cazador.getHabilidad());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene una edad de adquisicion");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setHabilidad method, of class Cazador.
     * test para probar que este personaje no tiene como habilidad especial la disciplina 
     * porque esta habilidad no tiene una edad de adquisicion
     */
    @Test
    public void testSetHabilidad2() {
        try{
            Disciplina disciplina = new Disciplina();
            Cazador cazador = new Cazador();
            cazador.setHabilidad(disciplina);
            assertSame(disciplina,cazador.getHabilidad());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene una edad de adquisicion");
            System.out.println("CP3 correcto");
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
            assertEquals(32,cazador.getOro());
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"la cantidad de oro no puede ser negativa");
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
            assertEquals(-1,cazador.getOro());
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
            assertEquals(0,cazador.getOro());
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"la cantidad de oro no puede ser negativa");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setSalud method, of class Cazador.
     * test para probar que la salud supera el maximo valor de salud permtido en 1 unidad
     */
    @Test
    public void testSetSalud() {
        try{ 
            int salud = 6;
            Cazador cazador = new Cazador();
            cazador.setSalud(salud);
            assertEquals(6,cazador.getSalud());
            System.out.println("CP4 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP4 correcto");
        }
    }

    /**
     * Test of setSalud method, of class Cazador.
     * test para probar que la salud no alcanza el minimo valor de salud permtido
     */
    @Test
    public void testSetSalud1() {
        try{ 
            int salud = -1;
            Cazador cazador = new Cazador();
            cazador.setSalud(salud);
            assertEquals(-1,cazador.getSalud());
            System.out.println("CP5 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP5 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Cazador.
     * test para probar que la salud es uno de los valores limite de salud permitidos 
     */
    @Test
    public void testSetSalu2() {
        try{ 
            int salud = 0;
            Cazador cazador = new Cazador();
            cazador.setSalud(salud);
            assertEquals(0,cazador.getSalud());
            System.out.println("CP7 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP7 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Cazador.
     * test para probar que la salud esta dentro del rango de valores permitidos 
     * pero no es uno de los valores limite
     */
    @Test
    public void testSetSalud3() {
        try{ 
            int salud = 4;
            Cazador cazador = new Cazador();
            cazador.setSalud(salud);
            assertEquals(4,cazador.getSalud());
            System.out.println("CP8 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP8 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Cazador.
     * test para probar que el poder supera el maximo valor de poder permtido en 1 unidad
     */
    @Test
    public void testSetPoder() {
        try{ 
            int poder = 6;
            Cazador cazador = new Cazador();
            cazador.setPoder(poder);
            assertEquals(6, cazador.getPoder());
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Cazador.
     * test para probar que el poder esta a un valor de alcanzar el minimo valor de poder permtido
     */
    @Test
    public void testSetPoder1() {
        try{ 
            int poder = 0;
            Cazador cazador = new Cazador();
            cazador.setPoder(poder);
            assertEquals(0,cazador.getPoder());
            System.out.println("CP2 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Cazador.
     * test para probar que el poder sobrepasa en mas de 1 unidad el valor maximo de poder permitido
     */
    @Test
    public void testSetPoder2() {
        try{ 
            int poder = 9;
            Cazador cazador = new Cazador();
            cazador.setPoder(poder);
            assertEquals(9,cazador.getPoder());
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP3 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Cazador.
     * test para probar que el poder esta en el rango de valores permitidos sin contar los valores limite
     */
    @Test
    public void testSetPoder3() {
        try{ 
            int poder = 3;
            Cazador cazador = new Cazador();
            cazador.setPoder(poder);
            assertEquals(3,cazador.getPoder());
            System.out.println("CP4 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP4 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Cazador.
     * test para probar que el poder es uno de los valores limite
     */
    @Test
    public void testSetPoder4() {
        try{ 
            int poder = 5;
            Cazador cazador = new Cazador();
            cazador.setPoder(poder);
            assertEquals(5,cazador.getPoder());
            System.out.println("CP5 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP5 correcto");
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
            assertEquals(8,cazador.getRabia());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este personaje no tiene rabia");
            System.out.println("CP1 correcto");
        }
    }

    /**
     * Test of setVoluntad method, of class Cazador.
     * test en el que se actualiza la voluntad de este personaje restándole 1 unidad
     */
    @Test
    public void testSetVoluntad() {
        try{
            Cazador cazador = new Cazador();
            int voluntad = cazador.getVoluntad();
            voluntad--;
            cazador.setVoluntad(voluntad);
            assertEquals(2,cazador.getVoluntad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"no se puede quitar mas voluntad");
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
            assertEquals(e.getMessage(),"no se puede quitar mas voluntad");
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
            assertEquals(-1,cazador.getVoluntad());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"no se puede quitar mas voluntad");
            System.out.println("CP3 correcto");
        }
    }
    
    /**
     * Test of setVoluntad method, of class Cazador.
     * test en el que se actualiza la voluntad de este personaje restándole 1 unidad  
     * y sabiendo que el personaje no tiene voluntad
     */
    @Test
    public void testSetVoluntad3() {
        try{
            Cazador cazador = new Cazador();
            int voluntad = 0;
            voluntad--;
            cazador.setVoluntad(voluntad);
            assertEquals(-1,cazador.getVoluntad());
            System.out.println("CP4 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"no se puede quitar mas voluntad");
            System.out.println("CP4 correcto");
        }
    }
}