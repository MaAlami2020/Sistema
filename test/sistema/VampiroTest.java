/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistema;

import java.util.ArrayList;
import java.util.List;
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
public class VampiroTest {
    
    public VampiroTest() {
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
     * Test of setEdad method, of class Vampiro.
     * test para probar que la edad del personaje es positiva
     */
    @Test
    public void testSetEdad() {
        try{
            int edad = 0;
            Vampiro vampiro = new Vampiro();
            vampiro.setEdad(edad);
            assertEquals(0,vampiro.getEdad());
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            fail("la edad puede ser negativa");
            System.out.println("CP1 correcto");
        }
    }
    /**
     * Test of setEdad method, of class Vampiro.
     * test para probar que la edad del personaje no puede ser negativa
     */
    @Test
    public void testSetEdad1() {
        try{
            int edad = -123;
            Vampiro vampiro = new Vampiro();
            vampiro.setEdad(edad);
            fail("la edad puede ser negativa");
            System.out.println("CP2 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"la edad no puede ser negativa");
            System.out.println("CP2 correcto");
        }
    }
    /**
     * Test of setEdad method, of class Vampiro.
     * test para probar que la edad del personaje puede ser 0
     */
    @Test
    public void testSetEdad2() {
        try{
            int edad = 0;
            Vampiro vampiro = new Vampiro();
            vampiro.setEdad(edad);
            assertEquals(0,vampiro.getEdad());
            System.out.println("CP3 incorrecto");
        }catch(RuntimeException e){
            fail("la edad no puede ser 0");
            System.out.println("CP3 correcto");
        }
    }
    /**
     * Test of setReservaPuntosSangre method, of class Vampiro.
     * test para probar que la reserva de puntos de sangre del personaje es 0
     */
    @Test
    public void testSetReservaPuntosSangre() {
        try{
            int reservaPuntosSangre = 0;
            Vampiro vampiro = new Vampiro();
            vampiro.setReservaPuntosSangre(reservaPuntosSangre);
            assertEquals(0,vampiro.getReservaPuntosSangre());
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            fail("sobrepasa el valor maximo de la reserva de puntos de sangre");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setReservaPuntosSangre method, of class Vampiro.
     * test para probar que la reserva de puntos de sangre del personaje es un numero negativo
     */
    @Test
    public void testSetReservaPuntosSangre1() {
        try{
            int reservaPuntosSangre = -5;
            Vampiro vampiro = new Vampiro();
            vampiro.setReservaPuntosSangre(reservaPuntosSangre);
            assertEquals(0,vampiro.getReservaPuntosSangre());
            System.out.println("CP2 incorrecto");
        }catch(RuntimeException e){
            fail("sobrepasa el valor maximo de la reserva de puntos de sangre");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setReservaPuntosSangre method, of class Vampiro.
     * test para probar que la reserva de puntos de sangre del personaje es el valor maximo
     */
    @Test
    public void testSetReservaPuntosSangre2() {
        try{
            int reservaPuntosSangre = 10;
            Vampiro vampiro = new Vampiro();
            vampiro.setReservaPuntosSangre(reservaPuntosSangre);
            assertEquals(10,vampiro.getReservaPuntosSangre());
            System.out.println("CP3 incorrecto");
        }catch(RuntimeException e){
            fail("sobrepasa el valor maximo de la reserva de puntos de sangre");
            System.out.println("CP3 correcto");
        }
    }
    
    /**
     * Test of setReservaPuntosSangre method, of class Vampiro.
     * test para probar que la reserva de puntos de sangre del personaje esta entre el 0 y el valor maximo
     */
    @Test
    public void testSetReservaPuntosSangre3() {
        try{
            int reservaPuntosSangre = 7;
            Vampiro vampiro = new Vampiro();
            vampiro.setReservaPuntosSangre(reservaPuntosSangre);
            assertEquals(7,vampiro.getReservaPuntosSangre());
            System.out.println("CP4 incorrecto");
        }catch(RuntimeException e){
            fail("sobrepasa el valor maximo de la reserva de puntos de sangre");
            System.out.println("CP4 correcto");
        }
    }
    
    /**
     * Test of setReservaPuntosSangre method, of class Vampiro.
     * test para probar que la reserva de puntos de sangre del personaje supera el valor maximo
     */
    @Test
    public void testSetReservaPuntosSangre4() {
        try{
            int reservaPuntosSangre = 21;
            Vampiro vampiro = new Vampiro();
            vampiro.setReservaPuntosSangre(reservaPuntosSangre);
            fail("la reserva esta dentro del rango de valores permitidos");
            System.out.println("CP5 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"sobrepasa el valor maximo de la reserva de puntos de sangre");
            System.out.println("CP5 correcto");
        }
    }

    /**
     * Test of setArmasActivas method, of class Vampiro.
     * test que prueba que se puede seleccionar un arma activa de 1 mano
     */
    @Test
    public void testSetArmasActivas() {
        try{
            List<String> materiales = new ArrayList<>();
            materiales.add("hgfd");
            materiales.add("hgfdthb");
            Arma arma1 = new Arma("KFH121",2,1,"1 mano",materiales);
            Vampiro vampiro = new Vampiro();
            vampiro.setListaArmas(arma1);
        
            vampiro.setArmasActivas(arma1);
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            fail("ha llegado al tope de armas activas");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Vampiro.
     * test que prueba que se puede seleccionar 2 armas activas de 1 mano
     */
    @Test
    public void testSetArmasActivas1() {
        try{
            List<String> materiales = new ArrayList<>();
            materiales.add("hgfd");
            materiales.add("hgfdthb");
            Arma arma1 = new Arma("KFH121",2,1,"1 mano",materiales);
            Arma arma2 = new Arma("kill",1,2,"1 mano",materiales);
            Vampiro vampiro = new Vampiro();
            vampiro.setListaArmas(arma1);
            vampiro.setListaArmas(arma2);
            
            vampiro.setArmasActivas(arma2);
            vampiro.setArmasActivas(arma1);
            System.out.println("CP2 incorrecto");
        }catch(RuntimeException e){
            fail("ha llegado al tope de armas activas");
            System.out.println("CP2 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Vampiro.
     * test que prueba que se puede seleccionar un arma activa de 2 manos
     */
    @Test
    public void testSetArmasActivas2() {
        try{
            List<String> materiales = new ArrayList<>();
            materiales.add("hgfd");
            materiales.add("hgfdthb");
            Arma arma1 = new Arma("KFH121",2,1,"2 manos",materiales);
            Vampiro vampiro = new Vampiro();
            vampiro.setListaArmas(arma1);
        
            vampiro.setArmasActivas(arma1);
            System.out.println("CP3 incorrecto");
        }catch(RuntimeException e){
            fail("ha llegado al tope de armas activas");
            System.out.println("CP3 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Vampiro.
     * test que prueba que no se puede tener 3 armas activas de 1 mano
     */
    @Test
    public void testSetArmasActivas3() {
        try{
            List<String> materiales = new ArrayList<>();
            materiales.add("hgfd");
            materiales.add("hgfdthb");
            Arma arma1 = new Arma("KFH121",2,1,"1 mano",materiales);
            Arma arma2 = new Arma("calggame",2,1,"1 mano",materiales);
            Arma arma3 = new Arma("satan",2,1,"1 mano",materiales);
            Vampiro vampiro = new Vampiro();
            vampiro.setListaArmas(arma1);
            vampiro.setListaArmas(arma2);
            vampiro.setListaArmas(arma3);
            
            vampiro.setArmasActivas(arma1);
            vampiro.setArmasActivas(arma2);
            vampiro.setArmasActivas(arma3);
            fail("se puden tener 3 armas activas");
            System.out.println("CP4 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"ha llegado al tope de armas activas");
            System.out.println("CP4 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Vampiro.
     * test que prueba que no se pueden tener 2 armas activas de 2 manos
     */
    @Test
    public void testSetArmasActivas4() {
        try{          
            Vampiro vampiro = new Vampiro();
            List<String> materiales = new ArrayList<>();
            materiales.add("hgfd");
            materiales.add("hgfdthb");
            Arma arma1 = new Arma("KFH121",2,1,"2 manos",materiales);
            vampiro.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"2 manos",materiales);
            vampiro.setListaArmas(arma2);
        
            vampiro.setArmasActivas(arma1);
            vampiro.setArmasActivas(arma2);
            fail("se puden tener 4 manos activas");
            System.out.println("CP5 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"ha llegado al tope de armas activas");
            System.out.println("CP5 correcto");
        }
    }
    
    /**
     * Test of setArmasActivas method, of class Vampiro.
     * test que prueba que se puede cambiar un arma activa por otra del mismo manejo
     */
    @Test
    public void testSetNuevasArmasActivas() {
        try{          
            Vampiro vampiro = new Vampiro();
            List<String> materiales = new ArrayList<>();
            materiales.add("hgfd");
            materiales.add("hgfdthb");
            Arma arma1 = new Arma("KFH121",2,1,"1 mano",materiales);
            vampiro.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"1 mano",materiales);
            vampiro.setListaArmas(arma2);
            Arma arma3 = new Arma("satan",3,3,"1 mano",materiales);
            vampiro.setListaArmas(arma3);
        
            vampiro.setArmasActivas(arma1);
            vampiro.setArmasActivas(arma2);
            //vampiro.setNuevasArmasActivas(0, arma3);
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            fail("no se pueden intercambiar las armas");
            System.out.println("CP1 correcto");
        }
    }
    /**
     * Test of setArmasActivas method, of class Vampiro.
     * test que prueba que no se puede cambiar un arma activa por otra de distinto manejo
     */
    @Test
    public void testSetNuevasArmasActivas1() {
        try{          
            Vampiro vampiro = new Vampiro();
            List<String> materiales = new ArrayList<>();
            materiales.add("hgfd");
            materiales.add("hgfdthb");
            Arma arma1 = new Arma("KFH121",2,1,"1 mano",materiales);
            vampiro.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"1 mano",materiales);
            vampiro.setListaArmas(arma2);
            Arma arma3 = new Arma("satan",3,3,"2 manos",materiales);
            vampiro.setListaArmas(arma3);
        
            vampiro.setArmasActivas(arma1);
            vampiro.setArmasActivas(arma2);
            //vampiro.setNuevasArmasActivas(0, arma3);
            fail("se puede intercambiar un arma por otra de distinto manejo");
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"no se pueden intercambiar las armas");
            System.out.println("CP1 correcto");
        }
    }    
    /**
     * Test of setArmasActivas method, of class Vampiro.
     * test que prueba que no se puede cambiar un arma activa por otra porque el arma seleccionada
     * a cambiar esta fuera del rango del array
     */
    @Test
    public void testSetNuevasArmasActivas2() {
        try{          
            Vampiro vampiro = new Vampiro();
            List<String> materiales = new ArrayList<>();
            materiales.add("hgfd");
            materiales.add("hgfdthb");
            Arma arma1 = new Arma("KFH121",2,1,"1 mano",materiales);
            vampiro.setListaArmas(arma1);
            Arma arma2 = new Arma("Kgc",1,1,"1 mano",materiales);
            vampiro.setListaArmas(arma2);
            Arma arma3 = new Arma("satan",3,3,"1 mano",materiales);
            vampiro.setListaArmas(arma3);
        
            vampiro.setArmasActivas(arma1);
            vampiro.setArmasActivas(arma2);
            //vampiro.setNuevasArmasActivas(2, arma3);
            fail("se puede meter un  arma activa fuera del rango de la lista");
            System.out.println("CP3 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"posicion fuera del rango del tamaño del array");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setListaEsbirros method, of class Vampiro.
     * test que prueba que este personaje no puede tener un esbirro humano
     */
    @Test

    public void testSetListaEsbirros() {
        try{
            Humano humano = new Humano("octipus",1,ALTA);
            Vampiro vampiro = new Vampiro();
            vampiro.setListaEsbirros(humano);
            fail("el personaje puede tener esbirros humanos");
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"este personaje no tiene esbirros humanos");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setListaEsbirros method, of class Vampiro.
     * test que prueba que este personaje puede tener un esbirro ghoul
     */
    @Test

    public void testSetListaEsbirros1() {
        try{
            Ghoul ghoul = new Ghoul("haskell",1,4);
            Vampiro vampiro = new Vampiro();
            vampiro.setListaEsbirros(ghoul);
            assertEquals(ghoul,vampiro.getListaEsbirros().get(vampiro.getListaEsbirros().size()-1));
            System.out.println("CP2 incorrecto");
        }catch(RuntimeException e){
            fail("este esbirro no tiene esbirros ghoul");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setListaEsbirros method, of class Vampiro.
     * test que prueba que este personaje puede tener un esbirro demonio
     */
    @Test

    public void testSetListaEsbirros2() {
        try{
            Demonio demonio = new Demonio("hastex",5,"infundir miedo");
            Vampiro vampiro = new Vampiro();
            vampiro.setListaEsbirros(demonio);
            assertEquals(demonio,vampiro.getListaEsbirros().get(vampiro.getListaEsbirros().size()-1));
            System.out.println("CP3 incorrecto");
        }catch(RuntimeException e){
            fail("este personaje no tiene esbirros demonio");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setOro method, of class Vampiro.
     * test para probar que la cantidad de oro introducida no es negativa
     */
    @Test
    public void testSetOro() {
         Vampiro vampiro = new Vampiro();
        try{
            int oro = 32;     
            vampiro.setOro(oro);
            assertEquals(32,vampiro.getOro(),0.1);
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            fail("la cantidad de oro no puede ser negativa");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setOro method, of class Vampiro.
     * test para probar que la cantidad de oro introducida es el primer valor negativo
     */
    @Test
    public void testSetOro1() {
         Vampiro vampiro = new Vampiro();
        try{
            int oro = -1;     
            vampiro.setOro(oro);
            fail("la cantidad de oro puede ser negativa");
            System.out.println("CP2 incorrecto");
        }catch(RuntimeException ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"la cantidad de oro no puede ser negativa");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setOro method, of class Vampiro.
     * test para probar que la cantidad de oro introducida es 0
     */
    @Test
    public void testSetOro2() {
         Vampiro vampiro = new Vampiro();
        try{
            int oro = 0;     
            vampiro.setOro(oro);
            assertEquals(0,vampiro.getOro(),0.1);
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            fail("la cantidad de oro no puede ser negativa");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setRabia method, of class Vampiro.
     * test en el que se intenta meter un valor de rabia cualquiera pese a que este personaje no tiene rabia
     */
    @Test
    public void testSetRabia() {
        try{
            int rabia = 8;
            Vampiro vampiro = new Vampiro();
            vampiro.setRabia(rabia);
            fail("el personaje tiene rabia");
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"este personaje no tiene rabia");
            System.out.println("CP1 correcto");
        }
    }

    /**
     * Test of setVoluntad method, of class Vampiro.
     * test en el que se intenta meter un valor de voluntad pese a que este personaje no tiene voluntad
     */
    @Test
    public void testSetVoluntad() {
        try{
            int voluntad = 0;
            Vampiro vampiro = new Vampiro();
            vampiro.setVoluntad(voluntad);
            fail("el personaje tiene voluntad");
            System.out.println("CP1 incorrecto");
        }catch(RuntimeException e){
            assertEquals(e.getMessage(),"este personaje no tiene voluntad");
            System.out.println("CP1 correcto");
        }
    }
    
}