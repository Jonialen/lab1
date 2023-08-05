import java.util.Scanner;

public class Menu {
    public Jugador computadora = new Jugador();
    public Jugador persona = new Jugador();
    public Integer puntosMaquina = 0;
    public Integer puntosJugador = 0;
    public static void main(String[] args){
        Menu menu = new Menu();
        Scanner inp = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de dados (1 o 3)");
        int cant_dados = inp.nextInt();
        if (cant_dados != 1 & cant_dados != 3){
            System.out.println("No es un numero posible el "+cant_dados);
            main(args);
        }
        inp.close();
        
        System.out.println("Inicia el juego");
        menu.juego(cant_dados);
    }
    
    public void juego(int cant_dados){
        int puntosPersona = persona.devolverPuntos();
        int puntosComputadora = computadora.devolverPuntos();
        boolean jugador = false;
        while(puntosComputadora < 100 & puntosPersona<100){
            if (jugador){
                System.out.println("Turno Humano");
                if (puntosPersona%20 == 0){
                    System.out.println("Puntos: " + puntosPersona);
                }
                puntosPersona = tirar(persona, cant_dados);
                jugador = false;
            }
            else{
                if (puntosPersona%20 == 0){
                    System.out.println("Puntos: " + puntosPersona);
                }
                System.out.println("Turno computadora");
                puntosComputadora = tirar(computadora, cant_dados);
                jugador = true;
                
            }
        } 
        if (puntosPersona > puntosComputadora){
            System.out.println("Ganaste");
        }
        else{
            System.out.println("Perdiste");
        }
        System.out.println("Puntos "+puntosPersona);
        System.out.println("GAME OVER");
    }
    
    public int tirar(Jugador jugador, int cant_dados){
        boolean detener;
        for (int i = 0; i < cant_dados; i++) {
                detener = jugador.jugar();
                
            if (detener) {
                System.out.println("Puntos: 0");
                break;
            }
        }
        return jugador.devolverPuntos();
        

    }


}
