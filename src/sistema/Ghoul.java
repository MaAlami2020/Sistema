/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;


/**
 *
 * @author mimit
 */
public class Ghoul extends Esbirro{
    private String nombre;
    private int salud;
    private int dependencia;

    public Ghoul(String nombre, int salud, int dependencia) {
        this.nombre = nombre;
        this.salud = salud;
        this.dependencia = dependencia;
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
           throw new RuntimeException("sobrepasa el  valor limite de salud");
        }
    }

    @Override
    public int getDependencia() {
        return dependencia;
    }

    @Override
    public void setDependencia(int dependencia) {
        if(dependencia >= 1 & dependencia <= 5){
           this.dependencia = dependencia;
        }else{
           throw new RuntimeException("sobrepasa el valor limite de dependencia");
        }
    }

    @Override
    public void setPacto(String pacto) {
        System.out.println("este esbirro no tiene un pacto");
    }

    @Override
    public void setLealtad(Lealtad lealtad) {
        System.out.println("este esbirro no tiene una lealtad");
    }

    @Override
    public Lealtad getLealtad() {
       return null;
    }

    @Override
    public String getPacto() {
        return "este esbirro no tiene un pacto";
    }
}
