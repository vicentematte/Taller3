import java.util.Scanner;

public class Administrador {
	private static Scanner s = new Scanner(System.in);
	
	// Agrega un nuevo mago al sistema pidiendo el nombre y hechizos al usuario 
	public static void agregarMago() {
	    try {
	        System.out.print("Ingrese nombre del mago: ");
	        String nombre = s.nextLine();
	        
	        Mago mago = new Mago(nombre);
	        
	        System.out.print("Cuantos hechizos domina: ");
	        int cantidad = Integer.parseInt(s.nextLine());
	        
	        for(int i = 0; i < cantidad; i++) {
	            System.out.println("\n¿Que tipo de hechizo quieres agregar?");
	            System.out.println("1. Fuego");
	            System.out.println("2. Tierra");
	            System.out.println("3. Planta");
	            System.out.println("4. Agua");
	            System.out.print("> ");
	            int tipo = Integer.parseInt(s.nextLine());
	            
	            String tipoElegido = "";
	            if(tipo == 1) tipoElegido = "Fuego";
	            else if(tipo == 2) {
	            	tipoElegido = "Tierra";
	            }
	            else if(tipo == 3) {
	            	tipoElegido = "Planta";
	            }
	            else if(tipo == 4) {
	            	tipoElegido = "Agua";
	            }
	            
	            System.out.println("Hechizos de tipo " + tipoElegido + ":");
	            int indice = 1;
	            for(Hechizo h : Sistema.listaHechizos) {
	                if(h.getTipo().equals(tipoElegido)) {
	                    System.out.println(indice + ". " + h.getNombre());
	                    indice++;
	                }
	            }
	            
	            System.out.print("Elige un hechizo (nombre): ");
	            String nombreHechizo = s.nextLine();
	            
	            boolean encontrado = false;
	            for(Hechizo h : Sistema.listaHechizos) {
	                if(h.getNombre().equals(nombreHechizo) && h.getTipo().equals(tipoElegido)) {
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
	        Sistema.guardarMagos();
	        
	    } catch(Exception e) {
	        System.out.println("Error al agregar mago");
	    }
	}
    
    // Modifica el nombre o los hechizos de un mago 
    public static void modificarMago() {
        try {
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
                Sistema.guardarMagos();
                
            } else if(op == 2) {
                System.out.println("\n¿Que tipo de hechizo quieres agregar?");
                System.out.println("1. Fuego");
                System.out.println("2. Tierra");
                System.out.println("3. Planta");
                System.out.println("4. Agua");
                System.out.print("> ");
                int tipo = Integer.parseInt(s.nextLine());
                
                String tipoElegido = "";
                if(tipo == 1) tipoElegido = "Fuego";
                else if(tipo == 2) tipoElegido = "Tierra";
                else if(tipo == 3) tipoElegido = "Planta";
                else if(tipo == 4) tipoElegido = "Agua";
                
                System.out.println("Hechizos de tipo " + tipoElegido + ":");
                int indice1 = 1;
                for(Hechizo h : Sistema.listaHechizos) {
                    if(h.getTipo().equals(tipoElegido)) {
                        System.out.println(indice1 + ". " + h.getNombre());
                        indice1++;
                    }
                }
                
                System.out.print("Elige un hechizo (nombre): ");
                String nombreHechizo = s.nextLine();
                boolean encontrado = false;
                for(Hechizo h : Sistema.listaHechizos) {
                    if(h.getNombre().equals(nombreHechizo) && h.getTipo().equals(tipoElegido)) {
                        mago.getListaHechizo().add(h);
                        encontrado = true;
                    }
                }
                if(!encontrado) {
                    System.out.println("Hechizo no encontrado");
                } else {
                    System.out.println("Hechizo agregado!");
                }
                Sistema.guardarMagos();
                
            } else if(op == 3) {
                System.out.println("Hechizos del mago:");
                int i = 1;
                for(Hechizo h : mago.getListaHechizo()) {
                    System.out.println(i + ". " + h.getNombre() + " | Tipo: " + h.getTipo() + " | Damage: " + h.getDamage());
                    i++;
                }
                System.out.print("Nombre del hechizo a eliminar: ");
                String nombreHechizo = s.nextLine();
                mago.getListaHechizo().removeIf(h -> h.getNombre().equals(nombreHechizo));
                System.out.println("Hechizo eliminado!");
                Sistema.guardarMagos();
            }
            
        } catch(Exception e) {
            System.out.println("Error al modificar mago");
        }
    }
    
    //Elimina un mago del sistema segun la eleccion del usuario
    public static void eliminarMago() {
        try {
            System.out.println("Magos disponibles:");
            int indice = 1;
            for(Mago m : Sistema.listaMagos) {
                System.out.println(indice + ". " + m.getNombre() + " | Hechizos: " + m.getListaHechizo().size());
                indice++;
            }
            
            System.out.print("Elige el mago a eliminar: ");
            int opcion = Integer.parseInt(s.nextLine());
            Mago mago = Sistema.listaMagos.get(opcion - 1);
            
            System.out.println("Hechizos de " + mago.getNombre() + ":");
            for(Hechizo h : mago.getListaHechizo()) {
                System.out.println("- " + h.getNombre() + " | Tipo: " + h.getTipo());
            }
            
            Sistema.listaMagos.remove(mago);
            System.out.println("Mago eliminado!");
            Sistema.guardarMagos();
            
        } catch(Exception e) {
            System.out.println("Error al eliminar mago");
        }
    }
    
    // Agrega un nuevo hechizo al sistema pidiendo datos al user
    public static void agregarHechizo() {
        try {
            System.out.print("Ingrese nombre del hechizo: ");
            String nombre = s.nextLine();
            
            System.out.println("Tipo de hechizo:");
            System.out.println("1. Fuego");
            System.out.println("2. Tierra");
            System.out.println("3. Planta");
            System.out.println("4. Agua");
            System.out.print("> ");
            int tipo = Integer.parseInt(s.nextLine());
            
            System.out.print("Ingrese daño: ");
            int damage = Integer.parseInt(s.nextLine());
            
            Hechizo h = null;
            
            if(tipo == 1) {
                System.out.print("Duracion quemadura: ");
                int duracion = Integer.parseInt(s.nextLine());
                h = new HechizoFuego(nombre, "Fuego", damage, duracion);
                
            } else if(tipo == 2) {
                System.out.print("Mejora defensa: ");
                int mejora = Integer.parseInt(s.nextLine());
                h = new HechizoTierra(nombre, "Tierra", damage, mejora);
                
            } else if(tipo == 3) {
                System.out.print("Duracion stun: ");
                int stun = Integer.parseInt(s.nextLine());
                System.out.print("Cantidad plantas: ");
                int plantas = Integer.parseInt(s.nextLine());
                h = new HechizoPlanta(nombre, "Planta", damage, stun, plantas);
                
            } else if(tipo == 4) {
                System.out.print("Cantidad heal: ");
                int heal = Integer.parseInt(s.nextLine());
                System.out.print("Presion agua: ");
                int presion = Integer.parseInt(s.nextLine());
                h = new HechizoAgua(nombre, "Agua", damage, heal, presion);
            }
            
            if(h != null) {
                Sistema.listaHechizos.add(h);
                System.out.println("Hechizo agregado!");
                Sistema.guardarHechizos();
            }
            
        } catch(Exception e) {
            System.out.println("Error al agregar hechizo");
        }
    }

    //Modifica el nombre o el damage de un hechizo existente 
    public static void modificarHechizo() {
        try {
            System.out.println("Hechizos disponibles:");
            int indice = 1;
            for(Hechizo h : Sistema.listaHechizos) {
                System.out.println(indice + ". " + h.getNombre() + " | Tipo: " + h.getTipo() + " | Damage: " + h.getDamage());
                indice++;
            }
            
            System.out.print("Elige un hechizo: ");
            int opcion = Integer.parseInt(s.nextLine());
            Hechizo hechizo = Sistema.listaHechizos.get(opcion - 1);
            
            System.out.println("Que deseas modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Daño");
            System.out.print("> ");
            int op = Integer.parseInt(s.nextLine());
            
            if(op == 1) {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = s.nextLine();
                hechizo.setNombre(nuevoNombre);
                System.out.println("Nombre modificado!");
                
            } else if(op == 2) {
                System.out.print("Nuevo daño: ");
                int nuevoDamage = Integer.parseInt(s.nextLine());
                hechizo.setDamage(nuevoDamage);
                System.out.println("Daño modificado!");
            }
            Sistema.guardarHechizos();
            
        } catch(Exception e) {
            System.out.println("Error al modificar hechizo");
        }
    }
    
    //elimina un hechizo del sistema y lo quita tambien de aquellos magos que eran portadores del hechizo
    public static void eliminarHechizo() {
        try {
            System.out.println("Hechizos disponibles:");
            int indice = 1;
            for(Hechizo h : Sistema.listaHechizos) {
                System.out.println(indice + ". " + h.getNombre() + " | Tipo: " + h.getTipo() + " | Damage: " + h.getDamage());
                indice++;
            }
            
            System.out.print("Elige el hechizo a eliminar: ");
            int opcion = Integer.parseInt(s.nextLine());
            Hechizo hechizo = Sistema.listaHechizos.get(opcion - 1);
            
            // Tambien se eliminan de los magos que lo tengan :v
            for(Mago m : Sistema.listaMagos) {
                m.getListaHechizo().removeIf(h -> h.getNombre().equals(hechizo.getNombre()));
            }
            
            Sistema.listaHechizos.remove(hechizo);
            System.out.println("Hechizo eliminado!");
            Sistema.guardarHechizos();
            Sistema.guardarMagos();
            
        } catch(Exception e) {
            System.out.println("Error al eliminar hechizo");
        }
    }
}