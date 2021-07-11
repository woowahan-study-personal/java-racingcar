package racingcar.controller;

import racingcar.view.InputView;

public class SystemController {

    public void play() {
        String carNames = InputView.inputCarNames();
        try {
            int trials = InputView.inputTrialNumbers();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능");
        }
    }
}
