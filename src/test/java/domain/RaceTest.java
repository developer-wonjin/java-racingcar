package domain;

import dto.RaceInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    static final int INIT_POSITION = 1;
    static final int DEFAULT_MOVE_VALUE = 1;
    static final int NUMBER_OF_CARS_DEFAULT = 3;
    static final int NUMBER_OF_RACES_DEFAULT = 5;

    Car defaultCar;
    Race race;

    @BeforeEach
    void setUp() {
        defaultCar = Car.createCar(CarState.create(INIT_POSITION), DefaultCarDisplacement.create(DEFAULT_MOVE_VALUE));
        race = new Race(new RaceInfo(new NumberOfCars(NUMBER_OF_CARS_DEFAULT), new NumberOfRaces(NUMBER_OF_RACES_DEFAULT), defaultCar));
    }

    @Test
    @DisplayName("자동차 경주 테스트")
    void calculate() {
        RaceResult raceResult = race.calculate();
        assertThat(raceResult.toString()).isEqualTo("[" +
                "[{position : 1}, {position : 1}, {position : 1}], " +
                "[{position : 2}, {position : 2}, {position : 2}], " +
                "[{position : 3}, {position : 3}, {position : 3}], " +
                "[{position : 4}, {position : 4}, {position : 4}], " +
                "[{position : 5}, {position : 5}, {position : 5}], " +
                "[{position : 6}, {position : 6}, {position : 6}]]");
    }
}
