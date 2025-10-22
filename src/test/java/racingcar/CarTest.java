package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    Driver driver = new Driver(new DefaultRandomIntegerGenerator());

    @Test
    void 자동차_이름은_5글자_이하만_가능합니다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("여섯글자이름", driver));
    }

    @ParameterizedTest
    @ValueSource(strings = {" 공백시작", "공백끝 ", " 시작끝 "})
    void 자동차_이름은_공백으로_시작하거나_끝날_수_없습니다(String value) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(value, driver));
    }

    @Test
    void 자동차는_후진할_수_없습니다() {
        Assertions.assertTrue(() -> {
            Car car = new Car("이름", driver);
            MoveResult moveResult = car.move();
            return moveResult.position() >= 0;
        });
    }
}
