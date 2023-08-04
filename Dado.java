import java.util.Random;

public class Dado {
    public int dado(){
        Random random = new Random();
        return random.nextInt(6);
    }
}
