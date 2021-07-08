package tdd.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @DisplayName("1,2_split_테스트")
    @Test
    void test1() {
        assertThat("1,2".split(",")).contains("1","2");
    }

    @DisplayName("1_split_테스트")
    @Test
    void test2() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @DisplayName("괄호제거_split_테스트")
    @Test
    void test3() {
        assertThat("(1,2)".replaceAll("[()]", "")).isEqualTo("1,2");
    }

    @DisplayName("String_문자_특정위치문자반환_테스트")
    @Test
    void test4() {
        assertThat("abc".charAt(2)).isEqualTo('c');
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                "abc".charAt(3);
            })
            .withMessage("String index out of range: 3");
    }
}
