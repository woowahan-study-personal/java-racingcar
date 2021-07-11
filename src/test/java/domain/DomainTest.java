package domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;

public class DomainTest {

    private static final String NULL_MESSAGE = "[ERROR]: 이름이 null 인 경우는 허용하지 않습니다.";
    private static final String BLANK_MESSAGE = "[ERROR]: 길이가 0인 이름은 허용하지 않습니다.";
    private static final String EXCEED_LENGTH_MESSAGE = "[ERROR]: 각 차량의 길이가 5를 초과하면 허용하지 않습니다.";

    private static final String[] testData = {"pobi", "crong", "honux"};
    private static final String[] testFailData = {"pobi", "stephen", "honux"};

    @Test
    @DisplayName("1. Car 도메인 생성 성공")
    void carCreateSuccessTest() {
        Car car = new Car("tony");
        assertThat(car.getClass()).isEqualTo(Car.class);
    }

    @Test
    @DisplayName("2. Car 도메인 생성 실패: null")
    void carCreateFailByNullTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Car car = new Car(null);
            }).withMessage(NULL_MESSAGE);
    }

    @Test
    @DisplayName("3. Car 도메인 생성 실패: 빈 문자열")
    void carCreateFailByZeroLengthTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Car car = new Car("");
            }).withMessage(BLANK_MESSAGE);
    }

    @Test
    @DisplayName("4. Car 도메인 생성 실패: 문자열 길이 초과")
    void carCreateFailByDataLengthTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Car car = new Car("stephen");
            }).withMessage(EXCEED_LENGTH_MESSAGE);
    }

    @Test
    @DisplayName("5. Car 도메인 getter 테스트")
    void carGetterTest() {
        Car car = new Car("tony");
        assertThat(car.getName()).isEqualTo("tony");
    }

    @Test
    @DisplayName("6. Car 도메인 이동 테스트")
    void carMoveTest() {
        Car car = new Car("tony");
        car.moveCar();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("7. CarRepository 도메인 생성 및 내용 추가 성공")
    void carRepositoryCreateSuccessTest() {
        assertThat(CarRepository.createGameByCarNameArray(testData).getClass())
            .isEqualTo(CarRepository.class);
    }

    @Test
    @DisplayName("8. CarRepository 도메인 내용 추가 실패")
    void carRepositoryCreateFailTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                CarRepository carRepository = CarRepository.createGameByCarNameArray(testFailData);
            }).withMessage(EXCEED_LENGTH_MESSAGE);
    }

    @Test
    @DisplayName("9. CarRepository 도메인 getCarList")
    void carRepositoryGetCarListTest() {
        assertThat(CarRepository.createGameByCarNameArray(testData).getCarList().getClass())
            .isEqualTo(ArrayList.class);
    }
}
