/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public abstract class Habilidad {
    private String nombre;
    private int valorAtaque;
    private int valorDefensa;
    
    public Habilidad(String nombre, int valorAtaque, int valorDefensa){
        this.nombre = nombre;
        this.valorAtaque = valorAtaque;
        this.valorDefensa = valorDefensa;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setValorAtaque(int valorAtaque){
        if(valorAtaque >= 1 & valorAtaque <= 3){
           this.valorAtaque = valorAtaque;
        }else{
           throw new RuntimeException("se sobrepasa el valor limite de valor de ataque");
        }
    }
    
    public void setValorDefensa(int valorDefensa){
        if(valorDefensa >= 1 & valorDefensa <= 3){
           this.valorDefensa = valorDefensa;
        }else{
           throw new RuntimeException("se sobrepasa el valor limite de valor de defensa"); 
        }
    } 
    
    public String getNombre(){
        return nombre;
    }   
    public int getValorAtaque(){
        return valorAtaque;
    }
    public int getValorDefensa(){
        return valorDefensa;
    }
    
    public abstract void setCostePuntosSangre(int costePuntosSangre);
    public abstract void setRabiaMin(int rabiaMin);
    public abstract int getRabiaMin();
    public abstract int getCostePuntosSangre();     
    public abstract void setEdad(int edad);
    public abstract int getEdad();
}
