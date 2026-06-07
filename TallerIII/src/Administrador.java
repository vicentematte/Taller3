
import java.util.Scanner;

public class Administrador {

    public static void agregarMago() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Ingrese nombre del mago: ");
            String nombre = s.nextLine();
            
            Mago mago = new Mago(nombre);
            
            System.out.print("Cuantos hechizos domina: ");
            int cantidad = Integer.parseInt(s.nextLine());
            
            for(int i = 0; i < cantidad; i++) {
                System.out.print("Ingrese nombre del hechizo: ");
                String nombreHechizo = s.nextLine();
                boolean encontrado = false;
                for(Hechizo h : Sistema.listaHechizos) {
                    if(h.getNombre().equals(nombreHechizo)) {
                        mago.getListaHechizo().add(h);
                        encontrado = true;
                    }
                }
                if(!encontrado) {
                    System.out.println("Hechizo no encontrado");
                }
            }
            Sistema.listaMagos.add(mago);
            System.out.println("Mago agregado!");
            
        } catch(Exception e) {
            System.out.println("Error al agregar mago");
        }
    }
}