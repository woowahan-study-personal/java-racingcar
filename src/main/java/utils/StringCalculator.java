package utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private StringCalculator() {
    }

    private static boolean textEmptyValidate(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private static String addPattern(String text) {
        String basePattern = ",|:";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            basePattern = basePattern + "|" + m.group(1);
        }

        return basePattern;
    }

    public static int splitAndSum(String text) {
        if (textEmptyValidate(text))
            return 0;

        int[] numberList = Arrays.asList(text.split(addPattern(text)))
            .stream().filter((String str) -> str.matches("-?\\d+")).mapToInt(Integer::parseInt).toArray();

        if (Arrays.stream(numberList).filter(i -> i < 0).count() > 0)
            throw new RuntimeException("음수 값은 허용하지 않습니다.");

        return Arrays.stream(numberList).sum();
    }
}
// .gradle, .idea, build