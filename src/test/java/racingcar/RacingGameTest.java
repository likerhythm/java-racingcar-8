package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class RacingGameTest extends NsTest {

    @Test
    void 레이싱_게임의_전체_흐름이_정상적으로_이루어집니다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("사용자1,사용자2,사용자3", "3");
                    printOutput();
                    assertThat(output()).contains(
                            "사용자1 : ", "사용자1 : -", "사용자1 : --",
                            "사용자2 : -", "사용자2 : --", "사용자2 : ---",
                            "사용자3 : -", "사용자3 : --", "사용자3 : ---");
                    assertThat(output()).contains("최종 우승자 : 사용자2, 사용자3");
                },
                3, 4
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[] {});
    }
}
