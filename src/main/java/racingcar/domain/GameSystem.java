package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.utils.RandomUtils;

public class GameSystem {

    private static final int START_RANDOM_NUM = 0;
    private static final int END_RANDOM_NUM = 10;

    public void rollTheDice(Car car) {
        int diceNumbers = RandomUtils.nextInt(START_RANDOM_NUM, END_RANDOM_NUM);
        car.go(diceNumbers);
    }

    public List<Car> getCarArray(String carNames) {
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

    public String[] splitCars(String carNames) {
        return carNames.split(",");
    }

    public int getMaxPosition(List<Car> cars) {
        int maxPosition = -1;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public String getWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            makeWinnerCandidates(maxPosition, winners, car);
        }
        return String.join(", ", winners);
    }

    private void makeWinnerCandidates(int maxPosition, List<String> winners, Car car) {
        if (Objects.equals(car.getPosition(), maxPosition)) {
            winners.add(car.getName());
        }
    }
}
