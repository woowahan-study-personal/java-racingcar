package racingcar;

import racingcar.controller.CarController;

public class Application {

    public static void main(String[] args) {
        CarController systemController = new CarController();
        systemController.play();
    }
}
