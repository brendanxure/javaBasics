/*
  Program title:         Unit Converter
  Program Author:        Brendan Obilo
                         100952871
  Date:                  21/05/2024

  Description:           A program to convert between two units of measurement
                         for height, weight and temperature.
 */
import java.util.Scanner;

// To establish a java main class which the program for conversion runs
public class Main {
    // To establish a main method where the code for all conversion runs
    public static void main(String[] args) {

        // To establish a constant to hold the correct value for option to ask
        // for another measurement
        final int YES_REPEAT_OPTION = 1;
        // To establish a constant to hold the correct value for option to end program
        final int NO_REPEAT_OPTION = 2;
        // To establish a constant to hold the min range value for option for conversion
        final int OPTION_MIN_RANGE = 1;
        // To establish a constant to hold the max range value for option for conversion
        final int OPTION_MAX_RANGE = 3;
        // To establish a variable to hold the value of the option selected by user
        int optionSelected = 0;
        // To establish a variable to determine which conversion the user wants
        boolean selectOption = true;
        // To establish a variable to determine if user wants to enter measurement to convert
        boolean startConversion = false;
        // To establish a variable to determine if the user wants to do a conversion or
        // enter another measurement
        boolean askUser = true;
        // To establish a variable that stores user measurement before it converts it
        double userInput;
        // To establish a variable that stores user converted result
        double userOutput;
        // To establish an array that hold different conversion options for user to choose
        String[] conversionType = {"Inch (“) to meter (m)", "Pound (lb) to kilogram (kg)",
                                   "Celsius (˚C) to Fahrenheit (˚F)"};

        // To display the banner of the program
        System.out.println("Unit Converter");
        // To instantiate a class where all the conversion calculation is performed
        Converter converter = new Converter();
        // To collect input from user keyboard
        Scanner input = new Scanner(System.in);

        // To determine if user wants to do a conversion or enter another measurement
        while (askUser){
            // To determine if program should ask the user to select conversion they desire
            while (selectOption) {
                try {
                    // To ask user to select the conversion they desire among possible options
                    System.out.println("""
                      Please choose an option between 1-3:
                      1. Inch ("") to meter (m).
                      2. Pound (lb) to kilogram (kg).
                      3. Celsius (°C) to Fahrenheit (°F).""");
                    // To validate it is an integer input and store the value in a variable
                    optionSelected = input.nextInt();
                    // To determine if the user input is within the range of options
                    if (optionSelected>= OPTION_MIN_RANGE && optionSelected<= OPTION_MAX_RANGE) {
                        // To avoid asking the user to select the conversion among options again
                        selectOption = false;
                        // To take give access to asking the user to enter the measurement
                        startConversion = true;
                    } else {
                        // To display to the user that input is not within the range of options
                        System.out.println("Please enter an option between range 1-3");
                    }
                } catch (Exception ex){
                    // To display to the user that input is not an integer
                    System.out.println("Please enter a valid option");
                    // To clear the input on the keyboard after data type error has occurred
                    input.next();
                }
            }
            // To determine if the program should ask user to enter measurement
            while (startConversion) {
                try{
                    // To ask user to enter the measurement they want to convert
                    System.out.printf("Enter an integer to convert from "
                                      + conversionType[optionSelected - 1] + ": ");
                    // To validate it is a decimal input and store the value in a variable
                    userInput = input.nextDouble();
                    // To ensure the program does not ask for measurement again after validation
                    startConversion = false;
                    // To determine if user wants to convert length from inch to meter
                    if(conversionType[optionSelected-1].equals(conversionType[0])){
                        // To pass the input value to the class created and store the
                        // result in a variable
                        userOutput = converter.length(userInput);
                        // To display the result in a nice format for the user
                        System.out.printf("The conversion is %.1f m\n", userOutput);
                      // To determine if user wants to convert weight from pounds to kilogram
                    } else if (conversionType[optionSelected-1].equals(conversionType[1])) {
                        // To pass the input value to the class created and store the result
                        // in a variable
                        userOutput = converter.weight(userInput);
                        // To display the result in a nice format for the user
                        System.out.printf("The conversion is %.1f kg\n", userOutput);
                        // To determine if user wants to convert temperature from (°C) to (°F)
                    } else {
                        // To pass the input value to the class created and store the result
                        // in a variable
                        userOutput = converter.temperature(userInput);
                        // To display the result in a nice format for the user
                        System.out.printf("The conversion is %.1f °F\n", userOutput);
                    }
                }
                catch(Exception ex){
                    // To display to the user that input is not a valid number
                    System.out.println("Please enter a valid number");
                    // To clear the input on the keyboard after data type error has occurred
                    input.next();
                }
            }
            try {
                // To ask user to select an option if they want to enter another measurement
                System.out.println("""
                      \nDo you want to enter another measurement
                      Please enter 1 or 2:
                      1. Yes.
                      2. No.""");
                // To validate it is an integer input and store the value in a variable
                optionSelected = input.nextInt();
                // To validate if user did not select between the range of options
                if(optionSelected != YES_REPEAT_OPTION && optionSelected != NO_REPEAT_OPTION){
                    System.out.println("Please enter an option between 1 and 2");
                }
                // To determine that the option selected is No
                else if(optionSelected == NO_REPEAT_OPTION){
                    // To end the program and not ask user to select option for another measurement
                    askUser = false;
                    // To exit and close the scanner
                    input.close();
                } else {
                    // To continue program and ask user to select option for another measurement
                    selectOption = true;
                }
            } catch (Exception ex){
                // To display to the user that input is not a valid number
                System.out.println("Please enter a valid option");
                // To clear the input on the keyboard after data type error has occurred
                input.next();
            }
        }
    }
}