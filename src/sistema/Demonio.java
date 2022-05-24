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
public class Demonio extends Esbirro{

    private String pacto;
    protected List<Esbirro> hijos = new ArrayList<>();
    
    public Demonio(String nombre, int salud, String pacto) {
        super(nombre,salud);
        this.pacto = pacto;
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
    
    @Override
    public void addHijos(Esbirro e){
        this.hijos.add(e);
    }
    @Override
    public List<Esbirro> getHijos() {
        return hijos;
    }
    
}
