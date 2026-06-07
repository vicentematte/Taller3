
public class HechizoFuego extends Hechizo{
	private int duracionQuemadura;

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
	public String toString() {
		return "HechizoFuego [duracionQuemadura=" + duracionQuemadura + "]";
	}
	
	public double calcularPuntaje() {
		return getDamage() * duracionQuemadura;
	}
	
	
}
