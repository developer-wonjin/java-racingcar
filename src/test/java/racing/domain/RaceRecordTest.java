package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.constant.RacePosition.FORWARD;
import static racing.constant.RacePosition.STOP;

public class RaceRecordTest {

    private final static String CAR_NAME = "bisohn27";

    List<Boolean> forwardResults = List.of(true, false, false, true, false);

    @Test
    void record() {
        RaceCar car = getRaceCar();
        RaceRecord record = car.raceRecord();
        List<Integer> results = results();

        assertThat(record.name()).isEqualTo(CAR_NAME);
        for (int i = 0; i < forwardResults.size(); i++) {
            assertThat(record.raceResult(i))
                    .isEqualTo(results.get(i));
        }
    }

    private RaceCar getRaceCar() {
        RaceCar car = new RaceCar(CAR_NAME);
        forwardResults.forEach(car::race);
        return car;
    }

    private List<Integer> results() {
        List<Integer> results = new ArrayList<>();
        int sum = 0;

        for (boolean isForward : forwardResults) {
            sum += isForward ? FORWARD.getPoint() : STOP.getPoint();
            results.add(sum);
        }
        return results;
    }

    @Test
    void 레이스_결과_합계() {
        int totalPoint = forwardResults.stream()
                .mapToInt(isForward -> isForward ? FORWARD.getPoint() : STOP.getPoint())
                .sum();
        RaceCar car = getRaceCar();
        RaceRecord record = car.raceRecord();

        int result = record.totalPoint();

        assertThat(result).isEqualTo(totalPoint);
        assertThat(record.name()).isEqualTo(CAR_NAME);
    }

    @Test
    void 레이스_결과_수() {
        RaceCar raceCar = getRaceCar();
        RaceRecord record = raceCar.raceRecord();

        assertThat(record.raceResult(forwardResults.size() - 1))
                .isNotNull();
        assertThatThrownBy(() -> record.raceResult(forwardResults.size()))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
