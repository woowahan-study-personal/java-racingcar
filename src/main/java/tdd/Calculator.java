package tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int splitSum(String text) {
        int result = 0;
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] splitArray = split(text);
        for (String number : splitArray) {
            checkNegative(number);
            result += Integer.parseInt(number);
        }
        return result;
    }

    private static void checkNegative(String number) {
        int parseNum = Integer.parseInt(number);
        if (parseNum < 0) {
            throw new RuntimeException("음수는 안됩니다!!");
        }
    }

    private static String[] split(String text) {
        String[] texts;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }
}
