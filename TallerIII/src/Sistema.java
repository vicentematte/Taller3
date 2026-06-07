
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public static ArrayList<Hechizo> listaHechizos = new ArrayList<>();
    public static ArrayList<Mago> listaMagos = new ArrayList<>();    
    
    public static void cargarHechizos() {
        try {
            File file = new File("Hechizos.txt");
            Scanner s = new Scanner(file);
            while(s.hasNextLine()) {
                String linea = s.nextLine();
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String tipo = partes[1];
                int damage = Integer.parseInt(partes[2]);
                
                if(tipo.equals("Fuego")) {
                    int duracionQuemadura = Integer.parseInt(partes[3]);
                    listaHechizos.add(new HechizoFuego(nombre, tipo, damage, duracionQuemadura));
                    
                } else if(tipo.equals("Tierra")) {
                    int mejoraDefensa = Integer.parseInt(partes[3]);
                    listaHechizos.add(new HechizoTierra(nombre, tipo, damage, mejoraDefensa));
                    
                } else if(tipo.equals("Planta")) {
                    String[] extras = partes[3].split(",");
                    int duracionStun = Integer.parseInt(extras[0]);
                    int cantPlantas = Integer.parseInt(extras[1]);
                    listaHechizos.add(new HechizoPlanta(nombre, tipo, damage, duracionStun, cantPlantas));
                    
                } else if(tipo.equals("Agua")) {
                    String[] extras = partes[3].split(",");
                    int cantHeal = Integer.parseInt(extras[0]);
                    int presionAgua = Integer.parseInt(extras[1]);
                    listaHechizos.add(new HechizoAgua(nombre, tipo, damage, cantHeal, presionAgua));
                }
            }
            s.close();
        } catch(FileNotFoundException e) {
        	System.out.println("Archivo no encontrado");
        }
            
    }
}