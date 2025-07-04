package org.stringCalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(12,stringCalculator.add("8,1,3"));
        assertEquals(15,stringCalculator.add("5,6,2,2"));

    }

    //3. Allow the add method to handle new lines between numbers (instead of commas).
    // ("1\n2,3" should return 6)
    @Test
    void allow_newline_as_delimiter() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
        assertEquals(6, stringCalculator.add("1,2\n3"));
        assertEquals(6, stringCalculator.add("1\n2\n3"));

    }

    //4. Support different delimiters:
    //To change the delimiter, the beginning of the string will contain a separate line that looks like this: "//[delimiter]\n[numbers…]".
    // For example, "//;\n1;2" where the delimiter is ";" should return 3.
    @Test
    void allow_different_delimiters() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
        assertEquals(3, stringCalculator.add("//.\n1.2.0"));
        assertEquals(6, stringCalculator.add("//}\n1\n2}3"));
        assertEquals(5, stringCalculator.add("//$\n2$3"));
    }

    //5. Calling add with a negative number will throw an exception:
    // "negative numbers not allowed <negative_number>".
    @Test
    void throw_exception_on_negative_number() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("-1");
        });
        assertEquals("negative numbers not allowed: -1", exception.getMessage());
    }
}