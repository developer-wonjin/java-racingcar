package step3.random;

import java.util.Random;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    public static final int RANDOM_NUMBER_BOUND = 10;
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

}
