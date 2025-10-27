package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.number_generator.RandomIntegerGenerator;

public class TestRandomIntegerGenerator implements RandomIntegerGenerator {

    private List<Integer> staticNumbers;
    private int nowIndex;

    public TestRandomIntegerGenerator(int carCount, List<Integer> winnerNumbers) {
        staticNumbers = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            if (winnerNumbers.contains(i)) {
                staticNumbers.add(7);
                continue;
            }
            staticNumbers.add(1);
        }
    }

    @Override
    public int generateByRange(int start, int end) {
        int number = staticNumbers.get(nowIndex);
        nowIndex = (nowIndex + 1) % staticNumbers.size();
        return number;
    }
}
