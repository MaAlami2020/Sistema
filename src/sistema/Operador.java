/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author mimit
 */
public class Operador implements Serializable{
    private String nombre;
    private String nick;
    private String password;
    private MenuInicio menu; 
    
    public Operador(String nombre, String nick, String password){
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;      
    }

    public Operador(MenuInicio menu){
        this.menu = menu;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreInicio) {
        this.nombre = nombreInicio;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nickInicio) {
        this.nick = nickInicio;
    }

    public void registrar_darBaja(){ 
      System.out.println("1.registrarse");
      System.out.println("2.eliminar cuenta");
      System.out.println("escoga una opcion: ");
      Scanner sc = new Scanner(System.in);
      String option = sc.next();
      int opcion =Integer.parseInt(option);
      if(opcion == 2){
        System.out.println("ingrese su nombre de usuario: ");
        sc = new Scanner(System.in);
        String nameOp = sc.next();
        String contraseniaOp = null;
        do{
            System.out.println("ingrese su contrasenia (8-12 caracteres): ");
            sc = new Scanner(System.in);
            contraseniaOp = sc.next();
        }while(contraseniaOp.length() < 8 || contraseniaOp.length() > 12);
        boolean cuentaEliminada = false;
        for(Operador op: menu.getOperatorlist()){
           if(nameOp.equals(op.getNombre()) && contraseniaOp.equals(op.getPassword())){
                menu.getOperatorlist().remove(op);
                System.out.println("cuenta eliminada");
                cuentaEliminada = true;
           }
        }
        if(cuentaEliminada == false){
            System.out.println("no esta registrado");
        }
      }else if(opcion == 1){
        boolean operatorRegistered = false;
        System.out.println("ingrese su nombre: ");
        sc = new Scanner(System.in);
        String name = sc.next();
        this.setNombre(name);
        System.out.println("ingrese su nick: ");
        sc = new Scanner(System.in);
        String apodo = sc.next();
        this.setNick(apodo);
        System.out.println("ingrese una contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contrasenia = sc.next();
        actualizarContrasenia(contrasenia);
        while(contrasenia.length() < 8 || contrasenia.length() > 12){
           System.out.println("Por favor, ingrese una nueva contrasenia (8-12 caracteres): ");
           sc = new Scanner(System.in);
           contrasenia = sc.next();
           actualizarContrasenia(contrasenia);
        }
        for(Operador op: menu.getOperatorlist()){
           if(op.getNombre().equals(name) && op.getPassword().equals(contrasenia)){
               operatorRegistered = true;
               System.out.println("usuario ya registrado");
               entrar_salirSistema();
               
           }
        }
        if(operatorRegistered == false){
            Operador operador = new Operador(name,apodo,contrasenia);
            menu.setOperatorlist(operador);
            serializar(operador);
            
            System.out.println("registrado/a corractamente");
            entrar_salirSistema();
        }
      }
    }
    
    public void seleccionarOpcionMenu(){
        int opc = 0;
        do{
            System.out.println("***BIENVENIDO**");
            System.out.println("3.-consultar las ventas realizadas");
            System.out.println("4.-validar las ofertas publicadas");
            System.out.println("5.-banear usuario");
            System.out.println("6.-desbanear usuario");
            System.out.println("7.-salir del sistema");
            System.out.println("escoga una opcion: ");
            Scanner sc = new Scanner(System.in);
            String opcion = sc.next();
            opc =Integer.parseInt(opcion);
            
            if(opc >= 3 && opc <= 7){
                switch(opc){
                    case 3:{
                        consultarVentas();
                        break;
                    }case 4:{
                        validarOfertas();
                        break;
                    }case 5:{
                        banearUsuario();
                        break;
                    }case 6:{
                        desbanearUsuario();
                        break;
                    }
                }
            }else{
                System.out.println("seleccion erronea");
            }
        }while(opc != 7);
    }
    
    public void consultarVentas(){
        for(Venta venta: menu.getVentas()){
            System.out.println(venta.getFecha());
            System.out.println("comprador: " + venta.getComprador().getNombre() + " - " + "vendedor:" + venta.getVendedor().getNombre());
            System.out.println(venta.getPrecio());
            System.out.println();
        }
    }
    
    public void validarOfertas(){
        for(Oferta ofertaPendiente: menu.getOfertasPendientes()){
            menu.setOfertasValidadas(ofertaPendiente);
            System.out.println("validacion realizada");
        } 
        menu.getOfertasPendientes().clear();
    }  
    /**
     * el operador puede banear a un usuario siempre y cuando éste haya perdido un combate en las ultimas 24h
     */
    /**
     * si se ha realizado una venta el dia actual o el anterior el operador puede
     * banear al vendedor y este no puede realizar ninguna venta hasta que sea desbaneado
     */
    public void banearUsuario(){
        LocalDate fechaActual = LocalDate.now();
        LocalDate diaAnterior = fechaActual.minusDays(1);
        for(Venta venta: menu.getVentas()){
            LocalDate fechaVenta = venta.getFecha();
            if(fechaActual.equals(fechaVenta) && diaAnterior.equals(fechaVenta)){
                menu.setUsuariosBaneados(venta.getVendedor());
            }
        }
        System.out.println("lista de usuarios baneados actualizada");
    }
    
    public void desbanearUsuario(){
        LocalDate fechaActual = LocalDate.now();
        LocalDate diaAnterior = fechaActual.minusDays(1);
        for(Usuario usuarioBaneado: menu.getUsuariosBaneados()){
            for(Venta venta: menu.getVentas()){
                LocalDate fechaVenta = venta.getFecha();
                if(usuarioBaneado.equals(venta.getVendedor()) && !fechaActual.equals(fechaVenta) && !diaAnterior.equals(fechaVenta)){
                    menu.getUsuariosBaneados().remove(usuarioBaneado);
                }
            }
        }
        System.out.println("lista de usuarios desbaneados actualizada");
    }
    
    //@Override
    public void entrar_salirSistema(){
      System.out.println("1.-entrar en el sistema");
      System.out.println("2.-salir del sistema");
      System.out.println("seleccione una opcion: -1 o 2-");
      Scanner sc = new Scanner(System.in);
      String opcion = sc.next();

      int opc = Integer.parseInt(opcion);
      if(opc == 1){
        boolean opRegistered = false;
        System.out.println("ingrese su nombre de usuario: ");
        sc = new Scanner(System.in);
        String nameOp = sc.next();
        this.setNombre(nameOp);
        System.out.println("ingrese su contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contraseniaOp = sc.next();
        this.setPassword(contraseniaOp);
        for(Operador op: menu.getOperatorlist()){
           if(nameOp.equals(op.getNombre()) && contraseniaOp.equals(op.getPassword())){
               opRegistered = true;
               seleccionarOpcionMenu();
           }
        }
        if(opRegistered == false){
           System.out.println("usuario no registrado");
        }
      }else if(opc == 2){
          System.out.println("saliendo del sistema");
      }
    }

    public String getPassword() {
        return password;
    }
    
    public void actualizarContrasenia(String password){
        try{
            setPassword(password);
        }catch(RuntimeException e){
            System.out.println("la longitud de la contrasenia esta fuera del tamaño permtido");
        }
    }

    public void setPassword(String password){
        if(password.length() >= 8 & password.length() <= 12){
            this.password = password;
        }else{
            throw new RuntimeException("longitud de la contrasenia fuera del rango[8-12]"); 
        }
    }

    public void serializar(Operador op){
       try{
           String fich = "D://Sistema//fichero.bin";
           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fich));
           out.writeObject(op);
           out.close();
       }catch(IOException e){
           System.out.println(e);
       }
    } 
}
