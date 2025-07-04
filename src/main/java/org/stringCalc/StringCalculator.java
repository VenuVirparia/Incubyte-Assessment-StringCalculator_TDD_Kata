package org.stringCalc;

import java.util.regex.Pattern;

public class StringCalculator {

    private int sumNumbers(String[] numberArray) {
        int sum = 0;
        for (String number : numberArray) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private Character checkDelimiter(String numbers){
        if(numbers.startsWith("//"))
            return numbers.charAt(2);
        return null;
    }

    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty())
            return 0;

        Character delimiter = checkDelimiter(numbers);
        if(delimiter != null){
            numbers = numbers.substring(numbers.indexOf("\n")+1);
            return sumNumbers(numbers.split("[,\n]" + "|" + Pattern.quote(delimiter+""))
            );
        }

        if(numbers.contains(",") || numbers.contains("\n"))
            return sumNumbers(numbers.split("[,\\n]"));

        return Integer.parseInt(numbers);
    }
}