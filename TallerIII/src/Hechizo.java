
public abstract class Hechizo implements Puntaje{
	private String nombre;
	private String tipo;
	private int damage;
	
	public Hechizo(String nombre, String tipo, int damage) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.damage = damage;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}


	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return "Hechizos [nombre=" + nombre + ", tipo=" + tipo + ", damage=" + damage + "]";
	}
	
	
	
}
