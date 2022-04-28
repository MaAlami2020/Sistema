/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mimit
 */
public class Licantropo extends Personaje{
    private String nombre;
    private List<Arma> armasActivas = new ArrayList<>();
    private List<Armadura> armaduraActiva = new ArrayList<>();    
    private List<Arma> listaArmas = new ArrayList<>();
    private List<Armadura>listaArmaduras = new ArrayList<>(); 
    private List<Fortaleza> listaFortalezas = new ArrayList<>();
    private List<Debilidad> listaDebilidades = new ArrayList<>();
    private int oro;
    private int salud;
    private int poder;
    private int rabia;
    
    public Licantropo(){
    }

    public int getRabia() {
        return rabia;
    }

    public void setRabia(int rabia) {
        this.rabia = rabia;
    }
    
    @Override
    public void anadirNombre(){
       System.out.println("Introduzca el nombre del licantropo: ");
       Scanner sc = new Scanner(System.in);
       String nombrePer = sc.next();
       this.nombre = nombrePer;
    }
    
    @Override
    public Habilidad construirHabilidad() {
        Don don = new Don();
        System.out.println("Introduzca el nombre de la habilidad: ");
        Scanner sc = new Scanner(System.in);
        String nombreHab = sc.next();
        don.setNombre(nombreHab);
        int ataque = 0;
        int defensa = 0;
        System.out.println("Introduzca el valor de rabia minimo: ");
        sc = new Scanner(System.in);
        String valor = sc.next();
        int rabiaMin = Integer.parseInt(valor);  
        don.setRabiaMin(rabiaMin);
        while((ataque < 1)|(ataque > 3)){
           System.out.println("Introduzca el valor de ataque -1,2 o 3-: ");
           sc = new Scanner(System.in);
           valor = sc.next();
           ataque = Integer.parseInt(valor);
        }  
        don.setValorAtaque(ataque);
        while((defensa < 1)|(defensa > 3)){
           System.out.println("Introduzca el valor de defensa -1,2 o 3-: ");
           sc = new Scanner(System.in);
           valor = sc.next();
           defensa = Integer.parseInt(valor);
        }  
        don.setValorDefensa(defensa);
        return don;
    
    }
    
