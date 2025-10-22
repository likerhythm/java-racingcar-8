package racingcar;

import racingcar.generator.RandomIntegerGenerator;

public class Driver {

    private static final int MIN_VALUE_TO_MOVE = 4;
    private static final int BASE_MOVE_COUNT = 1;
    private final RandomIntegerGenerator generator;

    public Driver(RandomIntegerGenerator generator) {
        this.generator = generator;
    }

    public int run() {
        if (generator.generateByRange(0, 9) >= MIN_VALUE_TO_MOVE) {
            return BASE_MOVE_COUNT;
        }
        return 0;
    }
}
