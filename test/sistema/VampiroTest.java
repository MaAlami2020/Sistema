/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistema;

import java.util.List;
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
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor maximo de la reserva de puntos de sangre");
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
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor maximo de la reserva de puntos de sangre");
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
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor maximo de la reserva de puntos de sangre");
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
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor maximo de la reserva de puntos de sangre");
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
            assertEquals(21,vampiro.getReservaPuntosSangre());
            System.out.println("CP5 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"sobrepasa el valor maximo de la reserva de puntos de sangre");
            System.out.println("CP5 correcto");
        }
    }

    /**
     * Test of setArmasActivas method, of class Vampiro.
     */
    @Test
    public void testSetArmasActivas() {
        System.out.println("setArmasActivas");
        Arma[] armasActivas = null;
        Vampiro instance = new Vampiro();
        instance.setArmasActivas(armasActivas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArmaduraActiva method, of class Vampiro.
     */
    @Test
    public void testSetArmaduraActiva() {
        System.out.println("setArmaduraActiva");
        Armadura armaduraActiva = null;
        Vampiro instance = new Vampiro();
        instance.setArmaduraActiva(armaduraActiva);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaArmas method, of class Vampiro.
     */
    @Test
    public void testSetListaArmas() {
        System.out.println("setListaArmas");
        Arma arma = null;
        Vampiro instance = new Vampiro();
        instance.setListaArmas(arma);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaArmaduras method, of class Vampiro.
     */
    @Test
    public void testSetListaArmaduras() {
        System.out.println("setListaArmaduras");
        Armadura armadura = null;
        Vampiro instance = new Vampiro();
        instance.setListaArmaduras(armadura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHabilidad method, of class Vampiro.
     * test para probar que este personaje tiene como habilidad especial la disciplina
     */
    @Test

    public void testSetHabilidad() {
        try{
            Disciplina disciplina = new Disciplina("extirpacion",3,1,2);
            Vampiro vampiro = new Vampiro();
            vampiro.setHabilidad(disciplina);
            assertSame(disciplina,vampiro.getHabilidad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este personaje no tiene esa habilidad");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setHabilidad method, of class Vampiro.
     * test para probar que este personaje no tiene como habilidad especial el don 
     * porque esta habilidad no tiene un coste en puntos de sangre
     */
    @Test
    public void testSetHabilidad1() {
        try{
            Don don = new Don();
            Vampiro vampiro = new Vampiro();
            vampiro.setHabilidad(don);
            assertSame(don,vampiro.getHabilidad());
            System.out.println("CP2 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene un coste");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setHabilidad method, of class Vampiro.
     * test para probar que este personaje no tiene como habilidad especial el talento 
     * porque esta habilidad no tiene un coste en puntos de sangre
     */
    @Test
    public void testSetHabilidad2() {
        try{
            Talento talento = new Talento();
            Vampiro vampiro = new Vampiro();
            vampiro.setHabilidad(talento);
            assertSame(talento,vampiro.getHabilidad());
            System.out.println("CP3 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"esta habilidad no tiene un coste");
            System.out.println("CP3 correcto");
        }
    }
    
    /**
     * Test of setListaEsbirros method, of class Vampiro.
     */
    @Test
    public void testSetListaEsbirros() {
        System.out.println("setListaEsbirros");
        Esbirro esbirro = null;
        Vampiro instance = new Vampiro();
        instance.setListaEsbirros(esbirro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaFortalezas method, of class Vampiro.
     */
    @Test
    public void testSetListaFortalezas() {
        System.out.println("setListaFortalezas");
        Fortaleza fortaleza = null;
        Vampiro instance = new Vampiro();
        instance.setListaFortalezas(fortaleza);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaDebilidades method, of class Vampiro.
     */
    @Test
    public void testSetListaDebilidades() {
        System.out.println("setListaDebilidades");
        Debilidad debilidad = null;
        Vampiro instance = new Vampiro();
        instance.setListaDebilidades(debilidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
            assertEquals(32,vampiro.getOro());
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"la cantidad de oro no puede ser negativa");
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
            assertEquals(-1,vampiro.getOro());
            System.out.println("CP2 incorrecto");
        }catch(Exception ex){
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
            assertEquals(0,vampiro.getOro());
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"la cantidad de oro no puede ser negativa");
            System.out.println("CP3 correcto");
        }
    }

    /**
     * Test of setSalud method, of class Vampiro.
     * test para probar que la salud supera el maximo valor de salud permtido en 1 unidad
     */
    @Test
    public void testSetSalud() {
        try{ 
            int salud = 6;
            Vampiro vampiro = new Vampiro();
            vampiro.setSalud(salud);
            assertEquals(6,vampiro.getSalud());
            System.out.println("CP4 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP4 correcto");
        }
    }

    /**
     * Test of setSalud method, of class Vampiro.
     * test para probar que la salud no alcanza el minimo valor de salud permtido
     */
    @Test
    public void testSetSalud1() {
        try{ 
            int salud = -1;
            Vampiro vampiro = new Vampiro();
            vampiro.setSalud(salud);
            assertEquals(-1,vampiro.getSalud());
            System.out.println("CP5 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP5 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Vampiro.
     * test para probar que la salud es uno de los valores limite de salud permitidos 
     */
    @Test
    public void testSetSalu2() {
        try{ 
            int salud = 0;
            Vampiro vampiro = new Vampiro();
            vampiro.setSalud(salud);
            assertEquals(0,vampiro.getSalud());
            System.out.println("CP7 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP7 correcto");
        }
    }
    
    /**
     * Test of setSalud method, of class Vampiro.
     * test para probar que la salud esta dentro del rango de valores permitidos 
     * pero no es uno de los valores limite
     */
    @Test
    public void testSetSalud3() {
        try{ 
            int salud = 4;
            Vampiro vampiro = new Vampiro();
            vampiro.setSalud(salud);
            assertEquals(4,vampiro.getSalud());
            System.out.println("CP8 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de salud permitida");
            System.out.println("CP8 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Vampiro.
     * test para probar que el poder supera el maximo valor de poder permtido en 1 unidad
     */
    @Test
    public void testSetPoder() {
        try{ 
            int poder = 6;
            Vampiro vampiro = new Vampiro();
            vampiro.setPoder(poder);
            assertEquals(6,vampiro.getPoder());
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Vampiro.
     * test para probar que el poder esta a un valor de alcanzar el minimo valor de poder permtido
     */
    @Test
    public void testSetPoder1() {
        try{ 
            int poder = 0;
            Vampiro vampiro = new Vampiro();
            vampiro.setPoder(poder);
            assertEquals(0,vampiro.getPoder());
            System.out.println("CP2 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP2 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Vampiro.
     * test para probar que el poder sobrepasa en mas de 1 unidad el valor maximo de poder permitido
     */
    @Test
    public void testSetPoder2() {
        try{ 
            int poder = 9;
            Vampiro vampiro = new Vampiro();
            vampiro.setPoder(poder);
            assertEquals(9,vampiro.getPoder());
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP3 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Vampiro.
     * test para probar que el poder esta en el rango de valores permitidos sin contar los valores limite
     */
    @Test
    public void testSetPoder3() {
        try{ 
            int poder = 3;
            Vampiro vampiro = new Vampiro();
            vampiro.setPoder(poder);
            assertEquals(3,vampiro.getPoder());
            System.out.println("CP4 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP4 correcto");
        }
    }
    
    /**
     * Test of setPoder method, of class Vampiro.
     * test para probar que el poder es uno de los valores limite
     */
    @Test
    public void testSetPoder4() {
        try{ 
            int poder = 5;
            Vampiro vampiro = new Vampiro();
            vampiro.setPoder(poder);
            assertEquals(5,vampiro.getPoder());
            System.out.println("CP5 incorrecto");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"sobrepasó el límite de poder permitido");
            System.out.println("CP5 correcto");
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
            assertEquals(8,vampiro.getRabia());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
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
            assertEquals(0,vampiro.getVoluntad());
            System.out.println("CP1 incorrecto");
        }catch(Exception e){
            assertEquals(e.getMessage(),"este personaje no tiene voluntad");
            System.out.println("CP1 correcto");
        }
    }
    
}
