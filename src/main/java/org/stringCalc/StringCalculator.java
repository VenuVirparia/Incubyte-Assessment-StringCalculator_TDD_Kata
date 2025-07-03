package org.stringCalc;

public class StringCalculator {

    private int sumNumbers(String[] numberArray) {
        int sum = 0;
        for (String number : numberArray) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty())
            return 0;

        if(numbers.contains(",") || numbers.contains("\n"))
            return sumNumbers(numbers.split("[,\\n]"));

        return Integer.parseInt(numbers);
    }
}