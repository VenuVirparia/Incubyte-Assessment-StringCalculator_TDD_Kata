package org.stringCalc;

import java.util.regex.Pattern;

public class StringCalculator {

    private int sumNumbers(String[] numberArray) throws IllegalArgumentException {
        int sum = 0;
        for (String number : numberArray) {
            int currentNumber = Integer.parseInt(number);
            if (currentNumber < 0) throw new IllegalArgumentException("negative numbers not allowed: "+currentNumber);
            sum += currentNumber;
        }
        return sum;
    }

    private Character getCustomDelimiterIfExists(String numbers){
        if(numbers.startsWith("//"))
            return numbers.charAt(2);
        return null;
    }

    String extractNumberSection(String numbers)
    {
        return numbers.substring(numbers.indexOf("\n")+1);
    }

    String buildRegex(Character delimiter){
        return "[,\n]" + "|" + Pattern.quote(String.valueOf(delimiter));
    }

    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty())
            return 0;

        Character delimiter = getCustomDelimiterIfExists(numbers);
        if(delimiter != null){
            numbers = extractNumberSection(numbers);
            String regex = buildRegex(delimiter);
            return sumNumbers(numbers.split(regex));
        }

        return sumNumbers(numbers.split("[,\\n]"));
    }
}