/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public interface Habilidad {
    
    public void setNombre(String nombre);
    public void setValorAtaque(int valorAtaque);
    public void setValorDefensa(int valorDefensa); 
    public void setCostePuntosSangre(int costePuntosSangre);
    public void setRabiaMin(int rabiaMin);
    public int getRabiaMin();
    public int getCostePuntosSangre(); 
    public String getNombre();   
    public int getValorAtaque();
    public int getValorDefensa();
}
