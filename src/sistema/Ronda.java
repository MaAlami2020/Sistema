/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mimit
 */
public class Ronda {
    private int valorAtaqueDesafiante;
    private int valorAtaqueDesafiado;
    private int valorDefensaDesafiante;
    private int valorDefensaDesafiado;
    //private Operador operador = new Operador();

    public Ronda()throws FileNotFoundException, IOException{
       
    }

    public int getValorAtaqueDesafiante() {
        return valorAtaqueDesafiante;
    }

    public int getValorAtaqueDesafiado() {
        return valorAtaqueDesafiado;
    }

    public int getValorDefensaDesafiante() {
        return valorDefensaDesafiante;
    }

    public int getValorDefensaDesafiado() {
        return valorDefensaDesafiado;
    }

    public void setValorAtaqueDesafiante(int valorAtaqueDesafiante) {
        this.valorAtaqueDesafiante = valorAtaqueDesafiante;
    }

    public void setValorAtaqueDesafiado(int valorAtaqueDesafiador) {
        this.valorAtaqueDesafiado = valorAtaqueDesafiador;
    }

    public void setValorDefensaDesafiante(int valorDefensaDesafiante) {
        this.valorDefensaDesafiante = valorDefensaDesafiante;
    }

    public void setValorDefensaDesafiado(int valorDefensaDesafiador) {
        this.valorDefensaDesafiado = valorDefensaDesafiador;
    }
    
