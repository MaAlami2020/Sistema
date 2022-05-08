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
public class Licantropo extends Personaje{
    private String nombre;
    private List<Arma> armasActivas = new ArrayList<>();
    private Armadura armaduraActiva;    
    private List<Arma> listaArmas = new ArrayList<>();
    private List<Armadura>listaArmaduras = new ArrayList<>(); 
    private List<Fortaleza> listaFortalezas = new ArrayList<>();
    private List<Debilidad> listaDebilidades = new ArrayList<>();
    private List<Esbirro> listaEsbirros = new ArrayList<>();  
    private double oro;
    private int salud;
    private int poder;
    private Habilidad habilidad;
    private int rabia = 0;
    
    public Licantropo(){
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

    public double getOro() {
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

    @Override
    public void setArmasActivas(List<Arma> armasActivas) {
        this.armasActivas = armasActivas;
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
    public void setListaEsbirros(List<Esbirro> listaEsbirros) {
        this.listaEsbirros = listaEsbirros;
    }

    @Override
    public void setListaFortalezas(List<Fortaleza> listaFortalezas) {
        this.listaFortalezas = listaFortalezas;
    }

    @Override
    public void setListaDebilidades(List<Debilidad> listaDebilidades) {
        this.listaDebilidades = listaDebilidades;
    }
 
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void setOro(double oro) {
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
         return rabia;
    }

    @Override
    public int getVoluntad() {
        throw new UnsupportedOperationException("este personaje no tiene voluntad"); 
    }

    @Override
    public void setEdad(int edad) {
        throw new UnsupportedOperationException("este personje no tiene edad"); 
    }

    @Override
    public int getEdad() {
        throw new UnsupportedOperationException("este personaje no tiene edad");
    }

    @Override
    public void setReservaPuntosSangre(int sangreAcum) {
        throw new UnsupportedOperationException("este personaje no tiene puntos de sangre"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getReservaPuntosSangre() {
        throw new UnsupportedOperationException("este personaje no tiene puntos de sangre"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRabia(int rabia) {
        this.rabia = rabia;
    }

    @Override
    public void setVoluntad(int voluntad) {
        throw new UnsupportedOperationException("este personaje no tiene voluntad");
    }
}
