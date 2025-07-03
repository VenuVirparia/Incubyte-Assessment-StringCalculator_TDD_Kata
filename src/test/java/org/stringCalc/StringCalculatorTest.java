package org.stringCalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void empty() {
    }
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
}