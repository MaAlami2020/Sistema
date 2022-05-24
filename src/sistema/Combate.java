/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mimit
 */
public class Combate{
    private List<Ronda> listaRondas = new ArrayList<>();
    private Usuario desafiante;
    private Usuario desafiado; 
    private Usuario usuarioVencedor;
    private LocalDateTime fecha = LocalDateTime.now();
    private double oroGanado;
    private List<Usuario> contendientes = new ArrayList<>();
    private MenuInicio menu;

    public Combate(){
        
    }
    
    public Combate(MenuInicio menu){
        this.menu = menu;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getOroGanado() {
        return oroGanado;
    }

    public Usuario getDesafiante() {
        return desafiante;
    }

    public Usuario getDesafiado() {
        return desafiado;
    }

    public Usuario getUsuarioVencedor() {
        return usuarioVencedor;
    }
    /**
     * 
     * @param user1 usuario que acepto el desafio
     * @param user2 usuario que desafia a otro
     */
    public void iniciar(Usuario user1, Usuario user2){
            desafiante = user2;
            desafiado = user1;
            
            int saludDesafiado = desafiado.getTipoPersonaje().getSalud();
            int saludDesafiante = desafiante.getTipoPersonaje().getSalud();
            
            while((saludDesafiante > 0)|(saludDesafiado > 0)){
                Ronda ronda = new Ronda(menu);
                ronda.calcularPotencialAtaque(desafiante,desafiado);
                //ronda.calcularPotencialDefensa(desafiante,desafiado);
                ronda.Jugar(desafiante,desafiado);
                listaRondas.add(ronda);
                saludDesafiado = desafiado.getTipoPersonaje().getSalud();
                saludDesafiante = desafiante.getTipoPersonaje().getSalud();
            }
            if(saludDesafiado == 0 & saludDesafiante == 0){
                usuarioVencedor = null;
            }
            if(saludDesafiante > 0){
                usuarioVencedor = desafiante;
                int oroApostado = desafiante.getOroApostado();
                
                double oroDesafiado = desafiado.getTipoPersonaje().getOro();
                double oroDesafiante = desafiante.getTipoPersonaje().getOro();
                
                if(oroApostado > oroDesafiado){
                    desafiado.getTipoPersonaje().setOro(0);    
                }else{
                    oroDesafiado -= oroApostado;
                    desafiado.getTipoPersonaje().setOro(oroDesafiado);
                }
                oroDesafiante += oroDesafiado;
                desafiante.getTipoPersonaje().setOro(oroDesafiante);
                
                oroGanado = oroDesafiante;   
                Operador operador = menu.getOperatorlist().get(0);
                operador.banearUsuario(desafiado);
                
            }else if(saludDesafiado > 0){
                usuarioVencedor = desafiado;
                int oroApostado = desafiante.getOroApostado();
                
                double oroDesafiado = desafiado.getTipoPersonaje().getOro();
                double oroDesafiante = desafiante.getTipoPersonaje().getOro();
                
                if(oroApostado > oroDesafiante){
                    desafiante.getTipoPersonaje().setOro(0);    
                }else{
                    oroDesafiante -= oroApostado;
                    desafiante.getTipoPersonaje().setOro(oroDesafiante);
                }
                oroDesafiado += oroDesafiante;
                desafiado.getTipoPersonaje().setOro(oroDesafiado);
                
                oroGanado = oroDesafiado;   
                Operador operador = menu.getOperatorlist().get(0);
                operador.banearUsuario(desafiante);
            }
            
            Usuario user = desafiado;
            while(user != null){
               boolean saludPerdida = false; 
               while(user.getTipoPersonaje().getListaEsbirros().iterator().hasNext()&(!saludPerdida)){         
                  Esbirro EsbirroUsuario = user.getTipoPersonaje().getListaEsbirros().iterator().next();
                  if(EsbirroUsuario.getSalud() != 0){
                      saludPerdida = true;
                      boolean userPresent = false;
                      for(Usuario us: contendientes){
                          if(us.equals(user)){
                             userPresent = true;
                          }
                      }
                      if(!userPresent){
                          contendientes.add(user);
                      }
                  }else{
                      Class esbirro = EsbirroUsuario.getClass(); 
                      if(esbirro == Demonio.class){
                         for(Esbirro esb: EsbirroUsuario.getHijos()){
                            if(esb.getSalud() != 0){
                                saludPerdida = true;
                                boolean userPresent = false;
                                for(Usuario us: contendientes){
                                    if(us.equals(user)){
                                        userPresent = true;
                                    }
                                }
                                if(!userPresent){
                                    contendientes.add(user);
                                }
                            }
                         }
                      }
                  }           
               if(user == desafiado){
                   user = desafiante;
               }else{
                   user = null;
               }
              }
            }
            menu.setListaCombates(this);
            menu.serializar(this);  
    }
    
    public void mostrarResultaddo(){
        if(usuarioVencedor == null){
            System.out.println("resultado del combate: empate");
        }else{
            System.out.println("resultado del combate: " + usuarioVencedor.getNombre() + " gana");
        }
        int numRonda = 0;
        for(Ronda rd: listaRondas){
            numRonda++;
            System.out.println("ronda " + numRonda + ": ");
            System.out.println("valor al ataque del desafiante: " + rd.getValorAtaqueDesafiante());
            System.out.println("valor al ataque del desafiador: " + rd.getValorAtaqueDesafiado());
            System.out.println("valor a la defensa del desafiante: " + rd.getValorDefensaDesafiante());
            System.out.println("valor a la defensa del desafiador: " + rd.getValorDefensaDesafiado());
        }
    }

}
