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
    //private String nombre;
    
    public abstract void setNombre(String nombre);
    public abstract void setEdad(int edad);
    public abstract void setOro(int oro) throws Exception;
    public abstract void setPoder(int pooder);                    
    public abstract void setSalud(int salud);
    public abstract String getNombre();
    public abstract int getEdad();
    public abstract int getOro();
    public abstract int getPoder();                    
    public abstract int getSalud();
    public abstract void setArmasActivas(Arma armaActiva);
    public abstract void setNuevasArmasActivas(int pos, Arma nuevaArmaActiva);
    public abstract void setArmaduraActiva(Armadura armaduraActiva);
    public abstract void setListaArmas(Arma arma);
    public abstract void setListaArmaduras(Armadura armadura);
    public abstract List<Arma> getListaArmas();
    public abstract List<Armadura> getListaArmaduras();
    public abstract List<Arma> getArmasActivas();
    public abstract Armadura getArmaduraActiva();
    public abstract void setListaEsbirros(Esbirro esbirro);
    public abstract List<Esbirro> getListaEsbirros();
    public abstract void setHabilidad(Habilidad habilidad); 
    public abstract Habilidad getHabilidad(); 
    public abstract void setReservaPuntosSangre(int sangreAcum); 
    public abstract int getReservaPuntosSangre();
    public abstract void setListaFortalezas(Fortaleza fortaleza);
    public abstract void setListaDebilidades(Debilidad debilidad);
    public abstract List<Fortaleza> getListaFortalezas();
    public abstract List<Debilidad> getListaDebilidades();
    public abstract void setRabia(int rabia);
    public abstract void setVoluntad(int voluntad);
    public abstract int getRabia();
    public abstract int getVoluntad();
}
