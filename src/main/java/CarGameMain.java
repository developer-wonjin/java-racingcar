import game.GameStrategy;
import game.PreparedCarGame;
import game.RacingCarGame;
import uiview.InputView;
import uiview.ResultView;

public class CarGameMain {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();

    public static void main(String[] args) {

        PreparedCarGame carGame = new PreparedCarGame();

        int carNum = inputView.inputCarNum();
        int attemptNum = inputView.inputAttemptNum();

        carGame.ready(racingCarGame(carNum, attemptNum));
        carGame.startRace();

        resultView.resultView(carGame.getRaceSituation());

    }

    public static GameStrategy racingCarGame(int carNum, int attemptNum) {
        RacingCarGame carGame = new RacingCarGame();
        carGame.readyRace(carNum, attemptNum);
        return carGame;
    }

}
