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
		System.out.println("《                     TECHMARKET        》");
		System.out.println("・ーーーーーーーーーーーーーーーーーーー・");   

		login();



	}

	public static void login() {

		List<Persona> personas = GsonArray.desserializarJsonAArrayPersona();
		List<Registro> registros = GsonArray.desserializarJsonAArrayRegistro();

		//for (Registro r : registros) {
			//System.out.println(r.toString());
		//}

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
				System.out.println("\n \n¡Bienvenido de nuevo " + personas.get(i).getUser() + "!") ;
				if (personas.get(i).getTipo().equals("user"))
					opcionesUser();
				else
					opcionesPowerUser();
			}
			i++;
		}
		if (!encontrado)
			System.out.println("El usuario o contraseña es incorrecto.");
		    System.out.println("¡Vuelve a intentarlo de nuevo!\n \n");
		login();

		

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
	
	public static void importarCsv() {
		
		//a completar
		
	}
	
	
	public static void exportarCsv() {
		
		//a completar
		
	}
	
	
	public static void enviarCsv() {
		
		//a completar
		
	}
	
	
	
}
