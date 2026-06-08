
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    // Lista global de hechizos cargados desde Hechizos.txt
    public static ArrayList<Hechizo> listaHechizos = new ArrayList<>();
    // Lista global de magos cargados desde Magos.txt

    public static ArrayList<Mago> listaMagos = new ArrayList<>();    
    
    
    /** Lee el archivo  de hechizos.txt y carga todos los hechizos en la lista segun su tipo (Fuego, Tierra, Planta, Agua)
     */
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
    
    /** Lee el archivo Magos.txt y carga todos los magosasignandoles sus hechizos desde la lista de hechizos ya cargada*/
    public static void cargarMagos() {
        try {
            File file = new File("Magos.txt");
            Scanner s = new Scanner(file);
            while(s.hasNextLine()) {
                String linea = s.nextLine();
                String[] partes = linea.split(";");
                String nombre = partes[0];
                
                Mago mago = new Mago(nombre);
                
                String[] hechizos = partes[1].split("\\|");
                for(String nombreHechizo : hechizos) {
                    for(Hechizo h : listaHechizos) {
                        if(h.getNombre().equals(nombreHechizo)) {
                            mago.getListaHechizo().add(h);
                        }
                    }
                }
                listaMagos.add(mago);
            }
            s.close();
        } catch(FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } 
    }
    
    /** Sobrescribe el archivo Hechizos.txt con los datos actuales
     * manteniendo el formato */
    public static void guardarHechizos() {
        try {
            BufferedWriter escribano = new BufferedWriter(new FileWriter("Hechizos.txt"));
            for(Hechizo h : listaHechizos) {
                if(h instanceof HechizoFuego) {
                    HechizoFuego hf = (HechizoFuego) h;
                    escribano.write(h.getNombre() + ";" + h.getTipo() + ";" + h.getDamage() + ";" + hf.getDuracionQuemadura());
                } else if(h instanceof HechizoTierra) {
                    HechizoTierra ht = (HechizoTierra) h;
                    escribano.write(h.getNombre() + ";" + h.getTipo() + ";" + h.getDamage() + ";" + ht.getMejoraDefensa());
                } else if(h instanceof HechizoPlanta) {
                    HechizoPlanta hp = (HechizoPlanta) h;
                    escribano.write(h.getNombre() + ";" + h.getTipo() + ";" + h.getDamage() + ";" + hp.getDuracionStun() + "," + hp.getCantPlantas());
                } else if(h instanceof HechizoAgua) {
                    HechizoAgua ha = (HechizoAgua) h;
                    escribano.write(h.getNombre() + ";" + h.getTipo() + ";" + h.getDamage() + ";" + ha.getCantHeal() + "," + ha.getPresionAgua());
                }
                escribano.newLine();
            }
            escribano.close();
    		}catch(IOException e) 
        {
            System.out.println("Error al guardar hechizos");
        }
    }
    
    /** Sobrescribe el archivo magos.txt con los datos actuales
     * manteniendo el formato */
    public static void guardarMagos() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt"));
            for(Mago m : listaMagos) {
                String linea = m.getNombre() + ";";
                for(int i = 0; i < m.getListaHechizo().size(); i++) {
                    linea += m.getListaHechizo().get(i).getNombre();
                    if(i < m.getListaHechizo().size() - 1) {
                        linea += "|";
                    }
                }
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
        } catch(IOException e) {
            System.out.println("Error al guardar magos");
        }
    }
}