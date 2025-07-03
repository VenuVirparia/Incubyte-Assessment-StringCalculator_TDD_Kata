package org.stringCalc;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty())
            return 0;
        else
            return Integer.parseInt(numbers);
    }
}