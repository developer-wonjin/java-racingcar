package step3.view;

import step3.domain.Car;
import step3.domain.Cars;

import java.util.List;

public class PrintView {

    public void input(int car, int count) {
        print("자동차 대수는 몇 대 인가요?");
        print(Integer.toString(car));
        print("시도할 회수는 몇 회 인가요?");
        print(Integer.toString(count));
        enter();
    }

    public void result(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(car.getName() + " : " + getDash(car.getPosition()));
        }
        enter();
    }

    private StringBuilder getDash(int position) {
        StringBuilder dash = new StringBuilder();

        for (int i = 0; i < position; i++) {
            dash.append("-");
        }

        return dash;
    }

    public void printWinner(List<String> winner) {
        print(String.join(", ", winner) + "가 최종 우승했습니다.");
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void enter() {
        System.out.println();
    }
}
