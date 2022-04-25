/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistema;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mimit
 */
public class MenuInicio {
    private List<Usuario> userlist = new ArrayList<>();
    private List<Operador> operatorlist = new ArrayList<>();
    
    //public abstract void registrar_darBaja();
    //public abstract void entrar_salirSistema();

    public List<Usuario> getUserlist() {
        return userlist;
    }

    public List<Operador> getOperatorlist() {
        return operatorlist;
    }
    
    
}
