package dto;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.dto.CarDTO;
import racingcar.dto.CarRepositoryDTO;

public class DtoTest {

    private static final String[] testData = {"pobi", "crong", "honux"};

    @Test
    @DisplayName("1. 차량 객체에 대한 DTO 테스트")
    void carDtoTest() {
        CarDTO carDTO = new CarDTO(new Car("pobi"));

        assertThat(carDTO.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("2. 차량 목록에 대한 DTO 테스트")
    void carRepositoryDtoTest() {
        List<CarDTO> carList = CarRepositoryDTO
            .getCarDTOList(CarRepository.createGameByCarNameArray(testData));

        assertThat(carList.getClass()).isEqualTo(ArrayList.class);
    }
}
