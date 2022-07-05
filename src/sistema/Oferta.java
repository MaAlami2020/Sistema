/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Oferta {
    private Equipo equipoEnVenta = null;
    private Esbirro esbirrosParaTraspasar;
    private double precioVenta;

    public Equipo getEquipoEnVenta() {
        return equipoEnVenta;
    }

    public void setEquipoEnVenta(Equipo equipoEnVenta) {
        this.equipoEnVenta = equipoEnVenta;
    }

    public Esbirro getEsbirrosParaTraspasar() {
        return esbirrosParaTraspasar;
    }

    public void setEsbirrosParaTraspasar(Esbirro esbirrosParaTraspasar) {
        this.esbirrosParaTraspasar = esbirrosParaTraspasar;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
}
