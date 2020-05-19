import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Principal {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        //mensaje de entrada
        System.out.println("");
        System.out.println("・ーーーーーーーーーーーーーーーーーーー・");
        System.out.println("《                 TECHMARKET          》");
        System.out.println("・ーーーーーーーーーーーーーーーーーーー・");

        login();

    }

    public static void login() {

        List<Persona> personas = GsonArray.desserializarJsonAArrayPersona();

        System.out.println("Introduce tu nombre de usuario: ");
        String u = entrada.next();
        System.out.println(" ");


        System.out.println("Introduce tu contraseña:  ");
        String psw = entrada.next();
        System.out.println(" ");


        boolean encontrado = false;
        int i = 0;
        while (i < personas.size() && !encontrado) {
            if (personas.get(i).getUser().equals(u) && personas.get(i).getPassword().equals(psw)) {
                encontrado = true;
                System.out.println("\n \n¡Bienvenido de nuevo " + personas.get(i).getUser() + "!");
                List<Registro> registros = GsonArray.desserializarJsonAArrayRegistro();
                if (personas.get(i).getTipo().equals("user"))
                    opcionesUser(registros);
                else
                    opcionesPowerUser(registros);
            }
            i++;
        }
        if (!encontrado) {
            System.out.println("El usuario o contraseña es incorrecto.");
            System.out.println("¡Vuelve a intentarlo de nuevo!\n \n");
            login();
        }

    }

    public static void opcionesUser(List<Registro> registros) {

        String opcion = "";
        while (!opcion.equals("s")) {

            System.out.println("╔═══════════════════════════════════╗");
            System.out.println("║        ¿Qué desea realizar?       ║");
            System.out.println("║                                   ║");
            System.out.println("║ - GESTIONAR REGISTRO   (Pulse G)  ║");
            System.out.println("║ - VISUALIZAR REGISTRO  (Pulse V)  ║");
            System.out.println("║ - SALIR                (Pulse S)  ║");
            System.out.println("╚═══════════════════════════════════╝");

            opcion = entrada.next();
            switch (opcion) {
                case "g":
                    System.out.println("Has escogido [GESTIONAR REGISTRO]");
                    gestionarRegistros(registros);
                    break;
                case "v":
                    System.out.println("Has escogido [VISUALIZAR REGISTRO]");
                    visualizarRegistros(registros);
                    break;
                case "s":
                    System.out.println("Has escogido [SALIR]");
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("¡Ha surgido un error, vuelve a intentarlo!");
                    break;
            }

        }

    }


    public static void opcionesPowerUser(List<Registro> registros) {
    	String opcion = "";
    	while (!opcion.equals("s")) {
    		
    		System.out.println("Usted se encuentra en el modo ADMINISTRADOR");
    		System.out.println("╔═══════════════════════════════════════════════╗");
    		System.out.println("║              ¿Qué desea realizar?             ║");
    		System.out.println("║                                               ║");
    		System.out.println("║ - VISUALIZAR ESTADÍSTICAS          (Pulse V)  ║");
    		System.out.println("║ - IMPORTAR REGISTROS .CSV          (Pulse I)  ║");
    		System.out.println("║ - EXPORTAR REGISTROS .CSV          (Pulse E)  ║");
    		System.out.println("║ - ENVIAR REGISTROS .CSV POR EMAIL  (Pulse M)  ║");
    		System.out.println("║ - SALIR                            (Pulse S)  ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            opcion = entrada.next();

            switch (opcion) {
                case "v":
                    System.out.println("Has escogido [VISUALIZAR ESTADÍSTICAS]");

                    visualizarEstadisticas(registros);

                    break;
                case "e":
                	System.out.println("Has escogido [EXPORTAR REGISTROS .CSV]");
                	
                	exportarCsv(registros);

                    break;
                case "i":
                    System.out.println("Has escogido [IMPORTAR REGISTROS .CSV]");

                    importarCsv(registros);

                    break;
                case "m":
                    System.out.println("Has escogido [ENVIAR REGISTROS .CSV POR EMAIL]");

                    enviarMail(registros);

                    break;
                case "s":
                    System.out.println("Has escogido [SALIR]");
                    System.out.println("¡Hasta pronto!");

                    break;
                default:
                    System.out.println("Ha surgido un error, vuelve a intentarlo!");
                    break;
            }

        }
    }

    public static void gestionarRegistros(List<Registro> registros) {

        String opcion = "";
        while (!opcion.equals("s")) {

            System.out.println("╔═══════════════════════════════════════════════╗");
            System.out.println("║              ¿Qué desea realizar?             ║");
            System.out.println("║                                               ║");
            System.out.println("║ - CREAR REGISTRO                   (Pulse C)  ║");
            System.out.println("║ - LEER REGISTROS                   (Pulse L)  ║");
            System.out.println("║ - ACTUALIZAR                       (Pulse A)  ║");
            System.out.println("║ - BORRAR REGISTRO                  (Pulse B)  ║");
            System.out.println("║ - SALIR                            (Pulse S)  ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            opcion = entrada.next();

            switch (opcion) {
                case "c":
                    System.out.println("Has escogido [CREAR REGISTRO]");

                    crearReg(registros);

                    break;
                case "l":
                    System.out.println("Has escogido [LEER REGISTROS]");

                    leerReg(registros);

                    break;
                case "a":
                    System.out.println("Has escogido [ACTUALIZAR]");

                    actualizarReg(registros);

                    break;
                case "b":
                    System.out.println("Has escogido [BORRAR REGISTRO]");

                    borrarReg(registros);

                    break;
                case "s":
                    System.out.println("Has escogido [SALIR]");

                    break;
                default:
                    System.out.println("Ha surgido un error, vuelve a intentarlo!");
                    break;
            }

        }
    }

    public static void crearReg(List<Registro> registros) {
        String nombre = "";
        System.out.println("Introduzca nombre:");
        nombre = entrada.next();

        String categoria = "";
        System.out.println("Introduzca categoria:");
        categoria = entrada.next();

        String coste = "";
        System.out.println("Introduzca coste:(número)");
        coste = entrada.next();
        int coste2 = Integer.parseInt(coste);

        String stock = "";
        System.out.println("Introduzca stock:(número)");
        stock = entrada.next();
        int stock2 = Integer.parseInt(stock);

        String financiacion = "";
        System.out.println("Introduzca si quiere financiacion:(true/false)");
        financiacion = entrada.next();
        boolean financiacion2 = Boolean.parseBoolean(financiacion);

        String fecha = LocalDate.now().toString();


        Registro reg = new Registro(nombre, categoria, coste2, stock2, fecha, financiacion2);
        registros.add(reg);
        escribirJson(registros);


    }


    public static void leerReg(List<Registro> registros) {

        int i = 0;
        for (Registro r : registros) {
            System.out.println(i + ": " + r.toString());
            i++;
        }

    }


    public static void actualizarReg(List<Registro> registros) {
        String opcion = "";
        String i = "";
        String actualizacion = "";
        System.out.println("¿Qué registro deseas actualizar?(del 0 al " + (registros.size() - 1) + ")");
        leerReg(registros);
        i = entrada.next(); // se necesita cortafuegos para que no pete si introduces un numero mayor del size o una letra


        while (!opcion.equals("s")) {


            System.out.println(registros.get(Integer.parseInt(i)));
            System.out.println("╔═══════════════════════════════════════════════╗");
            System.out.println("║              ¿Qué desea actualizar?           ║");
            System.out.println("║                                               ║");
            System.out.println("║ - Nombre                           (Pulse N)  ║");
            System.out.println("║ - Categoria                        (Pulse C)  ║");
            System.out.println("║ - Coste                            (Pulse P)  ║");
            System.out.println("║ - Stock                            (Pulse E)  ║");
            System.out.println("║ - Financiacion                     (Pulse F)  ║");
            System.out.println("║ - SALIR                            (Pulse S)  ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            opcion = entrada.next();

            switch (opcion) {
                case "n":
                    System.out.println("Actualice y pulse enter");
                    actualizacion = entrada.next();
                    registros.get(Integer.parseInt(i)).setNombre(actualizacion);
                    registros.get(Integer.parseInt(i)).setFecha(LocalDate.now().toString());
                    System.out.println("Actualizado con éxito");
                    escribirJson(registros);
                    break;
                case "c":
                    System.out.println("Actualice y pulse enter");
                    actualizacion = entrada.next();
                    registros.get(Integer.parseInt(i)).setCategoria(actualizacion);
                    registros.get(Integer.parseInt(i)).setFecha(LocalDate.now().toString());
                    System.out.println("Actualizado con éxito");
                    escribirJson(registros);
                    break;
                case "p":
                    System.out.println("Actualice y pulse enter");
                    actualizacion = entrada.next();
                    registros.get(Integer.parseInt(i)).setCoste(Integer.parseInt(actualizacion));
                    registros.get(Integer.parseInt(i)).setFecha(LocalDate.now().toString());
                    System.out.println("Actualizado con éxito");
                    escribirJson(registros);
                    break;
                case "e":
                    System.out.println("Actualice y pulse enter");
                    actualizacion = entrada.next();
                    registros.get(Integer.parseInt(i)).setStock(Integer.parseInt(actualizacion));
                    registros.get(Integer.parseInt(i)).setFecha(LocalDate.now().toString());
                    System.out.println("Actualizado con éxito");
                    escribirJson(registros);
                    break;
                case "f":
                    System.out.println("¿Desea que este producto tenga financiación?(s/n)");
                    actualizacion = entrada.next();
                    if (actualizacion.equals("s"))
                        registros.get(Integer.parseInt(i)).setFinanciacion(true);
                    else
                        registros.get(Integer.parseInt(i)).setFinanciacion(false); //aqui faltaria un cortafuegos
                    registros.get(Integer.parseInt(i)).setFecha(LocalDate.now().toString());
                    System.out.println("Actualizado con éxito");
                    escribirJson(registros);
                    break;
                case "s":
                    System.out.println("Has escogido [SALIR]");
                    break;
                default:
                    System.out.println("Ha surgido un error, vuelve a intentarlo!");
                    break;
            }
        }
    }


    public static void borrarReg(List<Registro> registros) {

        String i = "";
        leerReg(registros);
        System.out.println("¿Qué registro deseas borrar? (del 0 al " + (registros.size() - 1) + ")");
        i = entrada.next();
        System.out.println(registros.get(Integer.parseInt(i)));
        registros.remove(Integer.parseInt(i));
        System.out.println("Borrado con éxito");
        escribirJson(registros);
    }

    public static void visualizarRegistros(List<Registro> registros) {

        System.out.println("Indique en que categoria quiere buscar");
        String categoria;
        categoria = entrada.next();

        System.out.println("Indique el precio maximo");
        String precio;
        precio = entrada.next();
        boolean condicion = false;
        int i = 0;
        for (Registro r : registros) {
            if (registros.get(i).getCategoria().equals(categoria) && registros.get(i).getCoste() <= Integer.parseInt(precio)) {
                System.out.println(i + ": " + r.toString());
                condicion = true;
            }
            i++;
        }
        if (condicion == false)
            System.out.println("No se ha encontrado ningún registro con esos criterios de búsqueda");


    }


    public static void visualizarEstadisticas(List<Registro> registros) {
        System.out.println("Tienes un total de: " + registros.size() + " registros");
        System.out.println("Coste medio: " + media(registros) + " euros");
        System.out.println("Coste maximo: " + max(registros) + " euros");
        System.out.println("Coste minimo: " + min(registros) + " euros");
        System.out.println("Actualizaciones de registros este mes: " + actualizaciones(registros));
    }

    public static int media(List<Registro> registros) {
        int m = 0;
        int i = 0;
        for (Registro r : registros) {
            m += registros.get(i).getCoste();
            i++;
        }
        return m / i;
    }

    public static int max(List<Registro> registros) {
        int m = 0;
        int i = 0;
        for (Registro r : registros) {
            if (m <= registros.get(i).getCoste())
                m = registros.get(i).getCoste();
            i++;
        }
        return m;
    }

    public static int min(List<Registro> registros) {
        int m = registros.get(0).getCoste();
        int i = 0;
        for (Registro r : registros) {
            if (m >= registros.get(i).getCoste())
                m = registros.get(i).getCoste();
            i++;
        }
        return m;
    }

    public static int actualizaciones(List<Registro> registros) {

        String fechaActual = LocalDate.now().toString();
        String[] parts = fechaActual.split("-");
        String part2 = parts[1];

        int contador = 0;
        int i = 0;
        for (Registro r : registros) {
            String[] parts2 = registros.get(i).getFecha().split("-");
            String part2_2 = parts2[1];
            if (part2_2.equals(part2))
                contador++;
            i++;
        }
        return contador;
    }

    public static void importarCsv(List<Registro> registros) {
    	

    }
    
    public static void exportarCsv(List<Registro> registros) {

    	try
    	{
    		JFileChooser file=new JFileChooser();
    		file.showSaveDialog(null);
    		File fichero = file.getSelectedFile();

    		if(fichero != null)
    		{
    			/*guardamos el archivo y le damos el formato directamente,
    			 * si queremos que se guarde en formato doc lo definimos como .doc*/
    			FileWriter  save = new FileWriter(fichero + ".csv");
    			for (Registro r : registros) {
    				save.write("" + r.getNombre());
    				save.write(";");
    				save.write("" + r.getCategoria());
    				save.write(";");
    				save.write("" + r.getCoste());
    				save.write(";");
    				save.write("" + r.getStock());
    				save.write(";");
    				save.write("" + r.getFecha());
    				save.write(";");
    				save.write("" + r.getFinanciacion());
    				save.write("\n");
    			}
    			save.close();
    			System.out.println("El archivo ha sido exportado con éxito!\n \n");
    		}  
    	}
    	catch(IOException ex) {
    		System.out.println("Error en la exportación del archivo .CSV \n \n");
    		opcionesPowerUser(registros);
    	}
    }


public static void enviarMail(List<Registro> registros) {

	Scanner entrada = new Scanner(System.in);

	    //
        // DESTINATARIO DEL CORREO
        //
        System.out.println("Introduce el correo electrónico: ");
        String destinatario = entrada.nextLine();

        //
        // REMITENTE DEL CORREO
        //

        //Cuenta de correo del remitente
        String remitente = "techmarket42";       //Dirección de correo del remitente (se añade solo @gmail.com)
        String contraseña = "Techmarket+19";    //Contraseña de la cuenta de gmail.com


        //
        // CONTENIDO DEL CORREO
        //

        //Asunto del correo electrónico
        String asunto = "Información registros:";

        //Cuerpo del correo electrónico
        String cuerpo = "Meter aquí los registros a enviar";

        //Firma del correo electrónico
        String firma = "\n \nGracias por confiar en nosotros! \n [Equipo de Techmarket]";




        //Configuraciones de Google / Gmail
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");            //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", contraseña);
        props.put("mail.smtp.auth", "true");                    //Autentificación de correo y contraseña
        props.put("mail.smtp.starttls.enable", "true");        //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587");                   //El puerto SMTP seguro de Google (encriptado)

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera

            //Se añade el asunto al correo
            message.setSubject(asunto);

            //Se añade el cuerpo al correo
            message.setText(cuerpo);

            //Se añade la firma al correo
            message.setText(firma);

            //Se realiza el login por parte del remitente
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, contraseña);

            //Se envía el correo electrónico
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            //Enviado con éxito
            System.out.println("\nEl correo ha sido enviado con éxito! \n \n");
            opcionesPowerUser(registros);
        }

        //En caso de fallo, volvemos a ejecutar el método
        catch (Exception e) {
            System.out.println("\nEl correo electrónico es incorrecto! \n ");
            enviarMail(registros);
        }
    }

    public static void escribirJson(List<Registro> registros) { //siempre que se actualice la lista hay que usar este metodo para que actualice el json

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String representacionBonita = prettyGson.toJson(registros);
        String ruta = "registros.json";
        GsonArray.EscribirJson(representacionBonita, ruta);

    }


}
