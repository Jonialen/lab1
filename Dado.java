import java.util.Random;

// Clase Dado que representa un dado
public class Dado {
    // Método para simular el lanzamiento de un dado y obtener un número aleatorio entre 1 y 6
    public int dado() {
        Random random = new Random(); // Crear un objeto de la clase Random para generar números aleatorios

        // Lanzar el dado y obtener un número aleatorio entre 1 y 6 
        return random.nextInt(6)+1;
    }
}
