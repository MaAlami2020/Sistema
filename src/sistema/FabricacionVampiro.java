/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;


/**
 *
 * @author mimit
 */
public class FabricacionVampiro extends Fabrica{
    @Override
    public Personaje crearPersonaje(){
        /*
        Vampiro vampiro = new Vampiro();
        vampiro.anadirNombre();
        vampiro.anadirEdad();
        vampiro.anadirSangreAcum();
        vampiro.construirHabilidad();
        String opc = null;
        do{
          vampiro.anadirArma();
          System.out.println("¿desea anadir otra arma? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        do{
          vampiro.anadirArmadura();
          System.out.println("¿desea anadir otra armadura? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        vampiro.anadirOro();
        vampiro.anadirPoder();
        vampiro.anadirSalud();
        do{
          vampiro.construirFortaleza();
          System.out.println("¿desea anadir otra fortaleza? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        do{
          vampiro.construirDebilidad();
          System.out.println("¿desea anadir otra debilidad? -si o no-");
          Scanner sc = new Scanner(System.in);
          opc = sc.next();
        }while(opc == "si");
        vampiro.construirGhoul();
        vampiro.construirDemonio();
        */
        return new Vampiro();
    }
}