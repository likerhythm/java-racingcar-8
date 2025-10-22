package racingcar;

import java.util.List;
import racingcar.dto.MoveResult;
import racingcar.view.OutputView;

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
