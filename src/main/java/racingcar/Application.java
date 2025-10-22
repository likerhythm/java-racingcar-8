package racingcar;

public class Application {
    public static void main(String[] args) {
        GameConfigurator configurator = new GameConfigurator();
        RacingGame racingGame = configurator.createRacingGame();
        racingGame.run();
    }
}
