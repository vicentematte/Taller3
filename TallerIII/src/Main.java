// Nombre: Vicente Augusto Matte Barraza
// RUT: 21.753.089-K
// Carrera: ITI 
// Taller III
public class Main {
    // Metodo principal del taller, carga los archivos e inicia el menu */
    public static void main(String[] args) {
        Sistema.cargarHechizos();
        Sistema.cargarMagos();
        Menu.mostrarMenu();
    }
}