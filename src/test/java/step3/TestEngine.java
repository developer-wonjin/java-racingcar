package step3;

import step3.service.CarEngine;

public class TestEngine implements CarEngine {
    private static final int FORWARD = 4;
    private final int power;

    public TestEngine(int power) {
        this.power = power;
    }

    public boolean canGetPower() {
        return this.power >= FORWARD;
    }

}
