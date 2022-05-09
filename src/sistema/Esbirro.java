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

    public abstract void setNombre(String nombre);
    public abstract void setSalud(int salud);
    public abstract void setDependencia(int dependenncia);
    public abstract void setPacto(String pacto);
    public abstract void setLealtad(Lealtad lealtad);    
    public abstract int getSalud();
    public abstract Lealtad getLealtad();
    public abstract String getPacto();
    public abstract int getDependencia();
}
