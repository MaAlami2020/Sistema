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
    protected List<Usuario> userlist = new ArrayList<>();
    protected List<Operador> operatorlist = new ArrayList<>();
    protected List<Usuario> listaUsuariosDesafiantes = new ArrayList<>();
    protected List<Combate> listaCombates = new ArrayList<>();

    public MenuInicio(){// throws FileNotFoundException, IOException{
        
    }

    //public abstract void registrar_darBaja();
    //public abstract void entrar_salirSistema();
    
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
