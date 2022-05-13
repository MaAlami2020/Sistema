/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import static sistema.Lealtad.ALTA;
import static sistema.Lealtad.BAJA;
import static sistema.Lealtad.NORMAL;

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
        if(salud >= 1 & salud <= 3){
            this.salud = salud;
        }else{
            throw new RuntimeException("sobrepasa el valor de salud permitido");
        }
    }

    public Lealtad getLealtad() {
        return lealtad;
    }

    @Override
    public void setLealtad(Lealtad lealtad) {
        if(lealtad == ALTA | lealtad == NORMAL | lealtad == BAJA){
            this.lealtad = lealtad;
        }else{
            throw new RuntimeException("valor de lealtad erroneo");
        }
    }

    @Override
    public void setDependencia(int dependenncia) {
        throw new RuntimeException("este esbirro no tiene una dependencia"); 
    }

    @Override
    public void setPacto(String pacto) {
        throw new RuntimeException("este esbirro no tiene un pacto");
    }

    @Override
    public String getPacto() {
        return "este esbirro no tiene un pacto";
    }

    @Override
    public int getDependencia() {
        return -1;
    }
     
}
