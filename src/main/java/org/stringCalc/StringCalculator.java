package org.stringCalc;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty())
            return 0;
        else if(numbers.contains(","))
        {
            String[] numberArray = numbers.split(",");
            return Integer.parseInt(numberArray[0]) + Integer.parseInt(numberArray[1]);
        }
        else
            return Integer.parseInt(numbers);
    }
}