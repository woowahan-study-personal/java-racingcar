package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String DASH_POSITION = "-";
    public static final int GO_NUMBER = 4;
    private final String name;

    private int position = 0;
    private final StringBuilder dashPosition = new StringBuilder();

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getDashPosition() {
        return dashPosition.toString();
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 null값일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름은 5글자 이내여야합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름은 빈글자가 아니여야합니다.");
        }
    }

    public void go(int randomNumber) {
        if (isGo(randomNumber)) {
            this.position++;
            dashPosition.append(DASH_POSITION);
        }
    }

    public Boolean isGo(int randomNumber) {
        return randomNumber >= GO_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects
            .equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
