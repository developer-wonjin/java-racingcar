package step3.car;

public class Car {
    public static final int DEFAULT_POSITION = 0;
    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public int getPosition() {
        return position;
    }
}
