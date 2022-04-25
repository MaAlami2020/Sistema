/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.Scanner;

/**
 *
 * @author mimit
 */
public class FabricacionLicantropo extends Fabrica{
    @Override
    public Personaje crearPersonaje(){
        Licantropo licantropo = new Licantropo();
        licantropo.anadirNombre();
        licantropo.construirHabilidad();
        String opc = null;
        do{
          licantropo.anadirArma();
          System.out.println("¿desea anadir otra arma? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        do{
          licantropo.anadirArmadura();
          System.out.println("¿desea anadir otra armadura? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        licantropo.setRabia(0);
        licantropo.anadirOro();
        licantropo.anadirPoder();
        licantropo.anadirSalud();
        do{
          licantropo.construirFortaleza();
          System.out.println("¿desea anadir otra fortaleza? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        do{
          licantropo.construirDebilidad();
          System.out.println("¿desea anadir otra debilidad? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        licantropo.construirGhoul();
        licantropo.construirDemonio();
        licantropo.construirHumano();
        return licantropo;
    }
}
