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
     * Test of getNombre method, of class Usuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreUsuario method, of class Usuario.
     */
    @Test
    public void testSetNombreUsuario() {
        System.out.println("setNombreUsuario");
        String nombreInicio = "";
        Usuario instance = new Usuario();
        instance.setNombreUsuario(nombreInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNick method, of class Usuario.
     */
    @Test
    public void testGetNick() {
        System.out.println("getNick");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getNick();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNick method, of class Usuario.
     */
    @Test
    public void testSetNick() {
        System.out.println("setNick");
        String nickInicio = "";
        Usuario instance = new Usuario();
        instance.setNick(nickInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistro method, of class Usuario.
     */
    @Test
    public void testGetRegistro() {
        System.out.println("getRegistro");
        Usuario instance = new Usuario();
        StringBuilder expResult = null;
        StringBuilder result = instance.getRegistro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistro method, of class Usuario.
     */
    @Test
    public void testSetRegistro() {
        System.out.println("setRegistro");
        StringBuilder registro = null;
        Usuario instance = new Usuario();
        instance.setRegistro(registro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoPersonaje method, of class Usuario.
     */
    @Test
    public void testSetTipoPersonaje() {
        System.out.println("setTipoPersonaje");
        Personaje tipoPersonaje = null;
        Usuario instance = new Usuario();
        instance.setTipoPersonaje(tipoPersonaje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRegistro method, of class Usuario.
     */
    @Test
    public void testUpdateRegistro() {
        System.out.println("updateRegistro");
        Usuario instance = new Usuario();
        StringBuilder expResult = null;
        StringBuilder result = instance.updateRegistro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrar_darBaja method, of class Usuario.
     */
    @Test
    public void testRegistrar_darBaja() {
        System.out.println("registrar_darBaja");
        Usuario instance = new Usuario();
        instance.registrar_darBaja();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirNuevoUsuario method, of class Usuario.
     */
    @Test
    public void testAnadirNuevoUsuario() {
        System.out.println("anadirNuevoUsuario");
        String name = "";
        String apodo = "";
        String contrasenia = "";
        StringBuilder reg = null;
        Personaje tipoPersonaje = null;
        Usuario instance = new Usuario();
        instance.anadirNuevoUsuario(name, apodo, contrasenia, reg, tipoPersonaje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarOpcionMenu method, of class Usuario.
     */
    @Test
    public void testSeleccionarOpcionMenu() {
        System.out.println("seleccionarOpcionMenu");
        Usuario instance = new Usuario();
        instance.seleccionarOpcionMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of darBaja_Personaje method, of class Usuario.
     */
    @Test
    public void testDarBaja_Personaje() {
        System.out.println("darBaja_Personaje");
        Usuario instance = new Usuario();
        instance.darBaja_Personaje();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirEsbirro method, of class Usuario.
     */
    @Test
    public void testAnadirEsbirro() {
        System.out.println("anadirEsbirro");
        Usuario instance = new Usuario();
        Esbirro expResult = null;
        Esbirro result = instance.anadirEsbirro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirNombre method, of class Usuario.
     */
    @Test
    public void testAnadirNombre() {
        System.out.println("anadirNombre");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.anadirNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombrePersonaje method, of class Usuario.
     */
    @Test
    public void testSetNombrePersonaje() {
        System.out.println("setNombrePersonaje");
        String nombre = "";
        Usuario instance = new Usuario();
        instance.setNombrePersonaje(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirOro method, of class Usuario.
     */
    @Test
    public void testAnadirOro() {
        System.out.println("anadirOro");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirOro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOroPersonaje method, of class Usuario.
     */
    @Test
    public void testSetOroPersonaje() {
        System.out.println("setOroPersonaje");
        double oro = 0.0;
        Usuario instance = new Usuario();
        instance.setOroPersonaje(oro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirSalud method, of class Usuario.
     */
    @Test
    public void testAnadirSalud() {
        System.out.println("anadirSalud");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirSalud();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaludPersonaje method, of class Usuario.
     */
    @Test
    public void testSetSaludPersonaje() {
        System.out.println("setSaludPersonaje");
        int salud = 0;
        Usuario instance = new Usuario();
        instance.setSaludPersonaje(salud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirPoder method, of class Usuario.
     */
    @Test
    public void testAnadirPoder() {
        System.out.println("anadirPoder");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirPoder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPoderPersonaje method, of class Usuario.
     */
    @Test
    public void testSetPoderPersonaje() {
        System.out.println("setPoderPersonaje");
        int salud = 0;
        Usuario instance = new Usuario();
        instance.setPoderPersonaje(salud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirArmadura method, of class Usuario.
     */
    @Test
    public void testAnadirArmadura() {
        System.out.println("anadirArmadura");
        Usuario instance = new Usuario();
        Armadura expResult = null;
        Armadura result = instance.anadirArmadura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNuevaArmaduraPersonaje method, of class Usuario.
     */
    @Test
    public void testSetNuevaArmaduraPersonaje() {
        System.out.println("setNuevaArmaduraPersonaje");
        Armadura armaduraPer = null;
        Usuario instance = new Usuario();
        instance.setNuevaArmaduraPersonaje(armaduraPer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirArma method, of class Usuario.
     */
    @Test
    public void testAnadirArma() {
        System.out.println("anadirArma");
        Usuario instance = new Usuario();
        Arma expResult = null;
        Arma result = instance.anadirArma();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNuevaArmaPersonaje method, of class Usuario.
     */
    @Test
    public void testSetNuevaArmaPersonaje() {
        System.out.println("setNuevaArmaPersonaje");
        Arma armaPer = null;
        Usuario instance = new Usuario();
        instance.setNuevaArmaPersonaje(armaPer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirNombreEsbirro method, of class Usuario.
     */
    @Test
    public void testAnadirNombreEsbirro() {
        System.out.println("anadirNombreEsbirro");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.anadirNombreEsbirro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirPactoEsbirro method, of class Usuario.
     */
    @Test
    public void testAnadirPactoEsbirro() {
        System.out.println("anadirPactoEsbirro");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.anadirPactoEsbirro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirSaludEsbirro method, of class Usuario.
     */
    @Test
    public void testAnadirSaludEsbirro() {
        System.out.println("anadirSaludEsbirro");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirSaludEsbirro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirDependenciaEsbirro method, of class Usuario.
     */
    @Test
    public void testAnadirDependenciaEsbirro() {
        System.out.println("anadirDependenciaEsbirro");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirDependenciaEsbirro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirLealtadEsbirro method, of class Usuario.
     */
    @Test
    public void testAnadirLealtadEsbirro() {
        System.out.println("anadirLealtadEsbirro");
        Usuario instance = new Usuario();
        Lealtad expResult = null;
        Lealtad result = instance.anadirLealtadEsbirro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarListaEsbirros method, of class Usuario.
     */
    @Test
    public void testActualizarListaEsbirros() {
        System.out.println("actualizarListaEsbirros");
        Usuario instance = new Usuario();
        List<Esbirro> expResult = null;
        List<Esbirro> result = instance.actualizarListaEsbirros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEsbirrosPersonaje method, of class Usuario.
     */
    @Test
    public void testSetEsbirrosPersonaje() {
        System.out.println("setEsbirrosPersonaje");
        List<Esbirro> esbirrosPer = null;
        Usuario instance = new Usuario();
        instance.setEsbirrosPersonaje(esbirrosPer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirCosteSangre method, of class Usuario.
     */
    @Test
    public void testAnadirCosteSangre() {
        System.out.println("anadirCosteSangre");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirCosteSangre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirRabiaMin method, of class Usuario.
     */
    @Test
    public void testAnadirRabiaMin() {
        System.out.println("anadirRabiaMin");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirRabiaMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirEdadAdquisicion method, of class Usuario.
     */
    @Test
    public void testAnadirEdadAdquisicion() {
        System.out.println("anadirEdadAdquisicion");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirEdadAdquisicion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of construirHabilidad method, of class Usuario.
     */
    @Test
    public void testConstruirHabilidad() {
        System.out.println("construirHabilidad");
        Usuario instance = new Usuario();
        Habilidad expResult = null;
        Habilidad result = instance.construirHabilidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHabilidadPersonaje method, of class Usuario.
     */
    @Test
    public void testSetHabilidadPersonaje() {
        System.out.println("setHabilidadPersonaje");
        Habilidad habilidad = null;
        Usuario instance = new Usuario();
        instance.setHabilidadPersonaje(habilidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirEdad method, of class Usuario.
     */
    @Test
    public void testAnadirEdad() {
        System.out.println("anadirEdad");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirEdad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEdadPersonaje method, of class Usuario.
     */
    @Test
    public void testSetEdadPersonaje() {
        System.out.println("setEdadPersonaje");
        int edadPer = 0;
        Usuario instance = new Usuario();
        instance.setEdadPersonaje(edadPer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirSangreAcum method, of class Usuario.
     */
    @Test
    public void testAnadirSangreAcum() {
        System.out.println("anadirSangreAcum");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.anadirSangreAcum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSangreAcumPersonaje method, of class Usuario.
     */
    @Test
    public void testSetSangreAcumPersonaje() {
        System.out.println("setSangreAcumPersonaje");
        int sagreAcumPer = 0;
        Usuario instance = new Usuario();
        instance.setSangreAcumPersonaje(sagreAcumPer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of construirFortaleza method, of class Usuario.
     */
    @Test
    public void testConstruirFortaleza() {
        System.out.println("construirFortaleza");
        Usuario instance = new Usuario();
        Fortaleza expResult = null;
        Fortaleza result = instance.construirFortaleza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarListaFortalezas method, of class Usuario.
     */
    @Test
    public void testActualizarListaFortalezas() {
        System.out.println("actualizarListaFortalezas");
        Usuario instance = new Usuario();
        List<Fortaleza> expResult = null;
        List<Fortaleza> result = instance.actualizarListaFortalezas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFortalezasPersonaje method, of class Usuario.
     */
    @Test
    public void testSetFortalezasPersonaje() {
        System.out.println("setFortalezasPersonaje");
        List<Fortaleza> fortalezasPer = null;
        Usuario instance = new Usuario();
        instance.setFortalezasPersonaje(fortalezasPer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of construirDebilidad method, of class Usuario.
     */
    @Test
    public void testConstruirDebilidad() {
        System.out.println("construirDebilidad");
        Usuario instance = new Usuario();
        Debilidad expResult = null;
        Debilidad result = instance.construirDebilidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarListaDebilidades method, of class Usuario.
     */
    @Test
    public void testActualizarListaDebilidades() {
        System.out.println("actualizarListaDebilidades");
        Usuario instance = new Usuario();
        List<Debilidad> expResult = null;
        List<Debilidad> result = instance.actualizarListaDebilidades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebilidadesPersonaje method, of class Usuario.
     */
    @Test
    public void testSetDebilidadesPersonaje() {
        System.out.println("setDebilidadesPersonaje");
        List<Debilidad> debilidadesPer = null;
        Usuario instance = new Usuario();
        instance.setDebilidadesPersonaje(debilidadesPer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atributosComunesPersonaje method, of class Usuario.
     */
    @Test
    public void testAtributosComunesPersonaje() {
        System.out.println("atributosComunesPersonaje");
        Usuario instance = new Usuario();
        instance.atributosComunesPersonaje();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrar_vampiro method, of class Usuario.
     */
    @Test
    public void testRegistrar_vampiro() {
        System.out.println("registrar_vampiro");
        Usuario instance = new Usuario();
        instance.registrar_vampiro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrar_licantropo method, of class Usuario.
     */
    @Test
    public void testRegistrar_licantropo() {
        System.out.println("registrar_licantropo");
        Usuario instance = new Usuario();
        instance.registrar_licantropo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrar_cazador method, of class Usuario.
     */
    @Test
    public void testRegistrar_cazador() {
        System.out.println("registrar_cazador");
        Usuario instance = new Usuario();
        instance.registrar_cazador();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of apostarOro method, of class Usuario.
     */
    @Test
    public void testApostarOro() {
        System.out.println("apostarOro");
        Usuario instance = new Usuario();
        instance.apostarOro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOroApostado method, of class Usuario.
     */
    @Test
    public void testGetOroApostado() {
        System.out.println("getOroApostado");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.getOroApostado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of desafiarUsuario method, of class Usuario.
     */
    @Test
    public void testDesafiarUsuario() {
        System.out.println("desafiarUsuario");
        Usuario instance = new Usuario();
        instance.desafiarUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarArmadura_activa method, of class Usuario.
     */
    @Test
    public void testCambiarArmadura_activa() {
        System.out.println("cambiarArmadura_activa");
        Usuario instance = new Usuario();
        Armadura expResult = null;
        Armadura result = instance.cambiarArmadura_activa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarArmas_activas method, of class Usuario.
     */
    @Test
    public void testCambiarArmas_activas() {
        System.out.println("cambiarArmas_activas");
        Usuario instance = new Usuario();
        List<Arma> expResult = null;
        List<Arma> result = instance.cambiarArmas_activas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elegirArmadura_activa method, of class Usuario.
     */
    @Test
    public void testElegirArmadura_activa() {
        System.out.println("elegirArmadura_activa");
        Usuario instance = new Usuario();
        Armadura expResult = null;
        Armadura result = instance.elegirArmadura_activa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArmaduraActivaPersonaje method, of class Usuario.
     */
    @Test
    public void testSetArmaduraActivaPersonaje() {
        System.out.println("setArmaduraActivaPersonaje");
        Armadura armaduraActiva = null;
        Usuario instance = new Usuario();
        instance.setArmaduraActivaPersonaje(armaduraActiva);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elegirArmas_activas method, of class Usuario.
     */
    @Test
    public void testElegirArmas_activas() {
        System.out.println("elegirArmas_activas");
        Usuario instance = new Usuario();
        List<Arma> expResult = null;
        List<Arma> result = instance.elegirArmas_activas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArmasActivasPersonaje method, of class Usuario.
     */
    @Test
    public void testSetArmasActivasPersonaje() {
        System.out.println("setArmasActivasPersonaje");
        List<Arma> armasActivas = null;
        Usuario instance = new Usuario();
        instance.setArmasActivasPersonaje(armasActivas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarOro method, of class Usuario.
     */
    @Test
    public void testConsultarOro() {
        System.out.println("consultarOro");
        Usuario instance = new Usuario();
        instance.consultarOro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarRanking method, of class Usuario.
     */
    @Test
    public void testConsultarRanking() {
        System.out.println("consultarRanking");
        Usuario instance = new Usuario();
        instance.consultarRanking();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aceptar_rechazarDesafio method, of class Usuario.
     */
    @Test
    public void testAceptar_rechazarDesafio() {
        System.out.println("aceptar_rechazarDesafio");
        Usuario instance = new Usuario();
        instance.aceptar_rechazarDesafio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of entrar_salirSistema method, of class Usuario.
     */
    @Test
    public void testEntrar_salirSistema() {
        System.out.println("entrar_salirSistema");
        Usuario instance = new Usuario();
        instance.entrar_salirSistema();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Usuario.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    /**
     * Test of setPassword method, of class Usuario.
     * test para probar que la longitud de la contrasenia es menor que la longitud minima
     */
    @Test
    public void testSetPassword() {
        Usuario user = new Usuario();
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
        Usuario user1 = new Usuario();
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
     * Test of setPassword method, of class Usuario.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Usuario instance = new Usuario();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoPersonaje method, of class Usuario.
     */
    @Test
    public void testGetTipoPersonaje() {
        System.out.println("getTipoPersonaje");
        Usuario instance = new Usuario();
        Personaje expResult = null;
        Personaje result = instance.getTipoPersonaje();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarioDesafiar method, of class Usuario.
     */
    @Test
    public void testGetUsuarioDesafiar() {
        System.out.println("getUsuarioDesafiar");
        Usuario instance = new Usuario();
        Usuario expResult = null;
        Usuario result = instance.getUsuarioDesafiar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotifDesafio method, of class Usuario.
     */
    @Test
    public void testGetNotifDesafio() {
        System.out.println("getNotifDesafio");
        Usuario instance = new Usuario();
        List<String> expResult = null;
        List<String> result = instance.getNotifDesafio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * test para probar que la longitud de la contrasenia esta dentro del rango de  la longitud requerida
     */
    @Test
    public void testSetPassword2() {
        Usuario user2 = new Usuario();
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
     * test para probar que el oro apostado supera la cantidad de oro quee tiene el personaje
     */
    @Test
    public void testSetOroApostado(){
        Usuario user = new Usuario();
        Vampiro vampiro = new Vampiro();
        user.setTipoPersonaje(vampiro);
        user.getTipoPersonaje().setOro(50);
        try{
            user.setOroApostado(73);
            assertEquals(73,user.getOroApostado());
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
        Usuario user1 = new Usuario();
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
        Usuario user2 = new Usuario();
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
        Usuario user3 = new Usuario();
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
        Usuario user = new Usuario();
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
        Usuario user = new Usuario();
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
        Usuario user = new Usuario();
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
        Usuario user = new Usuario();
        List <Usuario> usuariosBaneados = new ArrayList<>();
        usuariosBaneados.add(new Usuario("wolfgang","wolf","0000384567"));
        usuariosBaneados.add(new Usuario("esteban","teseo","123443928"));
        
        Usuario usuarioBuscar = new Usuario("george lucas","georgie","020201456");
        boolean encontrado = user.usuarioBaneado(usuariosBaneados,usuarioBuscar);
        assertFalse(encontrado);
    } 
}
