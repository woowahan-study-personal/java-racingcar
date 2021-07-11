package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarControllerTest {

    @DisplayName("자동차이름_콤마_split_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"Song", "Kim", "Park"})
    void test1(String input) {
        CarController carController = new CarController();
        String[] splitCarNames = carController.splitCars("Song,Kim,Park");
        assertThat(splitCarNames).contains(input);
    }
}
