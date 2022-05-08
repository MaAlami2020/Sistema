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

    public Talento(int edad, String nombre, int valorAtaque, int valorDefensa) {
        this.edad = edad;
        this.nombre = nombre;
        this.valorAtaque = valorAtaque;
        this.valorDefensa = valorDefensa;
    }
    
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
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

    @Override
    public void setCostePuntosSangre(int costePuntosSangre) {
        throw new UnsupportedOperationException("esta habilidad no tiene coste"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCostePuntosSangre() {
        throw new UnsupportedOperationException("esta habilidad no tiene coste"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRabiaMin(int rabiaMin) {
        throw new UnsupportedOperationException("esta habilidad no tiene rabia minima"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRabiaMin() {
        throw new UnsupportedOperationException("esta habilidad no tiene rabia minima"); //To change body of generated methods, choose Tools | Templates.
    }

}
