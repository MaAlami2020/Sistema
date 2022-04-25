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
public abstract class Personaje {
    //private String nombre;
    
    public abstract String getNombre();
    public abstract int getEdad();
    public abstract int getOro();
    public abstract int getPoder();                    
    public abstract int getSalud();
    public abstract Habilidad construirHabilidad();  
    public abstract void anadirArma();
    public abstract void anadirArmadura();
    public abstract void anadirNombre();
    public abstract void anadirEdad();
    public abstract int anadirOro();
    public abstract int anadirSalud();
    public abstract List<Arma> getListaArmas();
    public abstract List<Armadura> getListaArmaduras();
    public abstract int anadirPoder();
    public abstract List<Arma> getArmasActivas();
    public abstract List<Armadura> getArmadurasActivas();
    public abstract List<Fortaleza> getListaFortalezas();
    public abstract List<Debilidad> getListaDebilidades();
    public abstract Ghoul construirGhoul();
    public abstract Demonio construirDemonio();
    public abstract Humano construirHumano();
    public abstract void construirFortaleza();
    public abstract void construirDebilidad();
    
}
