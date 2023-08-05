public class Jugador {
    public int puntosJugador; // Variable para almacenar los puntos del jugador

    // Método que representa el turno del jugador
    public boolean jugar() {
        Dado myDado = new Dado(); // Crear un objeto de la clase "Dado"
        int numero = myDado.dado(); // Lanzar el dado y obtener un número aleatorio entre 1 y 6

        // Comprobar si el número obtenido es igual a 1
        if (numero == 1) {
            puntosJugador = 0; // Si es 1, el jugador pierde todos sus puntos
            return true; // Indicar que el jugador perdió su turno
        } else {
            puntosJugador += numero; // Si no es 1, sumar los puntos obtenidos al total del jugador
            return false; // Indicar que el jugador continúa su turno
        }
    }

    // Método para devolver la cantidad de puntos acumulados por el jugador
    public int devolverPuntos() {
        return puntosJugador; // Devolver el total de puntos del jugador
    }
}
