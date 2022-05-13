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
    
    public Disciplina() {
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setValorAtaque(int valorAtaque) {
        if(valorAtaque >= 1 & valorAtaque <= 3){
           this.valorAtaque = valorAtaque;
        }else{
           throw new RuntimeException("se sobrepasa el valor limite de valor de ataque");
        }
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
        if(valorDefensa >= 1 & valorDefensa <= 3){
           this.valorDefensa = valorDefensa;
        }else{
           throw new RuntimeException("se sobrepasa el valor limite de valor de defensa"); 
        }
    }

    @Override
    public void setRabiaMin(int rabiaMin) {
        throw new RuntimeException("esta habilidad no tiene rabia minima"); 
    }

    @Override
    public int getRabiaMin() {
        throw new RuntimeException("esta habilidad no retorna rabia minima"); 
    }

    @Override
    public void setEdad(int edad) {
        throw new RuntimeException("esta habilidad no tiene una edad de adquisicion");
    }

    @Override
    public int getEdad() {
        throw new RuntimeException("esta habilidad no retorna una edad de adquisicion");
    }
}
