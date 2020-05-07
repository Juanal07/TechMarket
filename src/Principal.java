import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		List<Persona> personas = GsonArray.desserializarJsonAArrayPersona();
		List<Registro> registros = GsonArray.desserializarJsonAArrayRegistro();

		for (Registro r: registros) {
			System.out.println(r.toString());

		}

		System.out.println("Bienvenido/a a TechMarket, introduzca su usuario para iniciar sesion");

		Scanner entrada=new Scanner(System.in);
		String u =entrada.next();

		System.out.println("Introduzca su password");

		Scanner entrada2=new Scanner(System.in);
		String psw =entrada2.next();

		for (Persona p: personas) {
			if (p.getUser().equals(u)) {
				if (p.getPassword().equals(psw)) {
					System.out.println("Beinvenido "+p.getUser());
				}else{
					System.out.println("Contraseña incorrecta");
				}
			}else{
				System.out.println("Usuario no existe");
			}

			
		}








	}
}
