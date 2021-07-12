package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.GameSystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class GameSystemTest {

    @DisplayName("자동차이름_콤마_split_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"Song", "Kim", "Park"})
    void test1(String input) {
        GameSystem system = new GameSystem();
        String[] splitCarNames = system.splitCars("Song,Kim,Park");
        assertThat(splitCarNames).contains(input);
    }

    @DisplayName("자동차_객체_리스트_생성_확인")
    @ParameterizedTest
    @ValueSource(strings = {"Song", "Kim", "Park"})
    void test2(String input) {
        GameSystem system = new GameSystem();
        List<Car> carList = system.getCarArray("Song,Kim,Park");
        assertThat(carList).contains(new Car(input));
        assertThatThrownBy(() -> {
            List<Car> carList2 = system.getCarArray(",,,");
        })
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최대_포지션_값_구하기")
    @Test
    void test3() {
        GameSystem system = new GameSystem();
        List<Car> carList = system.getCarArray("Song,Kim,Park");
        for (int i = 0; i < 5; i++) {
            carList.get(0).go(5);
        }
        for (int i = 0; i < 3; i++) {
            carList.get(1).go(5);
        }
        int maxPosition = system.getMaxPosition(carList);
        assertThat(maxPosition).isEqualTo(5);
    }

    @DisplayName("우승자 결정")
    @ParameterizedTest
    @ValueSource(strings = {"Song", "Kim"})
    void test4(String input) {
        GameSystem system = new GameSystem();
        List<Car> carList = system.getCarArray("Song,Kim,Park");
        for (int i = 0; i < 3; i++) {
            carList.get(0).go(5);
        }
        for (int i = 0; i < 3; i++) {
            carList.get(1).go(5);
        }
        String winners = system.getWinners(carList, system.getMaxPosition(carList));
        assertThat(winners).contains(input);
    }
}
