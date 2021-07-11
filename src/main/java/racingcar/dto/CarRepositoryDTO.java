package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;

public class CarRepositoryDTO {

    private CarRepositoryDTO() {
    }

    public static List<CarDTO> getCarDTOList(CarRepository carRepository) {
        List<CarDTO> carDTOList = new ArrayList<>();

        for (Car car : carRepository.getCarList()) {
            carDTOList.add(new CarDTO(car));
        }

        return carDTOList;
    }
}
