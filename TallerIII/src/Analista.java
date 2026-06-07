
public class Analista {

    public static void mostrarHechizos() {
        int indice = 1;
        for(Hechizo h : Sistema.listaHechizos) {
            System.out.println(indice + ". " + h);
            indice++;
        }
    }

    public static void mostrarMagos() {
        int indice = 1;
        for(Mago m : Sistema.listaMagos) {
            System.out.println(indice + ". " + m.getNombre());
            indice++;
        }
    }
    public static void mostrarHechizosConPuntaje() {
        int indice = 1;
        for(Hechizo h : Sistema.listaHechizos) {
            System.out.println(indice + ". " + h.getNombre() + " - Puntaje: " + h.calcularPuntaje());
            indice++;
        }
    }

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
}