# Incubyte-Assessment-StringCalculator_TDD_Kata

This project implements a **String Calculator** that follows the **Test-Driven Development (TDD)** approach. TDD is a software development process in which tests are written before the actual code. In this project, I started with simple tests and gradually added complexity with each new test case, following the **Red-Green-Refactor** cycle.

### Key Features:

* **Red**: Start by writing a test case, which initially fails.
* **Green**: Implement just enough code to make the test pass.
* **Refactor**: Clean up the code while ensuring that the tests continue to pass.
  
---

### Test Features:

1. **Empty String**: Returns 0 for an empty string.

   * `assertEquals(0, stringCalculator.add(""))`

2. **Single Number**: Returns the number as the result.

   * `assertEquals(4, stringCalculator.add("4"))`

3. **Sum of Multiple Numbers**: Handles addition of multiple numbers.

   * `assertEquals(16, stringCalculator.add("14,2"))`

4. **Newline as Delimiter**: Handles numbers separated by newlines.

   * `assertEquals(6, stringCalculator.add("1\n2,3"))`

5. **Custom Delimiters**: Supports user-defined delimiters.

   * `assertEquals(3, stringCalculator.add("//;\n1;2"))`

6. **Negative Numbers**: Throws an exception for negative numbers.

   * `assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("-1"))`

7. **Ignoring Numbers Greater Than 1000**: Ignores numbers greater than 1000.

   * `assertEquals(5, stringCalculator.add("1001,2,3"))`

8. **Variable Length Delimiters**: Handles delimiters of varying lengths.

   * `assertEquals(6, stringCalculator.add("//[***]\n1***2***3"))`

9. **Multiple Delimiters**: Supports multiple delimiters in a string.

   * `assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"))`

---
## Screenshots

Screenshots of the first few test cases can be found in the /main/resources/screenshots directory.

## Cloning the Repository

To clone and run the project:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-username/StringCalculator.git
   ```
2. Navigate into the project directory:

   ```bash
   cd StringCalculator
   ```
3. Run the tests using Maven or your preferred IDE.

   * **Using Maven**:

     ```bash
     mvn test
     ```

---

## Gratitude

I would like to express my sincere gratitude to **Incubyte** for the opportunity to work on this assessment. It has been an excellent learning experience, and I appreciate the challenges and insights provided by this project.

Thank you - Venu Virparia
