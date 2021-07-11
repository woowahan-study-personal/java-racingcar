package racingcar;

import java.util.Scanner;
import racingcar.view.GameView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static void runGame(String[] carNameArray, int turnCount) {
        GameView gameView = new GameView(carNameArray);

        while (turnCount != 0) {
            turnCount--;
            gameView.runTurnRequest();
        }

        OutputView.printMatchWinner(gameView.gameResultRequest());
    }

    private static void runGameRequest(Scanner sc) {
        String[] carNameArray = InputView.inputCarList(sc);
        int turnCount = InputView.inputTurn(sc);

        OutputView.printExecutionResultUIMessage();
        OutputView.printEmptyNextLine();

        runGame(carNameArray, turnCount);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        runGameRequest(scanner);
    }
}
