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
    protected String nombreHab;
    protected int valorAtaqueHab;
    protected int valorDefensaHab;
    
    public void setNombre(String nombre){
        this.nombreHab = nombre;
    }
    
    public void setValorAtaque(int valorAtaque){
        if(valorAtaque >= 1 & valorAtaque <= 3){
           this.valorAtaqueHab = valorAtaque;
        }else{
           throw new RuntimeException("se sobrepasa el valor limite de valor de ataque");
        }
    }
    
    public void setValorDefensa(int valorDefensa){
        if(valorDefensa >= 1 & valorDefensa <= 3){
           this.valorDefensaHab = valorDefensa;
        }else{
           throw new RuntimeException("se sobrepasa el valor limite de valor de defensa"); 
        }
    } 
    
    public String getNombre(){
        return nombreHab;
    }   
    public int getValorAtaque(){
        return valorAtaqueHab;
    }
    public int getValorDefensa(){
        return valorDefensaHab;
    }
    
    public abstract void setCostePuntosSangre(int costePuntosSangre);
    public abstract void setRabiaMin(int rabiaMin);
    public abstract int getRabiaMin();
    public abstract int getCostePuntosSangre();     
    public abstract void setEdad(int edad);
    public abstract int getEdad();
}
