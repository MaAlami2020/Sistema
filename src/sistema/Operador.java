/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mimit
 */
public class Operador extends MenuInicio{
    private String nombre;
    private String nick;
    private String password;
    private int index = 0;
    private List<Usuario> usuariosBaneados = new ArrayList<>();
    private Usuario usuarioDesafiante;
    private Usuario usuarioDesafiado;
    private int fortalezasVampiro;
    private int debilidadesVampiro;
    private int fortalezasLicantropo;
    private int debilidadesLicantropo;
    private int fortalezasCazador;
    private int debilidadesCazador;
    private List<Combate> listaCombates = new ArrayList<>(); 
    
    public Operador(String nombre, String nick, String password) {
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;
    }

    public Operador(){
        Usuario usuario = new Usuario();
        usuarioDesafiante = getUserlist().get(usuario.getIndex());
        usuarioDesafiado = usuario.getUsuarioDesafiar();
    }

    public List<Combate> getListaCombates() {
        return listaCombates;
    }

    public int getFortalezasVampiro() {
        return fortalezasVampiro;
    }

    public int getDebilidadesVampiro() {
        return debilidadesVampiro;
    }

    public int getFortalezasLicantropo() {
        return fortalezasLicantropo;
    }

    public int getDebilidadesLicantropo() {
        return debilidadesLicantropo;
    }

    public int getFortalezasCazador() {
        return fortalezasCazador;
    }

    public int getDebilidadesCazador() {
        return debilidadesCazador;
    }
    
