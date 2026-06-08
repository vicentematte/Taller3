
public class HechizoTierra extends Hechizo{
	private int mejoraDefensa;
	
	/** Hechizo de tipo tierra, tiene como atributo extra la mejora de defensa
	 * que es el valor que aumentara la defensa  (clase abstract hechizo)
	 * @param nombre - nombre del hechizo (clase abstract Hechizo)
	 * @param tipo - la naturaleza de l hehchizo (clase abstract Hechizo)
	 * @param damage - el damage que causara el hechizo (clase abstract Hechizo)
	 * @param mejoraDefensa - valor de mejora de defensa
	 */
	
	public HechizoTierra(String nombre, String tipo, int damage, int mejoraDefensa) {
		super(nombre, tipo, damage);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return mejoraDefensa;
	}

	public void setMejoraDefensa(int mejoraDefensa) {
		this.mejoraDefensa = mejoraDefensa;
	}

	// Muestra la informacion del hechizo de tierra con el super de Hechizo
	@Override
	public String toString() {
		return super.toString() + " | Mejora Defensa: " + mejoraDefensa;
	}
	
	// Calcula el puntaje del hechizo: (damage * mejoraDefensa) / 2, con la interfaz
	public double calcularPuntaje() {
		return (getDamage() * mejoraDefensa) / 2;
	}
	
}
