/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.Serializable;

/**
 *
 * @author mimit
 */
public abstract class Fabrica implements Serializable{
    
    public abstract Personaje crearPersonaje();
    
}
