/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Debilidad{
    private String nombre;
   private int sensibilidad;

    public Debilidad(String nombre, int sensibilidad) {
        this.nombre = nombre;
        this.sensibilidad = sensibilidad;
    }
   
   public void setNombre(String nombre){
      this.nombre =  nombre;
   } 

    public void setSensibilidad(int sensibilidadModif) {
       this.sensibilidad = sensibilidadModif;
    }

    public int getSensibilidad() {
        return sensibilidad;
    }

    public String getNombre() {
        return nombre;
    }   
}
