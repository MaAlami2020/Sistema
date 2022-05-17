/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Armadura {
    private String nombre;
    private int modificadorAtaque;
    private int modificadorDefensa;

    public Armadura(String nombre, int modificadorAtaque, int modificadorDefensa) {
        this.nombre = nombre;
        this.modificadorAtaque = modificadorAtaque;
        this.modificadorDefensa = modificadorDefensa;
    }
    
    public Armadura(){

    }
    
    public void setNombre(String nombre) {
        if(nombre != " "){
            this.nombre = nombre;
        }else{
            throw new RuntimeException("nombre invalido");
        }
    }

    public String getNombre() {
        return nombre;
    }

    
    public void setModificadorAtaque(int modificadorAtaque){
        if(modificadorAtaque < 0 | modificadorAtaque > 3){
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
}
