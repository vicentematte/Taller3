
public class HechizoFuego extends Hechizo{
	private int duracionQuemadura;
	/** Hechizo de tipo fuego, tiene como atributo extra la duracion de quemadura
	 * que es el tiempo que el hechizo estara activo
	 * @param nombre - nombre del hechizo (clase abstracta)
	 * @param tipo - la naturaleza del hechizo (clase abstracta)
	 * @param damage - el damage que causara el hechizo (clase abstracta)
	 * @param duracionQuemadura - duracion de la quemadura
	 */
	

	public HechizoFuego(String nombre, String tipo, int damage, int duracionQuemadura) {
		super(nombre, tipo, damage);
		this.duracionQuemadura = duracionQuemadura;
	}

	public int getDuracionQuemadura() {
		return duracionQuemadura;
	}

	public void setDuracionQuemadura(int duracionQuemadura) {
		this.duracionQuemadura = duracionQuemadura;
	}

	@Override
	// Muestra la informacion del hechizo de fuego
	//con el agregado del super, dado que es una clase hija
	public String toString() {
		return super.toString() + " | Duracion Quemadura: " + duracionQuemadura;
	}
	
	// Calcula el puntaje del hechizo: damage * duracionQuemadura
	public double calcularPuntaje() {
		return getDamage() * duracionQuemadura;
	}
	
	
}
