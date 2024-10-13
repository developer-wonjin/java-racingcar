package racinggame.domain;

import java.util.List;
import racinggame.dto.History;
import racinggame.dto.Result;
import racinggame.random.CapacityGenerator;

public class RacingGame {

    private Cars cars;
    private int repeatCount;

    public RacingGame(int repeatCount, Names names) {
        if (isNonNegative(repeatCount)) {
            throw new IllegalArgumentException("반복횟수는 1이상이여야 합니다.");
        }
        this.repeatCount = repeatCount;
        this.cars = Cars.from(names.split());
    }

    private boolean isNonNegative(int repeatCount) {
        return repeatCount <= 0;
    }

    public Result start(CapacityGenerator capacityGenerator) {
        for (int i = 0; i < repeatCount; i++) {
            cars.move(capacityGenerator);
        }
        History history = cars.history();
        List<String> winners = cars.winners();
        return new Result(history,winners);
    }

}
