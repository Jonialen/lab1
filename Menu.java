import java.util.Scanner;

public class Menu {
    public Jugador computadora = new Jugador(); // Crear un objeto Jugador para la computadora
    public Jugador persona = new Jugador(); // Crear un objeto Jugador para la persona
    public Integer puntosMaquina = 0; // Variable para almacenar los puntos de la computadora (no utilizada)
    public Integer puntosJugador = 0; // Variable para almacenar los puntos de la persona (no utilizada)
    public Integer puntosTotales = 100; // Puntos totales requeridos para ganar el juego

    public static void main(String[] args){
        Menu menu = new Menu(); // Crear un objeto de la clase Menu
        Scanner inp = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        System.out.println("Ingresa la cantidad de dados (1 o 3)");
        int cant_dados = inp.nextInt(); // Leer la cantidad de dados que el jugador quiere usar

        // Verificar si la cantidad de dados ingresada es válida (1 o 3)
        if (cant_dados != 1 && cant_dados != 3){
            System.out.println("No es un numero posible el "+cant_dados);
            main(args); // Volver a pedir la entrada del usuario si el número no es válido
        }

        System.out.println("Inicia el juego");
        menu.juego(cant_dados); // Iniciar el juego con la cantidad de dados seleccionada
        inp.close(); // Cerrar el objeto Scanner
    }

    // Método para manejar el juego
    public void juego(int cant_dados) {
        Scanner inp = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        int puntosPersona = persona.devolverPuntos(); // Obtener los puntos de la persona
        int puntosComputadora = computadora.devolverPuntos(); // Obtener los puntos de la computadora
        int puntos;
        boolean jugador = false; // Variable para indicar de quién es el turno (false: computadora, true: persona)

        // Ciclo para seguir jugando hasta que uno de los jugadores alcance la cantidad de puntos totales
        while (puntosComputadora < puntosTotales && puntosPersona < puntosTotales) {
            if (jugador) {
                System.out.println("Turno Humano");
                // Mostrar los puntos de la persona cada vez que son múltiplos de 20
                if (puntosPersona % 20 == 0 && puntosPersona > 0) {
                    System.out.println("Puntos: " + puntosPersona);
                }
                while (true) {
                    System.out.println("Tirar o pasar(1/0)");
                    int pasar = inp.nextInt(); // Leer la decisión del jugador (tirar o pasar)

                    if (pasar == 0) {
                        System.out.println("Turno pasado");
                        break; // Salir del bucle y pasar al turno de la computadora
                    } else if (pasar == 1) {
                        puntos = tirar(persona, cant_dados); // Tirar los dados de la persona
                        int dif = puntos - puntosPersona;
                        if (dif < 0) {
                            dif = 0;
                        }
                        System.out.println("Haz lanzado, sacaste " + dif + " puntos en total");
                        puntosPersona = puntos; // Actualizar los puntos de la persona
                        jugador = false; // Cambiar el turno al de la computadora
                        break; // Salir del bucle y pasar al turno de la computadora
                    }
                }
            } else {
                if (puntosPersona % 20 == 0) {
                    System.out.println("Puntos: " + puntosPersona);
                }
                System.out.println("Turno computadora");
                puntosComputadora = tirar(computadora, cant_dados); // Tirar los dados de la computadora
                System.out.println("Computadora ha lanzado");
                jugador = true; // Cambiar el turno a la persona
            }
        }
        inp.close(); // Cerrar el objeto Scanner

        // Mostrar el resultado del juego (quién ganó o perdió)
        if (puntosPersona > puntosComputadora){
            System.out.println("Ganaste");
        }
        else{
            System.out.println("Perdiste");
        }
        System.out.println("Puntos jugador: "+puntosPersona);
        System.out.println("Puntos computadora: "+puntosComputadora);
        System.out.println("GAME OVER");
    }

    // Método para tirar los dados para un jugador y devolver los puntos obtenidos
    public int tirar(Jugador jugador, int cant_dados){
        boolean detener;
        for (int i = 0; i < cant_dados; i++) {
                detener = jugador.jugar(); // Tirar el dado para el jugador

            if (detener) {
                System.out.println("Puntos: 0, ha salido 1");
                break; // Detener el lanzamiento si el jugador obtiene un 1 en el dado
            }
        }
        return jugador.devolverPuntos(); // Devolver los puntos obtenidos por el jugador
    }
}
