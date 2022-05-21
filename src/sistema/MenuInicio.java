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

/**
 *
 * @author mimit
 */
public class MenuInicio implements Serializable{
    private List<Usuario> userlist = new ArrayList<>();
    private List<Operador> operatorlist = new ArrayList<>();
    private List<Usuario> listaUsuariosDesafiantes = new ArrayList<>();
    private List<Combate> listaCombates = new ArrayList<>();
    private List<Usuario> usuariosBaneados = new ArrayList<>();
    private List<Usuario> desafiosParaValidar = new ArrayList<>();
    
    public MenuInicio(){
        
    }
    
    public List<Usuario> getUserlist() {
        return userlist;
    }

    public List<Operador> getOperatorlist() {
        return operatorlist;
    }

    public List<Usuario> getListaUsuariosDesafiantes() {
        return listaUsuariosDesafiantes;
    }

    public List<Combate> getListaCombates() {
        return listaCombates;
    }

    public List<Usuario> getUsuariosBaneados() {
        return usuariosBaneados;
    }

    public List<Usuario> getDesafiosParaValidar() {
        return desafiosParaValidar;
    }
    
    public void serializar(Object obj){
       try{
           String fich = "C:\\Users\\mimit\\Sistema\\sistema.bin";
           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fich));
           out.writeObject(obj);
           out.close();
       }catch(Exception e){
           System.out.println(e);
       }
       System.out.println("informacion guardada");
    }
    /**
    public void serializar(){
       try{
           String fich = "C:\\Users\\mimit\\Sistema\\sistema.bin";
           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fich));
           out.writeObject(userlist);
           out.writeObject(operatorlist);
           out.writeObject(listaUsuariosDesafiantes);
           out.writeObject(listaCombates);
           out.close();
       }catch(Exception e){
           System.out.println(e);
       }
    }
    */
    
}
