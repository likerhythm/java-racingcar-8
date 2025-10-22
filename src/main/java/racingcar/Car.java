package racingcar;

public class Car {

    private String name;
    private int moveCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다");
        }
        if (name.startsWith(" ") || name.endsWith(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백으로 시작하거나 끝날 수 없습니다.");
        }
    }

    public void move(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("자동차는 후진할 수 없습니다.");
        }
        this.moveCount += value;
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }
}
