/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;


/**
 *
 * @author mimit
 */
public class FabricacionCazador extends Fabrica{
    @Override
    public Personaje crearPersonaje(){
        return new Cazador();
    }
}
