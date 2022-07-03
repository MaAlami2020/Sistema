/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.List;

/**
 *
 * @author mimit
 */
public abstract class Personaje {
    
    public abstract void setNombre(String nombre);
    public abstract void setEdad(int edad);
    public abstract void setOro(double oro);
    public abstract String getNombre();
    public abstract int getEdad();
    public abstract double getOro();
    public abstract void setListaArmas(Arma arma);
    public abstract void setListaArmaduras(Armadura armadura);
    public abstract List<Arma> getListaArmas();
    public abstract List<Armadura> getListaArmaduras();
    public abstract void setListaEsbirros(Esbirro esbirro);
    public abstract List<Esbirro> getListaEsbirros();
    public abstract void setReservaPuntosSangre(int sangreAcum); 
    public abstract int getReservaPuntosSangre();
    public abstract void setRabia(int rabia);
    public abstract void setVoluntad(int voluntad);
    public abstract int getRabia();
    public abstract int getVoluntad();
}