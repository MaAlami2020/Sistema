/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author mimit
 */
public class Arma {
   private String nombre;
    private int modificadorAtaque;
    private int modificadorDefensa;
    private String manejo;

    public Arma(String nombre, int modificadorAtaque, int modificadorDefensa, String manejo) {
        this.nombre = nombre;
        this.modificadorAtaque = modificadorAtaque;
        this.modificadorDefensa = modificadorDefensa;
        this.manejo = manejo;
    }

    public Arma() {
    }

    public void setNombre(String nombre) throws Exception{
        if(!nombre.equals(" ")){
            this.nombre = nombre;
        }else{
            throw new Exception("nombre invalido");
        }
    }

    public String getManejo() {       
        return manejo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setModificadorAtaque(int modificadorAtaque) throws Exception{
        if(modificadorAtaque < 1 | modificadorAtaque > 3){
            throw new Exception("sobrepasó el límite de modificador de ataque");
        }else{
            this.modificadorAtaque = modificadorAtaque;
        }
    }

    public int getModificadorAtaque() {
        return modificadorAtaque;
    }   
    
    public int getModificadorDefensa() {
        return modificadorDefensa;
    }

    public void setModificadorDefensa(int modificadorDefensa) throws Exception{
        if(modificadorDefensa < 0 | modificadorDefensa > 3){
            throw new Exception("sobrepasó el límite del modificador de defensa");
        }else{
            this.modificadorDefensa = modificadorDefensa;
        }
    }   
    
    public void setManejo(String manejo) throws Exception{
        if(!manejo.equals("1 mano") & !manejo.equals("2 manos")){
             throw new Exception("valor invalido");
        }
        this.manejo = manejo;
    } 
}
