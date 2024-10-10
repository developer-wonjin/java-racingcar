package race.domain;

import race.domain.car.Car;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;

    private List<Car> cars;

    public Cars(String[] names) {
        validateCount(names);

        List<Car> cars = new ArrayList<>();
        List<String> entry = new ArrayList<>();
        for (String name : names) {
            checkDuplicate(entry, name);
            cars.add(new Car(name));
            entry.add(name);
        }

        this.cars = cars;
    }

    public Cars(Car... cars) {
        this.cars = List.of(cars);
    }

    private static void validateCount(String[] names) {
        if (names.length < LOWER_BOUND || names.length > UPPER_BOUND) {
            throw new IllegalArgumentException("자동차 수는 " + LOWER_BOUND + " ~ " + UPPER_BOUND + "대 사이로 설정해야 합니다.");
        }
    }

    private void checkDuplicate(List<String> entry, String name) {
        if (entry.contains(name)) {
            throw new IllegalStateException("동일한 자동차 이름을 사용할 수 없습니다. : " + name);
        }
    }

    public void move(int random) {
        cars.forEach(car -> car.accelerate(random));
    }

    public Map<String, Integer> getPositions() {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getCurrentPosition
                ));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isInPosition(maxPosition))
                .collect(Collectors.toList());
    }
}
