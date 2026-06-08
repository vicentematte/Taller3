import java.util.ArrayList;

public class Mago {
	private String nombre;
	private ArrayList<Hechizo> listaHechizo = new ArrayList<>();
	
	/** Clase Mago: representa a un mago
	 * cada mago tiene un nombre y una lista de hechizos que domina
	 * @param nombre - nombre del mago
	 */

	public Mago(String nombre) {
		super();
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Hechizo> getListaHechizo() {
		return listaHechizo;
	}

	public void setListaHechizo(ArrayList<Hechizo> listaHechizo) {
		this.listaHechizo = listaHechizo;
	}

	// Muestra el nombre del mago y sus hechizos asociados
	@Override
	public String toString() {
		return "Mago: " + nombre + " | Hechizos: " + listaHechizo;
	}
	
	
}
