package racingcar.domain;

public class Car {

    private static final int MOVE_DISTANCE_PER_ORDER = 1;
    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public Car clone() {
        Car car = new Car(getName());
        car.position = getPosition();

        return car;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("[ERROR]: 이름이 null 인 경우는 허용하지 않습니다.");
        }

        if (name.length() == 0) {
            throw new IllegalArgumentException("[ERROR]: 길이가 0인 이름은 허용하지 않습니다.");
        }

        if (name.length() > CAR_NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("[ERROR]: 각 차량의 길이가 5를 초과하면 허용하지 않습니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveCar() {
        this.position += MOVE_DISTANCE_PER_ORDER;
    }
}
