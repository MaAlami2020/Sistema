/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    private Usuario usuarioDesafiado; 
    private Usuario usuarioVencedor;
    private LocalDateTime fecha = LocalDateTime.now();
    private int oroGanado;
    private List<Usuario> contendientes = new ArrayList<>();
    private Usuario usuario = new Usuario();
    private Ronda ronda= new Ronda();
    private Operador operador = new Operador();

    public Combate()throws FileNotFoundException, IOException{
        listaRondas = new ArrayList<>();
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getOroGanado() {
        return oroGanado;
    }

    public Usuario getUsuarioDesafiante() {
        return usuarioDesafiante;
    }

    public Usuario getUsuarioDesafiado() {
        return usuarioDesafiado;
    }

    public Usuario getUsuarioVencedor() {
        return usuarioVencedor;
    }
    
    public void iniciar(){
        int saludDesafiador = usuarioDesafiado.getTipoPersonaje().anadirSalud();
       
        usuarioDesafiante = usuario.getUsuarioDesafiante();
        int saludDesafiante = usuarioDesafiante.getTipoPersonaje().anadirSalud();
        while((saludDesafiante > 0)&(saludDesafiador > 0)){
            ronda.calcularPtencialAtaque();
            ronda.calcularPotencialDefensa();
            ronda.Juego();
            listaRondas.add(ronda);
        }
        int oroApostado = usuarioDesafiante.getOroApostado();  
        if(saludDesafiante > 0){
            oroGanado = usuarioDesafiante.getTipoPersonaje().anadirOro();
            oroGanado += oroApostado; 
            usuarioVencedor = usuarioDesafiante;
            operador.banearUsuario(usuarioDesafiado);
        }else if(saludDesafiador > 0){
            oroGanado = usuarioDesafiado.getTipoPersonaje().anadirOro();
            oroGanado += oroApostado;
            usuarioVencedor = usuarioDesafiado;
            operador.banearUsuario(usuarioDesafiante);
        }else if((saludDesafiador == 0)&(saludDesafiante == 0)){
            usuarioVencedor =  null;
        }
        operador.getListaCombates().add(this);
        int saludDesafianteGhoul = usuarioDesafiante.getTipoPersonaje().construirGhoul().getSalud();
        int saludDesafianteDemonio = usuarioDesafiante.getTipoPersonaje().construirDemonio().getSalud();
        int saludDesafianteHumano = usuarioDesafiante.getTipoPersonaje().construirHumano().getSalud(); 
        if(((saludDesafianteGhoul != 0)|(saludDesafianteDemonio != 0)|(saludDesafianteHumano != 0))){
            contendientes.add(usuarioDesafiante);
        }
        int saludDesafiadoGhoul = usuarioDesafiado.getTipoPersonaje().construirGhoul().getSalud();
        int saludDesafiadoDemonio = usuarioDesafiado.getTipoPersonaje().construirDemonio().getSalud();
        int saludDesafiadoHumano = usuarioDesafiado.getTipoPersonaje().construirHumano().getSalud();
        if(((saludDesafiadoGhoul != 0)|(saludDesafiadoDemonio != 0)|(saludDesafiadoHumano != 0))){
            contendientes.add(usuarioDesafiado);
        }
        usuario.serializar(this);
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

}
