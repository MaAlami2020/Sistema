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
    public void setEdad(int edad) {
        throw new RuntimeException("esta habilidad no tiene una edad de adquisicion"); 
    }

    @Override
    public int getEdad() {
        throw new RuntimeException("esta habilidad no tiene una edad de adquisicion");
    }
}
