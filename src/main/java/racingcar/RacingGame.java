package racingcar;

import java.util.List;

public class RacingGame {

    private GameController controller;
    private OutputView outputView;

    public RacingGame(GameController controller) {
        this.controller = controller;
        this.outputView = new OutputView();
    }

    public void run() {
        List<List<MoveResult>> gameResult = controller.run();
        outputView.printIntermediateResult(gameResult);
        outputView.printWinners(gameResult.getLast());
    }
}
