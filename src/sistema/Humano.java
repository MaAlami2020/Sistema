/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.Scanner;
import static sistema.Lealtad.ALTA;
import static sistema.Lealtad.BAJA;
import static sistema.Lealtad.NORMAL;

/**
 *
 * @author mimit
 */
public class Humano implements Esbirro{
    private String nombre;
    private int salud;
    private Lealtad lealtad;
    
    @Override
    public void anadirNombre(){
       System.out.println("Introduzca el nombre del ghoul: ");
       Scanner sc = new Scanner(System.in);
       String nombre = sc.next();
       this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    @Override
    public void anadirSalud() {
        int valorSalud = 0;
        do{
           System.out.println("Introduzca el valor de salud del ghoul: ");
           Scanner sc = new Scanner(System.in);
           String salud = sc.next();
           valorSalud = Integer.parseInt(salud);
        }while((valorSalud < 1)|(valorSalud > 3));
       this.salud = valorSalud; 
    }
    
    public void anadirLealtad(){
        
       System.out.println("1.-ALTA");
       System.out.println("2.-NORMAL");
       System.out.println("3.-BAJA");
       System.out.println("seleccione al valor de lealtad -1,2 o 3-: ");
       Scanner sc = new Scanner(System.in);
       String valor = sc.next();
       int valorLealtad = Integer.parseInt(valor);
       if(valorLealtad == 1)
           lealtad = lealtad.ALTA;
       else if(valorLealtad == 2)
           lealtad = lealtad.NORMAL;
       else if(valorLealtad == 3)
           lealtad = lealtad.BAJA;
    }
     
}
