import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput {

    /**
     * Prompts the user to input a string until a non-zero length string is provided.
     *
     * @param pipe    a Scanner object created to read from System.in
     * @param prompt  the message to display as the prompt for the input
     * @return        a non-zero length string input by the user
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString; // Declare a variable to store the user input
        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            retString = pipe.nextLine(); // Read the user input
        } while (retString.isEmpty()); // Continue looping until a non-zero length string is entered
        return retString; // Return the non-zero length string
    }

    /**
     * Prompts the user to input any integer and ensures the input is an integer.
     *
     * @param pipe    a Scanner object created to read from System.in
     * @param prompt  the message to display as the prompt for the input
     * @return        an integer input by the user
     */
    public static int getInt(Scanner pipe, String prompt) {
        int intValue = 0; // Initialize the variable to store the user input
        boolean isValidInput = false; // Flag to track input validity

        // Keep asking for input until a valid integer is entered
        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            try {
                intValue = Integer.parseInt(pipe.nextLine()); // Read the user input as an integer
                isValidInput = true; // Valid input, exit loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer."); // Error message for invalid input (not an integer)
            }
        } while (!isValidInput);

        return intValue; // Return the valid input value
    }

    /**
     * Prompts the user to input any double value and ensures the input is a valid double.
     *
     * @param pipe    a Scanner object created to read from System.in
     * @param prompt  the message to display as the prompt for the input
     * @return        a double value input by the user
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double doubleValue = 0.0; // Initialize the variable to store the user input
        boolean isValidInput = false; // Flag to track input validity

        // Keep asking for input until a valid double is entered
        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            try {
                doubleValue = Double.parseDouble(pipe.nextLine()); // Read the user input as a double
                isValidInput = true; // Valid input, exit loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a double."); // Error message for invalid input (not a double)
            }
        } while (!isValidInput);

        return doubleValue; // Return the valid input value
    }

    /**
     * Prompts the user to input an integer within a specified range and ensures the input is valid.
     *
     * @param pipe    a Scanner object created to read from System.in
     * @param prompt  the message to display as the prompt for the input
     * @param low     the lower bound of the acceptable range (inclusive)
     * @param high    the upper bound of the acceptable range (inclusive)
     * @return        an integer input by the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int rangedIntValue = 0; // Initialize the variable to store the user input
        boolean isValidInput = false; // Flag to track input validity

        // Keep asking for input until a valid integer within the specified range is entered
        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            try {
                rangedIntValue = Integer.parseInt(pipe.nextLine()); // Read the user input as an integer
                if (rangedIntValue >= low && rangedIntValue <= high) { // Check if the input is within the specified range
                    isValidInput = true; // Valid input, exit loop
                } else {
                    System.out.println("Invalid input. Please enter an integer within the range " + low + "-" + high + "."); // Error message for input outside the range
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer."); // Error message for invalid input (not an integer)
            }
        } while (!isValidInput);

        return rangedIntValue; // Return the valid input value
    }

    /**
     * Prompts the user to input a double value within a specified range and ensures the input is valid.
     *
     * @param pipe    a Scanner object created to read from System.in
     * @param prompt  the message to display as the prompt for the input
     * @param low     the lower bound of the acceptable range (exclusive)
     * @param high    the upper bound of the acceptable range (exclusive)
     * @return        a double value input by the user within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double rangedDoubleValue = 0.0; // Initialize the variable to store the user input
        boolean isValidInput = false; // Flag to track input validity

        // Keep asking for input until a valid double within the specified range is entered
        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            try {
                rangedDoubleValue = Double.parseDouble(pipe.nextLine()); // Read the user input as a double
                if (rangedDoubleValue >= low && rangedDoubleValue <= high) { // Check if the input is within the specified range
                    isValidInput = true; // Valid input, exit loop
                } else {
                    System.out.println("Invalid input. Please enter a double within the range (" + low + ", " + high + ")."); // Error message for input outside the range
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a double."); // Error message for invalid input (not a double)
            }
        } while (!isValidInput);

        return rangedDoubleValue; // Return the valid input value
    }

    /**
     * Prompts the user to input either 'y' or 'n' and ensures the input is valid.
     *
     * @param pipe    a Scanner object created to read from System.in
     * @param prompt  the message to display as the prompt for the input
     * @return        true if the user enters 'y', false if the user enters 'n'
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean yNConfirm = true; // Default confirmation value
        boolean isValidInput = false; // Flag to track input validity

        // Keep asking for input until a valid 'y' or 'n' is entered
        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            String filter = pipe.nextLine(); // Read user input

            // Check if the input is 'n' (negative)
            if (filter.equalsIgnoreCase("n")) {
                yNConfirm = false; // Set confirmation to false
                isValidInput = true; // Valid input, exit loop
            } else if (filter.equalsIgnoreCase("y")) { // Check if the input is 'y' (positive)
                yNConfirm = true; // Set confirmation to true
                isValidInput = true; // Valid input, exit loop
            } else {
                System.out.println("Invalid input. Please enter y/n."); // Error message for invalid input
            }
        } while (!isValidInput);

        return yNConfirm; // Return the confirmation value
    }

    /**
     * Prompts the user to input a string matching a specified regular expression pattern and ensures the input is valid.
     *
     * @param pipe    a Scanner object created to read from System.in
     * @param prompt  the message to display as the prompt for the input
     * @param regEx   the regular expression pattern to match against
     * @return        a string input by the user matching the specified pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input = ""; // Initialize input string
        boolean isValidInput = false; // Flag to track input validity

        // Keep asking for input until a valid string matching the specified pattern is entered
        while (!isValidInput) {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            if (pipe.hasNextLine()) { // Check if there's input available
                input = pipe.nextLine().trim(); // Read the input and remove leading/trailing whitespace
                if (Pattern.matches(regEx, input)) { // Check if the input matches the regular expression
                    isValidInput = true; // Set flag to true to exit the loop
                } else {
                    System.out.println("Invalid input. Please enter a string matching the pattern: " + regEx); // Error message for invalid input
                }
            } else {
                System.out.println("Invalid input. Please enter a string."); // Error message for no input
                pipe.next(); // Discard the non-string input
            }
        }

        return input; // Return the valid input string

    }


    /**
     * Prompts the user to input a string and converts that string to a fancy header and returns a string
     *
     * @param msg   the string that will be made into a fancy header
     * @return      the fancy header
     */

    public static String prettyHeader(String msg) {
        // Calculate the length of the input message
        int length = msg.length();
        // Calculate the number of spaces needed to center the message within the header
        int spaceNum = 60 - length;
        // Initialize an index to keep track of the position within the message
        int index = 0;
        // StringBuilder to construct the header
        StringBuilder header = new StringBuilder();

        // Loop to create the header lines
        for (int i = 1; i <= 3; i++) {
            // For the first and third lines, fill the entire width with asterisks
            if ((i == 1) || (i == 3)) {
                header.append("*".repeat(60)); // Fills the line with 60 asterisks
                header.append("\n"); // Move to the next line
            } else {
                // For the second line, construct the centered message
                for (int a = 1; a <= 60; a++) {
                    // Add asterisks at the beginning and end of the line
                    if ((a <= 3) || (a >= 58)) {
                        header.append("*");
                        if (a == 60) {
                            header.append("\n"); // Move to the next line at the end of the line
                        }
                    } else if ((a <= spaceNum / 2) || (a > length + (spaceNum / 2))) {
                        // Add spaces before and after the message to center it
                        header.append(" ");
                    } else {
                        // Add characters from the message
                        header.append(msg.charAt(index));
                        index++;
                    }
                }
            }
        }
        return String.valueOf(header); // Return the constructed header as a string
    }
}
