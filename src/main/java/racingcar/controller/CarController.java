package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameSystem;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private static final GameSystem system = new GameSystem();

    public void play() {
        List<Car> cars = system.getCarArray(InputView.inputCarNames());
        try {
            int trials = InputView.inputTrialNumbers();
            OutputView.printExecutionMessage();
            playAllGames(cars, trials);
            OutputView.printWinners(system.getWinners(cars, system.getMaxPosition(cars)));
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능");
        }
    }

    private void playAllGames(List<Car> cars, int trials) {
        for (int i = 0; i < trials; i++) {
            playOneTurn(cars);
        }
    }

    private void playOneTurn(List<Car> cars) {
        for (Car car : cars) {
            system.rollTheDice(car);
            OutputView.printPlayCarResult(car.getName(), car.getPosition());
        }
        OutputView.printNullLine();
    }

}
