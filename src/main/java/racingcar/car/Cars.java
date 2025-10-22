package racingcar.car;

import java.util.List;
import racingcar.dto.MoveResult;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<MoveResult> move() {
        return cars.stream().map(Car::move).toList();
    }
}
