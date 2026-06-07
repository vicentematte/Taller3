import java.util.ArrayList;

public class Mago {
	private String nombre;
	private ArrayList<Hechizo> listaHechizo = new ArrayList<>();
	


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

	@Override
	public String toString() {
		return "Mago [nombre=" + nombre + ", listaHechizo=" + listaHechizo + "]";
	}
	
	
}
