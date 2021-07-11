package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class SystemController {

    public void play() {
        List<Car> carList = getCarArray(InputView.inputCarNames());
        try {
            int trials = InputView.inputTrialNumbers();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능");
        }
    }

    public List<Car> getCarArray(String carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName: splitCars(carNames)) {
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

    public List<String> getWinners(List<Car> carList, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (Objects.equals(car.getPosition(), maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
