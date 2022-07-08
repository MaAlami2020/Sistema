/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author mimit
 */
public class Notificacion implements Observer{

    private MenuInicio menu;

    public Notificacion(MenuInicio menu) {
        this.menu = menu;
    }
    
    @Override
    public void update(Observable o, Object o1) {
        List<Usuario> usuarios = menu.getUserlist();
        Oferta newOffer = (Oferta) o1;
        for(Usuario us:usuarios){
            for(String notif: us.getSuscripciones()){
                String [] partes = notif.split(":");
                if(partes[0].equals("tipo")){
                    Class equipo = newOffer.getEquipoEnVenta().getClass();
                    Class esbirro = newOffer.getEsbirroParaTraspasar().get(0).getClass();
                    if(equipo.equals(partes[1].getClass()) || !newOffer.getEsbirroParaTraspasar().isEmpty() && esbirro.equals(partes[1].getClass())){
                        boolean repetida = false;
                        for(Oferta ofertaExistente: us.getNotificaciones()){
                            if(ofertaExistente.equals(newOffer)){
                                repetida = true;
                            }
                        }
                        if(!repetida){
                            us.getNotificaciones().add(newOffer);
                        }
                    }
                }else if(partes[0].equals("categoria")){
                    Categoria categoria =
                }
            }
        }
    }
    
}
