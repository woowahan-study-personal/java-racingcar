package tdd.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tdd.Calculator;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    @DisplayName("빈_문자열_0_반환_테스트")
    @Test
    void test1() {
        int answer = Calculator.splitSum("");
        assertThat(answer).isEqualTo(0);
    }

    @DisplayName("null_0_반환_테스트")
    @Test
    void test2() {
        int answer = Calculator.splitSum(null);
        assertThat(answer).isEqualTo(0);
    }

    @DisplayName("숫자하나_반환_테스트")
    @Test
    void test3() {
        int answer = Calculator.splitSum("1");
        assertThat(answer).isEqualTo(1);
    }

    @DisplayName("콤마_합_반환_테스트")
    @Test
    void test4() {
        int answer = Calculator.splitSum("1,2");
        assertThat(answer).isEqualTo(3);
    }

    @DisplayName("콤마_콜론_합_반환_테스트")
    @Test
    void test5() {
        int answer = Calculator.splitSum("1,2:3");
        assertThat(answer).isEqualTo(6);
    }

    @DisplayName("커스텀_구분자_합_반환_테스트")
    @Test
    void test6() {
        int answer = Calculator.splitSum("//;\n1;2;3");
        assertThat(answer).isEqualTo(6);
    }

    @DisplayName("음수_exception_테스트")
    @Test
    void test7() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                int answer = Calculator.splitSum("-1,2,3");
            })
            .withMessage("음수는 안됩니다!!");
    }
}
