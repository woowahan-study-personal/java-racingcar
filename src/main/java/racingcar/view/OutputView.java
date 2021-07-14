package racingcar.view;

public class OutputView {

    public static final String POSITION_MARK = "-";

    private OutputView() {
    }

    public static void printExecutionMessage() {
        System.out.println("실행 결과");
    }

    public static void printPlayCarResult(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_MARK);
        }
        System.out.println();
    }

    public static void printNullLine() {
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자: " + winners);
    }
}
