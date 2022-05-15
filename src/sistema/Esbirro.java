/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public abstract class Esbirro {
    private String nombre;
    private int salud;
    
    public Esbirro(String nombre,int salud){
        this.nombre = nombre;
        this.salud = salud;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setSalud(int salud){
        this.salud = salud;
    }
    
    public abstract void setDependencia(int dependenncia);
    public abstract void setPacto(String pacto);
    public abstract void setLealtad(Lealtad lealtad); 
    
    public String getNombre(){
       return nombre;
    }
    
    public int getSalud(){
        return salud;
    }
    public abstract Lealtad getLealtad();
    public abstract String getPacto();
    public abstract int getDependencia();
}
