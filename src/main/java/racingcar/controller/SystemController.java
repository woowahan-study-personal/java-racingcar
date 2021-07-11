package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
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
        List<Car> carList = new ArrayList();
        for (String carName: splitCars(carNames)) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public String[] splitCars(String carNames) {
        return carNames.split(",");
    }

}
