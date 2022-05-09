/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

//import java.util.Scanner;
//import static sistema.Lealtad.ALTA;
//import static sistema.Lealtad.BAJA;
//import static sistema.Lealtad.NORMAL;

/**
 *
 * @author mimit
 */
public class Humano extends Esbirro{
    private String nombre;
    private int salud;
    private Lealtad lealtad;

    public Humano(String nombre, int salud, Lealtad lealtad) {
        this.nombre = nombre;
        this.salud = salud;
        this.lealtad = lealtad;
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
        this.salud = salud;
    }

    public Lealtad getLealtad() {
        return lealtad;
    }

    @Override
    public void setLealtad(Lealtad lealtad) {
        this.lealtad = lealtad;
    }

    @Override
    public void setDependencia(int dependenncia) {
        throw new UnsupportedOperationException("este esbirro no tiene una dependencia"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPacto(String pacto) {
        throw new UnsupportedOperationException("este esbirro no tiene un pacto"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPacto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDependencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
