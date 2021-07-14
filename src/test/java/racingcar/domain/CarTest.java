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

//    @DisplayName("전진여부_테스트")
//    @Test
//    void test2() {
//        assertThat(new Car("Song").isGo(4)).isTrue();
//        assertThat(new Car("Song").isGo(2)).isFalse();
//    }

    @DisplayName("전진_테스트")
    @Test
    void test3() {
        Car car = new Car("Song");
        car.go(4);
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.getDashPosition()).isEqualTo("-");
        car.go(2);
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.getDashPosition()).isEqualTo("-");
    }
}
