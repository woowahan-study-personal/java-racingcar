package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
