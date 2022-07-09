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
public class Usuario implements Serializable{
    private String nombre;
    private String nick;
    private String password;  
    private String registro = "A00AA";
    private Personaje tipoPersonaje;
    private MenuInicio menu;
    private List<Oferta> ofertas = new ArrayList<>();
    private List<String> suscripciones = new ArrayList<>();
    private List<Oferta> notificaciones = new ArrayList<>();

    public Usuario(String nombre, String nick, String password){
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;   
    }

    //public Usuario(){  
    //}
    
    public Usuario(MenuInicio menu){
        this.menu = menu;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }
    
    public void setMenu(MenuInicio menu) {
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

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void setTipoPersonaje(Personaje tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }
    
    public String updateRegistro(){
        if(!menu.getUserlist().isEmpty()){
          for(int i = 4; i >= 0; i--){
             char caracter = registro.charAt(i);
             if(caracter < 'Z' || caracter < '9'){
                char nuevoCaracter = caracter;
                int numReg = menu.getUserlist().size();
                nuevoCaracter += numReg;
                StringBuilder regAux = new StringBuilder();
                regAux = regAux.append(registro);
                regAux.setCharAt(i, nuevoCaracter);
                registro = regAux.toString();
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
        }while(contraseniaUs.length() < 8 || contraseniaUs.length() > 12);
        setPassword(contraseniaUs);
        boolean cuentaEliminada = false;
        for(Usuario us: menu.getUserlist()){
           if(nameUs.equals(us.getNombre()) && contraseniaUs.equals(us.getPassword())){
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
        while(contrasenia.length() < 8 || contrasenia.length() > 12){
           System.out.println("Por favor, ingrese una nueva contrasenia (8-12 caracteres): ");
           sc = new Scanner(System.in);
           contrasenia = sc.next();
           actualizarContrasenia(contrasenia);
        }
        

        for(Usuario us: menu.getUserlist()){
           if(us.getNombre().equals(this.getNombre()) && us.getNick().equals(this.getNick()) && us.getPassword().equals(this.getPassword())){
               userRegistered = true;
               System.out.println("usuario ya registrado");
               entrar_salirSistema();
           }
        }
        if(userRegistered == false){
            tipoPersonaje = null;
            if(menu.getUserlist().isEmpty()){                
                  //registro.append("A00AA");
                  anadirNuevoUsuario(nombre,nick,password,registro,tipoPersonaje);                  
            }else{
                  String reg = updateRegistro();
                  anadirNuevoUsuario(nombre,nick,password,reg,tipoPersonaje);
            }
            System.out.println("registrado/a corractamente");
            entrar_salirSistema();
        }
      }
    
    }
    public void anadirNuevoUsuario(String name,String apodo,String contrasenia,String reg,Personaje tipoPersonaje){
        Usuario usuario = new Usuario(name,apodo,contrasenia);
        usuario.setRegistro(reg);
        usuario.setTipoPersonaje(tipoPersonaje);
        serializar(usuario);
        usuario.setMenu(menu);
        menu.setUserlist(usuario);
    }
  
    public void seleccionarOpcionMenu(){
        int opc;
        do{
            System.out.println("***BIENVENIDO**");
            System.out.println("3.-añadir/eliminar equipo");
            System.out.println("4.-añadir esbirro/s al personaje");
            System.out.println("5.-añadir/eliminar oro personaje");
            System.out.println("6.-seleccionar equipo/esbirros a ofertar");
            System.out.println("7.-consultar ofertas publicadas");
            System.out.println("8.-suscribirse  a ofertas de otros usuarios");
            System.out.println("9.-comprar los elementos de una oferta"); 
            System.out.println("10.-consultar oro, equipo, esbirros actuales"); 
            System.out.println("11.-salir del sistema");
            System.out.println("escoga una opcion: ");
            Scanner sc = new Scanner(System.in);
            String opcion = sc.next();
            opc =Integer.parseInt(opcion);
           
            if(opc >= 3 && opc <= 9){
                switch(opc){
                    case 3:{
                        System.out.println("1.-añadir equipo");
                        System.out.println("2.-eliminar equipo");
                        System.out.println("seleccione una opcion: -1 o 2-");
                        sc = new Scanner(System.in);
                        String option = sc.next();
                        int opt = Integer.parseInt(option);
                        if(opt == 1){
                            System.out.println("1.-añadir arma");
                            System.out.println("2.-añadir armadura");
                            System.out.println("seleccione una opcion: -1 o 2-");
                            sc = new Scanner(System.in);
                            option = sc.next();
                            opt = Integer.parseInt(option);
                            if(opt == 1){
                                Arma arma = añadirArma();
                                setNuevaArmaPersonaje(arma);
                            }else if(opt == 2){
                                Armadura armadura = añadirArmadura();
                                setNuevaArmaduraPersonaje(armadura);
                            }
                        }
                        break;
                    }case 4:{
                        Esbirro esbirro = añadirEsbirro();
                        setNuevoEsbirroPersonaje(esbirro);
                        break;
                    }case 5:{
                        System.out.println("1.-añadir oro personaje");
                        System.out.println("2.-eliminar oro personaje");
                        System.out.println("seleccione una opcion: -1 o 2-");
                        sc = new Scanner(System.in);
                        String option = sc.next();
                        int opt =Integer.parseInt(option);
                        if(opt == 1){
                            int valor = añadirOro();
                            añadirOroPersonaje(valor);
                        }else if(opt == 2){
                            reducirOroPersonaje();
                        }
                        break;
                    }case 6:{
                        seleccionarEquipo_esbirrosOfertar();                  
                        break;
                    }case 7:{
                        consultarOfertasPublicadas();
                        break;
                    }case 8:{
                        seleccionarTipoSuscripcion();
                        break;
                    }case 9:{
                        comprarElementos();
                        break;
                    }case 10:{
                        consultarOro_Equipo_Esbirros();
                    }case 11:{
                        System.out.println("saliendo del sistema");
                    }
                }
            }else{
                System.out.println("seleccion erronea");
            }
        }while(opc !=11);
    }

    public List<String> getSuscripciones() {
        return suscripciones;
    }

    public List<Oferta> getNotificaciones() {
        return notificaciones;
    }
    
    public void seleccionarTipoSuscripcion(){
        //TipoSuscripcion suscripcion = null;
        String opcion;
        do{
            System.out.println("1.suscripcion por tipo de equipo/esbirros");
            System.out.println("2.suscripcion por categoria");
            System.out.println("3.suscripcion por valor");
            System.out.println("4.suscripcion por lealtad de esbirro");
            System.out.println("5.suscripcion por tipo de esbirro");
            System.out.println("6.suscripcion por tipo  de usuario");
            System.out.println("7.suscripcion por precio");
            System.out.println("seleccione un numero de tipo de suscripcion");
            Scanner sc = new Scanner(System.in);
            opcion = sc.next();
            int tipoOpcion = Integer.parseInt(opcion);
            switch(tipoOpcion){
                case 1:
                    //suscripcion = TipoSuscripcion.porTipo;
                    System.out.println("seleccione el  tipo de suscripcion: 1.armas, 2.armaduras, 3.esbirros, 4. armas/esbirros, 5.armaduras/esbirros");
                    sc = new Scanner(System.in);
                    opcion = sc.next();
                    int subTipoOpcion = Integer.parseInt(opcion);
                    switch(subTipoOpcion){    
                        case 1:suscripciones.add("tipo:" + Arma.class);
                        case 2:suscripciones.add("tipo:" + Armadura.class);
                        case 3:suscripciones.add("tipo:" + Esbirro.class);
                        case 4:
                            suscripciones.add("tipo:" + Arma.class);
                            suscripciones.add("tipo:" + Esbirro.class);
                        case 5:
                            suscripciones.add("tipo:" + Armadura.class);
                            suscripciones.add("tipo:" + Esbirro.class);
                        default:System.out.println("seleccion erronea");
                    }    
                case 2:
                    //suscripcion = TipoSuscripcion.porCategoria;
                    System.out.println("seleccione la categoria de la suscripcion: 1.Comun, 2.Raro, 3.Epico, 4.Legendario");
                    sc = new Scanner(System.in);
                    opcion = sc.next();
                    subTipoOpcion = Integer.parseInt(opcion);
                    switch(subTipoOpcion){    
                        case 1:suscripciones.add("categoria:" + Categoria.Comun);
                        case 2:suscripciones.add("categoria:" + Categoria.Raro);
                        case 3:suscripciones.add("categoria:" + Categoria.Epico);
                        case 4:suscripciones.add("categoria:" + Categoria.Legendario);
                        default:System.out.println("seleccion erronea");
                    } 
                case 3:
                    //suscripcion = TipoSuscripcion.porCategoria;
                    System.out.println("seleccione el valor de la suscripcion: 1, 2 o 3");
                    sc = new Scanner(System.in);
                    opcion = sc.next();
                    int valorSusc = Integer.parseInt(opcion);
                    switch(valorSusc){
                        case 1:suscripciones.add("valor:" + 1);
                        case 2:suscripciones.add("valor:" + 2);
                        case 3:suscripciones.add("valor:" + 3);
                    }
                case 4:
                    System.out.println("seleccione la lealtad de la suscripcion: 1.ALTA, 2.NORMAL, 3.BAJA");
                    sc = new Scanner(System.in);
                    opcion = sc.next();
                    subTipoOpcion = Integer.parseInt(opcion);
                    switch(subTipoOpcion){    
                        case 1:suscripciones.add("lealtad:" + Lealtad.ALTA);
                        case 2:suscripciones.add("lealtad:" + Lealtad.NORMAL);
                        case 3:suscripciones.add("lealtad:" + Lealtad.BAJA);
                        default:System.out.println("seleccion erronea");
                    } 
                case 5:
                    System.out.println("seleccione el tipo de esbirro de la suscripcion: 1.ghoul, 2.demonio, 3.humano");
                    sc = new Scanner(System.in);
                    opcion = sc.next();
                    subTipoOpcion = Integer.parseInt(opcion);
                    switch(subTipoOpcion){    
                        case 1:suscripciones.add("esbirro:" + Ghoul.class);
                        case 2:suscripciones.add("esbirro:" + Demonio.class);
                        case 3:suscripciones.add("esbirro:" + Humano.class);
                        default:System.out.println("seleccion erronea");
                    } 
                case 6:
                    System.out.println("seleccione el tipo de usuario de la suscripcion: 1.vampiro, 2.licantropo, 3.cazador");
                    sc = new Scanner(System.in);
                    opcion = sc.next();
                    subTipoOpcion = Integer.parseInt(opcion);
                    switch(subTipoOpcion){    
                        case 1:suscripciones.add("usuario:" + Vampiro.class);
                        case 2:suscripciones.add("usuario:" + Licantropo.class);
                        case 3:suscripciones.add("usuario:" + Cazador.class);
                        default:System.out.println("seleccion erronea");
                    } 
                case 7:
                    int min;
                    do{
                        System.out.println("introduzca el precio minimo de la  suscripcion");
                        sc = new Scanner(System.in);
                        opcion = sc.next();
                        min = Integer.parseInt(opcion);
                    }while(min < 0);
                    int max;
                    do{
                        System.out.println("introduzca el precio maximo de la  suscripcion");
                        sc = new Scanner(System.in);
                        opcion = sc.next();
                        max = Integer.parseInt(opcion);
                    }while(max <= min);
                    suscripciones.add("precio:" + min + "-" + max);
            }
        System.out.println("escriba -no- si no quiere añadir otro tipo de suscripcion");
        sc = new Scanner(System.in);
        opcion = sc.next();
        }while(!opcion.equals("no"));
    }
    
    public void consultarOro_Equipo_Esbirros(){
        List<Esbirro> esbirrosPer = menu.getUsuarioActual().get(0).getTipoPersonaje().getListaEsbirros();
        List<Arma> listaArmas = menu.getUsuarioActual().get(0).getTipoPersonaje().getListaArmas();
        for(Arma arm: listaArmas){
            System.out.println("nombre arma: " + arm.getNombre());
        }
        List<Armadura> listaArmaduras = menu.getUsuarioActual().get(0).getTipoPersonaje().getListaArmaduras();
        for(Armadura armd: listaArmaduras){
            System.out.println("nombre armadura: " + armd.getNombre());
        }
        int index = 1;
        for(Esbirro esbP: esbirrosPer){
            System.out.println("esbirro: " + index + esbP.getNombre());
            index++;
        }
        double oroActual = menu.getUsuarioActual().get(0).getTipoPersonaje().getOro();
        System.out.println("oro actual " + oroActual);
    }
    
    public void seleccionarEquipo_esbirrosOfertar(){
        String repProceso;
        do{
            int opcion;
            Oferta oferta = new Oferta();
            System.out.println("1.-añadir equipo");
            System.out.println("2.-añadir esbirro/s");
            System.out.println("seleccione una opcion -1 o 2-");
            Scanner sc = new Scanner(System.in);
            String selec = sc.next();
            opcion = Integer.parseInt(selec);
            if(opcion == 1){
                if(oferta.getEquipoEnVenta() != null){
                    Equipo equipo = ofertarEquipo();
                    oferta.setEquipoEnVenta(equipo);
                }else{
                    System.out.println("ya tiene un equipo a la venta, escriba -si- si quiere modificarlo");
                    sc = new Scanner(System.in);
                    String opc = sc.next();
                    if(opc.equals("si")){
                        Equipo equipo = ofertarEquipo();
                        oferta.setEquipoEnVenta(equipo);
                    }
                }
            }else if(opcion == 2){
                String repetir;
                do{
                    Esbirro esbirroVenta = ofertarEsbirro();
                    oferta.setEsbirroParaTraspasar(esbirroVenta);
                    System.out.println("escriba -si- si quiere añadir otro esbirro a la oferta");
                    sc = new Scanner(System.in);
                    repetir = sc.next();
                }while(repetir.equals("si"));      
            }
            System.out.println("introduce el precio de venta de la oferta");
            sc = new Scanner(System.in);
            selec = sc.next();
            double precio = Integer.parseInt(selec); 
            oferta.setPrecioVenta(precio);
            menu.setOfertasPendientes(oferta);
            menu.getUsuarioActual().get(0).ofertas.add(oferta);
            
            System.out.println("escriba -si- si quiere añadir otra oferta");
            sc = new Scanner(System.in);
            repProceso = sc.next();
        }while(repProceso.equals("si"));
    }
    
    public void comprarElementos(){
        int opc;
        Venta venta = new Venta();
        do{
            consultarOfertasPublicadas();
            System.out.println("Seleccione una de las ofertas");
            Scanner sc = new Scanner(System.in);
            String opcionOferta = sc.next();
            opc = Integer.parseInt(opcionOferta);
        }while(opc <= 0 || opc > menu.getOfertasValidadas().size());
        
        int op = opc--;
        Oferta ofertaComprar = menu.getOfertasValidadas().get(op);
         boolean encontrado = false;
        for(Usuario us: menu.getUserlist()){
            for(Oferta offer: us.getOfertas()){
                if(offer.equals(ofertaComprar)){
                   encontrado = true;
                   venta.setVendedor(us);
                }
            }
        }
        boolean baneado = false;
        for(Usuario usBaneado: menu.getUsuariosBaneados()){
            if(usBaneado.equals(venta.getVendedor())){
               baneado = true;
            }  
        }
        if(!baneado){
            venta.setComprador(menu.getUsuarioActual().get(0));
            if(encontrado && ofertaComprar.getPrecioVenta()<=menu.getUsuarioActual().get(0).getTipoPersonaje().getOro()){
                menu.getOfertasValidadas().remove(ofertaComprar);
                if (ofertaComprar.getEquipoEnVenta() != null) {
                    Class equipo = ofertaComprar.getEquipoEnVenta().getClass();
                    if (equipo.equals(Arma.class)) {
                        venta.getVendedor().getTipoPersonaje().getListaArmas().remove((Arma) ofertaComprar.getEquipoEnVenta());
                        menu.getUsuarioActual().get(0).getTipoPersonaje().setListaArmas((Arma) ofertaComprar.getEquipoEnVenta());

                    } else {
                        venta.getVendedor().getTipoPersonaje().getListaArmaduras().remove((Armadura) ofertaComprar.getEquipoEnVenta());
                        menu.getUsuarioActual().get(0).getTipoPersonaje().setListaArmaduras((Armadura) ofertaComprar.getEquipoEnVenta());
                    }
                    venta.setEquipo(ofertaComprar.getEquipoEnVenta());
                }
                if (ofertaComprar.getEsbirroParaTraspasar() != null) {
                    for(Esbirro esb : ofertaComprar.getEsbirroParaTraspasar()){
                        menu.getUsuarioActual().get(0).getTipoPersonaje().setListaEsbirros(esb);
                        venta.getVendedor().getTipoPersonaje().getListaEsbirros().remove(esb);
                    }
                }  
                venta.setEsbirros(ofertaComprar.getEsbirroParaTraspasar());

                double oroComprador = menu.getUsuarioActual().get(0).getTipoPersonaje().getOro()-ofertaComprar.getPrecioVenta();
                menu.getUsuarioActual().get(0).getTipoPersonaje().setOro(oroComprador);

                double oroVendedor = venta.getVendedor().getTipoPersonaje().getOro()+ofertaComprar.getPrecioVenta();
                venta.getVendedor().getTipoPersonaje().setOro(oroVendedor);
                venta.setPrecio(ofertaComprar.getPrecioVenta());
                venta.setFecha(LocalDate.now());

                menu.setVentas(venta);
            } else {
                System.out.println("No tienes el oro suficiente");
            }
        }
    }
     
    public void consultarOfertasPublicadas(){
        boolean esMiOferta = false;
        List<Oferta> existencias = menu.getOfertasValidadas();
        if(!existencias.isEmpty()){
            int cont = 1;
            for(Oferta elem: existencias){
                for(Oferta miOferta: menu.getUsuarioActual().get(0).ofertas){
                    if(miOferta.equals(elem)){
                        esMiOferta = true; 
                    }
                }
                if(!esMiOferta){
                    System.out.println("oferta " + cont);
                    System.out.println("nombre equipo: " + elem.getEquipoEnVenta().getNombre());
                    int index = 1;
                    for(Esbirro esb: elem.getEsbirroParaTraspasar()){
                        System.out.println("esbirro: " + index + esb.getNombre());
                        index++;
                    }
                    System.out.println("precio total: " + elem.getPrecioVenta());
                }
                cont++;
            }
        }else{
            System.out.println("no hay ofertas publicadas");
        }
    }
    
    public Esbirro ofertarEsbirro(){
            List<Esbirro> esbirros = menu.getUsuarioActual().get(0).getTipoPersonaje().getListaEsbirros();
            int cont = 1;
            for(Esbirro esb: esbirros){
                Class claseEsbirro = menu.getUsuarioActual().get(0).getTipoPersonaje().getListaEsbirros().get(cont).getClass();
                if(claseEsbirro == Ghoul.class){
                    System.out.println(cont + ". " + esb.getNombre() + " GHOUL");
                }else if(claseEsbirro == Humano.class){
                    System.out.println(cont + ". " + esb.getNombre() + " HUMANO");
                }else if(claseEsbirro == Demonio.class){
                    System.out.println(cont + ". " + esb.getNombre() + " DEMONIO");
                    List<Esbirro> hijos = menu.getUsuarioActual().get(0).getTipoPersonaje().getListaEsbirros().get(cont).getHijos();
                    int contHijo = 1;
                    for(Esbirro esbHijo: hijos){
                        System.out.println(" hijo " + contHijo + ": " + esbHijo.getNombre());
                        contHijo++;
                    }
                }
                cont++;
            }
            int numOpc;
            do{
                System.out.println("escoga el numero de esbirro a ofertar");
                Scanner sc = new Scanner(System.in);
                String opc = sc.next();
                numOpc = Integer.parseInt(opc);
            }while(numOpc < 1 || numOpc >= cont);
            Esbirro esbirroEnVenta = menu.getUsuarioActual().get(0).getTipoPersonaje().getListaEsbirros().get(cont--); 
            return esbirroEnVenta;
    }
    
    public Equipo ofertarEquipo(){
        System.out.println("1.-añadir arma");
        System.out.println("2.-añadir armadura");
        System.out.println("seleccione el tipo de equipo, -1 o 2-");
        Scanner sc = new Scanner(System.in);
        String selec = sc.next();
        int opcion = Integer.parseInt(selec);
        if(opcion == 1){
            Arma arm = elegirArma();
            return  arm;
        }else if(opcion == 2){
            Armadura armd = elegirArmadura();
            return armd;
        }   
        return null;
    }
    
    public void darBaja_Personaje(){
        menu.getUsuarioActual().get(0).setTipoPersonaje(null);
    }
    
    public Esbirro añadirEsbirro(){ 
        int opcion = 0;
        do{
           System.out.println("1.-ghoul");
           System.out.println("2.-demonio");
           System.out.println("3.-humano");
           System.out.println("seleccione una opcion -1, 2 o 3-");
           Scanner sc = new Scanner(System.in);
           String selec = sc.next();
           opcion = Integer.parseInt(selec);
        }while(opcion < 1 || opcion > 3);
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
                     }while(saludEsb < 1 || saludEsb > 3);   
                        
                     int depEsb = 0;
                     do{
                         try{
                             depEsb = anadirDependenciaEsbirro();
                             ghoul.setDependencia(depEsb);
                         }catch(RuntimeException e){
                             System.out.println(e.getMessage());
                         }
                     }while(depEsb < 1 || depEsb > 5); 
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
                    }while(saludEsb < 1 || saludEsb > 3);
                    
                    String pactoEsb = anadirPactoEsbirro();
                    demonio.setPacto(pactoEsb);
                    String selec = null;
                    do {
                        System.out.println("¿quiere añadir esbirros hijos? -si- o -no-");
                        Scanner sc = new Scanner(System.in);
                        selec = sc.next();
                    } while (!selec.equals("si") && !selec.equals("no"));
                    if(selec.equals("si")){
                        Esbirro hijo = añadirEsbirro();
                        demonio.addHijos(hijo);
                    }
                    return demonio;
                }case 3:{
                    Class personaje = menu.getUsuarioActual().get(0).getTipoPersonaje().getClass();
                    if(personaje != Vampiro.class){
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
                        }while(saludEsb < 1 || saludEsb > 3);
                    
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
                    }else{
                        return null;
                    }
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
        menu.getUsuarioActual().get(0).getTipoPersonaje().setNombre(nombre);
    }
    
    public int añadirOro() {
            System.out.println("introduzca la cantidad de oro del personaje: ");
            Scanner sc = new Scanner(System.in);
            String cantidadOro = sc.next();
            int oroPer = Integer.parseInt(cantidadOro);
            return oroPer;
    }

    public void añadirOroPersonaje(double oro){
        try{
            menu.getUsuarioActual().get(0).getTipoPersonaje().setOro(oro);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void reducirOroPersonaje(){
        double oro = 0.2;
        try{
            double oroActual = menu.getUsuarioActual().get(0).getTipoPersonaje().getOro();
            if(oroActual != 0){
                oroActual -= oro;
                menu.getUsuarioActual().get(0).getTipoPersonaje().setOro(oroActual);
            }
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
      
    public Armadura añadirArmadura() {
        Armadura armadura = new Armadura("",0,0,null);
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
           
           while(modifAtaque < 1 || modifAtaque > 3){
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
       menu.getUsuarioActual().get(0).getTipoPersonaje().setListaArmaduras(armaduraPer);
    }
    
    
    public Arma añadirArma(){
        Arma arma = new Arma(null,0,0,null,null);
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
        }while(modifAtaque < 1 || modifAtaque > 3); 
        
        System.out.println("escriba -si- si quiere introducir un modificador a la defensa");
        Scanner sc = new Scanner(System.in);
        String opcModDef = sc.next();
        int modifDefensa = 0;
        if(opcModDef.equals("si")){
           
           while(modifDefensa < 1 || modifDefensa > 3){
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
        while(opcion != 1 && opcion != 2){
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
        while(opcion < 1 || opcion > 4){
              System.out.println("1.- Comun");
              System.out.println("2.- Raro");
              System.out.println("3.- Epico");
              System.out.println("4.- Legendario");
              System.out.println("Escoga una opcion de categoria -1,2,3 o 4-: ");
              sc = new Scanner(System.in);
              String opcManejo = sc.next();
              opcion = Integer.parseInt(opcManejo);
              switch(opcion){
                  case 1: arma.setCategoria(Categoria.Comun);
                  case 2: arma.setCategoria(Categoria.Raro);
                  case 3: arma.setCategoria(Categoria.Epico);
                  case 4: arma.setCategoria(Categoria.Legendario);
              }
        }
        return arma;
    }
    
    public void setNuevaArmaPersonaje(Arma armaPer){
        menu.getUsuarioActual().get(0).getTipoPersonaje().setListaArmas(armaPer);
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
            menu.getUsuarioActual().get(0).getTipoPersonaje().setListaEsbirros(esbirroPer);
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
  
    public int anadirEdad(){
       System.out.println("Introduzca la edad del vampiro: ");
       Scanner sc = new Scanner(System.in);
       String edadPer = sc.next();
       int edadP = Integer.parseInt(edadPer);
       return edadP;
    }
    
    public void setEdadPersonaje(int edadPer){
        try{
            menu.getUsuarioActual().get(0).getTipoPersonaje().setEdad(edadPer);
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
            menu.getUsuarioActual().get(0).getTipoPersonaje().setReservaPuntosSangre(sagreAcumPer);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void atributosComunesPersonaje(){
        String nombrePer = anadirNombre();
        setNombrePersonaje(nombrePer);
        
        int oroPer = 0;
        do{
           oroPer = añadirOro();
           añadirOroPersonaje(oroPer);
        }while(oroPer < 0);

        String insertar;
        do{
            Armadura armaduraPer = añadirArmadura();
            setNuevaArmaduraPersonaje(armaduraPer);
            System.out.println("escriba -no- si no quiere anadir otra armadura");
            Scanner sc = new Scanner(System.in);
            insertar = sc.next();
        }while(!insertar.equals("no"));  
        
        do{
            Arma armaPer = añadirArma();
            setNuevaArmaPersonaje(armaPer);
            System.out.println("escriba -no- si no quiere anadir otra arma");
            Scanner sc = new Scanner(System.in);
            insertar = sc.next();
        }while(!insertar.equals("no"));
        
        System.out.println("escriba -si- si quiere añadir un esbirro");
        Scanner sc = new Scanner(System.in);
        insertar = sc.next();
        if(insertar.equals("si")){
            do{
               Esbirro esbirro = añadirEsbirro();
               setNuevoEsbirroPersonaje(esbirro);
               System.out.println("escriba -no- si no quiere anadir otro esbirro");
               sc = new Scanner(System.in);
               insertar = sc.next();
            }while(!insertar.equals("no"));
        }
        
    }
    /**
     * se registra un personaje y se actualiza la información del usuario que registra el personaje 
     * en el listado del menú (userlist)
     */
    public void registrar_vampiro(){
        Fabrica fabrica = new FabricacionVampiro();
        menu.getUsuarioActual().get(0).setTipoPersonaje(fabrica.crearPersonaje());
        
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

    }
    
    public void registrar_licantropo(){
        Fabrica fabrica = new FabricacionLicantropo();
        menu.getUsuarioActual().get(0).setTipoPersonaje(fabrica.crearPersonaje());
        
    }
    
    public void registrar_cazador(){
        Fabrica fabrica = new FabricacionCazador();
        menu.getUsuarioActual().get(0).setTipoPersonaje(fabrica.crearPersonaje());
        
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
        
    public Armadura elegirArmadura(){
        List<Armadura> armaduras = menu.getUsuarioActual().get(0).getTipoPersonaje().getListaArmaduras();
        if(!armaduras.isEmpty()){
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
           }while(opcArmadura < 1 || opcArmadura >= cont);
           opcArmadura--;
           Armadura armaduraActiva = armaduras.get(opcArmadura);
           return armaduraActiva;
        }else{
            return null;
        }
    }
    
    public Arma elegirArma(){
        List<Arma> armas = menu.getUsuarioActual().get(0).getTipoPersonaje().getListaArmas();
        if(!armas.isEmpty()){
            int cont = 1;
                for(Arma a : armas){
                    System.out.println(cont + ".-" + a.getNombre() + " --> " + a.getManejo());
                    cont++;
                }
                int opcArma = 0;
                do{
                    System.out.println("escoga un numero de arma activa: ");
                    Scanner sc = new Scanner(System.in);
                    String opc = sc.next();
                    opcArma = Integer.parseInt(opc);
                }while(opcArma < 1 || opcArma >= cont);
                opcArma--;
                Arma arm = armas.get(opcArma);
            return arm;
        }else{
            return null;
        }
    }
    
    public void consultarOro(){ 
        System.out.println("usuario: " + menu.getUsuarioActual().get(0).getNombre());
        System.out.println("oro actual: "+menu.getUsuarioActual().get(0).tipoPersonaje.getOro());
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
        System.out.println("ingrese su contrasenia (8-12 caracteres): ");
        sc = new Scanner(System.in);
        String contraseniaUser = sc.next();

        for(Usuario user: menu.getUserlist()){
           if(nameUser.equals(user.getNombre()) && contraseniaUser.equals(user.getPassword())){
               userRegistered = true;  
               menu.setUsuarioActual(user);
               seleccionarOpcionMenu();
               menu.getUsuarioActual().clear();
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
        if(password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }else{
            throw new RuntimeException("longitud de la contrasenia fuera del rango[8-12]"); 
        }
    }

    public Personaje getTipoPersonaje() {
        return tipoPersonaje;
    }
    
    public void serializar(Usuario us){
       try{
           String fich = "D://Sistema//fichero.bin";
           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fich));
           out.writeObject(us);
           out.close();
       }catch(IOException e){
           System.out.println(e);
       }
    }  
  
}


