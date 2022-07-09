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
    private List<Arma> listaArmas = new ArrayList<>();
    private List<Armadura>listaArmaduras = new ArrayList<>(); 
    private List<Esbirro> listaEsbirros = new ArrayList<>();  
    private double oro;
    
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
    public double getOro(){
        return oro;
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
        if(armaActiva != null){
            if(comprobarArmaEnLista(armaActiva) & armasActivas.isEmpty() & armaActiva.getManejo().equals("2 manos")){
                this.armasActivas.add(armaActiva);
            }else if(comprobarArmaEnLista(armaActiva) & armasActivas.isEmpty() & armaActiva.getManejo().equals("1 mano")){
                this.armasActivas.add(armaActiva);
            }else if(comprobarArmaEnLista(armaActiva) & armasActivas.size() == 1 & armaActiva.getManejo().equals("1 mano")){    
                this.armasActivas.add(armaActiva);
            }else{
                throw new RuntimeException("ha llegado al tope de armas activas");  
            } 
        }else{
            throw new RuntimeException("no registró ningún personaje");
        }
    }
    
//    @Override
//    public void setNuevasArmasActivas(int pos, Arma nuevaArmaActiva){
//        if(pos == 0 | pos == 1){
//            if(armasActivas.get(pos).getManejo().equals(nuevaArmaActiva.getManejo())){
//                this.armasActivas.set(pos,nuevaArmaActiva);
//            }else{
//                throw new RuntimeException("no se pueden intercambiar las armas");
//            }
//        }else{
//            throw new RuntimeException("posicion fuera del rango del tamaño del array");
//        }
//    }
       

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
        if(esbirro != null){
            Lealtad valorLealtad = esbirro.getLealtad();
            if(valorLealtad == null){
                this.listaEsbirros.add(esbirro);
            }else{
                throw new RuntimeException("este personaje no tiene esbirros humanos");
            }
        }else{
            throw new RuntimeException("este personaje no tiene esbirros humanos");
        }
    }
 
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
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
    public List<Arma> getListaArmas() {
        return listaArmas;
    }

    @Override
    public List<Arma> getArmasActivas() {
        return armasActivas;
    }

    @Override
    public List<Armadura> getListaArmaduras() {
       return listaArmaduras;
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