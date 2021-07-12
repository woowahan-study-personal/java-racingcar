package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.domain.Car;
import racingcar.domain.GameSystem;
import racingcar.utils.RandomUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class SystemController {

    public void play() {
        GameSystem system = new GameSystem();
        List<Car> carList = system.getCarArray(InputView.inputCarNames());
        try {
            int trials = InputView.inputTrialNumbers();
            OutputView.printExecutionMessage();
            for (int i = 0; i < trials; i++) {
                playOneTurn(carList);
            }
            OutputView.printWinners(system.getWinners(carList, system.getMaxPosition(carList)));

        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능");
        }
    }

    private void playOneTurn(List<Car> carList) {
        GameSystem system = new GameSystem();
        for (Car car : carList) {
            system.rollTheDice(car);
            OutputView.printPlayCarResult(car.getName(), car.getDashPosition());
        }
        OutputView.printNullLine();
    }

}
