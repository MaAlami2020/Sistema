/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Don extends Habilidad{
 
    private int rabiaMin;

    public Don(String nombre, int valorAtaque, int valorDefensa, int rabiaMin) {
        nombreHab = nombre;
        valorAtaqueHab = valorAtaque;
        valorDefensaHab = valorDefensa;
        this.rabiaMin = rabiaMin;
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
    public void setCostePuntosSangre(int costePuntosSangre) {
        throw new RuntimeException("esta habilidad no tiene un coste"); 
    }

    @Override
    public int getCostePuntosSangre() {
        throw new RuntimeException("esta habilidad no tiene un coste"); 
    }

    @Override
    public void setEdad(int edad) {
        throw new RuntimeException("esta habilidad no tiene una edad de adquisicion"); 
    }

    @Override
    public int getEdad() {
        throw new RuntimeException("esta habilidad no tiene una edad de adquisicion");
    }
}
