package racingcar.view;

import java.util.List;
import racingcar.controller.GameController;

public class GameView {

    private GameController gameController;

    private GameView() {
    }

    public GameView(String[] carNameArray) {
        gameController = new GameController(carNameArray);
    }

    public void runTurnRequest() {
        gameController.runTurn();
        OutputView.printCurrentGameTurnStatus(gameController.getCarListInfo());
    }

    public List<String> gameResultRequest() {
        return gameController.getGameResultList();
    }

}
