/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import static java.lang.Math.random;

/**
 *
 * @author mimit
 */
public class Ronda {
    private int valorAtaqueDesafiante;
    private int valorAtaqueDesafiador;
    private int valorDefensaDesafiante;
    private int valorDefensaDesafiador;

    public int getValorAtaqueDesafiante() {
        return valorAtaqueDesafiante;
    }

    public void setValorAtaqueDesafiante(int valorAtaqueDesafiante) {
        this.valorAtaqueDesafiante = valorAtaqueDesafiante;
    }

    public int getValorAtaqueDesafiador() {
        return valorAtaqueDesafiador;
    }

    public void setValorAtaqueDesafiador(int valorAtaqueDesafiador) {
        this.valorAtaqueDesafiador = valorAtaqueDesafiador;
    }

    public int getValorDefensaDesafiante() {
        return valorDefensaDesafiante;
    }

    public void setValorDefensaDesafiante(int valorDefensaDesafiante) {
        this.valorDefensaDesafiante = valorDefensaDesafiante;
    }

    public int getValorDefensaDesafiador() {
        return valorDefensaDesafiador;
    }

    public void setValorDefensaDesafiador(int valorDefensaDesafiador) {
        this.valorDefensaDesafiador = valorDefensaDesafiador;
    }
    
    public void calcularPtencialAtaque(){
      Usuario usuario = new Usuario();
      Usuario usuarioDesafiador = usuario.getUsuarioDesafiar();
        
      MenuInicio menu = new MenuInicio();
      Usuario usuarioDesafiante = menu.getUserlist().get(usuario.getIndex());
        
      Usuario user = usuarioDesafiador;
      while(user != null){  
        int poderDesafiador = usuarioDesafiador.getTipoPersonaje().anadirPoder();
        int ataqueEquipoActivo = 0;
        for(Arma a: usuarioDesafiador.getTipoPersonaje().getArmasActivas()){       
            ataqueEquipoActivo += a.getModificadorAtaque();
        }
        Vampiro vampiro = new Vampiro();
        int potencialAtaque = 0;
        int ataqueHabilidad = 0;
        if(usuarioDesafiador.getTipoPersonaje() == vampiro){
            Disciplina disciplina = new Disciplina();
            if(vampiro.getReservaPuntosSangre() != 0){
                int reservaSangre = vampiro.getReservaPuntosSangre();
                reservaSangre -= disciplina.getCostePuntosSangre();
                ataqueHabilidad = usuarioDesafiador.getTipoPersonaje().construirHabilidad().getValorAtaque();
            }else if((vampiro.getReservaPuntosSangre() == 0)|(vampiro.getReservaPuntosSangre() < disciplina.getCostePuntosSangre())){
                ataqueHabilidad = 0;
            }
            
            if(usuarioDesafiador.getTipoPersonaje().anadirSalud() >= 5){
                potencialAtaque = poderDesafiador + ataqueHabilidad + ataqueEquipoActivo + 2;
            }else{
                potencialAtaque = poderDesafiador + ataqueHabilidad + ataqueEquipoActivo;
            } 
        }else{
            ataqueHabilidad = usuarioDesafiador.getTipoPersonaje().construirHabilidad().getValorAtaque();
            Licantropo licantropo = new Licantropo();
            Cazador cazador = new Cazador();
            if(usuarioDesafiador.getTipoPersonaje() == licantropo){                
                Don don = new Don();
                int rabiaActual = licantropo.getRabia();
                potencialAtaque += rabiaActual;
                if(licantropo.getRabia() > don.getRabiaMin() & licantropo.getRabia() <= 3){
                   rabiaActual += 1;
                   licantropo.setRabia(rabiaActual);
                }
            }else if(usuarioDesafiador.getTipoPersonaje() == cazador){
                int voluntad = cazador.getVoluntad();
                potencialAtaque += voluntad;
                if(voluntad < 0){
                   voluntad -= 1;
                   cazador.setVoluntad(voluntad);
                }
            }
        } 
        int exito = 0;
            int cont = potencialAtaque;
            while(cont != 0){
               int numAleat = (int) Math.random()*6+1;
               cont -= 1;
               if((numAleat == 5)|(numAleat == 6)){
                   exito += 1;
               }
            }
        if(user == usuarioDesafiador){                      
            setValorAtaqueDesafiador(exito);
            user = usuarioDesafiante;        
        }else{
            setValorAtaqueDesafiante(exito);
            user = null;
        }        
      }
    }
    
