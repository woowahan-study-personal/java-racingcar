package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.utils.RandomUtils;

public class GameSystem {
    private static final int START_RANDOM_NUM = 0;
    private static final int END_RANDOM_NUM = 10;
    private static final int GO_MEASURE = 4;

    public void rollTheDice(Car car) {
        int diceNumbers = RandomUtils.nextInt(START_RANDOM_NUM, END_RANDOM_NUM);
        if (diceNumbers >= GO_MEASURE) {
            car.go(diceNumbers);
        }
    }

    public List<Car> getCarArray(String carNames) {
        List<Car> carList = new ArrayList<>();
        String[] splitCars = new GameSystem().splitCars(carNames);
        if (Objects.equals(splitCars.length, 0)) {
            throw new IllegalArgumentException("[ERROR] 자동차를 제대로 입력해주세요");
        }
        for (String carName: splitCars) {
            System.out.println(carName);
            carList.add(new Car(carName));
        }
        return carList;
    }

    public String[] splitCars(String carNames) {
        return carNames.split(",");
    }

    public int getMaxPosition(List<Car> carList) {
        int maxPosition = -1;
        for (Car car: carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public String getWinners(List<Car> carList, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (Objects.equals(car.getPosition(), maxPosition)) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }
}
