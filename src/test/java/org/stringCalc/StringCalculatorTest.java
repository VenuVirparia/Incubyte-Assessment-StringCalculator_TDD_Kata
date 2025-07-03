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

}