    /**
     * en este metodo calcula los potenciales de ataque y los valores de ataque de cada uno de los usuarios implicados
     * @param user2 es el usuario que desafia
     * @param user1 es el usuario que acepta el desafio
     */
    public void calcularPotencialAtaque(Usuario user2, Usuario user1){
        try {
            Operador operador = new Operador();
            Usuario desafiado = user1;
            Usuario desafiante = user2;
            
            Usuario user = desafiado;
            while(user != null){
                int poder = user.getTipoPersonaje().getPoder();
                int ataqueEquipoActivo = 0;
                for(Arma a: user.getTipoPersonaje().getArmasActivas()){
                    ataqueEquipoActivo += a.getModificadorAtaque();
                }
                ataqueEquipoActivo += user.getTipoPersonaje().getArmaduraActiva().getModificadorAtaque();

                Vampiro vampiro = new Vampiro();
                int potencialAtaque = poder + ataqueEquipoActivo;
                int ataqueHabilidad = 0;
                if(user.getTipoPersonaje() == vampiro){
                    int fortaleza = operador.getFortalezasVampiro();
                    if(user.getTipoPersonaje().getReservaPuntosSangre() != 0){
                        int reservaSangre = user.getTipoPersonaje().getReservaPuntosSangre();
                        reservaSangre -= user.getTipoPersonaje().getHabilidad().getCostePuntosSangre();
                        user.getTipoPersonaje().setReservaPuntosSangre(reservaSangre);
                        ataqueHabilidad = user.getTipoPersonaje().getHabilidad().getValorAtaque();
                    }else if((user.getTipoPersonaje().getReservaPuntosSangre() < user.getTipoPersonaje().getHabilidad().getCostePuntosSangre())){
                        ataqueHabilidad = 0;
                    }
                    
                    if(user.getTipoPersonaje().getSalud() >= 5){
                        potencialAtaque += ataqueHabilidad + 2 + fortaleza;
                    }else{
                        potencialAtaque += ataqueHabilidad + fortaleza;
                    }
                }else{
                    ataqueHabilidad = user.getTipoPersonaje().getHabilidad().getValorAtaque();
                    Licantropo licantropo = new Licantropo();
                    Cazador cazador = new Cazador();
                    if(user.getTipoPersonaje() == licantropo){
                        int fortaleza = operador.getFortalezasLicantropo();
                        int rabiaActual = user.getTipoPersonaje().getRabia();         
                        if(rabiaActual < user.getTipoPersonaje().getHabilidad().getRabiaMin()){
                            ataqueHabilidad = 0;
                        }
                        potencialAtaque += ataqueHabilidad + rabiaActual + fortaleza;
                    }else if(user.getTipoPersonaje() == cazador){
                        int fortaleza = operador.getFortalezasCazador();
                        int voluntad = user.getTipoPersonaje().getVoluntad();
                        potencialAtaque += ataqueHabilidad + voluntad + fortaleza;
                       
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
                if(user == desafiado){
                    setValorAtaqueDesafiado(exito);
                    user = desafiante;
                }else{
                    setValorAtaqueDesafiante(exito);
                    user = null;
                }
            } 
        }catch (IOException ex) {
            Logger.getLogger(Ronda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void calcularPotencialDefensa(Usuario user2, Usuario user1){
        try {
            Operador operador = new Operador();
            Usuario desafiado = user1;
            Usuario desafiante = user2;
            
            Usuario user = desafiado;
            while(user != null){
                int poder = user.getTipoPersonaje().getPoder();
                int defensaEquipoActivo = 0;
                for(Arma a: user.getTipoPersonaje().getArmasActivas()){
                    defensaEquipoActivo += a.getModificadorDefensa();
                }
                defensaEquipoActivo += user.getTipoPersonaje().getArmaduraActiva().getModificadorDefensa();
                
                Vampiro vampiro = new Vampiro();
                int potencialDefensa = poder + defensaEquipoActivo;
                int defensaHabilidad = 0;
                if(user.getTipoPersonaje() == vampiro){
                    int debilidad = operador.getDebilidadesVampiro();
                    if(user.getTipoPersonaje().getReservaPuntosSangre() != 0){
                        int reservaSangre = user.getTipoPersonaje().getReservaPuntosSangre();
                        reservaSangre -= user.getTipoPersonaje().getHabilidad().getCostePuntosSangre();
                        user.getTipoPersonaje().setReservaPuntosSangre(reservaSangre);
                        defensaHabilidad = user.getTipoPersonaje().getHabilidad().getValorDefensa();
                    }else if((user.getTipoPersonaje().getReservaPuntosSangre() < user.getTipoPersonaje().getHabilidad().getCostePuntosSangre())){
                        defensaHabilidad = 0;
                    }
                    
                    if(user.getTipoPersonaje().getSalud() >= 5){
                        potencialDefensa += defensaHabilidad + 2 - debilidad;
                    }else{
                        potencialDefensa += defensaHabilidad - debilidad;
                    }
                }else{
                    defensaHabilidad = user.getTipoPersonaje().getHabilidad().getValorDefensa();
                    Licantropo licantropo = new Licantropo();
                    Cazador cazador = new Cazador();
                    if(user.getTipoPersonaje() == licantropo){
                        int debilidad = operador.getDebilidadesLicantropo();
                        int rabiaActual = user.getTipoPersonaje().getRabia();         
                        if(rabiaActual < user.getTipoPersonaje().getHabilidad().getRabiaMin()){
                            defensaHabilidad = 0;
                        }
                        potencialDefensa += defensaHabilidad + rabiaActual - debilidad;
                    }else if(user.getTipoPersonaje() == cazador){
                        int debilidad = operador.getDebilidadesCazador();
                        int voluntad = user.getTipoPersonaje().getVoluntad();
                        potencialDefensa += defensaHabilidad + voluntad - debilidad;
                       
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
                if(user == desafiado){
                    setValorDefensaDesafiado(exito);
                    user = desafiante;
                }else{
                    setValorDefensaDesafiante(exito);
                    user = null;
                }
            } 
        }catch (IOException ex) {
            Logger.getLogger(Ronda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @param user1 es el usuario que acepta el desafio
     * @param user2 es el usuario que desafia a otro
     */
    public void Juego(Usuario user1, Usuario user2){
       Usuario user = null;
        
       Vampiro vampiro = new Vampiro();
       Licantropo licantropo = new Licantropo();
       Cazador cazador = new Cazador();
       
       if(valorAtaqueDesafiado > valorDefensaDesafiante){
           user = user1;
       }
       if(valorAtaqueDesafiante > valorDefensaDesafiado){
           user = user2;
       }
           
       boolean saludPerdida = false; 
       while(user.getTipoPersonaje().getListaEsbirros().iterator().hasNext()&(!saludPerdida)){         
             Esbirro EsbirroUsuario = user.getTipoPersonaje().getListaEsbirros().iterator().next();
             if(EsbirroUsuario.getSalud() != 0){
                int saludEsbirroUsuario = EsbirroUsuario.getSalud();
                saludEsbirroUsuario -= 1;
                saludPerdida = true;
                EsbirroUsuario.setSalud(saludEsbirroUsuario);
                if(user.getTipoPersonaje() == vampiro){
                   int puntosSangre = user.getTipoPersonaje().getReservaPuntosSangre();
                   puntosSangre += 4;
                   user.getTipoPersonaje().setReservaPuntosSangre(puntosSangre);
                }else if(user.getTipoPersonaje() == licantropo){
                   int rabia = user.getTipoPersonaje().getRabia();
                   rabia += 1;
                   user.getTipoPersonaje().setRabia(rabia);
                }else if(user.getTipoPersonaje() == cazador){
                   int voluntad = user.getTipoPersonaje().getVoluntad();
                   voluntad -= 1;
                   user.getTipoPersonaje().setVoluntad(voluntad);
                }
              }
       }
       if(saludPerdida == false){
          int saludPersonaje = user.getTipoPersonaje().getSalud();
          if(saludPersonaje != 0){    
              saludPersonaje -= 1;
              user.getTipoPersonaje().setSalud(saludPersonaje);
              if(user.getTipoPersonaje() == vampiro){
                   int puntosSangre = user.getTipoPersonaje().getReservaPuntosSangre();
                   puntosSangre += 4;
                   user.getTipoPersonaje().setReservaPuntosSangre(puntosSangre);
              }else if(user.getTipoPersonaje() == licantropo){
                   int rabia = user.getTipoPersonaje().getRabia();
                   rabia += 1;
                   user.getTipoPersonaje().setRabia(rabia);
              }else if(user.getTipoPersonaje() == cazador){
                   int voluntad = user.getTipoPersonaje().getVoluntad();
                   voluntad -= 1;
                   user.getTipoPersonaje().setVoluntad(voluntad);
              }
          }
       }
    }
}
