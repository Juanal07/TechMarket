import java.time.LocalDate;
import java.util.Date;

public class Registro {

	//DEFINIMOS VARIABLES
	private String nombre;
	private String categoria;
	private int coste;
	private int stock;
	private String fecha;
	private boolean financiacion;

	public Registro() {
	}

	//CONSTRUCTOR
	public Registro(String nombre, String categoria, int coste, int stock, String fecha, boolean financiacion) {
		this.nombre       = nombre;
		this.categoria    = categoria;
		this.coste        = coste;
		this.stock        = stock;
		this.fecha        = fecha;
		this.financiacion = financiacion;
	}

	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean isFinanciacion() {
		return financiacion;
	}

	public void setFinanciacion(boolean financiacion) {
		this.financiacion = financiacion;
	}

	//FORMATO
	@Override
	public String toString() {
		return "{" +
				"nombre='" + nombre + '\'' +
				", categoria='" + categoria + '\'' +
				", coste=" + coste +
				", stock=" + stock +
				", fecha=" + fecha +
				", financiacion=" + financiacion +
				'}';
	}
}