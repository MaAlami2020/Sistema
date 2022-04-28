/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mimit
 */
public abstract class MenuInicio{
    protected List<Usuario> userlist = new ArrayList<>();
    protected List<Operador> operatorlist = new ArrayList<>();

    public MenuInicio() throws FileNotFoundException, IOException{
        
    }

    public abstract void registrar_darBaja();
    public abstract void entrar_salirSistema();
    
    public List<Usuario> getUserlist() {
        return userlist;
    }

    public List<Operador> getOperatorlist() {
        return operatorlist;
    }
    
}
