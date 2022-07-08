/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.Observable;

/**
 *esta clase es la que notifica
 * @author mimit
 */
public class Notificar extends Observable{
    private MenuInicio menu;
    private Notificacion notification;
    
    public Notificar(MenuInicio menu) {
        this.menu = menu;
        this.notification = new Notificacion(menu);
    }
    
    public void addOferta(Oferta nuevaOferta){
        notifyObservers(nuevaOferta);
    }
}
