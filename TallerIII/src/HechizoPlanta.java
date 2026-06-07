
public class HechizoPlanta extends Hechizo{
	private  int duracionStun;
	private int cantPlantas;
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



	@Override
	public String toString() {
		return "HechizoPlanta [duracionStun=" + duracionStun + ", cantPlantas=" + cantPlantas + "]";
	}



	public double calcularPuntaje() {
		return getDamage() + (duracionStun * cantPlantas);
	}
	
	
}
