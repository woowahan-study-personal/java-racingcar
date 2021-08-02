package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차_이름_길이_테스트")
    @Test
    void test1() {
        assertThatThrownBy(() -> new Car("SongSong"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진_테스트")
    @Test
    void test3() {
        Car car = new Car("Song");
        car.go();
        assertThat(car.getPosition()).isEqualTo(1);
        car.go();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
