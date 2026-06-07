import java.util.Scanner;

public class Menu {
    static Scanner s = new Scanner(System.in);
    
    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Panel Administrador");
            System.out.println("2. Panel Analista");
            System.out.println("0. Salir");
            System.out.print("> ");
            try {
                opcion = s.nextInt();
            } catch(Exception e) {
                s.nextLine();
                opcion = -1;
                System.out.println("Opcion invalida");
            }
            switch(opcion) {
            case 1:
                mostrarMenuAdministrador();
                break;
            case 2:
                mostrarMenuAnalista();
                break;
            case 0:
                System.out.println("Hasta luego!");
                break;
            default:
                System.out.println("Opcion invalida");
            }
        } while(opcion != 0);
    }
    
    public static void mostrarMenuAdministrador() {
        int opcion;
        do {
            System.out.println("\n=== ADMINISTRADOR ===");
            System.out.println("1. Agregar Mago");
            System.out.println("2. Modificar Mago");
            System.out.println("3. Eliminar Mago");
            System.out.println("4. Agregar Hechizo");
            System.out.println("5. Modificar Hechizo");
            System.out.println("6. Eliminar Hechizo");
            System.out.println("0. Volver");
            System.out.print("> ");
            try {
                opcion = s.nextInt();
            } catch(Exception e) {
                s.nextLine();
                opcion = -1;
                System.out.println("Opcion invalida");
            }
            switch(opcion) {
            case 1:
            	Administrador.agregarMago();
            	break;
            	
            case 2: 
            	Administrador.modificarMago();
            	break;
            case 3:
                Administrador.eliminarMago();
                break;
            case 4:
                Administrador.agregarHechizo();
                break;
            case 5: 
            	Administrador.modificarHechizo();
            	break;
            	
            case 6: 
            	Administrador.eliminarHechizo();
            	break;
            case 0:
                System.out.println("Volviendo...");
                break;
            default:
                System.out.println("Opcion invalida");
            }
        } while(opcion != 0);
    }
    
    public static void mostrarMenuAnalista() {
        int opcion;
        do {
            System.out.println("\n=== ANALISTA ===");
            System.out.println("1. Top 10 Mejores Hechizos");
            System.out.println("2. Top 3 Mejores Magos");
            System.out.println("3. Mostrar todos los Hechizos");
            System.out.println("4. Mostrar todos los Magos");
            System.out.println("5. Hechizos con puntuacion");
            System.out.println("6. Magos con puntuacion");
            System.out.println("0. Volver");
            System.out.print("> ");
            try {
                opcion = s.nextInt();
            } catch(Exception e) {
                s.nextLine();
                opcion = -1;
                System.out.println("Opcion invalida");
            }
            switch(opcion) {
            case 1: break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 0:
                System.out.println("Volviendo...");
                break;
            default:
                System.out.println("Opcion invalida");
            }
        } while(opcion != 0);
    }
}