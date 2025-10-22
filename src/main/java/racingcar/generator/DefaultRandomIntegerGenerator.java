package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomIntegerGenerator implements RandomIntegerGenerator {

    @Override
    public int generateByRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
