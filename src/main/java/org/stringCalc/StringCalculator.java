package org.stringCalc;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers == null || numbers.isEmpty())
            return 0;
        else if(numbers.contains(","))
        {
            String[] numberArray = numbers.split(",");
            int sum = 0;
            for(String number : numberArray){
                sum += Integer.parseInt(number);
            }
        return sum;
        }
        else
            return Integer.parseInt(numbers);
    }
}