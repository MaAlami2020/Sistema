/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Talento extends Habilidad{
    private int edad;

    public Talento(String nombre, int valorAtaque, int valorDefensa, int edad) {
        super(nombre,valorAtaque,valorDefensa);
        this.edad = edad;
    }

    @Override
    public void setEdad(int edad) {
        if(edad >= 0){
           this.edad = edad;
        }else{
           throw new RuntimeException("la edad de adquisicion no puede tomar un valor negativo");
        }
    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setCostePuntosSangre(int costePuntosSangre) {
        throw new RuntimeException("esta habilidad no tiene un coste"); 
    }

    @Override
    public int getCostePuntosSangre() {
        return -1;
    }

    @Override
    public void setRabiaMin(int rabiaMin) {
        throw new RuntimeException("esta habilidad no tiene rabia minima");
    }

    @Override
    public int getRabiaMin() {
        return -1;
    }

}
