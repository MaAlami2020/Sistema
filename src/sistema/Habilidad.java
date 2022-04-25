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
    
    public int getValorAtaque();

    public int getValorDefensa();
}
