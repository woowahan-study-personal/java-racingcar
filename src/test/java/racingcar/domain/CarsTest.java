package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarsTest {

    @DisplayName("자동차_객체_리스트_생성_확인")
    @ParameterizedTest
    @ValueSource(strings = {"Song", "Kim", "Park"})
    void test2(String input) {
        List<Car> cars = new Cars("Song,Kim,Park").getCars();
        assertThat(cars).contains(new Car(input));
        assertThatThrownBy(() -> {
            List<Car> cars2 = new Cars(",,,").getCars();
        })
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최대_포지션_값_구하기")
    @Test
    void test3() {
        Cars cars = new Cars("Song,Kim,Park");
        for (int i = 0; i < 5; i++) {
            cars.getCars().get(0).go();
        }
        for (int i = 0; i < 3; i++) {
            cars.getCars().get(1).go();
        }
        int maxPosition = cars.getMaxPosition();
        assertThat(maxPosition).isEqualTo(5);
    }

    @DisplayName("우승자 결정")
    @ParameterizedTest
    @ValueSource(strings = {"Song", "Kim"})
    void test4(String input) {
        Cars cars = new Cars("Song,Kim,Park");
        for (int i = 0; i < 3; i++) {
            cars.getCars().get(0).go();
        }
        for (int i = 0; i < 3; i++) {
            cars.getCars().get(1).go();
        }
        String winners = cars.getWinners(cars.getMaxPosition());
        assertThat(winners).contains(input);
    }
}
