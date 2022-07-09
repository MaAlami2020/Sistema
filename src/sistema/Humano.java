/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.List;
import static sistema.Lealtad.ALTA;
import static sistema.Lealtad.BAJA;
import static sistema.Lealtad.NORMAL;

/**
 *
 * @author mimit
 */
public class Humano extends Esbirro{
    private Lealtad lealtad;

    public Humano(String nombre, int salud, Lealtad lealtad) {
        super(nombre,salud);
        this.lealtad = lealtad;
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

    @Override
    public void addHijos(Esbirro e) {
        throw new RuntimeException("este esbirro no inserta otros esbirros"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Esbirro> getHijos() {
        return null;
    }
     
}
