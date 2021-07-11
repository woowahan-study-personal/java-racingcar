package racingcar.dto;

import racingcar.domain.Car;

public class CarDTO {

    private String name;
    private int position;

    private CarDTO() {
    }

    public CarDTO(Car Car) {
        name = Car.getName();
        position = Car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
