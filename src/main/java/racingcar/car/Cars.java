package racingcar.car;

import java.util.List;
import racingcar.dto.MoveResult;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarNames(cars);
        this.cars = cars;
    }

    public List<MoveResult> move() {
        return cars.stream().map(Car::move).toList();
    }

    private void validateCarNames(List<Car> cars) {
        long distinctNameCount = cars.stream().map(Car::getName).distinct().count();
        if (distinctNameCount != cars.size()) throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다");
    }
}
