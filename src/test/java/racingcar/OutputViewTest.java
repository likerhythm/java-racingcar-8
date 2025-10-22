package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dto.MoveResult;
import racingcar.view.OutputView;

public class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void 스테이지가_진행되지_않으면_우승자를_출력하지_않습니다() {
        List<MoveResult> emptyGameResult = new ArrayList<>();
        Assertions.assertEquals("최종 우승자 : ", outputView.printWinners(emptyGameResult));
    }

    @Test
    void 우승자를_정상적으로_출력합니다() {
        List<MoveResult> gameResult = new ArrayList<>();
        gameResult.add(new MoveResult("우승자1", 10));
        gameResult.add(new MoveResult("우승자2", 10));
        gameResult.add(new MoveResult("우승자3", 10));

        Assertions.assertEquals("최종 우승자 : 우승자1, 우승자2, 우승자3", outputView.printWinners(gameResult));
    }

    @Test
    void 중간_결과를_정상적으로_출력합니다() {
        List<MoveResult> gameResult1 = new ArrayList<>();
        gameResult1.add(new MoveResult("사용자1", 0));
        gameResult1.add(new MoveResult("사용자2", 2));
        gameResult1.add(new MoveResult("사용자3", 3));

        List<MoveResult> gameResult2 = new ArrayList<>();
        gameResult2.add(new MoveResult("사용자1", 1));
        gameResult2.add(new MoveResult("사용자2", 2));
        gameResult2.add(new MoveResult("사용자3", 4));

        Assertions.assertEquals("""
                \n실행 결과
                사용자1 : \n사용자2 : --
                사용자3 : ---
                
                사용자1 : -
                사용자2 : --
                사용자3 : ----
                """, outputView.printIntermediateResult(List.of(gameResult1, gameResult2)));
    }
}
