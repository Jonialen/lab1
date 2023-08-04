public class Jugador {
    public int puntosJugador;
    public boolean jugar(){
        Dado myDado = new Dado();
        int numero = myDado.dado();
        if (numero == 1){
            puntosJugador = 0;
            return true;
        }
        else {
            puntosJugador += numero;
            return false;
        }
    }
    public int devolverPuntos(){
        return puntosJugador;
    }
}
