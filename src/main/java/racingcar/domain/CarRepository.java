package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {

    private List<Car> carList;

    private void validateCarNamesArray(List<Car> carList) {
        if (carList.size() == 0) {
            throw new IllegalArgumentException("[ERROR]: 비어있는 경주 자동차 목록은 허용하지 않습니다.");
        }
    }

    private CarRepository(List<Car> carList) {
        validateCarNamesArray(carList);
        this.carList = carList;
    }

    public static CarRepository createGameByCarNameArray(String[] carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return new CarRepository(carList);
    }

    public List<Car> getCarList() {
        return carList;
    }

}
