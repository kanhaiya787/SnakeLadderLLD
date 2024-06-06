import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    public int getValue() {
        int min=1, max=6;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

}
