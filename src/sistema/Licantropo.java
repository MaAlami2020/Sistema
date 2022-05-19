/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.ArrayList;
import java.util.List;

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
        if(comprobarArmaEnLista(armaActiva) & armasActivas.isEmpty() & armaActiva.getManejo().equals("2 manos")){
            this.armasActivas.add(armaActiva);
        }else if(comprobarArmaEnLista(armaActiva) & armasActivas.isEmpty() & armaActiva.getManejo().equals("1 mano")){
            this.armasActivas.add(armaActiva);
        }else if(comprobarArmaEnLista(armaActiva) & armasActivas.size() == 1 & armaActiva.getManejo().equals("1 mano")){    
            this.armasActivas.add(armaActiva);
        }else{
            throw new RuntimeException("ha llegado al tope de armas activas");  
        }    
    }
    
    @Override
    public void setNuevasArmasActivas(int pos, Arma nuevaArmaActiva){
        if( pos == 0 | pos == 1){         
           if(armasActivas.get(pos).getManejo().equals(nuevaArmaActiva.getManejo())){
               this.armasActivas.add(pos,nuevaArmaActiva);
           }else{
               throw new RuntimeException("no se pueden intercambiar las armas");
           }
        }else{
            throw new RuntimeException("fuera del limite de armas activas");
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

    public void setListaEsbirros(Esbirro esbirro) {
        this.listaEsbirros.add(esbirro);
    }

    @Override
    public void setListaFortalezas(Fortaleza fortaleza) {
        this.listaFortalezas = listaFortalezas;
    }

    public void setListaDebilidades(Debilidad debilidad) {
        this.listaDebilidades = listaDebilidades;
    }
 
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void setOro(double oro){
        if(oro >= 0){ 
            this.oro = oro;
        }else{
            throw new RuntimeException("la cantidad de oro no puede ser negativa");
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
        int rabiaMin = habilidad.getRabiaMin();
        if(rabiaMin != -1){
            this.habilidad = habilidad;
        }else{
            throw new RuntimeException("no tiene esta habilidad");
        }
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
        return -1;
    }

    @Override
    public void setEdad(int edad) {
        throw new RuntimeException("este personje no tiene edad"); 
    }

    @Override
    public int getEdad() {
        return -1;
    }

    @Override
    public void setReservaPuntosSangre(int sangreAcum) {
        throw new RuntimeException("este personaje no tiene puntos de sangre");
    }

    @Override
    public int getReservaPuntosSangre() {
        return -1; 
    }

    @Override
    public void setRabia(int rabia) {
        if(rabia <= 3){
           this.rabia = rabia;
        }else{
           throw new RuntimeException("ha llegado al tope de rabia");
        }  
    }

    @Override
    public void setVoluntad(int voluntad) {
        throw new RuntimeException("este personaje no tiene voluntad");
    }
}
