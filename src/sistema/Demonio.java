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
public class Demonio extends Esbirro{
    private String nombre;
    private int salud;
    private String pacto;
    protected List<Esbirro> hijos = new ArrayList<>();
    
    public Demonio(String nombre, int salud, String pacto) {
        this.nombre = nombre;
        this.salud = salud;
        this.pacto = pacto;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getSalud() {
        return salud;
    }

    @Override
    public void setSalud(int salud) {
        if(salud >= 1 & salud <= 3){
           this.salud = salud;
        }else{
           throw new RuntimeException("sobrepasa el valor limite de salud"); 
        }
    }

    @Override
    public String getPacto() {
        return pacto;
    }

    @Override
    public void setPacto(String pacto) {
        this.pacto = pacto;
    }
   
    @Override
    public void setDependencia(int dependenncia) {
        throw new RuntimeException("este esbirro  no tiene una dependencia"); 
    }

    @Override
    public void setLealtad(Lealtad lealtad) {
        throw new RuntimeException("este esbirro no tiene una lealtad"); 
    }

    @Override
    public Lealtad getLealtad() {
       return null;
    }

    @Override
    public int getDependencia() {
        return -1;
    }
}
