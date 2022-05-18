/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Disciplina extends Habilidad{

    private int costePuntosSangre;

    public Disciplina(String nombre, int valorAtaque, int valorDefensa, int costePuntosSangre) {
        super(nombre,valorAtaque,valorDefensa);
        this.costePuntosSangre = costePuntosSangre;
    }

    @Override
    public void setCostePuntosSangre(int costePuntosSangre) {
        if(costePuntosSangre  >= 1 & costePuntosSangre <= 3){
           this.costePuntosSangre = costePuntosSangre;
        }else{
           throw new RuntimeException("se sobrepasa el valor limite del coste de puntos de sangre");
        }
    }

    @Override
    public int getCostePuntosSangre() {
        return costePuntosSangre;
    }

    @Override
    public void setRabiaMin(int rabiaMin) {
        throw new RuntimeException("esta habilidad no tiene rabia minima"); 
    }

    @Override
    public int getRabiaMin() {
        return -1;
    }

    @Override
    public void setEdad(int edad) {
        throw new RuntimeException("esta habilidad no tiene una edad de adquisicion");
    }

    @Override
    public int getEdad() {
        return -1;
    }

}
