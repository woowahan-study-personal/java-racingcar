package junit.string;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringClassTest {

    @Test
    @DisplayName("1. '1,2'를 ,로 split 할 때 1과 2로 분리 ")
    void test1() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @Test
    @DisplayName("2. '1'을 ,로 split 할 때 1만 포함되는 배열로 분리 ")
    void test2() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("3. (1,2)가 주어질 때, ()를 제거하고 '1,2'를 반환")
    void test3() {
        assertThat("(1,2)".replaceAll("[()]", "")).isEqualTo("1,2");
    }


    @Test
    @DisplayName("4. 'abc' 가 주어질 때, String의 ??? 메소드를 활용해 특정 위치의 문자를 가져오고 예외처리를 구현")
    void test4() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                "abc".charAt(4);
            }).withMessageMatching("String index out of range: 4");
    }
}
