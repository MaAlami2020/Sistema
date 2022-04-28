/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    private Usuario usuario = new Usuario();
    private Operador operador = new Operador();

    public Ronda()throws FileNotFoundException, IOException{
       
    }

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
      
      Usuario usuarioDesafiador = usuario.getUsuarioDesafiar();
        
      Usuario usuarioDesafiante = usuario.getUsuarioDesafiante();
        
      Usuario user = usuarioDesafiador;
      while(user != null){  
        int poder = user.getTipoPersonaje().anadirPoder();
        int ataqueEquipoActivo = 0;
        for(Arma a: user.getTipoPersonaje().getArmasActivas()){       
            ataqueEquipoActivo += a.getModificadorAtaque();
        }
        Vampiro vampiro = new Vampiro();
        int potencialAtaque = poder +  ataqueEquipoActivo;
        int ataqueHabilidad = 0;
        int fortaleza = 0;
        if(usuarioDesafiador.getTipoPersonaje() == vampiro){
            fortaleza = operador.getFortalezasVampiro();          
            Disciplina disciplina = new Disciplina();
            if(vampiro.getReservaPuntosSangre() != 0){
                int reservaSangre = vampiro.getReservaPuntosSangre();
                reservaSangre -= disciplina.getCostePuntosSangre();
                ataqueHabilidad = user.getTipoPersonaje().construirHabilidad().getValorAtaque();
            }else if((vampiro.getReservaPuntosSangre() == 0)|(vampiro.getReservaPuntosSangre() < disciplina.getCostePuntosSangre())){
                ataqueHabilidad = 0;
            }
            
            if(usuarioDesafiador.getTipoPersonaje().anadirSalud() >= 5){
                potencialAtaque += ataqueHabilidad + 2 + fortaleza;
            }else{
                potencialAtaque += ataqueHabilidad + fortaleza;
            } 
        }else{
            ataqueHabilidad = user.getTipoPersonaje().construirHabilidad().getValorAtaque();
            Licantropo licantropo = new Licantropo();
            Cazador cazador = new Cazador();
            if(usuarioDesafiador.getTipoPersonaje() == licantropo){ 
                fortaleza = operador.getFortalezasLicantropo();
                Don don = new Don();
                int rabiaActual = licantropo.getRabia();
                potencialAtaque += ataqueHabilidad + rabiaActual + fortaleza;
                if(licantropo.getRabia() > don.getRabiaMin() & licantropo.getRabia() <= 3){
                   rabiaActual += 1;
                   licantropo.setRabia(rabiaActual);
                }
            }else if(usuarioDesafiador.getTipoPersonaje() == cazador){
                fortaleza = operador.getFortalezasLicantropo();
                int voluntad = cazador.getVoluntad();
                potencialAtaque += ataqueHabilidad + voluntad + fortaleza;
                if(voluntad > 0){
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
      Usuario usuarioDesafiador = usuario.getUsuarioDesafiar();
       
      Usuario usuarioDesafiante = usuario.getUsuarioDesafiante();
        
      Usuario user = usuarioDesafiador;
      while(user != null){  
        int poder = user.getTipoPersonaje().anadirPoder();
        int defensaEquipoActivo = 0;
        for(Arma a: usuarioDesafiador.getTipoPersonaje().getArmasActivas()){       
           defensaEquipoActivo += a.getModificadorDefensa();
        }
        
        Vampiro vampiro = new Vampiro();
        int potencialDefensa = poder + defensaEquipoActivo;
        int defensaHabilidad = 0;
        int debilidad = 0;
        if(usuarioDesafiador.getTipoPersonaje() == vampiro){
            debilidad = operador.getDebilidadesVampiro();
            Disciplina disciplina = new Disciplina();
            if(vampiro.getReservaPuntosSangre() != 0){
                int reservaSangre = vampiro.getReservaPuntosSangre();
                reservaSangre -= disciplina.getCostePuntosSangre();
                defensaHabilidad = user.getTipoPersonaje().construirHabilidad().getValorDefensa();
            }else if((vampiro.getReservaPuntosSangre() == 0)|(vampiro.getReservaPuntosSangre() < disciplina.getCostePuntosSangre())){
                defensaHabilidad = 0;
            }
            
            if(usuarioDesafiador.getTipoPersonaje().anadirSalud() >= 5){
                potencialDefensa += defensaHabilidad + 2 - debilidad;
                if(potencialDefensa < 0){
                   potencialDefensa = 0;
                }
            }else{
                potencialDefensa += defensaHabilidad - debilidad;
                if(potencialDefensa < 0){
                   potencialDefensa = 0;
                }
            } 
        }else{
            defensaHabilidad = usuarioDesafiador.getTipoPersonaje().construirHabilidad().getValorDefensa();
            Licantropo licantropo = new Licantropo();
            Cazador cazador = new Cazador();
            if(usuarioDesafiador.getTipoPersonaje() == licantropo){
                debilidad = operador.getDebilidadesLicantropo();
                Don don = new Don();
                int rabiaActual = licantropo.getRabia();
                potencialDefensa += defensaHabilidad + rabiaActual - debilidad;
                if(potencialDefensa < 0){
                   potencialDefensa = 0;
                }
                if(licantropo.getRabia() > don.getRabiaMin() & licantropo.getRabia() <= 3){
                   rabiaActual += 1;
                   licantropo.setRabia(rabiaActual);
                }
            }else if(usuarioDesafiador.getTipoPersonaje() == cazador){
                debilidad = operador.getDebilidadesCazador();
                int voluntad = cazador.getVoluntad();
                potencialDefensa += voluntad + defensaHabilidad - debilidad;
                if(potencialDefensa < 0){
                   potencialDefensa = 0;
                }
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
                }else
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
                   }else
                   if(usuario.getUsuarioDesafiar().getTipoPersonaje() == cazador){
                       int voluntad = cazador.getVoluntad();
                       voluntad -= 1;
                       cazador.setVoluntad(voluntad);
                   }
               }else{
                   if(usuario.getUsuarioDesafiar().getTipoPersonaje() != vampiro){
                       int saludDesafiadorHumano = usuario.getUsuarioDesafiar().getTipoPersonaje().construirHumano().getSalud();                       
                       saludDesafiadorHumano -= 1;
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
           int saludDesafianteGhoul = usuario.getUsuarioDesafiante().getTipoPersonaje().construirGhoul().getSalud();
           if(saludDesafianteGhoul != 0){
                saludDesafianteGhoul -= 1;
                if(usuario.getUsuarioDesafiante().getTipoPersonaje() == licantropo){
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
               int saludDesafianteDemonio = usuario.getUsuarioDesafiante().getTipoPersonaje().construirDemonio().getSalud();
               if(saludDesafianteDemonio != 0){
                   saludDesafianteDemonio -= 1;
                   if(usuario.getUsuarioDesafiante().getTipoPersonaje() == licantropo){
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
                   if(usuario.getUsuarioDesafiante().getTipoPersonaje() != vampiro){
                       int saludDesafianteHumano = usuario.getUsuarioDesafiante().getTipoPersonaje().construirHumano().getSalud();                       
                       saludDesafianteHumano -= 1;
                       if(usuario.getUsuarioDesafiante().getTipoPersonaje() == licantropo){
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
                       int saludDesafiantePersonaje = usuario.getUsuarioDesafiante().getTipoPersonaje().anadirSalud();
                       saludDesafiantePersonaje -= 1;
                       if(usuario.getUsuarioDesafiante().getTipoPersonaje() == licantropo){
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
