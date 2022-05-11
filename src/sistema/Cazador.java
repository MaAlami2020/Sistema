/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mimit
 */
public class Cazador extends Personaje{
    private String nombre;
    private List<Arma> armasActivas = new ArrayList<>();
    private Armadura armaduraActiva;    
    private List<Arma> listaArmas = new ArrayList<>();
    private List<Armadura>listaArmaduras = new ArrayList<>(); 
    private List<Fortaleza> listaFortalezas = new ArrayList<>();
    private List<Debilidad> listaDebilidades = new ArrayList<>();
    private List<Esbirro> listaEsbirros = new ArrayList<>();  
    private int oro;
    private int salud;
    private int poder;
    private Habilidad habilidad;
    private int voulntad = 3;
    
    public Cazador(){
    }

    @Override
    public List<Esbirro> getListaEsbirros() {
        return listaEsbirros;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getOro() {
        return oro;
    }

    @Override
    public int getSalud() {
        return salud;
    }

    @Override
    public int getPoder() {
        return poder;
    }

    public boolean comprobarArmaEnLista(Arma arma){
        for(Arma a: listaArmas){
            if(a.equals(arma)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void setArmasActivas(Arma armaActiva) {
        int manejo = 2;
        if(comprobarArmaEnLista(armaActiva) & armasActivas.size() == 0 & armaActiva.getManejo().equals(manejo)){
            this.armasActivas.add(armaActiva);
        }else if(comprobarArmaEnLista(armaActiva) & armasActivas.size() == 0 & armaActiva.getManejo().equals(manejo--)){
            this.armasActivas.add(armaActiva);
        }else if(comprobarArmaEnLista(armaActiva) & armasActivas.size() == 1 & armaActiva.getManejo().equals(manejo--)){    
            this.armasActivas.add(armaActiva);
        }else{
            throw new RuntimeException("ha llegado al tope de armas activas");  
        }    
    }
    
    @Override
    public void setNuevasArmasActivas(int pos, Arma nuevaArmaActiva){
        if(pos == 0 | pos == 1){
            this.armasActivas.add(pos,nuevaArmaActiva);
        }else{
            throw new RuntimeException("posicion fuera del rango del tamaño del array");
        }
    }
    
    @Override
    public void setArmaduraActiva(Armadura armaduraActiva) {
        this.armaduraActiva = armaduraActiva;
    }

    @Override
    public void setListaArmas(Arma arma) {
        this.listaArmas.add(arma);
    }

    @Override
    public void setListaArmaduras(Armadura armadura) {
        this.listaArmaduras.add(armadura);
    }

    @Override
    public void setListaEsbirros(Esbirro esbirro) {
        this.listaEsbirros.add(esbirro);
    }

    @Override
    public void setListaFortalezas(Fortaleza fortaleza) {
        this.listaFortalezas = listaFortalezas;
    }

    @Override
    public void setListaDebilidades(Debilidad debilidad) {
        this.listaDebilidades = listaDebilidades;
    }
 
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void setOro(int oro) {
        this.oro = oro;
    }

    @Override
    public void setSalud(int salud) {
        this.salud = salud;
    }

    @Override
    public void setPoder(int poder) {
        this.poder = poder;
    }

    @Override
    public Habilidad getHabilidad() {
        return habilidad;
    }

    @Override
    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
    
    @Override
    public List<Arma> getListaArmas() {
        return listaArmas;
    }

    @Override
    public List<Arma> getArmasActivas() {
        return armasActivas;
    }

    @Override
    public List<Fortaleza> getListaFortalezas() {
        return listaFortalezas;
    }

    @Override
    public List<Debilidad> getListaDebilidades() {
        return listaDebilidades;
    }

    @Override
    public List<Armadura> getListaArmaduras() {
       return listaArmaduras;
    }

    @Override
    public Armadura getArmaduraActiva() {
        return armaduraActiva;
    }   

    @Override
    public int getRabia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getVoluntad() {
        return voulntad;
    }

    @Override
    public void setEdad(int edad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getEdad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setReservaPuntosSangre(int sangreAcum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getReservaPuntosSangre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRabia(int rabia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVoluntad(int voluntad) {
        this.voulntad = voluntad;
    }
    
}
