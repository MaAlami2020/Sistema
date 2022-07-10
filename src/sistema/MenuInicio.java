/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistema;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mimit
 */
public class MenuInicio implements Serializable{
    private List<Usuario> userlist;
    private List<Operador> operatorlist = new ArrayList<>();
    private List<Usuario> usuariosBaneados;
    private List<Oferta> ofertasPendientes = new ArrayList<>();
    private List<Oferta> ofertasValidadas = new ArrayList<>();
    private List<Usuario> usuariosActuales;
    private List<Venta> ventas = new ArrayList<>();
    
    public MenuInicio(){
        this.userlist = new ArrayList<>();
        this.usuariosBaneados = new ArrayList<>();
        this.usuariosActuales = new ArrayList<>();
    }

    public List<Usuario> getUsuarioActual() {
        return usuariosActuales;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuariosActuales.add(usuarioActual);
    }
    
    public void acceder(){
      Usuario user = new Usuario(this);
      Operador operador = new Operador(this);
      
      
      int seleccion = 0;  
      do{  
        int opcion1 = 0;
        do{
           System.out.println("1.-operador");
           System.out.println("2.-usuario");
           System.out.println("3.-salir de la app");
           System.out.println("escoga una opcion -1, 2 o 3-: ");
           Scanner sc1 = new Scanner(System.in);
           String opcion = sc1.next();
           opcion1 = Integer.valueOf(opcion);
        } while((opcion1 != 1)&(opcion1 != 2)&(opcion1 != 3));
        if(opcion1 != 3){
           System.out.println("1.-registrarse/darse de baja");
           System.out.println("2.-entrar/salir del sistema");
           System.out.println("escoga una opcion: ");
           Scanner sc2 = new Scanner(System.in); 
           String  opcion = sc2.next();

           int opcion2 = Integer.parseInt(opcion);
           if((opcion1 == 1)&(opcion2 == 1)){
               operador.registrar_darBaja();
           }else if((opcion1 == 1)&(opcion2 == 2)){
               operador.entrar_salirSistema();
           }else if((opcion1 == 2)&(opcion2 == 1)){
               user.registrar_darBaja();
           }else if((opcion1 == 2)&(opcion2 == 2)){
               user.entrar_salirSistema();
           }
        }else{
           seleccion = 0;
        }
      }while(seleccion != 3);
    
    }
    
    public List<Usuario> getUserlist() {
        return userlist;
    }

    public List<Operador> getOperatorlist() {
        return operatorlist;
    }

    public List<Usuario> getUsuariosBaneados() {
        return usuariosBaneados;
    }
    
    public void setUserlist(Usuario user) {
        this.userlist.add(user);
    }
    
    public void setOperatorlist(Operador operator) {
        this.operatorlist.add(operator);
    }

    public void setUsuariosBaneados(Usuario usuarioBaneado) {
        this.usuariosBaneados.add(usuarioBaneado);
    }

    public List<Oferta> getOfertasPendientes() {
        return ofertasPendientes;
    }

    public void setOfertasPendientes(Oferta ofertaPendiente) {
        this.ofertasPendientes.add(ofertaPendiente);
    }

    public List<Oferta> getOfertasValidadas() {
        return ofertasValidadas;
    }

    public void setOfertasValidadas(Oferta ofertaValidada) {
        this.ofertasValidadas.add(ofertaValidada);
    }


    
    public void updateUser(Usuario us, Personaje per){
        for(Usuario usuario: userlist){
            if(usuario.getNombre().equals(us.getNombre()) & usuario.getPassword().equals(us.getPassword())){
                usuario.setTipoPersonaje(per);
            }
        }    
    }
    
    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Venta venta) {
        this.ventas.add(venta);
    }
     
    public void serializeMenu() {//se escribe en el fichero out y se le trae el objeto mState
        try {
            String fich = System.getProperty("user.dir") + "\\menu.bin";
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fich));
            out.writeObject(this);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