    public void calcularPotencialDefensa(){
      Usuario usuario = new Usuario();
      Usuario usuarioDesafiador = usuario.getUsuarioDesafiar();
        
      MenuInicio menu = new MenuInicio();
      Usuario usuarioDesafiante = menu.getUserlist().get(usuario.getIndex());
        
      Usuario user = usuarioDesafiador;
      while(user != null){  
        int poderDesafiador = usuarioDesafiador.getTipoPersonaje().anadirPoder();
        int defensaEquipoActivo = 0;
        for(Arma a: usuarioDesafiador.getTipoPersonaje().getArmasActivas()){       
           defensaEquipoActivo += a.getModificadorDefensa();
        }
        Vampiro vampiro = new Vampiro();
        int potencialDefensa = 0;
        int defensaHabilidad = 0;
        if(usuarioDesafiador.getTipoPersonaje() == vampiro){
            Disciplina disciplina = new Disciplina();
            if(vampiro.getReservaPuntosSangre() != 0){
                int reservaSangre = vampiro.getReservaPuntosSangre();
                reservaSangre -= disciplina.getCostePuntosSangre();
                defensaHabilidad = usuarioDesafiador.getTipoPersonaje().construirHabilidad().getValorDefensa();
            }else if((vampiro.getReservaPuntosSangre() == 0)|(vampiro.getReservaPuntosSangre() < disciplina.getCostePuntosSangre())){
                defensaHabilidad = 0;
            }
            
            if(usuarioDesafiador.getTipoPersonaje().anadirSalud() >= 5){
                potencialDefensa = poderDesafiador + defensaHabilidad + defensaEquipoActivo + 2;
            }else{
                potencialDefensa = poderDesafiador + defensaHabilidad + defensaEquipoActivo;
            } 
        }else{
            defensaHabilidad = usuarioDesafiador.getTipoPersonaje().construirHabilidad().getValorDefensa();
            Licantropo licantropo = new Licantropo();
            Cazador cazador = new Cazador();
            if(usuarioDesafiador.getTipoPersonaje() == licantropo){                
                Don don = new Don();
                int rabiaActual = licantropo.getRabia();
                potencialDefensa += rabiaActual;
                if(licantropo.getRabia() > don.getRabiaMin() & licantropo.getRabia() <= 3){
                   rabiaActual += 1;
                   licantropo.setRabia(rabiaActual);
                }
            }else if(usuarioDesafiador.getTipoPersonaje() == cazador){
                int voluntad = cazador.getVoluntad();
                potencialDefensa += voluntad;
                if(voluntad < 0){
                   voluntad -= 1;
                   cazador.setVoluntad(voluntad);
                }
            }
        } 
        int exito = 0;
            int cont = potencialDefensa;
            while(cont != 0){
               int numAleat = (int) Math.random()*6+1;
               cont -= 1;
               if((numAleat == 5)|(numAleat == 6)){
                   exito += 1;
               }
            }
        if(user == usuarioDesafiador){                      
            setValorDefensaDesafiador(exito);
            user = usuarioDesafiante;        
        }else{
            setValorDefensaDesafiante(exito);
            user = null;
        }        
      }
    }
    
