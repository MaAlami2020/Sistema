/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mimit
 */
public class Desafio implements Iterator{
    //private Combate combate = new Combate();

    public Desafio(){
    }

    
    public void aceptar(Usuario desafiado, Usuario desafiante) throws Exception{
        Combate combate = new Combate();
        int opc = 0;
        do{
           System.out.println("1.cambiar arma activa");
           System.out.println("2.cambiar armadura activa");
           System.out.println("3.iniciar combate");
           Scanner sc = new Scanner(System.in);
           String opcion = sc.next();
           opc = Integer.parseInt(opcion);
        }while((opc < 1)|(opc > 3));
        Arma [] armasDesafiante = desafiante.getTipoPersonaje().getArmasActivas();
        Armadura armaduraDesafiante = desafiante.getTipoPersonaje().getArmaduraActiva();
        Arma [] armasDesafiado = desafiado.getTipoPersonaje().getArmasActivas();
        Armadura armaduraDesafiado = desafiado.getTipoPersonaje().getArmaduraActiva();
        if(((armasDesafiante.length != 0)|(armaduraDesafiante != null))&((armasDesafiado.length != 0)|(armaduraDesafiado != null))){           
            switch (opc) {
                case 1:
                   Arma [] nuevasArmas = desafiado.cambiarArmas_activas();
                   desafiado.setArmasActivasPersonaje(nuevasArmas);
                   break;
                case 2:
                   Armadura nuevaArmadura = desafiado.cambiarArmadura_activa();
                   desafiado.setArmaduraActivaPersonaje(nuevaArmadura);
                   break;
                case 3:
                   combate.iniciar(desafiado,desafiante);
                   combate.mostrarResultaddo();
                   break;
                default:
                   break;
            }
        }else{
            System.out.println("no tiene armas o armadura activa");
        }
    }

    /**
     * al usuario desafiado se le quita el 10% de la cantidad de oro que el desafiante aposto
     */
    public void rechazar(Usuario desafiado, Usuario desafiante) throws Exception{
        int oroPersonaje = desafiado.getTipoPersonaje().getOro();
        int oroDesafiante = desafiante.getOroApostado();
        oroPersonaje -= oroDesafiante * 0.1;
        desafiado.setOroPersonaje(oroPersonaje);
    }

    @Override
    public boolean hashNext() {
            Usuario usuario = new Usuario();
            List<String> listaNotif = usuario.getNotifDesafio();
            return !listaNotif.isEmpty();
    }

    @Override
    public String next() {
            Usuario usuario = new Usuario();
            List<String> listaNotif = usuario.getNotifDesafio();
            String notif = listaNotif.get(0);
            return notif;
    }
    
}
