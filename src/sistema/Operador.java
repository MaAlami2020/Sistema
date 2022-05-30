/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author mimit
 */
public class Operador implements Serializable{
    private String nombre;
    private String nick;
    private String password;
    private int fortalezasVampiro;
    private int debilidadesVampiro;
    private int fortalezasLicantropo;
    private int debilidadesLicantropo;
    private int fortalezasCazador;
    private int debilidadesCazador;
    private MenuInicio menu; 
    
    public Operador(String nombre, String nick, String password){
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;      
    }

    public Operador(MenuInicio menu){
        this.menu = menu;
    }
    
    //public Operador(){
    //}

    public void setMenu(MenuInicio menu) {
        this.menu = menu;
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
            
            if(opc >= 3 && opc <= 8){
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
            }else{
                System.out.println("seleccion erronea");
            }
        }while(opc != 8);
    }
    
    public void editar_Personaje(){  
      if(!menu.getUserlist().isEmpty()){  
        int posPer = 1;
        for(Usuario user: menu.getUserlist()){
            System.out.println(posPer + ".-" + user.getTipoPersonaje().getNombre());
            posPer++;
        }
        int perMod = 0;
        do{
           System.out.println("escoga un numero correspondiente al personaje que quiere modificar");
           Scanner sc = new Scanner(System.in);
           String opc = sc.next();
           perMod = Integer.parseInt(opc);
        }while(perMod < 1 || perMod >= posPer);
        perMod--;
        Usuario user = menu.getUserlist().get(perMod);
        menu.setUsuarioActual(user);
        System.out.println("usuario: " + menu.getUsuarioActual().get(0).getNombre());
        int opcion = 0;
        System.out.println("1.-cambiar nombre");
        System.out.println("2.-cambiar oro");
        System.out.println("3.-cambiar poder");
        System.out.println("4.-cambiar salud");
        Class personaje = user.getTipoPersonaje().getClass();
        if(personaje == Vampiro.class){
             System.out.println("5.-cambiar edad");
             System.out.println("seleccione una opcion -1,2,3,4 o 5-");
             Scanner sc = new Scanner(System.in);
             String selec = sc.next();
             opcion = Integer.parseInt(selec);
        }else{
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
               String nombrePer = user.anadirNombre();
               menu.getUsuarioActual().get(0).setNombrePersonaje(nombrePer);
               break;
            }case 2:{
               int oroPer = user.anadirOro();
               menu.getUsuarioActual().get(0).setOroPersonaje(oroPer);
               break;
            }case 3:{
               int poderPer = user.anadirPoder();
               menu.getUsuarioActual().get(0).setPoderPersonaje(poderPer);
               break;
            }case 4:{
               int saludPer = user.anadirSalud();
               menu.getUsuarioActual().get(0).setSaludPersonaje(saludPer);
               break;
            }case 5:{
                int edadPer = user.anadirEdad();
                menu.getUsuarioActual().get(0).setEdadPersonaje(edadPer);
               break;
            }default:{
               System.out.println("seleccion erronea");
            }             
        }
        menu.getUsuarioActual().clear();
      }else{
         System.out.println("no hay personajes dados de alta");
      }
    }
    /**
     * el primer usuario que se obtiene de la lista de los usuarios pendientes de validar son aquellos
     * que son  desafiados
     */
    public void validarDesafio(){
       while(!menu.getDesafiosParaValidar().isEmpty()){  
         
           Usuario desafiado = menu.getDesafiosParaValidar().remove(0);
           Usuario user = desafiado;
           Class personaje = user.getTipoPersonaje().getClass();
           //if(user != null){ 
                if(personaje == Vampiro.class){
                   for(Fortaleza fortaleza: user.getTipoPersonaje().getListaFortalezas()){
                       fortalezasVampiro += fortaleza.getSensibilidad();  
                   }
                   for(Debilidad debilidad: user.getTipoPersonaje().getListaDebilidades()){
                       debilidadesVampiro += debilidad.getSensibilidad();
                   }
                }else if(personaje == Licantropo.class){
                   for(Fortaleza fortaleza: user.getTipoPersonaje().getListaFortalezas()){
                       fortalezasLicantropo += fortaleza.getSensibilidad();  
                   }
                   for(Debilidad debilidad: user.getTipoPersonaje().getListaDebilidades()){
                       debilidadesLicantropo += debilidad.getSensibilidad();
                   }
                }else if(personaje == Cazador.class){
                   for(Fortaleza fortaleza: user.getTipoPersonaje().getListaFortalezas()){
                       fortalezasCazador += fortaleza.getSensibilidad();  
                   }
                   for(Debilidad debilidad: user.getTipoPersonaje().getListaDebilidades()){
                       debilidadesCazador += debilidad.getSensibilidad();
                   }
                }
           //}
           if(user == desafiado){
               boolean desafiadoConEquipoActivo = !user.getTipoPersonaje().getArmasActivas().isEmpty() & user.getTipoPersonaje().getArmaduraActiva() != null;
               Usuario desafiante = menu.getDesafiosParaValidar().remove(0);
               boolean desafianteConEquipoActivo = !desafiante.getTipoPersonaje().getArmasActivas().isEmpty() & desafiante.getTipoPersonaje().getArmaduraActiva() != null;              
               if(desafianteConEquipoActivo & desafiadoConEquipoActivo){
                    user.setNotifDesafio("desafio pendiente con: " + desafiante.getNombre());
                    menu.setListaUsuariosDesafiantes(desafiante);
               }
               //user = desafiante;        
           }//else{
             //  user = null;
           //}
       }
       if(menu.getDesafiosParaValidar().isEmpty()){
          System.out.println("no hay usuarios pendientes para validar");
       }
    }
    
    public void añadir_atributos_personaje(){
       if(!menu.getUserlist().isEmpty()){
          int posPer = 1;
          for(Usuario user: menu.getUserlist()){
             System.out.println(posPer + ".-" + user.getTipoPersonaje().getNombre());
             posPer++;
          }
          System.out.println("escoga un numero correspondiente al personaje al que quiere añadir atributos");
          Scanner sc = new Scanner(System.in);
          String opc = sc.next();
          int perMod = Integer.parseInt(opc);
          perMod--;
          Usuario user = menu.getUserlist().get(perMod);
          menu.setUsuarioActual(user);
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
          }while(opcion <1 || opcion > 5);
          switch(opcion){
             case 1:{
                Arma armaPer = user.anadirArma();
                menu.getUsuarioActual().get(0).setNuevaArmaPersonaje(armaPer);
                break;
             }case 2:{
                Armadura armaduraPer = user.anadirArmadura();
                menu.getUsuarioActual().get(0).setNuevaArmaduraPersonaje(armaduraPer);  
                break;
             }case 3:{
                Fortaleza fortaleza = user.construirFortaleza();
                menu.getUsuarioActual().get(0).setNuevaFortalezaPersonaje(fortaleza);
                break;
             }case 4:{
                Debilidad debilidad = user.construirDebilidad();
                menu.getUsuarioActual().get(0).setNuevaDebilidadPersonaje(debilidad);
                break;
             }case 5:{     
                Esbirro esbirroPer = user.anadirEsbirro();
                menu.getUsuarioActual().get(0).setNuevoEsbirroPersonaje(esbirroPer);
                break;
             }default:{
                System.out.println("seleccion erronea");
             }
         }
         menu.getUsuarioActual().clear();
        }else{
           System.out.println("no hay personajes dados de alta");
        }
    }
    /**
     * metodo que se llama una vez finalizado un combate;
     * en él se actualiza la lista de usuarios baneados
     * y se comprueba si hay usuarios para desbanear en la lista de los baneados
     * @param usuarioBaneado es el usuario que ha perdido el combate
     */
    
    public void banearUsuario(Usuario usuarioBaneado){
        boolean registrado =  false;
        for(Usuario us: menu.getUserlist()){
            if(us.equals(usuarioBaneado)){
                registrado = true;
            }
        }
        if(registrado == true){
           menu.getUsuariosBaneados().add(usuarioBaneado);
           LocalDateTime horaActual = LocalDateTime.now();
           LocalDateTime horaAnterior = horaActual.minusHours(24);
           for(Usuario usBaneado: menu.getUsuariosBaneados()){
             for(Combate combate: menu.getListaCombates()){
                Usuario desafiante = combate.getDesafiante();
                Usuario desafiado = combate.getDesafiado();
                if(desafiante.equals(combate.getUsuarioVencedor())){
       //se comprueba si el usuario perdedor del combate esta en la lista de usuarios baneados 
                   if(usBaneado.getNombre().equals(desafiado.getNombre())){
                      LocalDateTime horaCombate = combate.getFecha();
                      if(horaCombate.isBefore(horaAnterior)){
//para desbanear a un usuario el combate se debe de haber realizado 24h anteriores a la hora actual
                         desbanearUsuario(usBaneado);
                      }
                   }   
                }else if(desafiado.equals(combate.getUsuarioVencedor())){
                   if(usBaneado.getNombre().equals(desafiante.getNombre())){
                      LocalDateTime horaCombate = combate.getFecha();
                      if(horaCombate.isBefore(horaAnterior)){
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
        for(Usuario us: menu.getUserlist()){
            if(us.equals(usuarioDesbaneado)){
                registrado = true;
            }
        }
        if(registrado == true){
            for(Usuario usuario: menu.getUsuariosBaneados()){
                if(usuario.equals(usuarioDesbaneado)){
                    menu.getUsuariosBaneados().remove(usuarioDesbaneado);
                }
            }  
        }else{
            System.out.println("el usuario no esta registrado");
        }
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
       }catch(Exception e){
           System.out.println(e);
       }
    } 
}
