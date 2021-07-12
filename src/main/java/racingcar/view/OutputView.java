package racingcar.view;

public class OutputView {

    public static void printExecutionMessage() {
        System.out.println("실행 결과");
    }

    public static void printPlayCarResult(String carName, String positionDash) {
        System.out.println(carName + " : " + positionDash);
    }

    public static void printNullLine() {
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자: " + winners);
    }
}
