public class Persona {

	//DEFINIMOS VARIABLES
	private String user;
	private String password;
	private String tipo;
	private String email;


	//CONSTRUCTOR
	public Persona(String user, String password, String tipo, String email) {
		this.user     = user;
		this.password = password;
		this.tipo     = tipo;
		this.email    = email;
	}

	//GETTERS Y SETTERS
	public Persona(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//FORMATO
	@Override
	public String toString() {
		return "Persona{" +
				"user='" + user + '\'' +
				", password='" + password + '\'' +
				", tipo='" + tipo + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
