package racingcar.service;

import java.util.Collections;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.tool.GameRandomTool;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static int minimumRequirementNumberForCarMove = 4;

    private CarRepository carRepository;
    private int longestDistanceInMatch = 0;

    private GameService() {}

    public GameService(String[] carNames) {
        carRepository = CarRepository.createGameByCarNameArray(carNames);
    }

    private int getLongestDistanceInMatch() {
        return this.longestDistanceInMatch;
    }

    private boolean isCarMoveAble(int number) {
        return number >= minimumRequirementNumberForCarMove;
    }

    public void updateLongestDistance() {
        for (Car car : carRepository.getCarList()) {
            this.longestDistanceInMatch = Math
                .max(car.getPosition(), getLongestDistanceInMatch());
        }
    }

    public void runOneTurn() {
        for (Car car : carRepository.getCarList()) {
            if (isCarMoveAble(GameRandomTool.makeGameRandomNumber())) {
                car.moveCar();
            }
        }
    }

    public List<String> makeWinnerResult() {
        List<String> result = new ArrayList<>();

        for (Car car : carRepository.getCarList()) {
            if (car.getPosition() == getLongestDistanceInMatch()) {
                result.add(car.getName());
            }
        }

        return result;
    }
}
