package org.stringCalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void empty() {
    }

    //1. Create a simple String calculator with a method signature like this:
    //int add(string numbers)
    @Test
    void return_0_on_empty_string() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void return_number_on_single_number_string() {
        assertEquals(4, stringCalculator.add("4"));
    }

    @Test
    void return_sum_on_two_numbers_string() {
        assertEquals(16, stringCalculator.add("14,2"));
    }

    //2. Allow the add method to handle any amount of numbers
    @Test
    void return_sum_of_all_numbers_in_string() {
        assertEquals(12,stringCalculator("8,1,3"));
        assertEquals(15,stringCalculator("5,6,2,2"));

    }
}