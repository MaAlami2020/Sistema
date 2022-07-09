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
public class Armadura extends Equipo{
    private String nombre;

    public Armadura(String nombre, int modificadorAtaque, int modificadorDefensa, List<String> listaMateriales) {
        super(modificadorAtaque,modificadorDefensa,listaMateriales);
        this.nombre = nombre;
    }
    
    @Override
    public void setNombre(String nombre) {
        if(nombre != " "){
            this.nombre = nombre;
        }else{
            throw new RuntimeException("nombre invalido");
        }
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setManejo(String manejo) {
        throw new RuntimeException("este equipo no tiene un manejo");
    }

    @Override
    public String getManejo() {
        return null;
    }
 
    @Override
    public void setCategoria(Categoria categoria) {
        throw new RuntimeException("este equipo no tiene un categoria");
    }

    @Override
    public Categoria getCategoria() {
        return null;
    }
}
