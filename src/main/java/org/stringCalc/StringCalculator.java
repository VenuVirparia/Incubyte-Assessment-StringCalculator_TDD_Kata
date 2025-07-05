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

    private String getCustomDelimiterIfExists(String numbers){
        if(numbers.startsWith("//["))
            return numbers.substring(numbers.indexOf("[")+1,numbers.indexOf("]"));
        else if(numbers.startsWith("//"))
            return numbers.charAt(2)+"";
        return null;
    }

    String extractNumberSection(String numbers)
    {
        return numbers.substring(numbers.indexOf("\n")+1);
    }

    String buildRegex(String delimiter){
        return "[,\n]" + "|" + Pattern.quote(delimiter);
    }

    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty())
            return 0;

        String delimiter = getCustomDelimiterIfExists(numbers);
        if (delimiter != null && !delimiter.isEmpty()){
            numbers = extractNumberSection(numbers);
            String regex = buildRegex(delimiter);
            return sumNumbers(numbers.split(regex));
        }

        return sumNumbers(numbers.split("[,\\n]"));
    }
}