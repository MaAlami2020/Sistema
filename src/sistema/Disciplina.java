/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Disciplina implements Habilidad{
    private String nombre;
    private int valorAtaque;
    private int valorDefensa;
    private int costePuntosSangre;

    public Disciplina(String nombre, int valorAtaque, int valorDefensa, int costePuntosSangre) {
        this.nombre = nombre;
        this.valorAtaque = valorAtaque;
        this.valorDefensa = valorDefensa;
        this.costePuntosSangre = costePuntosSangre;
    }

    public void setCostePuntosSangre(int costePuntosSangre) {
        this.costePuntosSangre = costePuntosSangre;
    }

    public int getCostePuntosSangre() {
        return costePuntosSangre;
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
    public void setRabiaMin(int rabiaMin) {
        throw new UnsupportedOperationException("esta habilidad no tiene rabia minima"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRabiaMin() {
        throw new UnsupportedOperationException("esta habilidad no tiene rabia minima"); //To change body of generated methods, choose Tools | Templates.
    }
}
