
public class HechizoAgua extends Hechizo{
	private int cantidadHeal;
	private int presionAgua;
	public HechizoAgua(String nombre, String tipo, int damage, int cantHeal, int presionAgua) {
		super(nombre, tipo, damage);
		this.cantidadHeal = cantHeal;
		this.presionAgua = presionAgua;
	}
	public int getCantHeal() {
		return cantidadHeal;
	}
	public void setCantHeal(int cantHeal) {
		this.cantidadHeal = cantHeal;
	}
	public int getPresionAgua() {
		return presionAgua;
	}
	public void setPresionAgua(int presionAgua) {
		this.presionAgua = presionAgua;
	}
	
	@Override
	public String toString() {
		return "HechizoAgua [cantHeal=" + cantidadHeal + ", presionAgua=" + presionAgua + "]";
	}
	
	public double calcularPuntaje() {
		return (getDamage() + cantidadHeal + presionAgua) * 2;
	}
	
}
