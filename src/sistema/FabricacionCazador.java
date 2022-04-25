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
public class FabricacionCazador extends Fabrica{
    @Override
    public Personaje crearPersonaje(){
        Cazador cazador = new Cazador();
        cazador.anadirNombre();
        cazador.construirHabilidad();
        String opc = null;
        do{
          cazador.anadirArma();
          System.out.println("¿desea anadir otra arma? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        do{
          cazador.anadirArmadura();
          System.out.println("¿desea anadir otra armadura? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        cazador.setVoluntad(3);
        cazador.anadirOro();
        cazador.anadirPoder();
        cazador.anadirSalud();
        do{
          cazador.construirFortaleza();
          System.out.println("¿desea anadir otra fortaleza? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        do{
          cazador.construirDebilidad();
          System.out.println("¿desea anadir otra debilidad? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        cazador.construirGhoul();
        cazador.construirDemonio();
        cazador.construirHumano();
        return cazador;
    }
}
