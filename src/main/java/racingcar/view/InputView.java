package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

    public static int inputTrialNumbers() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }
}
