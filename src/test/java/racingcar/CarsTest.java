package racingcar;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.number_generator.DefaultRandomIntegerGenerator;

public class CarsTest {

    @Test
    void 자동차_이름은_중복될_수_없습니다() {
        Driver driver = new Driver(new DefaultRandomIntegerGenerator());
        List<Car> cars = List.of(new Car("car1", driver), new Car("car1", driver), new Car("car2", driver));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }
}
