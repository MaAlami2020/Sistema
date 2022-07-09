/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author mimit
 */
public class Venta  implements Serializable{

    private Usuario vendedor;
    private Usuario comprador;
    private Equipo equipo;
    private List<Esbirro> esbirros;
    private LocalDate fecha;
    private double precio;

    public Venta(){
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Esbirro> getEsbirros() {
        return esbirros;
    }

    public void setEsbirros(List<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
