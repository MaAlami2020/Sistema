/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mimit
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Usuario user = new Usuario();
        Operador operator = new Operador();
      int seleccion = 0;  
      do{  
        int opcion1 = 0;
        do{
           System.out.println("1.-operador");
           System.out.println("2.-usuario");
           System.out.println("3.-salir de la app");
           System.out.println("escoga una opcion -1, 2 o 3-: ");
           Scanner sc1 = new Scanner(System.in);
           String opcion = sc1.next();
           opcion1 = Integer.valueOf(opcion);
        } while((opcion1 != 1)&(opcion1 != 2)&(opcion1 != 3));
        int opcion2 = 0;
       if(opcion1 != 3){
        System.out.println("1.-registrarse/darse de baja");
        System.out.println("2.-entrar/salir del sistema");
        System.out.println("escoga una opcion: ");
        Scanner sc2 = new Scanner(System.in); 
        String  opcion = sc2.next();
        opcion2 = Integer.parseInt(opcion);
        if((opcion1 == 1)&(opcion2 == 1)){
             operator.registrar_darBaja();
        }else if((opcion1 == 1)&(opcion2 == 2)){
             operator.entrar_salirSistema();
        }else if((opcion1 == 2)&(opcion2 == 1)){
            user.registrar_darBaja();
        }else if((opcion1 == 2)&(opcion2 == 2)){
            user.entrar_salirSistema();
        }
       }else{
           seleccion = opcion1;
       }
      }while(seleccion != 3);
    }
   
    
}
