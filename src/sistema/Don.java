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

    public Don(String nombre, int valorAtaque, int valorDefensa, int rabiaMin) {
        this.nombre = nombre;
        this.valorAtaque = valorAtaque;
        this.valorDefensa = valorDefensa;
        this.rabiaMin = rabiaMin;
    }
    
    public Don(){
    }
    
    @Override
    public int getRabiaMin() {
        return rabiaMin;
    }

    @Override
    public void setRabiaMin(int rabiaMin) {
        this.rabiaMin = rabiaMin;
    }
    
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
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
        throw new UnsupportedOperationException("esta habilidad no tiene un coste"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCostePuntosSangre() {
        throw new UnsupportedOperationException("esta habilidad no tiene un coste"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEdad(int edad) {
        throw new UnsupportedOperationException("esta habilidad no tiene una edad"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEdad() {
        throw new UnsupportedOperationException("esta habilidad no tiene una edad"); //To change body of generated methods, choose Tools | Templates.
    }
}
