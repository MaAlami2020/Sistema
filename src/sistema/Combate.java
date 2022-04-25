/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author mimit
 */
public class Combate{
    private List<Ronda> listaRondas;
    private Usuario usuarioDesafiante;
    private Usuario usuarioDesafiador; 
    private Usuario usuarioVencedor;
    private LocalDateTime fecha = LocalDateTime.now();

    public Combate() {
        listaRondas = new ArrayList<>();
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    
    public void iniciar(){
        Usuario usuario = new Usuario();
        int saludDesafiador = usuarioDesafiador.getTipoPersonaje().anadirSalud();
        MenuInicio menu = new MenuInicio();
        Operador operador = new Operador();
        usuarioDesafiante = menu.getUserlist().get(usuario.getIndex());
        int saludDesafiante = usuarioDesafiante.getTipoPersonaje().anadirSalud();
        while((saludDesafiante > 0)&(saludDesafiador > 0)){
            Ronda ronda = new Ronda();
            ronda.calcularPtencialAtaque();
            ronda.calcularPotencialDefensa();
            ronda.Juego();
            listaRondas.add(ronda);
        }
        int oroApostado = usuarioDesafiante.getOroApostado();  
        if(saludDesafiante > 0){
            int oroGanado = usuarioDesafiante.getTipoPersonaje().anadirOro();
            oroGanado += oroApostado; 
            usuarioVencedor = usuarioDesafiante;
            operador.banearUsuario(usuarioDesafiador);
        }else if(saludDesafiador > 0){
            int oroGanado = usuarioDesafiador.getTipoPersonaje().anadirOro();
            oroGanado += oroApostado;
            usuarioVencedor = usuarioDesafiador;
            operador.banearUsuario(usuarioDesafiante);
        }else if((saludDesafiador == 0)&(saludDesafiante == 0)){
            usuarioVencedor =  null;
        }
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
            System.out.println("valor al ataque del desafiador: " + rd.getValorAtaqueDesafiador());
            System.out.println("valor a la defensa del desafiante: " + rd.getValorDefensaDesafiante());
            System.out.println("valor a la defensa del desafiador: " + rd.getValorDefensaDesafiador());
        }
    }
    
    public void serializar(){
    
    }
}
