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
    
    public Vampiro(){
    }

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

    public int getEdad() {
        return edad;
    }

    @Override
    public double getOro(){
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
        //int manejo = 2;
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
        if(pos == 0 | pos == 1){
            if(armasActivas.get(pos).getManejo().equals(nuevaArmaActiva.getManejo())){
                this.armasActivas.add(pos,nuevaArmaActiva);
            }else{
                throw new RuntimeException("no se pueden intercambiar las armas");
            }
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
        Lealtad valorLealtad = esbirro.getLealtad();
        if(valorLealtad == null){
            this.listaEsbirros.add(esbirro);
        }else{
            throw new RuntimeException("este personaje no tiene esbirros humanos");
        }
    }

    @Override
    public void setListaFortalezas(Fortaleza fortaleza) {
        this.listaFortalezas.add(fortaleza);
    }

    @Override
    public void setListaDebilidades(Debilidad debilidad) {
        this.listaDebilidades.add(debilidad);
    }
 
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if(edad >= 0){
           this.edad = edad;
        }else{
           throw new RuntimeException("la edad no puede ser negativa");
        }
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

    /**
     * trato de distinguir al personaje segun el atributo que solo dispone este personaje, 
     * es decir, que si el valor del coste en puntos de sangre es -1 significa que esa habilidad no tiene un coste
     * y si la habilidad no tiene un coste entonces ese personaje no tiene esa habilidad
     * @param habilidad
     */
    @Override
    public void setHabilidad(Habilidad habilidad) { 
        int valorCoste = habilidad.getCostePuntosSangre();
        if(valorCoste != -1){
            this.habilidad = habilidad;
        }else{
            throw new RuntimeException("este personaje no tiene esta habilidad");
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
        return -1;
    }

    @Override
    public int getVoluntad() {
        return -1;
    }

    @Override
    public void setRabia(int rabia) {
        throw new RuntimeException("este personaje no tiene rabia"); 
    }

    @Override
    public void setVoluntad(int voluntad) {
        throw new RuntimeException("este personaje no tiene voluntad"); 
    }

}