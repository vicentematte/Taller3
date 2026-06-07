
public class HechizoTierra extends Hechizo{
	private int mejoraDefensa;

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

	@Override
	public String toString() {
		return "HechizoTierra [mejoraDefensa=" + mejoraDefensa + "]";
	}
	
	public double calcularPuntaje() {
		return (getDamage() * mejoraDefensa) / 2;
	}
	
}
