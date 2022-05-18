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
public class LicantropoTest {
    
    public LicantropoTest() {
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
     * Test of setArmasActivas method, of class Licantropo.
     * test que prueba que se puede seleccionar un arma activa de 1 mano
     */
    @Test
    public void testSetArmasActivas() {
        try{
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            Licantropo licantropo = new Licantropo();
            licantropo.setListaArmas(arma1);        
            licantropo.setArmasActivas(arma1);
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("no se puede tener 1 arma activa de 1 mano");
            System.out.println("CP1 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Licantropo.
     * test que prueba que se pueden tener 2 armas activas de 1 mano
     */
    @Test
    public void testSetArmasActivas1() {
        try{
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            Arma arma2 = new Arma("killer",1,2,"1 mano");
            Licantropo licantropo = new Licantropo();
            licantropo.setListaArmas(arma1); 
            licantropo.setListaArmas(arma2);
            licantropo.setArmasActivas(arma1);
            licantropo.setArmasActivas(arma2);
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            fail("no se pueden tener 2 armas activas de 1 mano");
            System.out.println("CP2 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Licantropo.
     * test que prueba que no se pueden tener 3 armas activas de 1 mano
     */
    @Test
    public void testSetArmasActivas2() {
        try{
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            Arma arma2 = new Arma("killer",1,2,"1 mano");
            Arma arma3 = new Arma(" ",1,2,"1 mano");
            Licantropo licantropo = new Licantropo();
            licantropo.setListaArmas(arma1); 
            licantropo.setListaArmas(arma2);
            licantropo.setListaArmas(arma3);
            licantropo.setArmasActivas(arma1);
            licantropo.setArmasActivas(arma2);
            licantropo.setArmasActivas(arma3);
            fail("se pueden tener 3 armas activas de 1 mano");
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"ha llegado al tope de armas activas");
            System.out.println("CP3 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Licantropo.
     * test que prueba que no se pueden tener 2 armas activas de 2 manos
     */
    @Test
    public void testSetArmasActivas3() {
        try{
            Arma arma1 = new Arma("KFH121",2,1,"2 manos");
            Arma arma3 = new Arma(" ",1,2,"2 manos");
            Licantropo licantropo = new Licantropo();
            licantropo.setListaArmas(arma1);
            licantropo.setListaArmas(arma3);
            licantropo.setArmasActivas(arma1);
            licantropo.setArmasActivas(arma3);
            fail("se pueden tener 2 armas activas de 2 manos");
            System.out.println("CP4 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"ha llegado al tope de armas activas");
            System.out.println("CP4 correcto");
        }
    }    
    /**
     * Test of setArmasActivas method, of class Licantropo.
     * test que prueba que no se puede cambiar un arma activa por otra porque los manejos no son iguales
     */
    @Test
    public void testSetNuevasArmasActivas() {
        try{          
            Licantropo licantropo = new Licantropo();
            
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            licantropo.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"1 mano");
            licantropo.setListaArmas(arma2);
            Arma arma3 = new Arma("satan",3,3,"2 manos");
            licantropo.setListaArmas(arma3);
        
            licantropo.setArmasActivas(arma1);
            licantropo.setArmasActivas(arma2);
            licantropo.setNuevasArmasActivas(0, arma3);
            fail("se pueden intercambiar 2 armas de distinto manejo");
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"no se pueden intercambiar las armas");
            System.out.println("CP1 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Licantropo.
     * test que prueba que se puede cambiar un arma activa por otra porque los manejos son iguales
     */
    @Test
    public void testSetNuevasArmasActivas1() {
        try{          
            Licantropo licantropo = new Licantropo();
            
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            licantropo.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"1 mano");
            licantropo.setListaArmas(arma2);
            Arma arma3 = new Arma("satan",3,3,"1 mano");
            licantropo.setListaArmas(arma3);
        
            licantropo.setArmasActivas(arma1);
            licantropo.setArmasActivas(arma2);
            licantropo.setNuevasArmasActivas(0, arma3);
            assertEquals("1 mano",arma3.getManejo());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            fail("no se pueden intercambiar las armas");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Licantropo.
     * test que prueba que no se puede cambiar un arma activa por otra porque el arma seleccionada
     * a cambiar esta fuera del rango del array
     */
    @Test

    public void testSetNuevasArmasActivas2() {
        try{          
            Licantropo licantropo = new Licantropo(); 
            
            Arma arma1 = new Arma("KFH121",2,1,"1 mano");
            licantropo.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"1 mano");
            licantropo.setListaArmas(arma2);
            Arma arma3 = new Arma("satan",3,3,"1 mano");
            licantropo.setListaArmas(arma3);
        
            licantropo.setArmasActivas(arma1);
            licantropo.setArmasActivas(arma2);
            licantropo.setNuevasArmasActivas(2, arma3);
            fail("no se ha superado el tamaño maximo de armas activas");
            System.out.println("CP3 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"fuera del limite de armas activas");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setHabilidad method, of class Licantropo.
     * test para probar que este personaje tiene como habilidad especial el don
     */
    @Test

    public void testSetHabilidad() {
        try{
            Don don = new Don("extirpacion",3,1,2);
            Licantropo licantropo = new Licantropo();
            licantropo.setHabilidad(don);
            assertEquals(don,licantropo.getHabilidad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("esta habilidad no tiene una rabia minima");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setHabilidad method, of class Licantropo.
     * test para probar que este personaje no tiene como habilidad especial la disciplina 
     * porque el Don no tiene un coste
     */
    @Test
    public void testSetHabilidad1() {
        try{
            Disciplina disciplina = new Disciplina("adkgxv",3,1,1);
            Licantropo licantropo = new Licantropo();
            licantropo.setHabilidad(disciplina);
            fail("el personaje tiene como habilidad la disciplina");
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"no tiene esta habilidad");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setHabilidad method, of class Licantropo.
     * test para probar que este personaje no tiene como habilidad especial el talento
     */
    @Test
    public void testSetHabilidad2() {
        try{
            Talento talento = new Talento("adkgxv",3,1,455);
            Licantropo licantropo = new Licantropo();
            licantropo.setHabilidad(talento);
            fail("el personaje tiene como habilidad el talento");
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"no tiene esta habilidad");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setOro method, of class Licantropo.
     * test para probar que la cantidad de oro introducida no es negativa
     */
    @Test
    public void testSetOro() {
        Licantropo licantropo = new Licantropo();
        try{
            int oro = 32;     
            licantropo.setOro(oro);
            assertEquals(32,licantropo.getOro(),0.1);
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            fail("la cantidad de oro no puede ser negativa");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setOro method, of class Licantropo.
     * test para probar que la cantidad de oro introducida es el primer valor negativo
     */
    @Test
    public void testSetOro1() {
        Licantropo licantropo = new Licantropo();
        try{
            int oro = -1;     
            licantropo.setOro(oro);
            fail("se puede introducir un valor de oro negativo");
            System.out.println("CP2 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"la cantidad de oro no puede ser negativa");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setOro method, of class Licantropo.
     * test para probar que la cantidad de oro introducida es 0
     */
    @Test
    public void testSetOro2() {
        Licantropo licantropo = new Licantropo();
        try{
            double oro = 0.0;     
            licantropo.setOro(oro);
            assertEquals(0.0,licantropo.getOro(),0.1);
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            fail("la cantidad de oro no puede ser negativa");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setSalud method, of class Licantropo.
     * test para probar que la salud supera el maximo valor de salud permtido en 1 unidad
     */
    @Test
    public void testSetSalud() {
        try{ 
            int salud = 6;
            Licantropo licantropo = new Licantropo();
            licantropo.setSalud(salud);
            fail("el valor de saluud esta en los limites permitidos");
            System.out.println("CP4 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP4 correcto");
        }
    }

    /**
     * Test of setSalud method, of class Licantropo.
     * test para probar que la salud no alcanza el minimo valor de salud permtido
     */
    @Test
    public void testSetSalud1() {
        try{ 
            int salud = -1;
            Licantropo licantropo = new Licantropo();
            licantropo.setSalud(salud);
            fail("la salud esta en los limites permitidos");
            System.out.println("CP5 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP5 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Licantropo.
     * test para probar que la salud es uno de los valores limite de salud permitidos 
     */
    @Test
    public void testSetSalu2() {
        try{ 
            int salud = 0;
            Licantropo licantropo =  new Licantropo();
            licantropo.setSalud(salud);
            assertEquals(0,licantropo.getSalud());
            System.out.println("CP7 incorrecto");
        }catch(Exception ex){
            fail("sobrepasó el límite de salud permitida");
            System.out.println("CP7 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Licantropo.
     * test para probar que la salud esta dentro del rango de valores permitidos 
     * pero no es uno de los valores limite
     */
    @Test
    public void testSetSalud3() {
        try{ 
            int salud = 4;
            Licantropo licantropo = new Licantropo();
            licantropo.setSalud(salud);
            assertEquals(4,licantropo.getSalud());
            System.out.println("CP8 incorrecto");
        }catch(Exception ex){
            fail("sobrepasó el límite de salud permitida");
            System.out.println("CP8 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Licantropo.
     * test para probar que el poder supera el maximo valor de poder permtido en 1 unidad
     */
    @Test
    public void testSetPoder() {
        try{ 
            int poder = 6;
            Licantropo licantropo = new Licantropo();
            licantropo.setPoder(poder);
            fail("el poder esta dentro del limite");
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Licantropo.
     * test para probar que el poder esta a un valor de alcanzar el minimo valor de poder permtido
     */
    @Test
    public void testSetPoder1() {
        try{ 
            int poder = 0;
            Licantropo licantropo = new Licantropo();
            licantropo.setPoder(poder);
            fail("el poder esta dentro del limite");
            System.out.println("CP2 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Licantroopo.
     * test para probar que el poder sobrepasa en mas de 1 unidad el valor maximo de poder permitido
     */
    @Test
    public void testSetPoder2() {
        try{ 
            int poder = 9;
            Licantropo licantropo = new Licantropo();
            licantropo.setPoder(poder);
            fail("el poder esta dentro de los limites");
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP3 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Licantropo.
     * test para probar que el poder esta en el rango de valores permitidos sin contar los valores limite
     */
    @Test
    public void testSetPoder3() {
        try{ 
            int poder = 3;
            Licantropo licantropo = new Licantropo();
            licantropo.setPoder(poder);
            assertEquals(3,licantropo.getPoder());
            System.out.println("CP4 incorrecto");
        }catch(Exception ex){
            fail("sobrepasó el límite de poder permitido");
            System.out.println("CP4 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Licantropo.
     * test para probar que el poder es uno de los valores limite
     */
    @Test
    public void testSetPoder4() {
        try{ 
            int poder = 5;
            Licantropo licantropo = new Licantropo();
            licantropo.setPoder(poder);
            assertEquals(5,licantropo.getPoder());
            System.out.println("CP5 incorrecto");
        }catch(Exception ex){
            fail("sobrepasó el límite de poder permitido");
            System.out.println("CP5 correcto");
        }
    }

    /**
     * Test of setVoluntad method, of class Licantropo.
     * test en el que se intenta meter un valor de voluntad cualquiera pese a que este personaje no tiene
     */
    @Test
    public void testSetVoluntad() {
        try{
            int voluntad = 8;
            Licantropo licantropo = new Licantropo();
            licantropo.setVoluntad(voluntad);
            fail("el personaje tiene voluntad");
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este personaje no tiene voluntad");
            System.out.println("CP1 correcto");
        }
    }

    /**
     * Test of setRabia method, of class Licantropo.
     * test en el que se actualiza la rabia de este personaje sumándole 1 unidad y cuyo valor inicial es 0
     */
    @Test
    public void testSetRabia() {
        try{
            Licantropo licantropo = new Licantropo();
            int rabia = 0;
            rabia++;
            licantropo.setRabia(rabia);
            assertEquals(1,licantropo.getRabia());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            fail("ha llegado al tope de rabia");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setRabia method, of class Licantropo.
     * test en el que se actualiza la rabia de este personaje sumándole 1 unidad  
     * y sabiendo que la rabia actual del personaje es 2
     */
    @Test
    public void testSetVoluntad1() {
        try{
            Licantropo licantropo = new Licantropo();
            int rabia = 2;
            rabia++;
            licantropo.setRabia(rabia);
            assertEquals(3,licantropo.getRabia());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"ha llegado al tope de rabia");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setRabia method, of class Licantropo.
     * test en el que se actualiza la rabia de este personaje sumándole 1 unidad  
     * y sabiendo que el personaje ha alcanzado el valor maximo de rabia
     */
    @Test
    public void testSetRabia2() {
        try{
            Licantropo licantropo = new Licantropo();
            int rabia = 3;
            rabia++;
            licantropo.setRabia(rabia);
            assertEquals(3,licantropo.getRabia());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"ha llegado al tope de rabia");
            System.out.println("CP3 correcto");
        }
    }
/**
     * Test of setEdad method, of class Licantropo.
     * test en el que se intenta meter un valor de edad cualquiera pese a que este personaje no tiene
     */
    @Test
    public void testSetEdad() {
        try{
            int edad = 8;
            Licantropo licantropo = new Licantropo();
            licantropo.setEdad(edad);
            fail("el personaje tiene edad");
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"este personje no tiene edad");
            System.out.println("CP1 correcto");
        }
    }
    /**
     * Test of setReservaPunntosCoste method, of class Licantropo.
     * test en el que se intenta meter un valor de coste cualquiera pese a que este personaje no tiene
     */
    @Test
    public void testSeReservaPuntosCoste() {
        try{
            int coste = 8;
            Licantropo licantropo = new Licantropo();
            licantropo.setReservaPuntosSangre(coste);
            fail("el personaje tiene reserva");
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"este personaje no tiene puntos de sangre");
            System.out.println("CP1 correcto");
        }
    }
}