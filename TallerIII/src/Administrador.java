
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
    public static void modificarMago() {
        try {
            Scanner s = new Scanner(System.in);
            
            System.out.println("Magos disponibles:");
            int indice = 1;
            for(Mago m : Sistema.listaMagos) {
                System.out.println(indice + ". " + m.getNombre());
                indice++;
            }
            
            System.out.print("Elige un mago: ");
            int opcion = Integer.parseInt(s.nextLine());
            Mago mago = Sistema.listaMagos.get(opcion - 1);
            
            System.out.println("Que deseas modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Agregar hechizo");
            System.out.println("3. Eliminar hechizo");
            System.out.print("> ");
            int op = Integer.parseInt(s.nextLine());
            
            if(op == 1) {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = s.nextLine();
                mago.setNombre(nuevoNombre);
                System.out.println("Nombre modificado!");
                
            } else if(op == 2) {
                System.out.print("Nombre del hechizo a agregar: ");
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
                } else {
                    System.out.println("Hechizo agregado!");
                }
                
            } else if(op == 3) {
                System.out.println("Hechizos del mago:");
                int i = 1;
                for(Hechizo h : mago.getListaHechizo()) {
                    System.out.println(i + ". " + h.getNombre());
                    i++;
                }
                System.out.print("Nombre del hechizo a eliminar: ");
                String nombreHechizo = s.nextLine();
                mago.getListaHechizo().removeIf(h -> h.getNombre().equals(nombreHechizo));
                System.out.println("Hechizo eliminado!");
            }
            
        } catch(Exception e) {
            System.out.println("Error al modificar mago");
        }
    }
}