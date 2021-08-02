package tdd;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final int ZERO = 0;
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitSum(String text) {
        int result = 0;
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }
        String[] splitArray = split(text);
        for (String number : splitArray) {
            int parseNum = Integer.parseInt(number);
            checkNegative(parseNum);
            result += parseNum;
        }
        return result;
    }

    private static void checkNegative(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException("음수는 안됩니다!!");
        }
    }

    private static String[] split(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }
}
