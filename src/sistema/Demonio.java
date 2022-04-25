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
public class Demonio implements Esbirro{
    private String nombre;
    private int salud;
    private String pacto;
    protected List<Esbirro> hijos = new ArrayList<>();
    
    @Override
    public void anadirNombre(){
        System.out.println("Introduzca el nombre del demonio: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.next();
        this.nombre = nombre;
        for(int x = 0; x < hijos.size(); x++){
           Esbirro esb = hijos.get(x);
           esb.anadirNombre();
//           System.out.println("Introduzca el nombre del demonio: ");
//           Scanner sc = new Scanner(System.in);
//           String nombre = sc.next();
//           this.nombre = nombre;
        }
    }
    
    public void anadirPacto(){
       System.out.println("Anniada la descripcion del pacto: ");
       Scanner sc = new Scanner(System.in);
       String descripcion = sc.next();
       this.pacto = descripcion;
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
}
