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

    public Talento(String nombre, int valorAtaque, int valorDefensa, int edad) {
        this.edad = edad;
        this.nombre = nombre;
        this.valorAtaque = valorAtaque;
        this.valorDefensa = valorDefensa;
    }
    
    public Talento(){
    }
    
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public void setCostePuntosSangre(int costePuntosSangre) {
        throw new RuntimeException("esta habilidad no tiene un coste"); 
    }

    @Override
    public int getCostePuntosSangre() {
        throw new RuntimeException("esta habilidad no tiene un coste");
    }

    @Override
    public void setRabiaMin(int rabiaMin) {
        throw new RuntimeException("esta habilidad no tiene rabia minima");
    }

    @Override
    public int getRabiaMin() {
        throw new RuntimeException("esta habilidad no tiene rabia minima"); 
    }

}
