/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
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
                        banearUsuario();
                        break;
                    }case 7:{
                        desbanearUsuario();
                        break;
                    }
                }
            }else{
                System.out.println("seleccion erronea");
            }
        }while(opc != 8);
    }
    
    public int posDebilidadModificar(Personaje personaje){
       List<Debilidad> debilidades = personaje.getListaDebilidades();
       int cont = 0;
       for(Debilidad debilidad: debilidades){
           cont++;
           System.out.println(cont + ".-" + debilidad.getNombre());
       }
       int posModif;
       do{
            System.out.println("escoga el numero de debilidad a modificar");
            Scanner sc = new Scanner(System.in);
            String opcion = sc.next();
            posModif = Integer.parseInt(opcion);
       }while(posModif < 1 || posModif > cont);
       posModif--;
       return posModif;
    }
    
    public int posFortalezaModificar(Personaje personaje){
       List<Fortaleza> fortalezas = personaje.getListaFortalezas();
       int cont = 0;
       for(Fortaleza fortaleza: fortalezas){
           cont++;
           System.out.println(cont + ".-" + fortaleza.getNombre());
       }
       int posModif;
       do{
            System.out.println("escoga el numero de fortaleza a modificar");
            Scanner sc = new Scanner(System.in);
            String opcion = sc.next();
            posModif = Integer.parseInt(opcion);
       }while(posModif < 1 || posModif > cont);
       posModif--;
       return posModif;
    }
    
    public int posArmaModificar(Personaje personaje){
       List<Arma> armas = personaje.getListaArmas();
       int cont = 0;
       for(Arma arma: armas){
           cont++;
           System.out.println(cont + ".-" + arma.getNombre());
       }
       int posModif;
       do{
            System.out.println("escoga el numero de arma a modificar");
            Scanner sc = new Scanner(System.in);
            String opcion = sc.next();
            posModif = Integer.parseInt(opcion);
       }while(posModif < 1 || posModif > cont);
       posModif--;
       return posModif;
    }
    
    public int posArmaduraModificar(Personaje personaje){
       List<Armadura> armaduras = personaje.getListaArmaduras();
       int cont = 0;
       for(Armadura armadura: armaduras){
           cont++;
           System.out.println(cont + ".-" + armadura.getNombre());
       }
       int posModif;
       do{
            System.out.println("escoga el numero de armadura a modificar");
            Scanner sc = new Scanner(System.in);
            String opcion = sc.next();
            posModif = Integer.parseInt(opcion);
       }while(posModif < 1 || posModif > cont);
       posModif--;
       return posModif;
    }
    
    public int posEsbirroModificar(Personaje personaje){
       List<Esbirro> esbirros = personaje.getListaEsbirros();
       if(!esbirros.isEmpty()){
            int cont = 0;
            for(Esbirro esbirro: esbirros){
                cont++;
                System.out.println(cont + ".-" + esbirro.getNombre());
            }
            int posModif;
            do{
                System.out.println("escoga el numero de esbirro a modificar");
                Scanner sc = new Scanner(System.in);
                String opcion = sc.next();
                posModif = Integer.parseInt(opcion);
            }while(posModif < 1 || posModif > cont);
            posModif--;
            return posModif;
       }else{
            return -1;
       }
    }
    
    public void editar_Personaje(){  
      if(!menu.getUserlist().isEmpty()){  
        int posPer = 1;
        for(Usuario user: menu.getUserlist()){
            System.out.println(posPer + ".-" + user.getTipoPersonaje().getNombre());
            posPer++;
        }
        int perMod;
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
        System.out.println("5.-cambiar edad");
        System.out.println("6.-cambiar debilidad");
        System.out.println("7.-cambiar fortaleza");
        System.out.println("8.-cambiar arma");
        System.out.println("9.-cambiar armadura");
        System.out.println("10.-cambiar esbirro");
        System.out.println("11.-cambiar habilidad");
        System.out.println("seleccione una de las 11 opciones-");
        Scanner sc = new Scanner(System.in);
        String selec = sc.next();
        opcion = Integer.parseInt(selec);
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
                Class personaje = user.getTipoPersonaje().getClass();
                if(personaje == Vampiro.class){
                    int edadPer = user.anadirEdad();
                    menu.getUsuarioActual().get(0).setEdadPersonaje(edadPer);
                }else{
                    System.out.println("este personaje no tiene una edad");
                }
               break;
            }case 6:{
                int posAntigua = posDebilidadModificar(menu.getUsuarioActual().get(0).getTipoPersonaje());
                Debilidad debilidad = user.construirDebilidad();
                user.getTipoPersonaje().getListaDebilidades().set(posAntigua, debilidad);
                break;
            }case 7:{
                int posAntigua = posFortalezaModificar(menu.getUsuarioActual().get(0).getTipoPersonaje());
                Fortaleza fortaleza = user.construirFortaleza();
                user.getTipoPersonaje().getListaFortalezas().set(posAntigua, fortaleza);
                break;
            }case 8:{
                int posAntigua = posArmaModificar(menu.getUsuarioActual().get(0).getTipoPersonaje());
                Arma arma = user.anadirArma();
                user.getTipoPersonaje().getListaArmas().set(posAntigua, arma);
                break;
            }case 9:{
                int posAntigua = posArmaduraModificar(menu.getUsuarioActual().get(0).getTipoPersonaje());
                Armadura armadura = user.anadirArmadura();
                user.getTipoPersonaje().getListaArmaduras().set(posAntigua, armadura);
                break;
            }case 10:{
                //si esta la lista vacia retorna -1
                int posAntigua = posEsbirroModificar(menu.getUsuarioActual().get(0).getTipoPersonaje());
                if(posAntigua != -1){
                    Esbirro esbirro = user.anadirEsbirro();
                    List<Esbirro> listaEsbirros = user.getTipoPersonaje().getListaEsbirros();
                    if(listaEsbirros.isEmpty()){
                        user.setNuevoEsbirroPersonaje(esbirro);
                    }else{
                        listaEsbirros.set(posAntigua, esbirro);
                    }
                }else{
                    System.out.println("la lista de esbirros esta vacia");
                }
                break;
            }case 11:{
                Habilidad habilidad = user.construirHabilidad();
                user.setHabilidadPersonaje(habilidad);
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
       boolean desafiadoConEquipoActivo = false; 
       Usuario desafiado = menu.getDesafiosParaValidar().get(0);
       Usuario desafiante = menu.getDesafiosParaValidar().get(1);
       Usuario user = desafiado;
           
       while(!menu.getDesafiosParaValidar().isEmpty() && user != null){  
                   
           Class personaje = user.getTipoPersonaje().getClass();
           if(user != null){ 
                if(personaje == Vampiro.class){
                   System.out.println("### fortalezas de " + user.getNombre() + " ##");
                   for(Fortaleza fortaleza: user.getTipoPersonaje().getListaFortalezas()){
                       System.out.print(fortaleza.getNombre() + " -> ");
                       System.out.println(fortaleza.getSensibilidad());  
                   }
                   System.out.println("### debilidades de " + user.getNombre() + " ##");
                   for(Debilidad debilidad: user.getTipoPersonaje().getListaDebilidades()){
                       System.out.print(debilidad.getNombre() + " -> ");
                       System.out.println(debilidad.getSensibilidad());
                   }
                }else if(personaje == Licantropo.class){
                   System.out.println("### fortalezas de " + user.getNombre() + " ##"); 
                   for(Fortaleza fortaleza: user.getTipoPersonaje().getListaFortalezas()){
                       System.out.print(fortaleza.getNombre() + " -> ");
                       System.out.println(fortaleza.getSensibilidad()); 
                   }
                   System.out.println("### debilidades de " + user.getNombre() + " ##");
                   for(Debilidad debilidad: user.getTipoPersonaje().getListaDebilidades()){
                       System.out.print(debilidad.getNombre() + " -> ");
                       System.out.println(debilidad.getSensibilidad());
                   }
                }else if(personaje == Cazador.class){
                   System.out.println("### fortalezas de " + user.getNombre() + " ##"); 
                   for(Fortaleza fortaleza: user.getTipoPersonaje().getListaFortalezas()){
                       System.out.print(fortaleza.getNombre() + " -> ");
                       System.out.println(fortaleza.getSensibilidad());  
                   }
                   System.out.println("### debilidades de " + user.getNombre() + " ##");
                   for(Debilidad debilidad: user.getTipoPersonaje().getListaDebilidades()){
                       System.out.print(debilidad.getNombre() + " -> ");
                       System.out.println(debilidad.getSensibilidad());
                   }
                }
           }
           if(user == desafiado){
               desafiadoConEquipoActivo = !user.getTipoPersonaje().getArmasActivas().isEmpty() && user.getTipoPersonaje().getArmaduraActiva() != null;
               user = desafiante;
           }else{
               boolean desafianteConEquipoActivo = !user.getTipoPersonaje().getArmasActivas().isEmpty() && user.getTipoPersonaje().getArmaduraActiva() != null;              
               if(desafianteConEquipoActivo && desafiadoConEquipoActivo){
                    desafiado.setNotifDesafio("desafio pendiente con: " + user.getNombre());
                    menu.setListaUsuariosDesafiantes(user);
               }
               menu.getDesafiosParaValidar().remove(desafiado);
               menu.getDesafiosParaValidar().remove(desafiante);
               user = null;
           }
       }if(menu.getDesafiosParaValidar().isEmpty()){
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
          int perMod;
          do{
              System.out.println("escoga un numero correspondiente al personaje al que quiere añadir atributos");
              Scanner sc = new Scanner(System.in);
              String opc = sc.next();
              perMod = Integer.parseInt(opc);
          }while(perMod < 1 || perMod >= posPer);
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
             Scanner sc = new Scanner(System.in);
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
     * el operador puede banear a un usuario siempre y cuando éste haya perdido un combate en las ultimas 24h
     */
    
    public void banearUsuario(){
        Usuario usuarioBanear = null;
        System.out.println("escriba el nombre del usuario a banear");
        Scanner sc = new Scanner(System.in);
        String nombreUsuarioBanear = sc.next();
        boolean registrado =  false;
        for(Usuario us: menu.getUserlist()){
            if(us.getNombre().equals(nombreUsuarioBanear)){
                registrado = true;
                usuarioBanear = us;
            }
        }
              
        if(registrado == true){
            Collections.sort(menu.getListaCombates());
            LocalDateTime horaActual = LocalDateTime.now();
            LocalDateTime horaAnterior = horaActual.minusHours(24);
            for(Combate combate: menu.getListaCombates()){
                Usuario desafiante = combate.getDesafiante();
                Usuario desafiado = combate.getDesafiado();
                LocalDateTime horaCombate = combate.getFecha();
                if(usuarioBanear.equals(desafiado) && desafiante.equals(combate.getUsuarioVencedor())){
                    if(horaCombate.isAfter(horaAnterior) && horaCombate.isBefore(horaActual)){
                        menu.setUsuariosBaneados(usuarioBanear);
                    }else{
                        System.out.println("este usuario no necesita estar baneado");
                    }
                }else if(usuarioBanear.equals(desafiante) && desafiado.equals(combate.getUsuarioVencedor())){
                    if(horaCombate.isAfter(horaAnterior) && horaCombate.isBefore(horaActual)){
                        menu.setUsuariosBaneados(usuarioBanear);
                    }else{
                        System.out.println("este usuario no necesita estar baneado");
                    }
                }
            }
        }else{
           System.out.println("el usuario no esta registrado");
        }
    }
    
    /**
     * el operador puede desbanear un usuario cualquiera
     */
    public void desbanearUsuario(){
        //Usuario usuarioBaneado = null;
        System.out.println("escriba el nombre del usuario a desbanear");
        Scanner sc = new Scanner(System.in);
        String nombreUsuarioBaneado = sc.next();
        
        boolean registrado =  false;
        for(Usuario us: menu.getUserlist()){
            if(us.getNombre().equals(nombreUsuarioBaneado)){
                registrado = true;
            }
        }
        LocalDateTime horaActual = LocalDateTime.now();
        LocalDateTime horaAnterior = horaActual.minusHours(24);
        if(registrado == true){
            for(Usuario usuario: menu.getUsuariosBaneados()){
                for(Combate combate: menu.getListaCombates()){
                    if(usuario.equals(combate.getDesafiado()) && combate.getFecha().isBefore(horaAnterior) || usuario.equals(combate.getDesafiante()) && combate.getFecha().isBefore(horaAnterior)){
                        menu.getUsuariosBaneados().remove(usuario);
                    }else{
                        System.out.println("no se puede desbanear a este usuario");
                    }
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
       }catch(IOException e){
           System.out.println(e);
       }
    } 
}
