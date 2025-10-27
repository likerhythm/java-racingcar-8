package racingcar;

import racingcar.number_generator.DefaultRandomIntegerGenerator;

public class Application {
    public static void main(String[] args) {
        GameConfigurator configurator = new GameConfigurator(new DefaultRandomIntegerGenerator());
        RacingGame racingGame = configurator.createRacingGame();
        racingGame.run();
    }
}
