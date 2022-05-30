/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;


/**
 *
 * @author mimit
 */
public class Ronda {
    private int valorAtaqueDesafiante;
    private int valorAtaqueDesafiado;
    private int valorDefensaDesafiante;
    private int valorDefensaDesafiado;
    private MenuInicio menu;

    public Ronda(){   
    }
    
    public Ronda(MenuInicio menu){
        this.menu = menu;
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
            Operador operador = menu.getOperatorlist().get(0);
            Usuario desafiado = user1;
            Usuario desafiante = user2;
            
            Usuario user = desafiado;
            
            while(user != null){
                Class personaje = user.getTipoPersonaje().getClass();
                int poder = user.getTipoPersonaje().getPoder();
                int ataqueEquipoActivo = 0;
                for(Arma a: user.getTipoPersonaje().getArmasActivas()){
                    ataqueEquipoActivo += a.getModificadorAtaque();
                }
                ataqueEquipoActivo += user.getTipoPersonaje().getArmaduraActiva().getModificadorAtaque();

                int potencialAtaque = poder + ataqueEquipoActivo;
                int ataqueHabilidad = 0;
                if(personaje == Vampiro.class){
                    int fortaleza = operador.getFortalezasVampiro();
                    if(user.getTipoPersonaje().getReservaPuntosSangre() != 0){
                        int reservaSangre = user.getTipoPersonaje().getReservaPuntosSangre();
                        reservaSangre -= user.getTipoPersonaje().getHabilidad().getCostePuntosSangre();
                        try{
                            user.getTipoPersonaje().setReservaPuntosSangre(reservaSangre);
                        }catch(RuntimeException e){
                            System.out.println(e.getMessage());
                        }
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
                    
                    if(personaje == Licantropo.class){
                        int fortaleza = operador.getFortalezasLicantropo();
                        int rabiaActual = user.getTipoPersonaje().getRabia();         
                        if(rabiaActual < user.getTipoPersonaje().getHabilidad().getRabiaMin()){
                            ataqueHabilidad = 0;
                        }
                        potencialAtaque += ataqueHabilidad + rabiaActual + fortaleza;
                    }else if(personaje == Cazador.class){
                        int fortaleza = operador.getFortalezasCazador();
                        int voluntad = user.getTipoPersonaje().getVoluntad();
                        potencialAtaque += ataqueHabilidad + voluntad + fortaleza;
                       
                    }
                }
                int exito = 0;
                int cont = potencialAtaque;
                while(cont != 0){
                    int numAleat = (int) (Math.random()*6+1);
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
    }
    
    public void calcularPotencialDefensa(Usuario user2, Usuario user1){
            Operador operador = menu.getOperatorlist().get(0);
            Usuario desafiado = user1;
            Usuario desafiante = user2;
            
            Usuario user = desafiado;
            
            while(user != null){
                Class personaje = user.getTipoPersonaje().getClass();
                int poder = user.getTipoPersonaje().getPoder();
                int defensaEquipoActivo = 0;
                for(Arma a: user.getTipoPersonaje().getArmasActivas()){
                    defensaEquipoActivo += a.getModificadorDefensa();
                }
                defensaEquipoActivo += user.getTipoPersonaje().getArmaduraActiva().getModificadorDefensa();
                
                int potencialDefensa = poder + defensaEquipoActivo;
                int defensaHabilidad = 0;
                if(personaje == Vampiro.class){
                    int debilidad = operador.getDebilidadesVampiro();
                    if(user.getTipoPersonaje().getReservaPuntosSangre() != 0){
                        int reservaSangre = user.getTipoPersonaje().getReservaPuntosSangre();
                        reservaSangre -= user.getTipoPersonaje().getHabilidad().getCostePuntosSangre();
                        try{
                            user.getTipoPersonaje().setReservaPuntosSangre(reservaSangre);
                        }catch(RuntimeException e){
                            System.out.println(e.getMessage());
                        }
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
                    
                    if(personaje == Licantropo.class){
                        int debilidad = operador.getDebilidadesLicantropo();
                        int rabiaActual = user.getTipoPersonaje().getRabia();         
                        if(rabiaActual < user.getTipoPersonaje().getHabilidad().getRabiaMin()){
                            defensaHabilidad = 0;
                        }
                        potencialDefensa += defensaHabilidad + rabiaActual - debilidad;
                    }else if(personaje == Cazador.class){
                        int debilidad = operador.getDebilidadesCazador();
                        int voluntad = user.getTipoPersonaje().getVoluntad();
                        potencialDefensa += defensaHabilidad + voluntad - debilidad;
                       
                    }
                }
                int exito = 0;
                int cont = potencialDefensa;
                while(cont != 0){
                    int numAleat = (int) (Math.random()*6+1);
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
    }
    /**
     * 
     * @param user1 es el usuario que acepta el desafio
     * @param user2 es el usuario que desafia a otro
     */
    public void Jugar(Usuario user2, Usuario user1){ 
      Usuario user = user1; 
      if(valorAtaqueDesafiado > valorDefensaDesafiante){
           user = user1;
      }
      while(user != null){ 
       
         Class personaje = user.getTipoPersonaje().getClass();    
         boolean saludPerdida = false; 
         //int iter =0;
         while(user.getTipoPersonaje().getListaEsbirros().iterator().hasNext()&(!saludPerdida)){         
             Esbirro EsbirroUsuario = user.getTipoPersonaje().getListaEsbirros().iterator().next();
             if(EsbirroUsuario.getSalud() != 0){
                int saludEsbirroUsuario = 5;//se inicializa con el maximo de salud 
                Class esbirro = EsbirroUsuario.getClass(); 
                      if(esbirro == Demonio.class){
                         int saludEsbirroHijo = 5; 
                         if(EsbirroUsuario.getHijos().isEmpty()){
                             saludEsbirroUsuario = EsbirroUsuario.getSalud();
                             saludEsbirroUsuario -= 1;
                             if(saludEsbirroUsuario >= 1)
                                EsbirroUsuario.setSalud(saludEsbirroUsuario); 
                         }else{
                               for(Esbirro esb: EsbirroUsuario.getHijos()){
                             
                                   if(esb.getSalud() != 0){
                                      saludEsbirroHijo = esb.getSalud();
                                      saludEsbirroHijo -= 1;
                                
                                      if(saludEsbirroHijo == 0)
                                           EsbirroUsuario.getHijos().remove(esb);
                                      else if(saludEsbirroHijo >= 1)
                                           esb.setSalud(saludEsbirroHijo);
                                   }
                                   break;
                               }
                         } 
                      }else{
                        saludEsbirroUsuario = EsbirroUsuario.getSalud();
                        saludEsbirroUsuario -= 1;
                        if(saludEsbirroUsuario >= 1)
                           EsbirroUsuario.setSalud(saludEsbirroUsuario);
                      }
                saludPerdida = true;
                if(saludEsbirroUsuario == 0)
                    user.getTipoPersonaje().getListaEsbirros().remove(EsbirroUsuario);
                if(personaje == Vampiro.class){
                   int puntosSangre = user.getTipoPersonaje().getReservaPuntosSangre();
                   puntosSangre += 4;
                   try{
                       user.getTipoPersonaje().setReservaPuntosSangre(puntosSangre);
                   }catch(RuntimeException e){
                       user.getTipoPersonaje().setReservaPuntosSangre(10);
                   }
                }else if(personaje == Licantropo.class){
                   int rabia = user.getTipoPersonaje().getRabia();
                   rabia += 1;
                   try{
                       user.getTipoPersonaje().setRabia(rabia);
                   }catch(RuntimeException e){
                       user.getTipoPersonaje().setRabia(3);
                   }
                }else if(personaje == Cazador.class){
                   int voluntad = user.getTipoPersonaje().getVoluntad();
                   voluntad -= 1;
                   try{
                       user.getTipoPersonaje().setVoluntad(voluntad);
                   }catch(RuntimeException e){
                       user.getTipoPersonaje().setVoluntad(0);
                   }
                }
              }
             //iter++;
        }
        if(saludPerdida == false){
          int saludPersonaje = user.getTipoPersonaje().getSalud();
          if(saludPersonaje != 0){    
              saludPersonaje -= 1;
              user.getTipoPersonaje().setSalud(saludPersonaje);
              if(personaje == Vampiro.class){
                   int puntosSangre = user.getTipoPersonaje().getReservaPuntosSangre();
                   puntosSangre += 4;
                   try{
                       user.getTipoPersonaje().setReservaPuntosSangre(puntosSangre);
                   }catch(RuntimeException e){
                       user.getTipoPersonaje().setReservaPuntosSangre(10);
                   }
              }else if(personaje == Licantropo.class){
                   int rabia = user.getTipoPersonaje().getRabia();
                   rabia += 1;
                   try{
                       user.getTipoPersonaje().setRabia(rabia);
                   }catch(RuntimeException e){
                       user.getTipoPersonaje().setRabia(3);
                   }
              }else if(personaje == Cazador.class){
                   int voluntad = user.getTipoPersonaje().getVoluntad();
                   voluntad -= 1;
                   try{
                       user.getTipoPersonaje().setVoluntad(voluntad);
                   }catch(RuntimeException e){
                       user.getTipoPersonaje().setVoluntad(0);
                   }
              }
          }
        }
    
     if(user == user1){
        if(valorAtaqueDesafiante > valorDefensaDesafiado){
           user = user2;
        }else{
           user = null;
        }  
     }else{
       user = null;
     }   
   }   
  }   
      
}
