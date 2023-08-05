import java.util.Scanner;

public class Menu {
    public Jugador computadora = new Jugador();
    public Jugador persona = new Jugador();
    public Integer puntosMaquina = 0;
    public Integer puntosJugador = 0;
    public Integer puntosTotales = 100;
    public static void main(String[] args){
        Menu menu = new Menu();
        Scanner inp = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de dados (1 o 3)");
        int cant_dados = inp.nextInt();
        if (cant_dados != 1 && cant_dados != 3){
            System.out.println("No es un numero posible el "+cant_dados);
            main(args);
        }
        
        System.out.println("Inicia el juego");
        menu.juego(cant_dados);
        inp.close();
    }
    
    public void juego(int cant_dados) {
        Scanner inp = new Scanner(System.in);
        int puntosPersona = persona.devolverPuntos();
        int puntosComputadora = computadora.devolverPuntos();
        int puntos;
        boolean jugador = false;
        while (puntosComputadora < puntosTotales && puntosPersona < puntosTotales) {
            if (jugador) {
                System.out.println("Turno Humano");
                if (puntosPersona % 20 == 0 && puntosPersona>0) {
                    System.out.println("Puntos: " + puntosPersona);
                }
                while (true) {
                    System.out.println("Tirar o pasar(1/0)");
                    int pasar = inp.nextInt();
                    if (pasar == 0) {
                        System.out.println("Turno pasado");
                        break;
                    } else if (pasar == 1) {
                        puntos = tirar(persona, cant_dados);
                        int dif = puntos-puntosPersona;
                        if (dif < 0) {
                            dif = 0;
                        }
                        System.out.println("Haz lanzado, sacaste "+dif+" puntos en total");
                        puntosPersona = puntos;
                        jugador = false;
                        break;
                    }
                }
            } else {
                if (puntosPersona % 20 == 0) {
                    System.out.println("Puntos: " + puntosPersona);
                }
                System.out.println("Turno computadora");
                puntosComputadora = tirar(computadora, cant_dados);
                System.out.println("Computadora a lanzado");
                jugador = true;
            }
        }
        inp.close();
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
    
    public int tirar(Jugador jugador, int cant_dados){
        boolean detener;
        for (int i = 0; i < cant_dados; i++) {
                detener = jugador.jugar();
                
            if (detener) {
                System.out.println("Puntos: 0, ha salido 1");
                break;
            }
        }
        return jugador.devolverPuntos();
    }
}
