
public class HechizoAgua extends Hechizo{
	private int cantidadHeal;
	private int presionAgua;
	
	/** Hechizo de tipo agua, tiene como atributos extra la cantidad de heal y la presion del agua que aplicara el hechizo
	 * @param nombre - nombre del hechizo abst
	 * @param tipo - la naturaleza del hechizo abst
	 * @param damage - el damage que causara el hechizo abst
	 * @param cantHeal - cantidad de vida que recupera, atributo unico de la clase
	 * @param presionAgua - presion del agua, atributo unico de la clase
	 */
	

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
		return super.toString() + " | Cant Heal: " + cantidadHeal + " | Presion Agua: " + presionAgua;
	}
	
	// Calcula el puntaje del hechizo: (damage + cantidadHeal + presionAgua) * 2
	public double calcularPuntaje() {
		return (getDamage() + cantidadHeal + presionAgua) * 2;
	}
	
}
