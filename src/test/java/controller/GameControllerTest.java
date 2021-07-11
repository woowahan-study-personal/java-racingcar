package controller;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.dto.CarDTO;

public class GameControllerTest {

    private static final String[] testData = {"pobi", "crong", "honux"};

    @Test
    @DisplayName("1. 컨트롤러를 통한 현재의 차량 정보 요청")
    void getCarRepositoryInfoRequestTest() {
        GameController gameController = new GameController(testData);
        List<CarDTO> carInfoList = gameController.getCarListInfo();

        for (CarDTO carDTO : carInfoList) {
            assertThat(carDTO.getPosition()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("2. 컨트롤러를 통한 게임 결과 반환 요청")
    void gameResultRequestTest() {
        GameController gameController = new GameController(testData);
        List<String> gameResultInfo = gameController.getGameResultList();

        assertThat(gameResultInfo).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }
}