    public void Juego(){
       Usuario usuario = new  Usuario();
       MenuInicio menu = new MenuInicio();
       Vampiro vampiro = new Vampiro();
       Licantropo licantropo = new Licantropo();
       Cazador cazador = new Cazador();
       if(valorAtaqueDesafiador > valorDefensaDesafiante){
           int saludDesafiadorGhoul = usuario.getUsuarioDesafiar().getTipoPersonaje().construirGhoul().getSalud();
           if(saludDesafiadorGhoul != 0){
                saludDesafiadorGhoul -= 1;
                if(usuario.getUsuarioDesafiar().getTipoPersonaje() == licantropo){
                   int rabia = licantropo.getRabia();
                   rabia += 1;
                   licantropo.setRabia(rabia);
                }
                if(usuario.getUsuarioDesafiar().getTipoPersonaje() == cazador){
                   int voluntad = cazador.getVoluntad();
                   voluntad -= 1;
                   cazador.setVoluntad(voluntad);
                }
           }else{
               int saludDesafiadorDemonio = usuario.getUsuarioDesafiar().getTipoPersonaje().construirDemonio().getSalud();
               if(saludDesafiadorDemonio != 0){
                   saludDesafiadorDemonio -= 1;
                   if(usuario.getUsuarioDesafiar().getTipoPersonaje() == licantropo){
                   int rabia = licantropo.getRabia();
                   rabia += 1;
                   licantropo.setRabia(rabia);
                }
                if(usuario.getUsuarioDesafiar().getTipoPersonaje() == cazador){
                   int voluntad = cazador.getVoluntad();
                   voluntad -= 1;
                   cazador.setVoluntad(voluntad);
                }
               }else{
                   if(usuario.getUsuarioDesafiar().getTipoPersonaje() != vampiro){
                       int saludDesafiadorHumano = usuario.getUsuarioDesafiar().getTipoPersonaje().construirHumano().getSalud();                       
                       if(usuario.getUsuarioDesafiar().getTipoPersonaje() == licantropo){
                           int rabia = licantropo.getRabia();
                           rabia += 1;
                           licantropo.setRabia(rabia);
                       }
                       if(usuario.getUsuarioDesafiar().getTipoPersonaje() == cazador){
                           int voluntad = cazador.getVoluntad();
                           voluntad -= 1;
                           cazador.setVoluntad(voluntad);
                       }
                   }else{
                       int saludDesafiadorPersonaje = usuario.getUsuarioDesafiar().getTipoPersonaje().anadirSalud();
                       saludDesafiadorPersonaje -= 1;
                       if(usuario.getUsuarioDesafiar().getTipoPersonaje() == licantropo){
                           int rabia = licantropo.getRabia();
                           rabia += 1;
                           licantropo.setRabia(rabia);
                       }
                       if(usuario.getUsuarioDesafiar().getTipoPersonaje() == cazador){
                           int voluntad = cazador.getVoluntad();
                           voluntad -= 1;
                           cazador.setVoluntad(voluntad);
                       }
                   }
               }
           }
       }else if(valorAtaqueDesafiante > valorDefensaDesafiador){
           int saludDesafianteGhoul = menu.getUserlist().get(usuario.getIndex()).getTipoPersonaje().construirGhoul().getSalud();
           if(saludDesafianteGhoul != 0){
                saludDesafianteGhoul -= 1;
                if(menu.getUserlist().get(usuario.getIndex()).getTipoPersonaje() == licantropo){
                   int rabia = licantropo.getRabia();
                   rabia += 1;
                   licantropo.setRabia(rabia);
                }
                if(usuario.getUsuarioDesafiar().getTipoPersonaje() == cazador){
                   int voluntad = cazador.getVoluntad();
                   voluntad -= 1;
                   cazador.setVoluntad(voluntad);
                }
           }else{
               int saludDesafianteDemonio = menu.getUserlist().get(usuario.getIndex()).getTipoPersonaje().construirDemonio().getSalud();
               if(saludDesafianteDemonio != 0){
                   saludDesafianteDemonio -= 1;
                   if(menu.getUserlist().get(usuario.getIndex()).getTipoPersonaje() == licantropo){
                       int rabia = licantropo.getRabia();
                       rabia += 1;
                       licantropo.setRabia(rabia);
                   }
                   if(usuario.getUsuarioDesafiar().getTipoPersonaje() == cazador){
                       int voluntad = cazador.getVoluntad();
                       voluntad -= 1;
                       cazador.setVoluntad(voluntad);
                   }
               }else{
                   if(menu.getUserlist().get(usuario.getIndex()).getTipoPersonaje() != vampiro){
                       int saludDesafianteHumano = menu.getUserlist().get(usuario.getIndex()).getTipoPersonaje().construirHumano().getSalud();                       
                       if(menu.getUserlist().get(usuario.getIndex()).getTipoPersonaje() == licantropo){
                           int rabia = licantropo.getRabia();
                           rabia += 1;
                           licantropo.setRabia(rabia);
                       }
                       if(usuario.getUsuarioDesafiar().getTipoPersonaje() == cazador){
                           int voluntad = cazador.getVoluntad();
                           voluntad -= 1;
                           cazador.setVoluntad(voluntad);
                       }
                   }else{
                       int saludDesafiantePersonaje = menu.getUserlist().get(usuario.getIndex()).getTipoPersonaje().anadirSalud();
                       saludDesafiantePersonaje -= 1;
                       if(menu.getUserlist().get(usuario.getIndex()).getTipoPersonaje() == licantropo){
                           int rabia = licantropo.getRabia();
                           rabia += 1;
                           licantropo.setRabia(rabia);
                       }
                       if(usuario.getUsuarioDesafiar().getTipoPersonaje() == cazador){
                           int voluntad = cazador.getVoluntad();
                           voluntad -= 1;
                           cazador.setVoluntad(voluntad);
                       }
                   }
               }
           }
       }   
    }
}
