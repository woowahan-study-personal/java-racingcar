package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = makeCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> makeCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] splitCars = splitCars(carNames);
        validateSplitNames(splitCars);
        for (String carName : splitCars) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void validateSplitNames(String[] splitCars) {
        if (Objects.equals(splitCars.length, 0)) {
            throw new IllegalArgumentException("[ERROR] 자동차를 제대로 입력해주세요");
        }
    }

    private String[] splitCars(String carNames) {
        return carNames.split(",");
    }

    public int getMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public String getWinners(int maxPosition) {
        return cars.stream()
            .filter(elm -> Objects.equals(elm.getPosition(), maxPosition))
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }
}