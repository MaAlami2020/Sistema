/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mimit
 * esta clase es abstarcta, por tanto, en la clase sistema, en vez de crear objetos de la clase ussuario crearé objetos de sus hijas
 */
public class Usuario extends MenuInicio{
    private String nombre;
    private String nick;
    private String password;  
    private StringBuilder registro = new StringBuilder();
    private Personaje tipoPersonaje;
    private int index = 0;
    private Usuario usuarioDesafiar;
    private Usuario usuarioDesafiante;
    private int oroApostado;
    private List<String> notifDesafio = new ArrayList<>();
    private Combate combate;
    private Desafios desafios;
    private Operador operador;

    public Usuario(String nombre, String nick, String password, StringBuilder registro, Personaje tipoPersonaje) throws IOException{
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;
        this.registro = registro;
        this.tipoPersonaje = tipoPersonaje;
        this.operador = new Operador();
    }

    public Usuario()throws FileNotFoundException, IOException{
        
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
    
    public StringBuilder updateRegistro(){
        if(getUserlist().size() != 0){
       //char [] registroArray = new char[4];
          for(int i = 0; i <= 4; i++){
          //registroArray[i] = registro.charAt(i);
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

    @Override
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
        String nameOp = sc.next();
        System.out.println("ingrese su contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contraseniaOp = sc.next();
        for(Usuario us: getUserlist()){
           if((nameOp.equals(us.getNombre()))&(contraseniaOp.equals(us.getPassword()))){
                getUserlist().remove(us);
                System.out.println("cuenta eliminada");
                entrar_salirSistema();
           }
        }
      }else if(opcion == 1){
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
        while((contrasenia.length() < 8)|(contrasenia.length() > 12)){
           System.out.println("Por favor, ingrese una nueva contrasenia (8-12 caracteres): ");
           sc = new Scanner(System.in);
           contrasenia = sc.next();
        }
        this.setPassword(contrasenia);
        
        for(Usuario us: getUserlist()){
           if((us.getNombre().equals(name))&(us.getNick().equals(apodo))){
               userRegistered = true;
               System.out.println("usuario ya registrado");
               entrar_salirSistema();
           }
        }
        if(userRegistered == false){
            tipoPersonaje = null;
            try {
                if(getUserlist().size()==0){                
                    registro.append("A00AA");
                    getUserlist().add(new Usuario(name,apodo,contrasenia,registro,tipoPersonaje));
                    
                }else{
                    StringBuilder reg = updateRegistro();
                    getUserlist().add(new Usuario(name,apodo,contrasenia,reg,tipoPersonaje));
                }
            } catch (IOException ex) {
                System.out.println("error");
            }
            System.out.println("registrado/a corractamente");
            entrar_salirSistema();
        }
      }
    
    }
    
    public void seleccionarOpcionMenu(){
        System.out.println("***BIENVENIDO**");
        System.out.println("3.-registrar/dar de baja un personaje");
        System.out.println("4.-desafiar a otro usuario");
        System.out.println("5.-elegir armas/armaduras activas");
        System.out.println("6.-consultar oro");
        System.out.println("7.-consultar ranking");
        System.out.println("8.-aceptar/rechazar desafios"); 
        System.out.println("escoga una opcion: ");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.next();
        Integer opc =Integer.parseInt(opcion);
        switch(opc){
            case 3:{
               System.out.println("1.-registrar personaje");
               System.out.println("2.-dar de baja personaje");
               System.out.println("seleccione una opcion: -1 o 2-");
               sc = new Scanner(System.in);
               String option = sc.next();
               Integer opt =Integer.parseInt(option);
               if(opt == 1){
                   registrar_Personaje();
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
               sc = new Scanner(System.in);
               String option = sc.next();
               Integer opt =Integer.parseInt(option);
               if(opt == 1){
                   elegirArmas_activas();
               }else if(opt == 2){
                   elegirArmadura_activa();
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
        getUserlist().get(index).tipoPersonaje = null;
        seleccionarOpcionMenu();
    }
    
    public void registrar_Personaje(){
        System.out.println("1.-vampiro");
        System.out.println("2.-licantropo");
        System.out.println("3.-cazador");
        System.out.println("escoga el tipo de personaje a registrar -1,2 o 3-: ");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.next();
        int opc =Integer.parseInt(opcion);
        if(opc == 1){
           FabricacionVampiro fabVampiro = new FabricacionVampiro();
           getUserlist().get(index).tipoPersonaje = fabVampiro.crearPersonaje(); 
           seleccionarOpcionMenu();
        }else if(opc == 2){
           FabricacionLicantropo fabLicantropo = new FabricacionLicantropo();
           getUserlist().get(index).tipoPersonaje = fabLicantropo.crearPersonaje(); 
           seleccionarOpcionMenu();
        }else if(opc == 3){
           FabricacionCazador fabCazador = new FabricacionCazador();
           getUserlist().get(index).tipoPersonaje = fabCazador.crearPersonaje(); 
           seleccionarOpcionMenu();
        }
    }
    
    public void apostarOro(){
        do{
            System.out.println("introduzca la cantidad de oro a apostar: ");
            Scanner sc = new Scanner(System.in);
            String cantidad = sc.next();
            oroApostado = Integer.parseInt(cantidad);
        }while((oroApostado < 0)|(oroApostado > getUserlist().get(index).tipoPersonaje.anadirOro()));
        
    }

    public int getOroApostado() {
        return oroApostado;
    }
    
    public void desafiarUsuario(){
        usuarioDesafiante = this;
        System.out.println("introduzca el nick del usuario a desafiar: ");
        Scanner sc = new Scanner(System.in);
        String nickUsuarioDesafiar = sc.next();
        for(Usuario usuarioDesafiado: getUserlist()){
           if(usuarioDesafiado.nick.equals(nickUsuarioDesafiar)){
               boolean estaPresente = false;
               for(Usuario us: operador.getUsuariosBaneados()){
                   if(us.getNick().equals(usuarioDesafiado.nick)){
                       estaPresente = true;  
                   }
               }if(estaPresente == false){
                  usuarioDesafiar = usuarioDesafiado;
                  apostarOro();
                  operador.validarDesafio();
               }else{
                  System.out.println("no puede desafiar a este usuario");
               }
           }
        }
        
        seleccionarOpcionMenu();    
    }
    public void cambiarArmadura_activa(){
       List<Armadura> armaduraActiva = usuarioDesafiar.tipoPersonaje.getListaArmaduras();
       int cont = 1;
       for(Armadura armd: armaduraActiva){
          System.out.println(cont + ".-" + armd.getNombre());
       }
       int opcNuevaArmadura = 0;
       do{
          System.out.println("escoga el numero de nueva armadura activa: ");
          Scanner sc = new Scanner(System.in);
          String opc = sc.next();
          opcNuevaArmadura = Integer.parseInt(opc);
       }while((opcNuevaArmadura > cont)|(opcNuevaArmadura <= 0));
       armaduraActiva.set(0, usuarioDesafiar.tipoPersonaje.getArmadurasActivas().get(opcNuevaArmadura--));
    }
    
    public void cambiarArmas_activas(){ 
       List<Arma> armasActivas = usuarioDesafiar.tipoPersonaje.getArmasActivas();
       int cont = 1;
       for(Arma arm: armasActivas){
          System.out.println(cont + ".-" + arm.getNombre());
       }
       int opcArma = 0;
       do{
          System.out.println("seleccione el arma a modificar -1 o 2-: ");
          Scanner sc = new Scanner(System.in);
          String opc = sc.next();
          opcArma = Integer.parseInt(opc);
       }while((opcArma != 1)|(opcArma != 2));
       if((opcArma == 1)|(opcArma == 2)){
           Arma arma = usuarioDesafiar.tipoPersonaje.getArmasActivas().get(opcArma--); 
           List<Arma> armas = getUserlist().get(index).tipoPersonaje.getListaArmas();
           int pos = 1;
           for(Arma a : armas){
              if(a.getManejo() == arma.getManejo()){ 
                 System.out.println(pos + ".-" + a.getNombre());
              pos++;
              }
           }
           int opcNuevaArma = 0;
           do{
              System.out.println("escoga el numero de nueva arma activa: ");
              Scanner sc = new Scanner(System.in);
              String opc = sc.next();
              opcNuevaArma = Integer.parseInt(opc);
           }while(usuarioDesafiar.tipoPersonaje.getArmasActivas().get(opcNuevaArma--).getManejo() != arma.getManejo());
           armasActivas.set(opcArma--, usuarioDesafiar.tipoPersonaje.getArmasActivas().get(opcNuevaArma--));
       }
       seleccionarOpcionMenu();
    }
    public void elegirArmadura_activa(){
           List<Armadura> armaduras = getUserlist().get(index).tipoPersonaje.getListaArmaduras();
           int cont = 1;
           for(Armadura a : armaduras){
              System.out.println(cont + ".-" + a.getNombre());
              cont++;
           }
           System.out.println("escoga el numero de armadura activa: ");
           Scanner sc = new Scanner(System.in);
           String opc = sc.next();
           int opcArmadura = Integer.parseInt(opc);
           getUserlist().get(index).tipoPersonaje.getArmadurasActivas().add(armaduras.get(opcArmadura--));
           seleccionarOpcionMenu();
    }
    
    public void elegirArmas_activas(){
        List<Arma> armas = getUserlist().get(index).tipoPersonaje.getListaArmas();
        int cont = 1;
        int manejoArma = 2;
        while(manejoArma != 0){
           for(Arma a : armas){
              System.out.println(cont + ".-" + a.getNombre());
              cont++;
           }
           System.out.println("escoga el numero de arma activa: ");
           Scanner sc = new Scanner(System.in);
           String opc = sc.next();
           int opcArma = Integer.parseInt(opc);
           String manejo = armas.get(opcArma--).getManejo();
           if(manejo.equals("1 mano")){
              getUserlist().get(index).tipoPersonaje.getArmasActivas().add(armas.get(opcArma--));
              manejoArma--;
              cont = 1;
              for(Arma a : armas){
                  if(a.getManejo().equals("1 mano")){
                     System.out.println(cont + ".-" + a.getNombre());
                  cont++;
                  }
              }
              System.out.println("escoga el numero de arma activa");
              sc = new Scanner(System.in);
              opc = sc.next();
              opcArma = Integer.parseInt(opc);
              getUserlist().get(index).tipoPersonaje.getArmasActivas().add(armas.get(opcArma--));
              manejoArma--;
           }else if(manejo.equals("2 manos")){
              getUserlist().get(index).tipoPersonaje.getArmasActivas().add(armas.get(opcArma--)); 
              manejoArma = 0;
           }
        }
        seleccionarOpcionMenu();
    }
    
    public void consultarOro(){
        System.out.println("usuario: " + this.nombre);
        System.out.print("oro ganado: ");
        for(Combate combate: operador.getListaCombates()){
            if(this.nombre.equals(combate.getUsuarioDesafiante().getNombre())){
                System.out.print(combate.getUsuarioDesafiante().getTipoPersonaje().anadirOro());
            }else if(this.nombre.equals(combate.getUsuarioDesafiado().getNombre())){
                System.out.print(combate.getUsuarioDesafiado().getTipoPersonaje().anadirOro());
            }
        }
    }
    
    public void consultarRanking(){
        List<Usuario> listaUsuarios = getUserlist(); 
        Usuario [] usuarios = new Usuario[listaUsuarios.size()];
        int pos = 0;       
        for(Usuario usuario: listaUsuarios){
            usuarios[pos] = usuario;
            pos++;
        }
        for(int i = 0; i < usuarios.length; i++){
            for(int j = i+1; j < usuarios.length; j++){
                Usuario aux = null;
                if(usuarios[i].getTipoPersonaje().anadirOro() > usuarios[j].getTipoPersonaje().anadirOro()){
                    aux = usuarios[i];
                    usuarios[i] = usuarios[j];
                    usuarios[j] = aux;
                }
            }
        }
        for(int posUs = usuarios.length; posUs > 0; posUs--){
             System.out.print("usuario: " + usuarios[pos].getNombre() + " --> ");
             System.out.println("oro ganado: " + usuarios[posUs].getTipoPersonaje().anadirOro());
        }
    }
    
    public void mostrarResultadoDesafiante(){
       combate.mostrarResultaddo();
    }
    
    public void aceptar_rechazarDesafio(){
        int cont = 0;
        while(notifDesafio.iterator().hasNext()){
            System.out.println("1.aceptar desafio");
            System.out.println("2.rechazar desafio");
            System.out.println("seleccione una opcion: ");
            Scanner  sc = new Scanner(System.in);
            String selec = sc.next();
            int opc = Integer.parseInt(selec);
            if(opc == 1){
                desafios.aceptarDesafio();
                notifDesafio.remove(cont);
                cont++;
                mostrarResultadoDesafiante();
                serializar(this);
            }else if(opc == 2){
                desafios.rechazarDesafio();
                notifDesafio.remove(cont);
                cont++;
            }
            notifDesafio.iterator().next();
        }
        seleccionarOpcionMenu();
    }
    
    public void serializar(Object obj){
       try{
           String fich = "C:\\Users\\mimit\\Sistema\\sistema.bin";
           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fich));
           out.writeObject((Object)obj);
           out.close();
       }catch(Exception e){
           System.out.println(e);
       }
    }
   
    @Override
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
        this.setNombre(nameUser);
        System.out.println("ingrese su contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contraseniaUser = sc.next();
        this.setPassword(contraseniaUser);
        for(Usuario us: getUserlist()){
           if((nameUser.equals(us.getNombre()))&(contraseniaUser.equals(us.getPassword()))){
               userRegistered = true;
               index = getUserlist().indexOf(us);
               if(notifDesafio.size() != 0){
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Personaje getTipoPersonaje() {
        return tipoPersonaje;
    }

    public int getIndex() {
        return index;
    }

    public Usuario getUsuarioDesafiante() {
        return usuarioDesafiante;
    }

    public Usuario getUsuarioDesafiar() {
        return usuarioDesafiar;
    }

    public List<String> getNotifDesafio() {
        return notifDesafio;
    }
    
    
}
