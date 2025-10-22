package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final int totalStage;

    private Cars cars;

    public GameController(int totalStage, Cars cars) {
        this.totalStage = totalStage;
        this.cars = cars;
    }

    public List<List<MoveResult>> run() {
        List<List<MoveResult>> gameResult = new ArrayList<>();
        for (int stage = 1; stage <= totalStage; stage++) {
            gameResult.add(cars.move());
        }
        return gameResult;
    }
}
