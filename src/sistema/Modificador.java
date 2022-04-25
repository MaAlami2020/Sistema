/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public abstract class Modificador {
    protected int sensibilidad;
    protected String nombre;
    
    public abstract void setNombre(String nombreModif);
    public abstract void setSensibilidad(int sensibilidadModif);
    
}
