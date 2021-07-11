package racingcar.controller;

import java.util.List;
import racingcar.dto.CarDTO;
import racingcar.dto.CarRepositoryDTO;
import racingcar.service.GameService;

public class GameController {

    GameService gameService;

    private GameController() {
    }

    public GameController(String[] carNameArray) {
        this.gameService = new GameService(carNameArray);
    }

    public void runTurn() {
        gameService.runOneTurn();
    }

    public List<CarDTO> getCarListInfo() {
        return CarRepositoryDTO.getCarDTOList(gameService.getCarRepository());
    }

    public List<String> getGameResultList() {
        return gameService.makeWinnerResult();
    }
}
