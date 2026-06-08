import java.util.ArrayList;

public class Analista {
	// Muestra todos los hechizos del sistema
    public static void mostrarHechizos() {
        int indice = 1;
        for(Hechizo h : Sistema.listaHechizos) {
            System.out.println(indice + ". " + h);
            indice++;
        }
    }

    //Muestra todos los magos del sistema
    public static void mostrarMagos() {
        int indice = 1;
        for(Mago m : Sistema.listaMagos) {
            System.out.println(indice + ". " + m.getNombre());
            indice++;
        }
    }
    
    // Muestra todos los hechizos junto a sus puntajes calculados
    public static void mostrarHechizosConPuntaje() {
        int indice = 1;
        for(Hechizo h : Sistema.listaHechizos) {
            System.out.println(indice + ". " + h.getNombre() + " - Puntaje: " + h.calcularPuntaje());
            indice++;
        }
    }

    // Muestra todos los magos junto a su puntaje total calculado 
    public static void mostrarMagosConPuntaje() {
        int indice = 1;
        for(Mago m : Sistema.listaMagos) {
            double puntaje = 0;
            for(Hechizo h : m.getListaHechizo()) {
                puntaje += h.calcularPuntaje();
            }
            System.out.println(indice + ". " + m.getNombre() + " - Puntaje: " + puntaje);
            indice++;
        }
    }
    
    //  Muestra el top 10 de hechizos ordenados de mayor a menor puntaje 
    public static void top10Hechizos() {
        ArrayList<Hechizo> lista = new ArrayList<>(Sistema.listaHechizos);
        
        //orden:v to10
        for(int i = 0; i < lista.size() - 1; i++) {
            for(int j = i + 1; j < lista.size(); j++) {
                if(lista.get(j).calcularPuntaje() > lista.get(i).calcularPuntaje()) {
                    Hechizo temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
        
        System.out.println("=== TOP 10 HECHIZOS ===");
        for(int i = 0; i < 10 && i < lista.size(); i++) {
            System.out.println((i+1) + ". " + lista.get(i).getNombre() + " - Puntaje: " + lista.get(i).calcularPuntaje());
        }
    }
    

    // Muestra el top 10 de hechizos ordenados de mayor a menor puntaje
    public static void top3Magos() {
        ArrayList<Mago> lista = new ArrayList<>(Sistema.listaMagos);
        
        //ordentop3:v
        for(int i = 0; i < lista.size() - 1; i++) {
            for(int j = i + 1; j < lista.size(); j++) {
                double puntajeI = 0;
                double puntajeJ = 0;
                for(Hechizo h : lista.get(i).getListaHechizo()) {
                    puntajeI += h.calcularPuntaje();
                }
                for(Hechizo h : lista.get(j).getListaHechizo()) {
                    puntajeJ += h.calcularPuntaje();
                }
                if(puntajeJ > puntajeI) {
                    Mago temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }
        
        System.out.println("=== TOP 3 MAGOS ===");
        for(int i = 0; i < 3 && i < lista.size(); i++) {
            double puntaje = 0;
            for(Hechizo h : lista.get(i).getListaHechizo()) {
                puntaje += h.calcularPuntaje();
            }
            System.out.println((i+1) + ". " + lista.get(i).getNombre() + " - Puntaje: " + puntaje);
        }
    }
}