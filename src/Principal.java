import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

//		ArrayList<Persona> personas = new ArrayList<Persona>();
//		Persona p1 = new Persona("juan1","1234","User","jjrr1307@gmail.com");
//		personas.add(p1);

		List<Persona> personas = GsonArray.desserializarJsonAArrayPersona();
		
		
//		ArrayList<Registro> registros = new ArrayList<Registro>();
//		Registro r1 = new Registro("AMD A10-5800K 3.80Ghz","procesador",104,5, LocalDate.parse("2018-10-30"),true);
//		registros.add(r1);

//		System.out.println(r1.toString());
//
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
