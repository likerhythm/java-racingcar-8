package racingcar;

public class Car {

    private String name;
    private int moveCount;
    private Driver driver;

    public Car(String name, Driver driver) {
        validateName(name);
        this.name = name;
        this.moveCount = 0;
        this.driver = driver;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다");
        }
        if (name.startsWith(" ") || name.endsWith(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백으로 시작하거나 끝날 수 없습니다.");
        }
    }

    public MoveResult move() {
        this.moveCount += driver.run();
        return new MoveResult(this.name, this.moveCount);
    }
}
