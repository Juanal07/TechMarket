import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        List<Persona> personas = GsonArray.desserializarJsonAArrayPersona();
        List<Registro> registros = GsonArray.desserializarJsonAArrayRegistro();

        for (Registro r : registros) {
            System.out.println(r.toString());

        }

        System.out.println("Bienvenido/a a TechMarket, introduzca su usuario para iniciar sesion");        
        String u = entrada.next();
        System.out.println("Introduzca su password");
        String psw = entrada.next();

        boolean encontrado = false;
        int i = 0;
        while (i < personas.size() && !encontrado) {
            if (personas.get(i).getUser().equals(u) && personas.get(i).getPassword().equals(psw)) {
                encontrado = true;
                System.out.println("Bienvenido " + personas.get(i).getUser());
                if (personas.get(i).getTipo().equals("user"))
                    opcionesUser();
                else
                    opcionesPowerUser();
            }
            i++;
        }
        if (!encontrado)
            System.out.println("Usuario o password incorrecto");
    entrada.close();}

    public static void opcionesUser() {

        String opcion = "";
        while (!opcion.equals("s")) {
            System.out.println("Elija una opcion:" +
                    '\n' + "-Gestionar registros(g)" +
                    '\n' + "-Visualizar registros dados unos parametros de busqueda(v)" +
                    '\n' + "-Salir(s)");
            opcion = entrada.next();
            switch (opcion) {
                case "g":
                    System.out.println("escogio la g");
                    break;
                case "v":
                    System.out.println("escogio la v");
                    break;
                case "s":
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            
        }
        
    }

    public static void opcionesPowerUser() {
        String opcion = "";
        while (!opcion.equals("s")) {
            System.out.println("-Ver estadisticas(v)" +
                    '\n' + "-Exportar registros a un csv(e)" +
                    '\n' + "-Importar registros de un csv(i)" +
                    '\n' + "-Enviar registros en csv por mail(m)" +
                    '\n' + "-Salir(s)");

            opcion = entrada.next();

            switch (opcion) {
                case "v":
                    System.out.println("escogio la v");
                    break;
                case "e":
                    System.out.println("escogio la e");
                    break;
                case "i":
                    System.out.println("escogio la i");
                    break;
                case "m":
                    System.out.println("escogio la m");
                    break;
                case "s":
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("error");
                    break;
            }

        }
    }
}
