package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameSystem;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private static final GameSystem system = new GameSystem();

    public void play() {
        Cars cars = new Cars(InputView.inputCarNames());
        try {
            int trials = InputView.inputTrialNumbers();
            OutputView.printExecutionMessage();
            playAllGames(cars, trials);
            OutputView.printWinners(cars.getWinners(cars.getMaxPosition()));
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능");
        }
    }

    private void playAllGames(Cars cars, int trials) {
        for (int i = 0; i < trials; i++) {
            playOneTurn(cars);
        }
    }

    private void playOneTurn(Cars cars) {
        for (Car car : cars.getCars()) {
            system.rollTheDice(car);
            OutputView.printPlayCarResult(car.getName(), car.getPosition());
        }
        OutputView.printNullLine();
    }
}
