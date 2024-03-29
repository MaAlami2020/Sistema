/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mimit
 */
public class Oferta implements Serializable{
    private Equipo equipoEnVenta = null;
    private List<Esbirro> esbirroParaTraspasar = new ArrayList<>();
    private double precioVenta;

    public Equipo getEquipoEnVenta() {
        return equipoEnVenta;
    }

    public void setEquipoEnVenta(Equipo equipoEnVenta) {
        this.equipoEnVenta = equipoEnVenta;
    }

    public List<Esbirro> getEsbirroParaTraspasar() {
        return esbirroParaTraspasar;
    }

    public void setEsbirroParaTraspasar(Esbirro esbirroT) {
        this.esbirroParaTraspasar.add(esbirroT);
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        if(precioVenta > 0){
            this.precioVenta = precioVenta;
        }else{
            throw new RuntimeException("el precio debe ser positivo");
        }
    }
    
    
}
