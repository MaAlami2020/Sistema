/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.List;

/**
 *
 * @author mimit
 */
public class Arma extends Equipo{
    private String nombre;
    private String manejo;

    public Arma(String nombre, int modificadorAtaque, int modificadorDefensa, List<String> listaMateriales, String manejo) {
        super(modificadorAtaque,modificadorDefensa,listaMateriales);
        this.nombre = nombre;
        this.manejo = manejo;
    }

    @Override
    public void setNombre(String nombre){
        if(!nombre.equals(" ")){
            this.nombre = nombre;
        }else{
            throw new RuntimeException("nombre invalido");
        }
    }

    @Override
    public String getManejo() {       
        return manejo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }   

    @Override
    public void setManejo(String manejo){
        if(!manejo.equals("1 mano") & !manejo.equals("2 manos")){
             throw new RuntimeException("valor invalido");
        }else{
            this.manejo = manejo;
        }
    } 
}
