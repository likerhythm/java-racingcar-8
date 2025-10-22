package racingcar;

import java.util.List;
import java.util.OptionalInt;

public class OutputView {

    public String printIntermediateResult(List<List<MoveResult>> gameResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과\n");
        for (List<MoveResult> moveResults : gameResult) {
            for (MoveResult moveResult : moveResults) {
                sb.append(moveResult.carName()).append(" : ").append("-".repeat(moveResult.position())).append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        return sb.toString();
    }

    public String printWinners(List<MoveResult> gameResult) {
        OptionalInt optionalMaxPosition = gameResult.stream().mapToInt(MoveResult::position).max();
        String winnerOutput = "";
        if (optionalMaxPosition.isPresent()) {
            int maxPosition = optionalMaxPosition.getAsInt();
            String[] winnerNames = gameResult.stream()
                    .filter(gr -> gr.position() == maxPosition)
                    .map(MoveResult::carName)
                    .toArray(String[]::new);
            winnerOutput = String.join(", ", winnerNames);
        }
        String output = "최종 우승자 : " + winnerOutput;
        System.out.println(output);
        return output;
    }
}
