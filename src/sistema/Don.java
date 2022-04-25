/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Don implements Habilidad{
    private String nombre;
    private int valorAtaque;
    private int valorDefensa;
    private int rabiaMin;

    public int getRabiaMin() {
        return rabiaMin;
    }

    public void setRabiaMin(int rabiaMin) {
        this.rabiaMin = rabiaMin;
    }
    
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
