package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.number_generator.RandomIntegerGenerator;
import racingcar.view.InputView;

public class GameConfigurator {

    private InputView inputView;
    private RandomIntegerGenerator generator;

    public GameConfigurator(RandomIntegerGenerator generator) {
        this.inputView = new InputView();
        this.generator = generator;
    }

    public RacingGame createRacingGame() {
        String carNames = inputView.printCarNameInputGuide();
        Driver driver = new Driver(generator);
        List<Car> cars = Arrays.stream(carNames.split(",")).map(cn -> new Car(cn, driver)).toList();
        try {
            int gameStage = Integer.parseInt(inputView.printGameStageInputGuide());
            GameController gameController = new GameController(gameStage, new Cars(cars));
            Console.close();
            return new RacingGame(gameController);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수로 입력해야 합니다");
        }
    }

}
