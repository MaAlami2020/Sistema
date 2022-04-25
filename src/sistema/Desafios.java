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
public class Desafios implements Iterator{

    @Override
    public void aceptarDesafio() {
        int opc = 0;
        do{
           System.out.println("1.cambiar arma activa");
           System.out.println("2.cambiar armadura activa");
           System.out.println("3.iniciar combate");
           Scanner sc = new Scanner(System.in);
           String opcion = sc.next();
           opc = Integer.parseInt(opcion);
        }while((opc < 1)|(opc > 3));
        if(opc == 1){
           Usuario usuario = new Usuario();
           usuario.cambiarArmas_activas();
        }else if(opc == 2){
        
        }else if(opc == 3){
           Combate combate = new Combate();
           combate.iniciar();
        }
    }

    @Override
    public void rechazarDesafio() {
        Usuario usuario = new Usuario();
        double oroPersonaje = usuario.getUsuarioDesafiar().getTipoPersonaje().anadirOro();
        int oroDesafiador = usuario.getUserlist().get(usuario.getIndex()).getTipoPersonaje().anadirOro();
        oroPersonaje -= (double) oroDesafiador * 0.1;
    }
    
}
