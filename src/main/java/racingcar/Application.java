package racingcar;

import java.util.Scanner;
import racingcar.controller.SystemController;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SystemController systemController = new SystemController();
        systemController.play();
    }
}
