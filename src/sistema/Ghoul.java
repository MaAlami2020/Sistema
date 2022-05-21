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

    private int dependencia;

    public Ghoul(String nombre, int salud, int dependencia) {
        super(nombre,salud);
        this.dependencia = dependencia;
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
        throw new RuntimeException("este esbirro no tiene un pacto");
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
    public String getPacto() {
        return null;
    }
}
