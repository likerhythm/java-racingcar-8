package racingcar;

import java.util.Arrays;
import java.util.List;

public class GameConfigurator {

    private InputView inputView;

    public GameConfigurator() {
        this.inputView = new InputView();
    }

    public RacingGame createRacingGame() {
        String carNames = inputView.printCarNameInputGuide();
        RandomIntegerGenerator generator = new DefaultRandomIntegerGenerator();
        Driver driver = new Driver(generator);
        List<Car> cars = Arrays.stream(carNames.split(",")).map(cn -> new Car(cn, driver)).toList();
        try {
            int gameStage = Integer.parseInt(inputView.printGameStageInputGuide());
            GameController gameController = new GameController(gameStage, new Cars(cars));
            return new RacingGame(gameController);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수로 입력해야 합니다");
        }
    }

}
