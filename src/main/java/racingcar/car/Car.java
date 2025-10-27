package racingcar.car;

import racingcar.Driver;
import racingcar.dto.MoveResult;

public class Car {

    private String name;
    private int position;
    private Driver driver;

    public Car(String name, Driver driver) {
        validateName(name);
        this.name = name;
        this.position = 0;
        this.driver = driver;
    }

    private void validateName(String name) {
        if (name.isEmpty()) throw new IllegalArgumentException("자동차 이름은 한 글자 이상으로 입력해주세요");
        if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다");
        if (name.startsWith(" ") || name.endsWith(" ")) throw new IllegalArgumentException("자동차 이름은 공백으로 시작하거나 끝날 수 없습니다");
    }

    public MoveResult move() {
        this.position += driver.run();
        return new MoveResult(this.name, this.position);
    }

    public String getName() {
        return this.name;
    }
}
