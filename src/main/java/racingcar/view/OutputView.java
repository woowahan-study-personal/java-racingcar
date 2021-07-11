package racingcar.view;

import java.util.Collections;
import java.util.List;
import racingcar.dto.CarDTO;

public class OutputView {

    private OutputView() {
    }

    private static void printCarStatus(CarDTO car) {
        System.out.println(car.getName() + " : " + String.join("", Collections
            .nCopies(car.getPosition(), "-")));
    }

    public static void printCurrentGameTurnStatus(List<CarDTO> carDTOList) {
        for (CarDTO car : carDTOList) {
            printCarStatus(car);
        }

        printEmptyNextLine();
    }

    public static void printMatchWinner(List<String> winnerList) {
        System.out.println("최종 우승자: " + String.join(", ", winnerList));
    }

    public static void printExecutionResultUIMessage() {
        System.out.println("실행 결과");
    }

    public static void printEmptyNextLine() {
        System.out.println();
    }
}
