package racingcar.tool;

import static utils.RandomUtils.nextInt;

public class GameRandomTool {

    private static int minimumNumberRange = 0;
    private static int maximumNumberRange = 9;

    private GameRandomTool() {
    }

    public static int makeGameRandomNumber() {
        return nextInt(minimumNumberRange, maximumNumberRange);
    }
}
