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
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    
    public void setModificadorAtaque(int modificadorAtaque) {
        this.modificadorAtaque = modificadorAtaque;
    }

    public int getModificadorAtaque() {
        return modificadorAtaque;
    }

    
    
    public int getModificadorDefensa() {
        return modificadorDefensa;
    }

    public void setModificadorDefensa(int modificadorDefensa) {
        this.modificadorDefensa = modificadorDefensa;
    } 
}
