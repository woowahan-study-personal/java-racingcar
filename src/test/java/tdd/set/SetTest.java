package tdd.set;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set_Size_테스트")
    @Test
    void test1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("set_값_확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test2(int input) {
        assertThat(numbers).contains(input);
    }

    @DisplayName("set_값_유무확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void test3(int input, boolean answer) {
        assertThat(numbers.contains(input)).isEqualTo(answer);
    }

}
