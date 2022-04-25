/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Talento implements Habilidad{
    private int edad;
    private String nombre;
    private int valorAtaque;
    private int valorDefensa;
    
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void setValorAtaque(int valorAtaque) {
        this.valorAtaque = valorAtaque;
    }

    @Override
    public int getValorAtaque() {
        return valorAtaque;
    }

    @Override
    public int getValorDefensa() {
        return valorDefensa;
    }

    @Override
    public void setValorDefensa(int valorDefensa) {
        this.valorDefensa = valorDefensa;
    }
}
