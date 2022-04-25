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
public class Ghoul implements Esbirro{
    private String nombre;
    private int salud;
    private int dependencia;
    
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
    
    public void anadirDependencia(){
        int dep = 0;
        do{
           System.out.println("Introduzca el valor de dependencia con el amo (de 1 a 5): ");
           Scanner sc = new Scanner(System.in);
           String valorDep = sc.next();
           dep = Integer.parseInt(valorDep);
        }while((dep < 1)|(dep > 5));
        this.dependencia = dep;
    }
}
