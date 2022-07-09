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
public abstract class Equipo {
    protected int modificadorAtaque;
    protected int modificadorDefensa;
    protected List<String> listaMateriales;

    public Equipo(int modificadorAtaque, int modificadorDefensa, List<String> listaMateriales) {
        this.modificadorAtaque = modificadorAtaque;
        this.modificadorDefensa = modificadorDefensa;
        this.listaMateriales = listaMateriales;
    }

    
    public void setModificadorAtaque(int modificadorAtaque){
        if(modificadorAtaque < 1 | modificadorAtaque > 3){
            throw new RuntimeException("sobrepasó el límite de modificador de ataque");
        }else{
            this.modificadorAtaque = modificadorAtaque;
        }
    }

    public int getModificadorAtaque() {
        return modificadorAtaque;
    }   
    
    public int getModificadorDefensa() {
        return modificadorDefensa;
    }

    public void setModificadorDefensa(int modificadorDefensa){
        if(modificadorDefensa < 1 | modificadorDefensa > 3){
            throw new RuntimeException("sobrepasó el límite del modificador de defensa");
        }else{
            this.modificadorDefensa = modificadorDefensa;
        }
    }

    public List<String> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<String> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }
    
    public abstract void setNombre(String nombre);
    public abstract String getNombre();
    public abstract void setManejo(String manejo);
    public abstract String getManejo();
    public abstract void setCategoria(Categoria categoria);
    public abstract Categoria getCategoria();  
}
