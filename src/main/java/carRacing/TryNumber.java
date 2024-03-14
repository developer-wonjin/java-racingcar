package carRacing;

public class TryNumber {
    private final int value;

    public TryNumber(int input) {
        validation(input);
        this.value = input;
    }

    public int getValue() {
        return value;
    }

    private void validation(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("1 이상의 정수만 입력 가능합니다.");
        }
    }
}
