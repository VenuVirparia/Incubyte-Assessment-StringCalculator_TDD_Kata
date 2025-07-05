package org.stringCalc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private int sumNumbers(String[] numberArray) throws IllegalArgumentException {
        int sum = 0;
        List<String> negativeNumbers = new ArrayList<>();

        for (String number : numberArray) {
            int currentNumber = Integer.parseInt(number);

            if (currentNumber < 0)
                negativeNumbers.add(currentNumber+"");

            if (currentNumber > 1000) continue;

            sum += currentNumber;
        }
        if (!negativeNumbers.isEmpty())
            throw new IllegalArgumentException("negative numbers not allowed: " + String.join(",",negativeNumbers));
        return sum;
    }

    private List<String> getCustomDelimitersIfExists(String numbers) {
        List<String> delimiters = new ArrayList<>();

        if (numbers.startsWith("//[")) {
            String delimiterSection = numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n"));

            while (delimiterSection.contains("[")) {
                int open = delimiterSection.indexOf("[") + 1;
                int close = delimiterSection.indexOf("]");
                delimiters.add(delimiterSection.substring(open, close));
                delimiterSection = delimiterSection.substring(close + 1);
            }
        } else if (numbers.startsWith("//")) {
            delimiters.add(numbers.charAt(2) + "");
        }

        return delimiters;
    }

    String extractNumberSection(String numbers)
    {
        return numbers.substring(numbers.indexOf("\n")+1);
    }

    String buildRegex(List<String> delimiters) {
        delimiters.add(",");
        delimiters.add("\n");

        List<String> quoted = new ArrayList<>();
        for (String d : delimiters) {
            quoted.add(Pattern.quote(d));
        }

        return String.join("|", quoted);
    }

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty())
            return 0;

        List<String> delimiters = getCustomDelimitersIfExists(numbers);

        if (!delimiters.isEmpty()) {
            numbers = extractNumberSection(numbers);
            String regex = buildRegex(delimiters);
            return sumNumbers(numbers.split(regex));
        }

        return sumNumbers(numbers.split("[,\\n]"));
    }
}