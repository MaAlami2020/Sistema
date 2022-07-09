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
                    if(equipo.equals(partes[1]) || !newOffer.getEsbirroParaTraspasar().isEmpty() && esbirro.equals(partes[1].getClass())){
                        /**boolean repetida = false;
                        for(Oferta ofertaExistente: us.getNotificaciones()){
                            if(ofertaExistente.equals(newOffer)){
                                repetida = true;
                            }
                        }
                        if(!repetida){*/
                            us.getNotificaciones().add(newOffer);
                    }
                }else if(partes[0].equals("categoria")){
                    if(newOffer.getEquipoEnVenta().getCategoria().equals(partes[1])){
                    us.getNotificaciones().add(newOffer);
                    }
                }else if(partes[0].equals("valor")){
                    int modificador = Integer.parseInt(partes[1]);
                    if(newOffer.getEquipoEnVenta().getModificadorAtaque()==modificador || newOffer.getEquipoEnVenta().getModificadorDefensa()==modificador){
                    us.getNotificaciones().add(newOffer);
                    }
                }else if(partes[0].equals("lealtad")){
                    boolean encontrado = false;
                    for(Esbirro esbPadre: newOffer.getEsbirroParaTraspasar()){
                        for(Esbirro esbHijo: esbPadre.getHijos()){
                            if(esbPadre.getLealtad().equals(partes[1]) || esbHijo.getLealtad().equals(partes[1])){
                                encontrado = true;
                            }
                        }
                    }
                    if(encontrado){
                        us.getNotificaciones().add(newOffer);
                    }
                }else if(partes[0].equals("esbirro")){
                    boolean encontrado = false;
                    for(Esbirro esbPadre: newOffer.getEsbirroParaTraspasar()){
                        for(Esbirro esbHijo: esbPadre.getHijos()){
                            if(esbPadre.equals(partes[1]) || esbHijo.equals(partes[1])){
                                encontrado = true;
                            }
                        }
                    }
                    if(encontrado){
                        us.getNotificaciones().add(newOffer);
                    }
                }else if(partes[0].equals("usuario")){
                    boolean encontrado = false;
                    for(Oferta oferta: us.getOfertas()){
                        if(oferta.equals(newOffer)){
                           encontrado = true;
                        }
                    }
                    if(encontrado && us.getTipoPersonaje().equals(partes[1])){
                        us.getNotificaciones().add(newOffer);
                    }
                }else if(partes[0].equals("precio")){
                    String [] subPartes = partes[1].split("-");
                    int precioMin = Integer.parseInt(subPartes[0]);
                    int precioMax = Integer.parseInt(subPartes[1]);
                    if(newOffer.getPrecioVenta()>=precioMin && newOffer.getPrecioVenta()<=precioMax){
                        us.getNotificaciones().add(newOffer);
                    }
                }
            }
        }
    }
    
}
