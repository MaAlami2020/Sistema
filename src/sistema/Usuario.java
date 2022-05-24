/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static sistema.Lealtad.ALTA;
import static sistema.Lealtad.BAJA;
import static sistema.Lealtad.NORMAL;

/**
 *
 * @author MariaAmparoAlami
 */
public class Usuario{
    private String nombre;
    private String nick;
    private String password;  
    private StringBuilder registro = new StringBuilder();
    private Personaje tipoPersonaje;
    private Usuario usuarioDesafiar;
    private int oroApostado;
    private List<String> notifDesafio = new ArrayList<>();
    private MenuInicio menu;

    public Usuario(String nombre, String nick, String password){
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;    
    }

    public Usuario(){  
    }
    
    public Usuario(MenuInicio menu){
        this.menu = menu;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombreUsuario(String nombreInicio) {
        this.nombre = nombreInicio;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nickInicio) {
        this.nick = nickInicio;
    }

    public StringBuilder getRegistro() {
        return registro;
    }

    public void setRegistro(StringBuilder registro) {
        this.registro = registro;
    }

    public void setTipoPersonaje(Personaje tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }
    
    public StringBuilder updateRegistro(){
        if(!menu.getUserlist().isEmpty()){
          for(int i = 0; i <= 4; i++){
             char caracter = registro.charAt(i);
             if((caracter < 'Z')|(caracter < '9')){
                char nuevoCaracter = caracter;
                nuevoCaracter++;
                registro.setCharAt(i, nuevoCaracter);
                return registro;
             }
          }
        }
        return registro;
    }
    
    public void registrar_darBaja(){
      boolean userRegistered = false;  
      System.out.println("1.registrarse");
      System.out.println("2.eliminar cuenta");
      System.out.println("escoga una opcion: ");
      Scanner sc = new Scanner(System.in);
      String option = sc.next();

      int opcion =Integer.parseInt(option);
      if(opcion == 2){
        System.out.println("ingrese su nombre de usuario: ");
        sc = new Scanner(System.in);
        String nameUs = sc.next();
        setNombreUsuario(nameUs);
        String contraseniaUs = null;
        do{
           System.out.println("ingrese su contrasenia (8-12 caracteres): ");
           sc = new Scanner(System.in);
           contraseniaUs = sc.next();
        }while(contraseniaUs.length() < 8 | contraseniaUs.length() > 12);
        setPassword(contraseniaUs);
        boolean cuentaEliminada = false;
        for(Usuario us: menu.getUserlist()){
           if((nameUs.equals(us.getNombre()))&(contraseniaUs.equals(us.getPassword()))){
                menu.getUserlist().remove(us);
                System.out.println("cuenta eliminada");
                cuentaEliminada = true;
           }
        }
        if(cuentaEliminada == false){
            System.out.println("no esta registrado");
        }
      }else if(opcion == 1){
        System.out.println("ingrese su nombre: ");
        sc = new Scanner(System.in);
        String name = sc.next();

        this.setNombreUsuario(name);
        System.out.println("ingrese su nick: ");
        sc = new Scanner(System.in);
        String apodo = sc.next();

        this.setNick(apodo);
        System.out.println("ingrese una contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contrasenia = sc.next();
        actualizarContrasenia(contrasenia);
        while(contrasenia.length() < 8 | contrasenia.length() > 12){
           System.out.println("Por favor, ingrese una nueva contrasenia (8-12 caracteres): ");
           sc = new Scanner(System.in);
           contrasenia = sc.next();
           actualizarContrasenia(contrasenia);
        }
        

        for(Usuario us: menu.getUserlist()){
           if((us.getNombre().equals(this.getNombre()))&&(us.getNick().equals(this.getNick()))){
               userRegistered = true;
               System.out.println("usuario ya registrado");
               entrar_salirSistema();
           }
        }
        if(userRegistered == false){
            tipoPersonaje = null;
            if(menu.getUserlist().isEmpty()){                
                  registro.append("A00AA");
                  anadirNuevoUsuario(nombre,nick,password,registro,tipoPersonaje);                  
            }else{
                  StringBuilder reg = updateRegistro();
                  anadirNuevoUsuario(nombre,nick,password,reg,tipoPersonaje);
            }
            System.out.println("registrado/a corractamente");
            entrar_salirSistema();
        }
      }
    
    }
    public void anadirNuevoUsuario(String name,String apodo,String contrasenia,StringBuilder reg,Personaje tipoPersonaje){
        Usuario usuario = new Usuario(name,apodo,contrasenia);
        usuario.setRegistro(reg);
        usuario.setTipoPersonaje(tipoPersonaje);
        menu.setUserlist(usuario);
    }
  
    public void seleccionarOpcionMenu(){
        int opc = 0;
        do{
           System.out.println("***BIENVENIDO**");
           System.out.println("3.-registrar/dar de baja un personaje");
           System.out.println("4.-desafiar a otro usuario");
           System.out.println("5.-elegir armas/armaduras activas");
           System.out.println("6.-consultar oro");
           System.out.println("7.-consultar ranking");
           System.out.println("8.-aceptar/rechazar desafios"); 
           System.out.println("9.-salir del sistema");
           System.out.println("escoga una opcion: ");
           Scanner sc = new Scanner(System.in);
           String opcion = sc.next();
           opc =Integer.parseInt(opcion);
        }while(opc < 3 | opc > 9);
        switch(opc){
            case 3:{
               System.out.println("1.-registrar personaje");
               System.out.println("2.-dar de baja personaje");
               System.out.println("seleccione una opcion: -1 o 2-");
               Scanner sc = new Scanner(System.in);
               String option = sc.next();
               int opt =Integer.parseInt(option);
               if(opt == 1){
                   System.out.println("1.-vampiro");
                   System.out.println("2.-licantropo");
                   System.out.println("3.-cazador");
                   System.out.println("seleccione el tipo de personaje a registrar: -1, 2 o 3-");
                   sc = new Scanner(System.in);
                   option = sc.next();
                   int opt1 =Integer.parseInt(option);
                   if(opt1 == 1){

                       registrar_vampiro();
                   }else if(opt1 == 2){
                      registrar_licantropo();
                   }else if(opt1 == 3){
                      registrar_cazador();
                   }
               }else if(opt == 2){
                   darBaja_Personaje();
               }
               break;
            }case 4:{
                    desafiarUsuario();
                    break;
            }case 5:{
               System.out.println("1.-elegir armas activas");
               System.out.println("2.-elegir armadura activa");
               System.out.println("seleccione una opcion: -1 o 2-");
               Scanner sc = new Scanner(System.in);
               String option = sc.next();
               Integer opt = Integer.parseInt(option);
               if(opt == 1){
                   Arma armaActiva = elegirArma_activa();
                   setArmasActivasPersonaje(armaActiva);
                   menu.updateUser(this, tipoPersonaje);
                   seleccionarOpcionMenu();
               }else if(opt == 2){
                   Armadura armaduraActiva = elegirArmadura_activa();
                   setArmaduraActivaPersonaje(armaduraActiva);
                   menu.updateUser(this, tipoPersonaje);
                   seleccionarOpcionMenu();
               }                  
               break;
            }case 6:{
               consultarOro();
               break;
            }case 7:{
               consultarRanking();
               break;
            }case 8:{
               aceptar_rechazarDesafio();
               break;
            }
        }
    }
    
    public void darBaja_Personaje(){
        tipoPersonaje = null;
        seleccionarOpcionMenu();
    }
    
    public Esbirro anadirEsbirro(){ 
        int opcion = 0;
        do{
           System.out.println("1.-ghoul");
           System.out.println("2.-demonio");
           System.out.println("3.-humano");
           System.out.println("seleccione una opcion -1, 2 o 3-");
           Scanner sc = new Scanner(System.in);
           String selec = sc.next();
           opcion = Integer.parseInt(selec);
        }while(opcion < 1 | opcion > 3);
        switch(opcion){
                case 1:{
                     Ghoul ghoul = new Ghoul("",0,0);
                     String nombreEsb = anadirNombreEsbirro();
                     ghoul.setNombre(nombreEsb);
                     int saludEsb = 0;
                     do{
                         try{
                             saludEsb = anadirSaludEsbirro();
                             ghoul.setSalud(saludEsb);
                         }catch(RuntimeException e){
                             System.out.println(e.getMessage());
                         }
                     }while(saludEsb < 1 | saludEsb > 3);   
                        
                     int depEsb = 0;
                     do{
                         try{
                             depEsb = anadirDependenciaEsbirro();
                             ghoul.setDependencia(depEsb);
                         }catch(RuntimeException e){
                             System.out.println(e.getMessage());
                         }
                     }while(depEsb < 1 | depEsb > 5); 
                     return ghoul;
                }case 2:{
                    Demonio demonio = new Demonio("",0,"");
                    String nombreEsb = anadirNombreEsbirro();
                    demonio.setNombre(nombreEsb);
                    
                    int saludEsb = 0;
                    do{
                        try{
                            saludEsb = anadirSaludEsbirro();
                            demonio.setSalud(saludEsb);
                        }catch(RuntimeException e){
                             System.out.println(e.getMessage());
                        }
                    }while(saludEsb < 1 | saludEsb > 3);
                    
                    String pactoEsb = anadirPactoEsbirro();
                    demonio.setPacto(pactoEsb);
                    String selec = null;
                    do {
                        System.out.println("¿quiere añadir esbirros hijos? -si- o -no-");
                        Scanner sc = new Scanner(System.in);
                        selec = sc.next();
                    } while (!selec.equals("si") & !selec.equals("no"));
                    if(selec.equals("si")){
                        Esbirro hijo = anadirEsbirro();
                        demonio.addHijos(hijo);
                    }
                    return demonio;
                }case 3:{
                    Humano humano = new Humano("",0,null);
                    String nombreEsb = anadirNombreEsbirro();
                    humano.setNombre(nombreEsb);
                    
                    int saludEsb = 0;
                    do{
                        try{
                            saludEsb = anadirSaludEsbirro();
                            humano.setSalud(saludEsb);
                        }catch(RuntimeException e){
                             System.out.println(e.getMessage());
                        }
                    }while(saludEsb < 1 | saludEsb > 3);
                    
                    Lealtad lealtadEsb = null;
                    do{
                        try{
                            lealtadEsb = anadirLealtadEsbirro();
                            humano.setLealtad(lealtadEsb);
                        }catch(RuntimeException e){
                             System.out.println(e.getMessage());
                        }
                    }while(lealtadEsb == null);
                    return humano;
                }default:{
                    System.out.println("seleccion erronea");
                }
        } 
        return null;
    }
    
    
    public String anadirNombre(){
       System.out.println("Introduzca el nombre del personaje: ");
       Scanner sc = new Scanner(System.in);
       String nombrePer = sc.next();
       return nombrePer;
    }
    
    public void setNombrePersonaje(String nombre){
        tipoPersonaje.setNombre(nombre);
    }
    
    public int anadirOro() {
            System.out.println("introduzca la cantidad de oro del personaje: ");
            Scanner sc = new Scanner(System.in);
            String cantidadOro = sc.next();
            int oroPer = Integer.parseInt(cantidadOro);
            return oroPer;
    }

    public void setOroPersonaje(double oro){
        try{
            tipoPersonaje.setOro(oro);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public int anadirSalud() {
        System.out.println("introduzca la salud del personaje entre 0 y 5: ");
        Scanner sc = new Scanner(System.in);
        String cantidadSalud = sc.next();
        int saludPer = Integer.parseInt(cantidadSalud);
        return saludPer;
    }

    public void setSaludPersonaje(int salud){
        try{
            tipoPersonaje.setSalud(salud);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
    public int anadirPoder() {
        System.out.println("introduzca el poder del personaje entre 1 y 5: ");
        Scanner sc = new Scanner(System.in);
        String cantidadPoder = sc.next();
        int poderPer = Integer.parseInt(cantidadPoder);
        return poderPer;
    }
    
    public void setPoderPersonaje(int poder){
        try{
            tipoPersonaje.setPoder(poder);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
      
    public Armadura anadirArmadura() {
        Armadura armadura = new Armadura("",0,0);
        boolean nombreValido = true;
        do{
           System.out.println("introduzca el nombre del armadura del personaje: ");
           Scanner sc = new Scanner(System.in);
                  
           try{
               String nombreArmadura = sc.next();
               armadura.setNombre(nombreArmadura);
           }catch(RuntimeException e){
               System.out.println(e.getMessage());
               nombreValido = false;
           }
        }while(nombreValido == false);
        int modifDefensa = 0;
        do{
           System.out.println("introduzca el valor del modificador a la defensa del armadura -1,2 o 3-: ");
           Scanner sc = new Scanner(System.in);
           String modificadorDefensa = sc.next();
           try{
               modifDefensa = Integer.parseInt(modificadorDefensa);
               armadura.setModificadorDefensa(modifDefensa);
           }catch(RuntimeException e){
               System.out.println(e.getMessage());
           }
        }while((modifDefensa < 1)|(modifDefensa > 3)); 
        
        System.out.println("escriba -si- si quiere introducir un modificador al ataque");
        Scanner sc = new Scanner(System.in);
        String opcModDef = sc.next();
        int modifAtaque = 0;
        if(opcModDef.equals("si")){
           
           while((modifAtaque < 1)|(modifAtaque > 3)){
              System.out.println("introduzca el valor del modificador al ataque del armadura -1,2 o 3-: ");
              sc = new Scanner(System.in);
              String modifAtaq = sc.next();
              try{
                  modifAtaque = Integer.parseInt(modifAtaq);
              }catch(RuntimeException e){
                  System.out.println(e.getMessage());
              }
           }
        }
        return armadura;
    }
    
    public void setNuevaArmaduraPersonaje(Armadura armaduraPer){
       tipoPersonaje.setListaArmaduras(armaduraPer);
    }
    
    
    public Arma anadirArma(){
        Arma arma = new Arma(null,0,0,null);
        boolean nombreValido = true;
        do{
           System.out.println("introduzca el nombre del arma del personaje: ");
           Scanner sc = new Scanner(System.in);
           String nombreArma = sc.next();
           try{
               arma.setNombre(nombreArma);
           }catch(RuntimeException e){
               System.out.println(e.getMessage());
               nombreValido = false;
           }
        }while(nombreValido == false);
        int modifAtaque = 0;
        do{
           System.out.println("introduzca el valor del modificador al ataque del arma -1,2 o 3-: ");
           Scanner sc = new Scanner(System.in);
           String modifAtq = sc.next();
           modifAtaque = Integer.parseInt(modifAtq);
           try{
               arma.setModificadorAtaque(modifAtaque);
           }catch(RuntimeException e){
               System.out.println(e.getMessage());
           }
        }while((modifAtaque < 1)|(modifAtaque > 3)); 
        
        System.out.println("escriba -si- si quiere introducir un modificador a la defensa");
        Scanner sc = new Scanner(System.in);
        String opcModDef = sc.next();
        int modifDefensa = 0;
        if(opcModDef.equals("si")){
           
           while((modifDefensa < 1)|(modifDefensa > 3)){
              System.out.println("introduzca el valor del modificador a la defensa del arma -1,2 o 3-: ");
              sc = new Scanner(System.in);
              String modifDef = sc.next();
              modifDefensa = Integer.parseInt(modifDef);
              try{
                  arma.setModificadorDefensa(modifDefensa);
              }catch(RuntimeException e){
                  System.out.println(e.getMessage());
              }
           }   
           
        }else{
              modifDefensa = 0;
        }
        int opcion = 0;
        String manejo = null;
        while((opcion != 1)&(opcion != 2)){
              System.out.println("1.- 1 mano ");
              System.out.println("2.- 2 manos ");
              System.out.println("Escoga el manejo del arma -1 o 2-: ");
              sc = new Scanner(System.in);
              String opcManejo = sc.next();
              opcion = Integer.parseInt(opcManejo);
             
              if(opcion == 1)
                  manejo = "1 mano";
              
              else if(opcion == 2)
                  manejo = "2 manos";
              else
                  manejo = "";
              try{
                  arma.setManejo(manejo);
              }catch(RuntimeException e){
                  System.out.println(e.getMessage());
              }
        }
        return arma;
    }
    
    public void setNuevaArmaPersonaje(Arma armaPer){
        tipoPersonaje.setListaArmas(armaPer);
    }
    
    public String anadirNombreEsbirro(){
       System.out.println("Introduzca el nombre del esbirro: ");
       Scanner sc = new Scanner(System.in);
       String nombreEsb = sc.next();
       return nombreEsb;
    }
    
    public String anadirPactoEsbirro(){
       System.out.println("Introduzca el pacto del esbirro: ");
       Scanner sc = new Scanner(System.in);
       String pactoEsb = sc.next();
       return pactoEsb;
    }
    
    public int anadirSaludEsbirro() {
           System.out.println("Introduzca el valor de salud del esbirro (1-3): ");
           Scanner sc = new Scanner(System.in);
           String salud = sc.next();
           int valorSalud = Integer.parseInt(salud); 
           return valorSalud;
    }
    
    public int anadirDependenciaEsbirro(){
           System.out.println("Introduzca el valor de dependencia con el amo (de 1 a 5): ");
           Scanner sc = new Scanner(System.in);
           String valorDep = sc.next();
           int dep = Integer.parseInt(valorDep);
           return dep;
    }
    
    public Lealtad anadirLealtadEsbirro(){
       Lealtad lealtad = null; 
       System.out.println("1.-ALTA");
       System.out.println("2.-NORMAL");
       System.out.println("3.-BAJA");
       System.out.println("seleccione al valor de lealtad -1,2 o 3-: ");
       Scanner sc = new Scanner(System.in);
       String valor = sc.next();
       int valorLealtad = Integer.parseInt(valor);
        switch (valorLealtad) {
            case 1:
                lealtad = ALTA;
                break;
            case 2:
                lealtad = NORMAL;
                break;
            case 3:
                lealtad = BAJA;
                break;
            default:
                lealtad = null;
                break;
        }
       return lealtad;
    }
 
    public void setNuevoEsbirroPersonaje(Esbirro esbirroPer){
        try{
            tipoPersonaje.setListaEsbirros(esbirroPer);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
 
    public int anadirCosteSangre(){
        System.out.println("Introduzca el coste en puntos de sangre -1,2 o 3-: ");
        Scanner sc = new Scanner(System.in);
        String valor = sc.next();
        int coste = Integer.parseInt(valor); 
        return coste;
    }
    public int anadirRabiaMin(){
        System.out.println("Introduzca el valor de rabia minimo: ");
        Scanner sc = new Scanner(System.in);
        String valor = sc.next();
        int rabiaMin = Integer.parseInt(valor);
        return rabiaMin;
    }
    public int anadirEdadAdquisicion(){
        System.out.println("Introduzca la edad de adquisicion del talento: ");
        Scanner sc = new Scanner(System.in);
        String valor = sc.next();
        int edadAdq = Integer.parseInt(valor);
        return edadAdq;
    }
    
    public Habilidad construirHabilidad() {
            Class personaje = tipoPersonaje.getClass();
            Disciplina disciplina = new Disciplina(null,0,0,0);
            Don don = new Don(null,0,0,0);
            Talento talento = new Talento(null,0,0,0);
        
            System.out.println("Introduzca el nombre de la habilidad: ");
            Scanner sc = new Scanner(System.in);
            String nombreHab = sc.next();
            if(personaje == Vampiro.class){
                disciplina.setNombre(nombreHab);
            }else if(personaje == Licantropo.class){
                don.setNombre(nombreHab);
            }else if(personaje == Cazador.class){
                talento.setNombre(nombreHab);
            }
        
            int ataque = 0;
            int defensa = 0;
        
            while((ataque < 1)|(ataque > 3)){
                System.out.println("Introduzca el valor de ataque -1,2 o 3-: ");
                sc = new Scanner(System.in);
                String valor = sc.next();
                try{
                    ataque = Integer.parseInt(valor);
                    if(personaje == Vampiro.class){
                        disciplina.setValorAtaque(ataque);
                    }else if(personaje == Licantropo.class){
                        don.setValorAtaque(ataque);
                    }else if(personaje == Cazador.class){
                        talento.setValorAtaque(ataque);
                    }
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }  
            while((defensa < 1)|(defensa > 3)){
                System.out.println("Introduzca el valor de defensa -1,2 o 3-: ");
                sc = new Scanner(System.in);
                String valor = sc.next();
                try{
                    defensa = Integer.parseInt(valor);
                    if(personaje == Vampiro.class){
                        disciplina.setValorDefensa(defensa);
                    }else if(personaje == Licantropo.class){
                        don.setValorDefensa(defensa);
                    }else if(personaje == Cazador.class){
                        talento.setValorDefensa(defensa);
                    }
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
           } 
            
           if(personaje == Vampiro.class){
               int coste = 0;
               do{
                  try{
                      coste = anadirCosteSangre();
                      disciplina.setCostePuntosSangre(coste);
                  }catch(RuntimeException e){
                      System.out.println(e.getMessage());
                  }
               }while((coste < 1)|(coste > 3));
               return disciplina; 
           }else if(personaje == Licantropo.class){
               int rabiaMin = anadirRabiaMin();
               don.setRabiaMin(rabiaMin);
               return don;
           }else if(personaje == Cazador.class){
               int edadAdquisicion = 0;
               do{
                  try{
                      edadAdquisicion = anadirEdadAdquisicion();
                      talento.setEdad(edadAdquisicion);
                  }catch(RuntimeException e){
                      System.out.println(e.getMessage());
                  }
               }while(edadAdquisicion < 0);
               return talento;
           }
           return null;
    }
    
    public void setHabilidadPersonaje(Habilidad habilidad){
        try{
            tipoPersonaje.setHabilidad(habilidad);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
  
    public int anadirEdad(){
       System.out.println("Introduzca la edad del vampiro: ");
       Scanner sc = new Scanner(System.in);
       String edadPer = sc.next();
       int edadP = Integer.parseInt(edadPer);
       return edadP;
    }
    
    public void setEdadPersonaje(int edadPer){
        try{
            tipoPersonaje.setEdad(edadPer);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
    public int anadirSangreAcum(){
        System.out.println("Introduzca los puntos de sangre acumulados del vampiro (0-10): ");
        Scanner sc = new Scanner(System.in);
        String reservaSangre = sc.next();
        int sangreAcum = Integer.parseInt(reservaSangre);
       return sangreAcum;
    }
    
    public void setSangreAcumPersonaje(int sagreAcumPer){
        try{
            tipoPersonaje.setReservaPuntosSangre(sagreAcumPer);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Fortaleza construirFortaleza() {
          int sensibilidad = 0;
          Fortaleza fortaleza = new Fortaleza(null,sensibilidad);
          System.out.println("introduzca el nombre de la fortaleza: ");
          Scanner sc = new Scanner(System.in);
          String nombreFortaleza = sc.next();
          fortaleza.setNombre(nombreFortaleza);
          do{
             System.out.println("introduzca la sensibilidad -entre 1 y 5-: ");
             sc = new Scanner(System.in);
             String sensibilidadMod = sc.next();
             sensibilidad = Integer.parseInt(sensibilidadMod);
             try{
                 fortaleza.setSensibilidad(sensibilidad);
             }catch(RuntimeException e){
                 System.out.println(e.getMessage());
             }
          }while((sensibilidad<1)|(sensibilidad>5));
          return fortaleza;
    }
    
    public void setNuevaFortalezaPersonaje(Fortaleza fortalezaPer){
        tipoPersonaje.setListaFortalezas(fortalezaPer);
    }
    
    public Debilidad construirDebilidad() { 
          int sensibilidad = 0;
          Debilidad debilidad = new Debilidad(null,sensibilidad);
          System.out.println("introduzca el nombre de la debilidad: ");
          Scanner sc = new Scanner(System.in);
          String nombreDebilidad = sc.next();
          debilidad.setNombre(nombreDebilidad);
          do{
             System.out.println("introduzca la sensibilidad -entre 1 y 5-: ");
             sc = new Scanner(System.in);
             String sensibilidadMod = sc.next();
             sensibilidad = Integer.parseInt(sensibilidadMod);
             try{
                 debilidad.setSensibilidad(sensibilidad);
             }catch(RuntimeException e){
                 System.out.println(e.getMessage());
             }
          }while((sensibilidad<1)|(sensibilidad>5));
          return debilidad;
    }
    
    public void setNuevaDebilidadPersonaje(Debilidad debilidadPer){
        tipoPersonaje.setListaDebilidades(debilidadPer);
    }
    
    public void atributosComunesPersonaje(){
        String nombrePer = anadirNombre();
        setNombrePersonaje(nombrePer);
        
        int oroPer = 0;
        do{
           oroPer = anadirOro();
           setOroPersonaje(oroPer);
        }while(oroPer < 0);
        
        int poderPer = 0;
        do{
           poderPer = anadirPoder();
           setPoderPersonaje(poderPer);
        }while(poderPer < 0 | poderPer > 5);
        
        int saludPer = 0;
        do{
           saludPer = anadirSalud();
           setSaludPersonaje(saludPer);
        }while(saludPer < 0 | saludPer > 5);
        
        String insertar;
        do{
            Armadura armaduraPer = anadirArmadura();
            setNuevaArmaduraPersonaje(armaduraPer);
            System.out.println("escriba -no- si no quiere anadir otra armadura");
            Scanner sc = new Scanner(System.in);
            insertar = sc.next();
        }while(!insertar.equals("no"));  
        
        do{
            Arma armaPer = anadirArma();
            setNuevaArmaPersonaje(armaPer);
            System.out.println("escriba -no- si no quiere anadir otra arma");
            Scanner sc = new Scanner(System.in);
            insertar = sc.next();
        }while(!insertar.equals("no"));
        
        do{

            Esbirro esbirro = anadirEsbirro();
            setNuevoEsbirroPersonaje(esbirro);
            
            System.out.println("escriba -no- si no quiere anadir otro esbirro");
            Scanner sc = new Scanner(System.in);
            insertar = sc.next();
        }while(!insertar.equals("no"));
        
        Habilidad habilidad = construirHabilidad();
        setHabilidadPersonaje(habilidad);
        
        do{
            Fortaleza fortaleza = construirFortaleza();
            setNuevaFortalezaPersonaje(fortaleza);
            System.out.println("escriba -no- si no quiere anadir otra fortaleza");
            Scanner sc = new Scanner(System.in);
            insertar = sc.next();
        }while(!insertar.equals("no"));
         
         do{
            Debilidad debilidad = construirDebilidad();
            setNuevaDebilidadPersonaje(debilidad);
            System.out.println("escribe -no- si no quiere anadir otra debilidad");
            Scanner sc = new Scanner(System.in);
            insertar = sc.next();
        }while(!insertar.equals("no"));
        
    }
    /**
     * se registra un personaje y se actualiza la información del usuario que registra el personaje 
     * en el listado del menú (userlist)
     */
    public void registrar_vampiro(){
        Fabrica fabrica = new FabricacionVampiro();
        this.setTipoPersonaje(fabrica.crearPersonaje());
        
        int edad = 0;
        do{
           edad = anadirEdad();
           setEdadPersonaje(edad);
        }while(edad < 0);
        
        int sangreAcum = -1;
        do{
           sangreAcum = anadirSangreAcum();
           setSangreAcumPersonaje(sangreAcum);
        }while(sangreAcum < 0 | sangreAcum > 10);
        
        atributosComunesPersonaje();
        menu.updateUser(this,tipoPersonaje);
        seleccionarOpcionMenu();

    }
    
    public void registrar_licantropo(){
        Fabrica fabrica = new FabricacionLicantropo();
        this.setTipoPersonaje(fabrica.crearPersonaje());
        
        atributosComunesPersonaje(); 
        menu.updateUser(this,tipoPersonaje);
        seleccionarOpcionMenu();
    }
    
    public void registrar_cazador(){
        Fabrica fabrica = new FabricacionCazador();
        this.setTipoPersonaje(fabrica.crearPersonaje());
        
        atributosComunesPersonaje();
       menu.updateUser(this,tipoPersonaje);
        seleccionarOpcionMenu();
    }
    
    public int apostarOro(){
        System.out.println("introduzca la cantidad de oro a apostar entre 0 y "+tipoPersonaje.getOro()+": ");
        Scanner sc = new Scanner(System.in);
        String cantidad = sc.next();
        int oro = Integer.parseInt(cantidad);
        return oro;
    }

    public void setOroApostado(int oroApostar){
        if(oroApostar < 0 | oroApostar > tipoPersonaje.getOro()){
            throw new RuntimeException("cantidad apostada no valida");
        }else{
            this.oroApostado = oroApostar;
        }
    }

    public int getOroApostado() {
        return oroApostado;
    }
    
    public Usuario buscarUsuarioDesafiar(List<Usuario> listaUsuarios, String nickUsuario){     
        for(Usuario usuarioDesafiado: listaUsuarios){
           if(usuarioDesafiado.nick.equals(nickUsuario)){
               return usuarioDesafiado;
           }
        }
        return null;
    }
    
    public boolean usuarioBaneado(List<Usuario> usuariosBaneados , Usuario usuario){
        for(Usuario us: usuariosBaneados){
            if(us.getNick().equals(usuario.nick)){
                return true;  
            }
        }
        return false;
    }
    
     public void desafiarUsuario(){
        System.out.println("introduzca el nick del usuario a desafiar: ");
        Scanner sc = new Scanner(System.in);
        String nickUsuarioDesafiar = sc.next();
        Usuario usuarioDesafiado = buscarUsuarioDesafiar(menu.getUserlist(),nickUsuarioDesafiar);
        if(usuarioDesafiado != null){
               boolean estaBaneado = usuarioBaneado(menu.getUsuariosBaneados(),usuarioDesafiado); 
               if(estaBaneado == false){
                   usuarioDesafiar = usuarioDesafiado;
                   do{
                      int oro = apostarOro();
                      setOroApostado(oro);
                   }while((oroApostado < 0)|(oroApostado > tipoPersonaje.getOro()));
                   menu.setUsuariosParaValidar(usuarioDesafiar);
                   menu.setUsuariosParaValidar(this);
                   System.out.println(menu.getDesafiosParaValidar().size());
               }else{
                  System.out.println("no puede desafiar a este usuario");
               }
        }else{
            System.out.println("este usuario no esta registrado");
        }
        seleccionarOpcionMenu();    
    } 
    
    public Armadura cambiarArmadura_activa(){
       return elegirArmadura_activa();
    }
    
    public int seleccionarArmaModificar(){ 
       List<Arma> armasActivas = tipoPersonaje.getArmasActivas();
       int cont = 1;
       for(Arma arm: armasActivas){
          System.out.println(cont + ".-" + arm.getNombre());
          cont++;
       }
       int opcArma = 0;
       do{
          System.out.println("seleccione el numero de arma a modificar: ");
          Scanner sc = new Scanner(System.in);
          String opc = sc.next();
          opcArma = Integer.parseInt(opc);
       }while((opcArma != 1)&(opcArma != 2));
       
       return opcArma;
    }
    
    public void cambiarArmasActivasPersonaje(){
        int posArmaModificar = seleccionarArmaModificar();
        Arma nuevaArma = elegirArma_activa();
        tipoPersonaje.setNuevasArmasActivas(posArmaModificar, nuevaArma);
    }
        
    public Armadura elegirArmadura_activa(){
           List<Armadura> armaduras = tipoPersonaje.getListaArmaduras();
           int cont = 1;
           for(Armadura a : armaduras){
              System.out.println(cont + ".-" + a.getNombre());
              cont++;
           }
           int opcArmadura = 0;
           do{
              System.out.println("escoga el numero de armadura activa: ");
              Scanner sc = new Scanner(System.in);
              String opc = sc.next();
              opcArmadura = Integer.parseInt(opc);
           }while((opcArmadura < 1)|(opcArmadura > cont));
           opcArmadura--;
           Armadura armaduraActiva = armaduras.get(opcArmadura);
           return armaduraActiva;
    }
    
    public void setArmaduraActivaPersonaje(Armadura armaduraActiva){
        tipoPersonaje.setArmaduraActiva(armaduraActiva);
    }
    
    public Arma elegirArma_activa(){
        List<Arma> armas = tipoPersonaje.getListaArmas();
        int cont = 1;
           for(Arma a : armas){
              System.out.println(cont + ".-" + a.getNombre());
              cont++;
           }
           int opcArma = 0;
           do{
              System.out.println("escoga un numero de arma activa: ");
              Scanner sc = new Scanner(System.in);
              String opc = sc.next();
              opcArma = Integer.parseInt(opc);
           }while((opcArma < 1)|(opcArma > cont));
           opcArma--;
           Arma arm = armas.get(opcArma);
           System.out.println(arm.getNombre());
        return arm;
    }
    
    public void setArmasActivasPersonaje(Arma armaActiva){
        tipoPersonaje.setArmasActivas(armaActiva);
    }
    
    public void consultarOro(){ 
      if(!menu.getListaCombates().isEmpty()){
        System.out.println("usuario: " + this.nombre);
        int cont = 1;
        for(Combate combate: menu.getListaCombates()){
            if(this.nombre.equals(combate.getDesafiante().getNombre())){
                System.out.print("combate " + cont);
                cont++;
                System.out.println(combate.getDesafiante().getTipoPersonaje().getOro());
            }else if(this.nombre.equals(combate.getDesafiado().getNombre())){
                System.out.print("combate " + cont);
                cont++;
                System.out.println(combate.getDesafiado().getTipoPersonaje().getOro());
            }
        }
      }else{
           System.out.println("no jugo en ningun combate");
      }
      seleccionarOpcionMenu();
    }
    
    public void consultarRanking(){
        List<Usuario> listaUsuarios = menu.getUserlist(); 
        Usuario [] usuarios = new Usuario[listaUsuarios.size()];
        int pos = 0;       
        for(Usuario usuario: listaUsuarios){
            usuarios[pos] = usuario;
            pos++;
        }
        for(int i = 0; i < usuarios.length; i++){
            for(int j = i+1; j < usuarios.length; j++){
                Usuario aux;
                if(usuarios[i].getTipoPersonaje().getOro() > usuarios[j].getTipoPersonaje().getOro()){
                    aux = usuarios[i];
                    usuarios[i] = usuarios[j];
                    usuarios[j] = aux;
                }
            }
        }
        for(int posUs = 0; posUs < usuarios.length; posUs++){
             System.out.print("usuario: " + usuarios[posUs].getNombre() + " --> ");
             System.out.println("oro: " + usuarios[posUs].getTipoPersonaje().getOro());
        }
        seleccionarOpcionMenu();
    }
    
    public void aceptar_rechazarDesafio(){ 
      if(!usuarioDesafiar.notifDesafio.isEmpty()){
        Desafio desafio = new Desafio(menu);
        int cont = 0;
        int iter = 0;
        while(iter != menu.getListaUsuariosDesafiantes().size() & usuarioDesafiar.notifDesafio.iterator().hasNext()){
            Usuario desafiante = menu.getListaUsuariosDesafiantes().get(iter);
            System.out.println("1.aceptar desafio con: " + desafiante.getNombre());
            System.out.println("2.rechazar desafio con: " + desafiante.getNombre());
            System.out.println("seleccione una opcion: ");
            Scanner  sc = new Scanner(System.in);
            String selec = sc.next();
            int opc = Integer.parseInt(selec);
            if(opc == 1){
                desafio.aceptar(usuarioDesafiar,desafiante);
                usuarioDesafiar.notifDesafio.remove(cont);
                cont++;
                menu.serializar(this);
            }else if(opc == 2){
                desafio.rechazar(usuarioDesafiar,desafiante);
                usuarioDesafiar.notifDesafio.remove(cont);
                cont++;
            }
            usuarioDesafiar.notifDesafio.iterator().next();
            iter++;
        }
      }else{
         System.out.println("no tiene desafios pendientes");
      }
      seleccionarOpcionMenu();
    }
   
    public void entrar_salirSistema(){  
      System.out.println("1.-entrar en el sistema");
      System.out.println("2.-salir del sistema");
      System.out.println("seleccione una opcion: -1 o 2-");
      Scanner sc = new Scanner(System.in);
      String opcion = sc.next();
      int opc = Integer.parseInt(opcion);
      if(opc == 1){
        boolean userRegistered = false;
        System.out.println("ingrese su nombre de usuario: ");
        sc = new Scanner(System.in);
        String nameUser = sc.next();
        //this.setNombreUsuario(nameUser);
        System.out.println("ingrese su contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contraseniaUser = sc.next();
        //this.setPassword(contraseniaUser);

        for(Usuario us: menu.getUserlist()){
           if(nameUser.equals(us.getNombre()) && contraseniaUser.equals(us.getPassword())){
               userRegistered = true;  
               while(!us.notifDesafio.isEmpty()){
                   usuarioDesafiar = us;
                   aceptar_rechazarDesafio();
               }
               seleccionarOpcionMenu();
           }
        }
        if(userRegistered == false){
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

    public Personaje getTipoPersonaje() {
        return tipoPersonaje;
    }
/*
    public void setUsuarioDesafiar(Usuario usuarioDesafiar) {
        this.usuarioDesafiar = usuarioDesafiar;
    }

    public Usuario getUsuarioDesafiar() {
        return usuarioDesafiar;
    }
*/
    public void setNotifDesafio(String notificacion) {
        this.notifDesafio.add(notificacion);
    }

    public List<String> getNotifDesafio() {
        return notifDesafio;
    }
        
}