    public List<Usuario> getUsuariosBaneados() {
        return usuariosBaneados;
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
      System.out.println("1.iniciar sesion");
      System.out.println("2.eliminar cuenta");
      System.out.println("escoga una opcion: ");
      int opcion = 0;
      if(opcion == 2){
        System.out.println("ingrese su nombre de usuario: ");
        Scanner sc = new Scanner(System.in);
        String nameOp = sc.next();
        System.out.println("ingrese su contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contraseniaOp = sc.next();
        for(Operador op: getOperatorlist()){
           if((nameOp.equals(op.getNombre()))&(contraseniaOp.equals(op.getPassword()))){
                getOperatorlist().remove(op);
                System.out.println("cuenta eliminada");
                entrar_salirSistema();
           }
        }
      }else if(opcion == 1){
        boolean operatorRegistered = false;
        System.out.println("ingrese su nombre: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        this.setNombre(name);
        System.out.println("ingrese su nick: ");
        sc = new Scanner(System.in);
        String apodo = sc.next();
        this.setNick(apodo);
        System.out.println("ingrese una contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contrasenia = sc.next();
        while((contrasenia.length() < 1)&(contrasenia.length() > 4)){
           System.out.println("Por favor, ingrese una nueva contrasenia (8-12 caracteres): ");
           sc = new Scanner(System.in);
           contrasenia = sc.next();
        }
        this.setPassword(contrasenia);
        
        for(Operador op: getOperatorlist()){
           if((op.getNombre().equals(name))&(op.getNick().equals(apodo))){
               operatorRegistered = true;
               System.out.println("usuario ya registrado");
               entrar_salirSistema();
               
           }
        }
        if(operatorRegistered == false){
            getOperatorlist().add(new Operador(name,apodo,contrasenia));  
            System.out.println("registrado/a corractamente");
            entrar_salirSistema();
        }
      }
    }
    
    public void seleccionarOpcionMenu(){
        System.out.println("***BIENVENIDO**");
        System.out.println("3.-editar un personaje");
        System.out.println("4.-validar desafio");
        System.out.println("5.-anadir atributos al personaje");
        System.out.println("6.-banear usuario");
        System.out.println("7.-desbanear usuario"); 
        System.out.println("escoga una opcion: ");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.next();
        Integer opc =Integer.parseInt(opcion);
        switch(opc){
            case 3:{
               editar_Personaje();
               break;
            }case 4:{
               validarDesafio();
               break;
            }case 5:{
               añadir_atributos_personaje();
               break;
            }case 6:{
               Usuario usuarioBaneado = null;
               banearUsuario(usuarioBaneado);
               break;
            }case 7:{
                Usuario usuarioDesbaneado = null;
               desbanearUsuario(usuarioDesbaneado);
               break;
            }

        }
    }
    
    public void editar_Personaje(){
        Vampiro vampiro = new Vampiro();
      Usuario user = usuarioDesafiado;
      while(user != null){ 
        System.out.println("usuario: " + user.getNombre());
        int opcion = 0;
        System.out.println("1.-cambiar nombre");
        System.out.println("2.-cambiar oro");
        System.out.println("3.-cambiar poder");
        System.out.println("4.-cambiar salud");
        if(user.getTipoPersonaje() == vampiro){
             System.out.println("5.-cambiar edad");
             System.out.println("seleccione una opcion -1,2,3,4 o 5-");
             Scanner sc = new Scanner(System.in);
             String selec = sc.next();
             opcion = Integer.parseInt(selec);
        }else if(user.getTipoPersonaje() != vampiro){
            System.out.println("seleccione una opcion -1,2,3 o 4-");
            Scanner sc = new Scanner(System.in);
            String selec = sc.next();
            opcion = Integer.parseInt(selec);
            if(opcion == 5){
               opcion = 0;
            }
        }
        switch(opcion){
            case 1:{
               user.getTipoPersonaje().anadirNombre();
               break;
            }case 2:{
               user.getTipoPersonaje().anadirOro();
               break;
            }case 3:{
               user.getTipoPersonaje().anadirPoder();
               break;
            }case 4:{
               user.getTipoPersonaje().anadirSalud();
               break;
            }case 5:{
                user.getTipoPersonaje().anadirEdad();
               break;
            }default:{
               System.out.println("seleccion erronea");
            }
             
        }
      }
      if(user == usuarioDesafiado){      
            user = usuarioDesafiante;        
      }else{
            user = null;
      }
      seleccionarOpcionMenu();  
    }
  
    
    public void validarDesafio(){
      Vampiro vampiro = new Vampiro();
      Licantropo licantropo = new Licantropo();
      Cazador cazador = new Cazador();
      Usuario user = usuarioDesafiado;
      while(user != null){ 
        if(user.getTipoPersonaje() == vampiro){
           for(Fortaleza fortaleza: user.getTipoPersonaje().getListaFortalezas()){
                fortalezasVampiro += fortaleza.getSensibilidad();  
           }
           for(Debilidad debilidad: user.getTipoPersonaje().getListaDebilidades()){
             debilidadesVampiro += debilidad.getSensibilidad();
           }
        }else if(user.getTipoPersonaje() == licantropo){
           for(Fortaleza fortaleza: user.getTipoPersonaje().getListaFortalezas()){
                fortalezasLicantropo += fortaleza.getSensibilidad();  
           }
           for(Debilidad debilidad: user.getTipoPersonaje().getListaDebilidades()){
               debilidadesLicantropo += debilidad.getSensibilidad();
           }
        }else if(user.getTipoPersonaje() == cazador){
           for(Fortaleza fortaleza: user.getTipoPersonaje().getListaFortalezas()){
                fortalezasCazador += fortaleza.getSensibilidad();  
           }
           for(Debilidad debilidad: user.getTipoPersonaje().getListaDebilidades()){
             debilidadesCazador += debilidad.getSensibilidad();
           }
        }
        user.getUsuarioDesafiar().getNotifDesafio().add("desafio pendiente");
        seleccionarOpcionMenu();
      }
      if(user == usuarioDesafiado){      
            user = usuarioDesafiante;        
      }else{
            user = null;
      }
  
    }
    
    public void añadir_atributos_personaje(){
        Usuario usuario = new Usuario();
        System.out.println("1.-añadir atributos al personaje de: " + usuarioDesafiante.getNombre());
        System.out.println("2.-añadir atributos al personaje de: " + usuarioDesafiado.getNombre());
        System.out.println("seleccione un opcion -1 o 2-");
        Scanner sc = new Scanner(System.in);
        String selec = sc.next();
        int opcion = Integer.parseInt(selec);
        if(opcion == 1){
            usuario = usuarioDesafiante;
        }else if(opcion == 2){
            usuario = usuarioDesafiado;
        }
        Vampiro vampiro = new Vampiro();
        System.out.println("1.-añadir arma");
        System.out.println("2.-añadir armadura");
        System.out.println("3.-añadir fortaleza");
        System.out.println("4.-añadir debilidad");
        System.out.println("5.-añadir ghoul");
        System.out.println("6.-añadir demonio");
        if(usuario.getTipoPersonaje() != vampiro){
            System.out.println("7.-añadir humano");
            System.out.println("seleccione un numero de opcion: ");
            sc = new Scanner(System.in);
            selec = sc.next();
            opcion = Integer.parseInt(selec);
        }else{
            System.out.println("seleccione un numero de opcion: ");
            sc = new Scanner(System.in);
            selec = sc.next();
            opcion = Integer.parseInt(selec);
            if(opcion == 7){
               opcion = 0;
            }
        }
        switch(opcion){
            case 1:{
               usuario.getTipoPersonaje().anadirArma();
               break;
            }case 2:{
               usuario.getTipoPersonaje().anadirArmadura();
               break;
            }case 3:{
               usuario.getTipoPersonaje().construirFortaleza();
               break;
            }case 4:{
               usuario.getTipoPersonaje().construirDebilidad();
               break;
            }case 5:{
                usuario.getTipoPersonaje().construirGhoul();
               break;
            }case 6:{
                usuario.getTipoPersonaje().construirDemonio();
               break;
            }case 7:{
                usuario.getTipoPersonaje().construirHumano();
               break;
            }default:{
               System.out.println("seleccion erronea");
            }
        }
        seleccionarOpcionMenu();
    }
    
    public void banearUsuario(Usuario usuarioBaneado){
        usuariosBaneados.add(usuarioBaneado);
        LocalDateTime horaActual = LocalDateTime.now();
        LocalDateTime hora = horaActual.minusHours(24);
        for(Usuario usBaneado: usuariosBaneados){
            for(Combate combate: listaCombates){
                usuarioDesafiante = combate.getUsuarioDesafiante();
                usuarioDesafiado = combate.getUsuarioDesafiado();
                if(usuarioDesafiante == combate.getUsuarioVencedor()){
                   if(usBaneado.getNombre() == usuarioDesafiado.getNombre()){
                      LocalDateTime horaCombate = combate.getFecha();
                      if(horaCombate.isBefore(hora)){
                        desbanearUsuario(usBaneado);
                      }
                   }   
                }else if(usuarioDesafiado == combate.getUsuarioVencedor()){
                   if(usBaneado.getNombre() == usuarioDesafiante.getNombre()){
                      LocalDateTime horaCombate = combate.getFecha();
                      if(horaCombate.isBefore(hora)){
                        desbanearUsuario(usBaneado);
                      }
                   } 
                }
            }
        }
    }
    
    public void desbanearUsuario(Usuario usuarioDesbaneado){
        usuariosBaneados.remove(usuarioDesbaneado);
    }
    
    public void entrar_salirSistema(){
        boolean opRegistered = false;
        System.out.println("ingrese su nombre de usuario: ");
        Scanner sc = new Scanner(System.in);
        String nameOp = sc.next();
        this.setNombre(nameOp);
        System.out.println("ingrese su contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contraseniaOp = sc.next();
        this.setPassword(contraseniaOp);
        for(Operador op: getOperatorlist()){
           if((nameOp.equals(op.getNombre()))&(contraseniaOp.equals(op.getPassword()))){
               opRegistered = true;
               index = getUserlist().indexOf(op);
               seleccionarOpcionMenu();
           }
        }
        if(opRegistered == false){
           System.out.println("usuario no registrado");
        }           
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
