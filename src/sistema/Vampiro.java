/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mimit.java
 */
public class Vampiro extends Personaje{
    private String nombre;
    private int reservaPuntosSangre;
    private int edad;
    private Arma [] armasActivas = new Arma [2];
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
    
    public Vampiro(){
    }

    @Override
    public int getReservaPuntosSangre() {
        return reservaPuntosSangre;
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
    public int getEdad() {
        return edad;
    }

    @Override
    public int getOro(){
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
    public void setReservaPuntosSangre(int reservaPuntosSangre) {
        int sangreAcum = reservaPuntosSangre;
        if(sangreAcum < 0){
            this.reservaPuntosSangre = 0;
        }else if(sangreAcum <= 10){
            this.reservaPuntosSangre = reservaPuntosSangre;
        }else{
            throw new RuntimeException("sobrepasa el valor maximo de la reserva de puntos de sangre");
        }
    }

    @Override
    public void setArmasActivas(Arma [] armasActivas) {
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
    public void setListaEsbirros(Esbirro esbirro) {
        Lealtad valorLealtad = esbirro.getLealtad();
        this.listaEsbirros.add(esbirro);
        
        int valorCoste = habilidad.getCostePuntosSangre();
        String coste = String.valueOf(valorCoste);
        if(!coste.equals("esta habilidad no tiene coste")){
            this.habilidad = habilidad;
        }
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
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public void setOro(int oro) throws Exception{
        if(oro >= 0){ 
            this.oro = oro;
        }else{
            throw new Exception("la cantidad de oro no puede ser negativa");
        }
    }

    @Override
    public void setSalud(int salud) {
        if(salud < 0 | salud > 5){
            throw new RuntimeException("sobrepasó el límite de salud permitida");
        }else{
            this.salud = salud;
        }
    }

    @Override
    public void setPoder(int poder){
        if(poder < 1 | poder > 5){
            throw new RuntimeException("sobrepasó el límite de poder permitido");
        }else{
            this.poder = poder;
        }
    }

    @Override
    public Habilidad getHabilidad() {
        return habilidad;
    }

    @Override
    public void setHabilidad(Habilidad habilidad) {
        //distinguir al personaje segun el atributo que solo dispone este personaje, es decir que no se null    
        int valorCoste = habilidad.getCostePuntosSangre();
        String coste = String.valueOf(valorCoste);
        if(!coste.equals("esta habilidad no tiene coste")){
            this.habilidad = habilidad;
        }
    }
    
    @Override
    public List<Arma> getListaArmas() {
        return listaArmas;
    }

    @Override
    public Arma [] getArmasActivas() {
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
        throw new UnsupportedOperationException("este personaje no tiene rabia");
    }

    @Override
    public int getVoluntad() {
        throw new UnsupportedOperationException("este personaje no tiene voluntad");
    }

    @Override
    public void setRabia(int rabia) {
        throw new UnsupportedOperationException("este personaje no tiene rabia");
    }

    @Override
    public void setVoluntad(int voluntad) {
        throw new UnsupportedOperationException("este personaje no tiene voluntad");
    }

}
