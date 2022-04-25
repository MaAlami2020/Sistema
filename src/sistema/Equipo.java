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
public class Equipo {
    private List<Arma> listaArmas = new ArrayList<>();
    private Armadura armadura = new Armadura(); 

    public List<Arma> getListaArmas() {
        return listaArmas;
    }
    
    public void anadirArma(){
        Arma arma = new Arma();
        System.out.println("introduzca el nombre del arma: ");
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
           //armmadura.setModificadorDefensa(modifDefensa);
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

    public Equipo() {
    }
}
