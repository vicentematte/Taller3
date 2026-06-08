
public abstract class Hechizo implements Puntaje{
	private String nombre;
	private String tipo;
	private int damage;
	/** COmo tenemos varios hechizos con cosas en comun creamos una clase abstracta, ya que aparte no 
  		tenemos un hechizo unitario, me refiero a que no existe un hechizo de tipo hechizo siempre es con algo mas.
	 * @param nombre - nombre del hechizo
	 * @param tipo - la naturaleza del hechizo 
	 * @param damage - el damage que causara el hechizo
	 */
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
	    return nombre + " | Tipo: " + tipo + " | Damage: " + damage;
	}
	
	
	
}