    @Override
    public void anadirArma(){
        Arma arma = new Arma();
        System.out.println("introduzca el nombre del arma del vampiro: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.next();
        arma.setNombre(nombre);
        int modifAtaque = 0;
        do{
           System.out.println("introduzca el valor del modificador al ataque del arma -1,2 o 3-: ");
           sc = new Scanner(System.in);
           String modifAtq = sc.next();
           modifAtaque = Integer.parseInt(modifAtq);
        }while((modifAtaque < 1)|(modifAtaque > 3));  
        arma.setModificadorAtaque(modifAtaque);
        
        System.out.println("¿Quiere introducir un modificador a la defensa -si o no-?");
        sc = new Scanner(System.in);
        String opcModDef = sc.next();
        if(opcModDef == "si"){
           int modifDefensa = 0;
           while((modifDefensa < 1)|(modifDefensa > 3)){
              System.out.println("introduzca el valor del modificador a la defensa del arma -1,2 o 3-: ");
              sc = new Scanner(System.in);
              String modifDef = sc.next();
              modifDefensa = Integer.parseInt(modifDef);
           }   
           arma.setModificadorDefensa(modifDefensa);
        }
        int opcion = 0;
        while((opcion != 1)&(opcion != 2)){
              System.out.println("1.- 1 mano: ");
              System.out.println("2.- 2 manos: ");
              System.out.println("Escoga el manejo del arma -1 o 2-: ");
              sc = new Scanner(System.in);
              String opcManejo = sc.next();
              opcion = Integer.parseInt(opcManejo);
              if(opcion == 1)
                  arma.setManejo("1 mano");
              else if(opcion == 2)
                  arma.setManejo("2 manos");
        }
        listaArmas.add(arma);
    }

    @Override
    public int anadirOro() {
        do{
            System.out.println("introduzca la cantidad de oro del vampiro no negativa: ");
            Scanner sc = new Scanner(System.in);
            String cantidadOro = sc.next();
            oro = Integer.parseInt(cantidadOro);
        }while(oro < 0);
        return oro;
    }

    @Override
    public int anadirSalud() {
        do{
            System.out.println("introduzca la salud del vampiro entre 0 y 5: ");
            Scanner sc = new Scanner(System.in);
            String cantidadSalud = sc.next();
            salud = Integer.parseInt(cantidadSalud);
        }while((salud < 0)|(salud > 5));
        return salud;
    }

    @Override
    public int anadirPoder() {
        do{
            System.out.println("introduzca el poder del vampiro entre 1 y 5: ");
            Scanner sc = new Scanner(System.in);
            String cantidadPoder = sc.next();
            poder = Integer.parseInt(cantidadPoder);
        }while((poder < 1)|(poder > 5));
        return poder;
    }

    @Override
    public List<Arma> getListaArmas() {
        return listaArmas;
    }

    @Override
    public List<Arma> getArmasActivas() {
        return armasActivas;
    }

    @Override
    public void construirFortaleza() {
        String opcion = null;
        do{
          Fortaleza fortaleza = new Fortaleza();  
          System.out.println("introduzca el nombre de la fortaleza: ");
          Scanner sc = new Scanner(System.in);
          String nombreMod = sc.next();
          fortaleza.setNombre(nombreMod);
          int sensibMod = 0;
          do{
             System.out.println("introduzca la sensibilidad: ");
             sc = new Scanner(System.in);
             String sensibilidadMod = sc.next();
             sensibMod = Integer.parseInt(sensibilidadMod);
          }while((sensibMod<1)|(sensibMod>5));
          fortaleza.setSensibilidad(sensibMod);
          listaFortalezas.add(fortaleza);
          System.out.println("¿quiere añadir otra fortaleza? -si o no-");
          sc = new Scanner(System.in);
          opcion = sc.next();
        }while(opcion=="si");
    }

    @Override
    public void construirDebilidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fortaleza> getListaFortalezas() {
        return listaFortalezas;
    }

    @Override
    public List<Debilidad> getListaDebilidades() {
        return listaDebilidades;
    }

    @Override
    public Ghoul construirGhoul(){
        Ghoul ghoul = new Ghoul();
        ghoul.anadirNombre();
        ghoul.anadirSalud();
        ghoul.anadirDependencia();
        return ghoul;
    }
    
    @Override
    public Demonio construirDemonio(){
        Demonio demonio = new Demonio();
        demonio.anadirNombre();
        demonio.anadirSalud();
        demonio.anadirPacto();
        return demonio;
    }

    @Override
    public Humano construirHumano() {
       Humano humano = new Humano(); 
       humano.anadirNombre();
       humano.anadirSalud();
       humano.anadirLealtad();
       return humano;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override

    public int getOro() {
        return oro;
    }

    @Override
    public int getSalud() {
        return salud;
    }

    @Override
    public int getPoder() {
        return poder;
    }

    @Override
    public int getEdad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void anadirEdad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void anadirArmadura() {
        Armadura armadura = new Armadura();
        System.out.println("introduzca el nombre del armadura del vampiro: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.next();
        armadura.setNombre(nombre);
        int modifDefensa = 0;
        do{
           System.out.println("introduzca el valor del modificador a la defensa del armadura -1,2 o 3-: ");
           sc = new Scanner(System.in);
           String modificadorDefensa = sc.next();
           modifDefensa = Integer.parseInt(modificadorDefensa);
        }while((modifDefensa < 1)|(modifDefensa > 3));  
        armadura.setModificadorDefensa(modifDefensa);
        
        System.out.println("¿Quiere introducir un modificador al ataque -si o no-?");
        sc = new Scanner(System.in);
        String opcModDef = sc.next();
        if(opcModDef == "si"){
           int modifAtaque = 0;
           while((modifAtaque < 1)|(modifAtaque > 3)){
              System.out.println("introduzca el valor del modificador al ataque del armadura -1,2 o 3-: ");
              sc = new Scanner(System.in);
              String modifAtaq = sc.next();
              modifAtaque = Integer.parseInt(modifAtaq);
           }   
           armadura.setModificadorAtaque(modifAtaque);
        }
        listaArmaduras.add(armadura);
    }

    @Override
    public List<Armadura> getListaArmaduras() {
       return listaArmaduras;
    }

    @Override
    public List<Armadura> getArmadurasActivas() {
        return armaduraActiva;
    }

    @Override
    public void anadirSangreAcum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
