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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getPacto() {
        return pacto;
    }

    public void setPacto(String pacto) {
        this.pacto = pacto;
    }
   
    @Override
    public void setDependencia(int dependenncia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLealtad(Lealtad lealtad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
