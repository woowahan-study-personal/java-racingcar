package racingcar.domain;

import java.util.Objects;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
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
}
