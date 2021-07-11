package racingcar.view;

import java.util.Collections;
import racingcar.domain.Car;
import racingcar.service.GameService;

public class OutputView {

    private OutputView() {
    }

    private static void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + String.join("", Collections
            .nCopies(car.getPosition(), "-")));
    }

    public static void printCurrentGameTurnStatus(GameService game) {
        // for (Car car : game.getCarList()) {
        //    printCarStatus(car);
        // }

        printEmptyNextLine();
    }

    public static void printMatchWinner(GameService game) {
        System.out.println("최종 우승자: " + String.join(", ", game.makeWinnerResult()));
    }

    public static void printExecutionResultUIMessage() {
        System.out.println("실행 결과");
    }

    public static void printEmptyNextLine() { System.out.println(); }
}
