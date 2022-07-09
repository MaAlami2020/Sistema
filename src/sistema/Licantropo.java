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
    private List<Arma> listaArmas = new ArrayList<>();
    private List<Armadura>listaArmaduras = new ArrayList<>(); 
    private List<Esbirro> listaEsbirros = new ArrayList<>();  
    private double oro;
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
//    
//    @Override
//    public void setNuevasArmasActivas(int pos, Arma nuevaArmaActiva){
//        if( pos == 0 | pos == 1){         
//           if(armasActivas.get(pos).getManejo().equals(nuevaArmaActiva.getManejo())){
//               this.armasActivas.add(pos,nuevaArmaActiva);
//           }else{
//               throw new RuntimeException("no se pueden intercambiar las armas");
//           }
//        }else{
//            throw new RuntimeException("fuera del limite de armas activas");
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
        this.listaEsbirros.add(esbirro);
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
