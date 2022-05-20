/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.time.LocalDateTime;
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
    private List<Usuario> usuariosBaneados = new ArrayList<>();
    private int fortalezasVampiro;
    private int debilidadesVampiro;
    private int fortalezasLicantropo;
    private int debilidadesLicantropo;
    private int fortalezasCazador;
    private int debilidadesCazador;
     
    
    public Operador(String nombre, String nick, String password){
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;      
    }

    public Operador(){
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

    //@Override
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
            serializar(this);
            System.out.println("registrado/a corractamente");
            entrar_salirSistema();
        }
      }
    }
    
    public void seleccionarOpcionMenu(){
        int opc = 0;
        do{
           System.out.println("***BIENVENIDO**");
           System.out.println("3.-editar un personaje");
           System.out.println("4.-validar desafio");
           System.out.println("5.-anadir atributos al personaje");
           System.out.println("6.-banear usuario");
           System.out.println("7.-desbanear usuario");
           System.out.println("8.-salir del sistema");
           System.out.println("escoga una opcion: ");
           Scanner sc = new Scanner(System.in);
           String opcion = sc.next();
           opc =Integer.parseInt(opcion);
        }while(opc < 3 | opc > 8);
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
      if(!getUserlist().isEmpty()){  
        int posPer = 1;
        for(Usuario user: getUserlist()){
            System.out.println(posPer + ".-" + user.getTipoPersonaje().getNombre());
        }
        System.out.println("escoga un numero correspondiente al personaje que quiere modificar");
        Scanner sc = new Scanner(System.in);
        String opc = sc.next();
        int perMod = Integer.parseInt(opc);
        
        Usuario user = getUserlist().get(perMod--);
        
        System.out.println("usuario: " + user.getNombre());
        int opcion = 0;
        System.out.println("1.-cambiar nombre");
        System.out.println("2.-cambiar oro");
        System.out.println("3.-cambiar poder");
        System.out.println("4.-cambiar salud");
        if(user.getTipoPersonaje() == new Vampiro()){
             System.out.println("5.-cambiar edad");
             System.out.println("seleccione una opcion -1,2,3,4 o 5-");
             sc = new Scanner(System.in);
             String selec = sc.next();
             opcion = Integer.parseInt(selec);
        }else if(user.getTipoPersonaje() != new Vampiro()){
            System.out.println("seleccione una opcion -1,2,3 o 4-");
            sc = new Scanner(System.in);
            String selec = sc.next();
            opcion = Integer.parseInt(selec);
            if(opcion == 5){
               opcion = 0;
            }
        }
        switch(opcion){
            case 1:{
               String nombrePer = user.anadirNombre();
               user.setNombrePersonaje(nombrePer);
               break;
            }case 2:{
               int oroPer = user.anadirOro();
               user.setOroPersonaje(oroPer);
               break;
            }case 3:{
               int poderPer = user.anadirPoder();
               user.setPoderPersonaje(poderPer);
               break;
            }case 4:{
               int saludPer = user.anadirSalud();
               user.setSaludPersonaje(saludPer);
               break;
            }case 5:{
                int edadPer = user.anadirEdad();
               user.setEdadPersonaje(edadPer);
               break;
            }default:{
               System.out.println("seleccion erronea");
            }             
        }
        serializar(user); 
      }else{
         System.out.println("no hay personajes dados de alta");
      }
      seleccionarOpcionMenu(); 
    }
    /**
     * el primer usuario que se obtiene de la lista de los usuarios pendientes de validar son aquellos
     * que son  desafiados
     */
    public void validarDesafio(){
       if(!getDesafiosParaValidar().isEmpty()){  
           Vampiro vampiro = new Vampiro();
           Licantropo licantropo = new Licantropo();
           Cazador cazador = new Cazador();
           Usuario desafiado = getDesafiosParaValidar().remove(0);
           Usuario user = desafiado;
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
           }
           if(user == desafiado){
               Usuario desafiante = getDesafiosParaValidar().remove(0);
               boolean desafianteConEquipoActivo = !desafiante.getTipoPersonaje().getArmasActivas().isEmpty() & desafiante.getTipoPersonaje().getArmaduraActiva() != null;
               boolean desafiadoConEquipoActivo = !desafiado.getTipoPersonaje().getArmasActivas().isEmpty() & desafiado.getTipoPersonaje().getArmaduraActiva() != null;
               if(desafianteConEquipoActivo & desafiadoConEquipoActivo){
                    user.getUsuarioDesafiar().getNotifDesafio().add("desafio pendiente con: " + desafiante.getNombre());
                    getListaUsuariosDesafiantes().add(desafiante);
               }
               user = desafiante;        
           }else{
               user = null;
           }
       }else{
          System.out.println("no hay usuarios pendientes para validar");
       }
       seleccionarOpcionMenu();
    }
    
    public void añadir_atributos_personaje(){
       if(!getUserlist().isEmpty()){
          int posPer = 1;
          for(Usuario user: getUserlist()){
             System.out.println(posPer + ".-" + user.getTipoPersonaje().getNombre());
          }
          System.out.println("escoga un numero correspondiente al personaje al que quiere añadir atributos");
          Scanner sc = new Scanner(System.in);
          String opc = sc.next();
          int perMod = Integer.parseInt(opc);
          perMod--;
          Usuario user = getUserlist().get(perMod);
          int opcion = 0;
          do{
             System.out.println("1.-añadir arma");
             System.out.println("2.-añadir armadura");
             System.out.println("3.-añadir fortaleza");
             System.out.println("4.-añadir debilidad");
             System.out.println("5.-añadir esbirro");
             System.out.println("seleccione un numero de opcion: ");
             sc = new Scanner(System.in);
             String selec = sc.next();
             opcion = Integer.parseInt(selec);
          }while(opcion <1 | opcion > 5);
          switch(opcion){
             case 1:{
                Arma armaPer = user.anadirArma();
                user.setNuevaArmaPersonaje(armaPer);
                break;
             }case 2:{
                Armadura armaduraPer = user.anadirArmadura();
                user.setNuevaArmaduraPersonaje(armaduraPer);  
                break;
             }case 3:{
                Fortaleza fortaleza = user.construirFortaleza();
                user.setNuevaFortalezaPersonaje(fortaleza);
                break;
             }case 4:{
                Debilidad debilidad = user.construirDebilidad();
                user.setNuevaDebilidadPersonaje(debilidad);
                break;
             }case 5:{     
                Esbirro esbirroPer = user.anadirEsbirro();
                user.setNuevoEsbirroPersonaje(esbirroPer);
                break;
             }default:{
                System.out.println("seleccion erronea");
             }
         }
         serializar(user);
        }else{
           System.out.println("no hay personajes dados de alta");
        }
      seleccionarOpcionMenu();
    }
    /**
     * metodo que se llama una vez finalizado un combate;
     * en él se actualiza la lista de usuarios baneados
     * y se comprueba si hay usuarios para desbanear en la lista de los baneados
     * @param usuarioBaneado es el usuario que ha perdido el combate
     */
    public void banearUsuario(Usuario usuarioBaneado){  
        boolean registrado =  false;
        for(Usuario us: getUserlist()){
            if(us.equals(usuarioBaneado)){
                registrado = true;
            }
        }
        if(registrado == true){
           getUsuariosBaneados().add(usuarioBaneado);
           LocalDateTime horaActual = LocalDateTime.now();
           LocalDateTime hora = horaActual.minusHours(24);
           for(Usuario usBaneado: getUsuariosBaneados()){
             for(Combate combate: getListaCombates()){
                Usuario desafiante = combate.getDesafiante();
                Usuario desafiado = combate.getDesafiado();
                if(desafiante == combate.getUsuarioVencedor()){
                   if(usBaneado.getNombre().equals(desafiado.getNombre())){
                      LocalDateTime horaCombate = combate.getFecha();
                      if(horaCombate.isBefore(hora)){
                         desbanearUsuario(usBaneado);
                      }
                   }   
                }else if(desafiado == combate.getUsuarioVencedor()){
                   if(usBaneado.getNombre().equals(desafiante.getNombre())){
                      LocalDateTime horaCombate = combate.getFecha();
                      if(horaCombate.isBefore(hora)){
                         desbanearUsuario(usBaneado);
                      }
                   } 
                }
             }
           }
        }else{
           System.out.println("el usuario no esta registrado");
        }
    }
    
    public void desbanearUsuario(Usuario usuarioDesbaneado){
        boolean registrado =  false;
        for(Usuario us: getUserlist()){
            if(us.equals(usuarioDesbaneado)){
                registrado = true;
            }
        }
        if(registrado == true){
            for(Usuario usuario: usuariosBaneados){
                if(usuario.equals(usuarioDesbaneado)){
                    usuariosBaneados.remove(usuarioDesbaneado);
                }
            }  
        }else{
            System.out.println("el usuario no esta registrado");
        }
    }
    
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
        for(Operador op: getOperatorlist()){
           if((nameOp.equals(op.getNombre()))&(contraseniaOp.equals(op.getPassword()))){
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

    public void setPassword(String password){
        try{
            if(password.length() >= 8 & password.length() <= 12){
                this.password = password;
            }else{
                throw new RuntimeException("longitud de la contrasenia fuera del rango[8-12]"); 
            }
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
