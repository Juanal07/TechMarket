import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        //mensaje de entrada
        System.out.println("");
        System.out.println("・ーーーーーーーーーーーーーーーーーーー・");
        System.out.println("《              TECHMARKET        》");
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
                if (personas.get(i).getTipo().equals("user"))
                    opcionesUser();
                else
                    opcionesPowerUser();
            }
            i++;
        }
        if (!encontrado) {
            System.out.println("El usuario o contraseña es incorrecto.");
            System.out.println("¡Vuelve a intentarlo de nuevo!\n \n");
            login();
        }

    }

    public static void opcionesUser() {

        String opcion = "";
        while (!opcion.equals("s")) {

            System.out.println("╔═══════════════════════════════════╗");
            System.out.println("║        ¿Qué desea realizar?       ║");
            System.out.println("║                                   ║");
            System.out.println("║ ● GESTIONAR REGISTRO   (Pulse G)  ║");
            System.out.println("║ ● VISUALIZAR REGISTRO  (Pulse V)  ║");
            System.out.println("║ ● SALIR                (Pulse S)  ║");
            System.out.println("╚═══════════════════════════════════╝");

            opcion = entrada.next();
            switch (opcion) {
                case "g":
                    System.out.println("Has escogido [GESTIONAR REGISTRO]");
                    gestionarRegistros();
                    break;
                case "v":
                    System.out.println("Has escogido [VISUALIZAR REGISTRO]");
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

    public static void opcionesPowerUser() {
        String opcion = "";
        while (!opcion.equals("s")) {

            System.out.println("╔═══════════════════════════════════════════════╗");
            System.out.println("║              ¿Qué desea realizar?             ║");
            System.out.println("║                                               ║");
            System.out.println("║ ● VISUALIZAR ESTADÍSTICAS          (Pulse V)  ║");
            System.out.println("║ ● IMPORTAR REGISTROS .CSV          (Pulse I)  ║");
            System.out.println("║ ● EXPORTAR REGISTROS .CSV          (Pulse E)  ║");
            System.out.println("║ ● ENVIAR REGISTROS .CSV POR EMAIL  (Pulse M)  ║");
            System.out.println("║ ● SALIR                            (Pulse S)  ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            opcion = entrada.next();

            switch (opcion) {
                case "v":
                    System.out.println("Has escogido [VISUALIZAR ESTADÍSTICAS]");

                    //llamamos método

                    break;
                case "e":
                    System.out.println("Has escogido [EXPORTAR REGISTROS .CSV]");

                    exportarCsv();

                    break;
                case "i":
                    System.out.println("Has escogido [IMPORTAR REGISTROS .CSV]");

                    importarCsv();

                    break;
                case "m":
                    System.out.println("Has escogido [ENVIAR REGISTROS .CSV POR EMAIL]");

                    enviarCsv();

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

    public static void gestionarRegistros() {

        List<Registro> registros = GsonArray.desserializarJsonAArrayRegistro();

        String opcion = "";
        while (!opcion.equals("s")) {

            System.out.println("╔═══════════════════════════════════════════════╗");
            System.out.println("║              ¿Qué desea realizar?             ║");
            System.out.println("║                                               ║");
            System.out.println("║ ● CREAR REGISTRO                   (Pulse C)  ║");
            System.out.println("║ ● LEER REGISTROS                   (Pulse L)  ║");
            System.out.println("║ ● ACTUALIZAR                       (Pulse A)  ║");
            System.out.println("║ ● BORRAR REGISTRO                  (Pulse B)  ║");
            System.out.println("║ ● SALIR                            (Pulse S)  ║");
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
        System.out.println("Introduzca coste:");
        coste = entrada.next();
        int coste2 = Integer.parseInt(coste);

        String stock = "";
        System.out.println("Introduzca stock:");
        stock = entrada.next();
        int stock2 = Integer.parseInt(stock);

        String financiacion = "";
        System.out.println("Introduzca financiacion:");
        financiacion = entrada.next();
        boolean financiacion2 = Boolean.parseBoolean(financiacion);

        String fecha = LocalDate.now().toString();


        Registro reg = new Registro(nombre,categoria,coste2,stock2,fecha,financiacion2);
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
        System.out.println("¿Qué registro deseas actualizar?");
        leerReg(registros);
        i = entrada.next();
        System.out.println(registros.get(Integer.parseInt(i)));
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║              ¿Qué desea actualizar?           ║");
        System.out.println("║                                               ║");
        System.out.println("║ ● Nombre                           (Pulse N)  ║");
        System.out.println("║ ● Categoria                        (Pulse C)  ║");
        System.out.println("║ ● Coste                            (Pulse P)  ║");
        System.out.println("║ ● Stock                            (Pulse S)  ║");
        System.out.println("║ ● Financiacion                     (Pulse F)  ║");
        System.out.println("║ ● SALIR                            (Pulse S)  ║");
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
            case "s":
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
            default:
                System.out.println("Ha surgido un error, vuelve a intentarlo!");
                break;
        }
    }


    public static void borrarReg(List<Registro> registros) {

        String i = "";
        leerReg(registros);
        System.out.println("¿Qué registro deseas borrar?");
        i = entrada.next();
        System.out.println(registros.get(Integer.parseInt(i)));
        registros.remove(Integer.parseInt(i));
        System.out.println("Borrado con éxito");
        escribirJson(registros);
    }

    public static void importarCsv() {

        //a completar

    }

    public static void exportarCsv() {

        //a completar

    }


    public static void enviarCsv() {

        //a completar

    }

    public static void escribirJson(List<Registro> registros) { //siempre que se actualice la lista hay que usar este metodo para que actualice el json

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String representacionBonita = prettyGson.toJson(registros);
        String ruta = "registros.json";
        GsonArray.EscribirJson(representacionBonita, ruta);

    }


}
