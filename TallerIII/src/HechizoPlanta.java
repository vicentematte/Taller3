
public class HechizoPlanta extends Hechizo{
	private  int duracionStun;
	private int cantPlantas;
	
	/** Hechizo de tipo planta, tiene como atributos extra la duracion del stun
	 * y la cantidad de plantas va a imvocar
	 * @param nombre - nombre del hechizo ( de la clase Hechizo (abstract))
	 * @param tipo - la naturaleza del hechizo ( de la clase Hechizo (abstract))
	 * @param damage - el damage que causara el hechizo ( de la clase Hechizo (abstract))
	 * @param duracionStun - duracion del stun 
	 * @param cantPlantas - cantidad de plantas que aparecen
	 */
	
	
	public HechizoPlanta(String nombre, String tipo, int damage, int duracionStun, int cantPlantas) {
		super(nombre, tipo, damage);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}
	
	
	
	public int getDuracionStun() {
		return duracionStun;
	}



	public void setDuracionStun(int duracionStun) {
		this.duracionStun = duracionStun;
	}



	public int getCantPlantas() {
		return cantPlantas;
	}



	public void setCantPlantas(int cantPlantas) {
		this.cantPlantas = cantPlantas;
	}



	// Muestra la informacion del hechizo de planta mas el super.toString(), que muestra la informacion abstracta (la que se repite en todos los hechizos)
	@Override
	public String toString() {
		return super.toString() + " | Duracion Stun: " + duracionStun + " | Cant Plantas: " + cantPlantas;
	}


	// Calcula el puntaje del hechizo: damage + (duracionStun * cantPlantas)
	public double calcularPuntaje() {
		return getDamage() + (duracionStun * cantPlantas);
	}
	
	
}
