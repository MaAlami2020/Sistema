/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistema;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mimit
 */
public class UsuarioTest {
    
    public UsuarioTest() {
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
     * Test of setPassword method, of class Usuario.
     * test para probar que la longitud de la contrasenia es menor que la longitud minima
     */
    @Test
    public void testSetPassword() {
        MenuInicio menu = new MenuInicio();
        Usuario user = new Usuario(menu);
        try{
            String password = "micontr";
            user.setPassword(password);
            fail("longitud de la contrasenia esta en el rango[8-12]");
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"longitud de la contrasenia fuera del rango[8-12]");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setPassword method, of class Usuario.
     * test para probar que la longitud de la contrasenia es mayor que la longitud maxima
     */
    @Test
    public void testSetPassword1() {
        MenuInicio menu = new MenuInicio();
        Usuario user1 = new Usuario(menu);
        try{
            String password = "micontrasenia";
            user1.setPassword(password);
            fail("longitud de la contrasenia esta en el rango[8-12]");
            System.out.println("CP2 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"longitud de la contrasenia fuera del rango[8-12]");
            System.out.println("CP2 correcto");
        }
    }

    /**
     * test para probar que la longitud de la contrasenia esta dentro del rango de  la longitud requerida
     */
    @Test
    public void testSetPassword2() {
        MenuInicio menu = new MenuInicio();
        Usuario user2 = new Usuario(menu);
        try{
            String password = "mypassword";
            user2.setPassword(password);
            assertEquals(password,user2.getPassword());
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            fail("longitud de la contrasenia fuera del rango[8-12]");
            System.out.println("CP3 correcto");
        }
    }
    
    /**
     * Test of setOroApostado method, of class Usuario.
     * test para probar que el oro apostado supera la cantidad de oro que tiene el personaje
     */
    @Test
    public void testSetOroApostado(){
        MenuInicio menu = new MenuInicio();
        Usuario user = new Usuario(menu);
        Vampiro vampiro = new Vampiro();
        user.setTipoPersonaje(vampiro);
        user.getTipoPersonaje().setOro(50);
        try{
            user.setOroApostado(73);
            fail("cantidad apostada no valida");
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"cantidad apostada no valida");
            System.out.println("CP1 correcto");
        }
    }
    
    /**
     * Test of setOroApostado method, of class Usuario.
     * test para probar que el oro apostado es inferior a la cantidad de oro que tiene el personaje,
     * y menor que 0
     */
    @Test
    public void testSetOroApostado1() {
        MenuInicio menu = new MenuInicio();
        Usuario user1 = new Usuario(menu);
        Licantropo licantropo = new Licantropo();
        user1.setTipoPersonaje(licantropo);
        user1.getTipoPersonaje().setOro(4);
        try{
            user1.setOroApostado(-20);
            assertEquals(-20,user1.getOroApostado());
            System.out.println("CP2 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"cantidad apostada no valida");
            System.out.println("CP2 correcto");
        }
    }
    
     /**
     * Test of setOroApostado method, of class Usuario.
     * test para probar que el oro apostado es mayor que 0 y menor que la cantidad de oro que tiene el 
     * personaje, sin incluir ambos valoores
     */
    @Test

    public void testSetOroApostado2() {
        MenuInicio menu = new MenuInicio();
        Usuario user2 = new Usuario(menu);
        Cazador cazador = new Cazador();
        user2.setTipoPersonaje(cazador);
        user2.getTipoPersonaje().setOro(39);
        try{
            user2.setOroApostado(15);
            assertEquals(15,user2.getOroApostado());
            System.out.println("CP3 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"cantidad apostada no valida");
            System.out.println("CP3 correcto");
        }
    }
    
     /**
     * Test of setOroApoostado method, of class Usuario.
     * test para probar que el oro apostado es exactamente 0 o la cantidad de oro que tiene el 
     * personaje
     */
    @Test
    public void testSetOroApostado3() {
        MenuInicio menu = new MenuInicio();
        Usuario user3 = new Usuario(menu);
        Cazador cazador = new Cazador();
        user3.setTipoPersonaje(cazador);
        user3.getTipoPersonaje().setOro(56);
        try{
            user3.setOroApostado(0);
            assertEquals(0,user3.getOroApostado());
            System.out.println("CP4 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),"cantidad apostada no valida");
            System.out.println("CP4 correcto");
        }
    }
    
    /**
     * Test of buscarUsuarioDesafiar method, of class Usuario.
     * test para probar que el usuario que se busca esta registrado en el sistema
     */
    @Test
    public void testBuscarUsuarioDesafiar() {
        MenuInicio menu = new MenuInicio();
        Usuario user = new Usuario(menu);
        List <Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("wolfgang","wolf","0000384567"));
        usuarios.add(new Usuario("esteban","teseo","123443928"));
        String nickBuscar = "teseo";
        try{
            Usuario usuario = user.buscarUsuarioDesafiar(usuarios,nickBuscar);
            assertEquals("teseo",usuario.getNick());
            System.out.println("CP1 incorrecto");
        }catch(Exception ex){
            Exception e;
            e = ex;
            assertEquals(e.getMessage(),null);
            System.out.println("CP1 correcto");
        }
    } 
    
    /**
     * Test of buscarUsuarioDesafiar method, of class Usuario.
     * test para probar que el usuario que se busca no esta registrado en el sistema.
     * El test retorna un objeto nulo
     */
    @Test
    public void testBuscarUsuarioDesafiar1() {
        MenuInicio menu = new MenuInicio();
        Usuario user = new Usuario(menu);
        List <Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("wolfgang","wolf","0000384567"));
        usuarios.add(new Usuario("esteban","teseo","123443928"));
        String nickBuscar = "luke";
        Usuario usuario = user.buscarUsuarioDesafiar(usuarios,nickBuscar);
        assertNull(usuario);
    } 
    
    /**
     * Test of usuarioBaneado method, of class Usuario.
     * test para probar que el usuario esta baneado
     */
    @Test
    public void testUsuarioBaneado() {
        MenuInicio menu = new MenuInicio();
        Usuario user = new Usuario(menu);
        List <Usuario> usuariosBaneados = new ArrayList<>();
        usuariosBaneados.add(new Usuario("wolfgang","wolf","0000384567"));
        usuariosBaneados.add(new Usuario("esteban","teseo","123443928"));
        usuariosBaneados.add(new Usuario("jean-pierce","jj","0202010394"));
        
        Usuario usuarioBuscar = new Usuario("jean-pierce","jj","0202010394");
        boolean respuesta = user.usuarioBaneado(usuariosBaneados,usuarioBuscar);
        assertEquals(true,respuesta);
    } 
    
    /**
     * Test of buscarUsuarioDesafiar method, of class Usuario.
     * test para probar que el usuario que se busca en la lista de usuarios baneados no esta baneado
     */
    @Test
    public void testUsuarioBaneado1() {
        MenuInicio menu = new MenuInicio();
        Usuario user = new Usuario(menu);
        List <Usuario> usuariosBaneados = new ArrayList<>();
        usuariosBaneados.add(new Usuario("wolfgang","wolf","0000384567"));
        usuariosBaneados.add(new Usuario("esteban","teseo","123443928"));
        
        Usuario usuarioBuscar = new Usuario("george lucas","georgie","020201456");
        boolean encontrado = user.usuarioBaneado(usuariosBaneados,usuarioBuscar);
        assertFalse(encontrado);
    } 
}
