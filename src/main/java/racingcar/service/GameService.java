package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.tool.GameRandomTool;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static int MINIMUM_REQUIREMENT_NUMBER_FOR_CAR_MOVE = 4;

    private CarRepository carRepository;
    private int longestDistanceInMatch = 0;

    private GameService() {}

    public GameService(String[] carNames) {
        carRepository = CarRepository.createGameByCarNameArray(carNames);
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    private int getLongestDistanceInMatch() {
        return this.longestDistanceInMatch;
    }

    private boolean isCarMoveAble(int number) {
        return number >= MINIMUM_REQUIREMENT_NUMBER_FOR_CAR_MOVE;
    }

    public void runCarByRandomNumber(Car car) {
        if (isCarMoveAble(GameRandomTool.makeGameRandomNumber())) {
            car.moveCar();
        }
    }

    public void runOneTurn() {
        for (Car car : carRepository.getCarList()) {
            runCarByRandomNumber(car);
        }
    }

    private void updateLongestDistance() {
        for (Car car : carRepository.getCarList()) {
            this.longestDistanceInMatch = Math
                .max(car.getPosition(), getLongestDistanceInMatch());
        }
    }

    private void applyResultInArray(List<String> result, Car car) {
        if (car.getPosition() == getLongestDistanceInMatch()) {
            result.add(car.getName());
        }
    }

    public List<String> makeWinnerResult() {
        List<String> result = new ArrayList<>();

        updateLongestDistance();

        for (Car car : carRepository.getCarList()) {
            applyResultInArray(result, car);
        }

        return result;
    }
}
