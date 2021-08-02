package racingcar.domain;

import racingcar.utils.RandomUtils;

public class GameSystem {

    private static final int START_RANDOM_NUM = 0;
    private static final int END_RANDOM_NUM = 10;
    private static final int GO_NUMBER = 4;

    public void rollTheDice(Car car) {
        int diceNumbers = RandomUtils.nextInt(START_RANDOM_NUM, END_RANDOM_NUM);
        if (isGo(diceNumbers)) {
            car.go();
        }
    }

    private Boolean isGo(int randomNumber) {
        return randomNumber >= GO_NUMBER;
    }
}