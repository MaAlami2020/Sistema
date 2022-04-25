/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Debilidad extends Modificador{
   @Override
   public void setNombre(String nombreModif){
      nombre =  nombreModif;
   } 

    @Override
    public void setSensibilidad(int sensibilidadModif) {
       sensibilidad = sensibilidadModif;
    }

    public int getSensibilidad() {
        return sensibilidad;
    }

    public String getNombre() {
        return nombre;
    }
    
}
