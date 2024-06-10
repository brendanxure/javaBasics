/*
  Program title:         Body Mass Index
  Program Author:        Brendan Obilo
                         100952871
  Date:                  27/05/2024

  Description:           A program that accepts user input of height
                         and weight to calculate the body mass index
                         of user and gives the user the required output.
 */

import java.util.Scanner;


// To establish a java main class which the program for conversion runs/
public class Main {
    // To establish a main method where the code for all conversion runs
    public static void main(String[] args) {

        // To establish a variable to hold the maximum limit for height in inches
        final int HEIGHT_MAX_RANGE = 120;
        // To establish a variable to hold the minimum limit for height in inches
        final int HEIGHT_MIN_RANGE = 24;
        // To establish a variable to hold the minimum limit for weight in pounds
        final int WEIGHT_MIN_RANGE = 25;
        // To establish a variable to hold the minimum limit for an obese BMI
        final int OBESE_MIN = 30;
        // To establish a variable to hold the minimum limit for an overweight BMI
        final int OVERWEIGHT_MIN = 25;
        // To establish a variable to hold the minimum limit for a healthy BMI
        final double HEALTHY_MIN = 18.5;
        // To establish a variable to hold the minimum limit for an underweight BMI
        final int UNDERWEIGHT_MIN = 16;
        // To establish a variable to hold the BMI constant for calculation with pounds and inches
        final int BMI_CONSTANT = 703;
        // To establish a variable and initialize to hold the user height input
        double height = 0.0;
        // To establish a variable and initialize to hold the user weight input
        double weight = 0.0;
        // To establish a variable and initialize to hold a value to determine if the user should try again
        int optionYes = 1;
        // To establish a variable and initialize to hold a value to determine if the user should end the program
        int optionNo = 2;
        // To establish a variable and initialize to determine if the user should repeat input
        boolean askUser = true;
        // To establish a variable and initialize to select elements of the arrays of user inputs
        // and unit of measurement
        int questionIndex = 0;
        // To establish a variable to hold the body mass index calculated
        double bodyMassIndex;
        // To establish a variable to hold the value of the BMI condition
        String outputCategory;
        // To establish an array to hold different format of the questions for different inputs
        String[] askUserDetails = {"height", "weight"};
        // To establish an array to hold different format of the measurements for different inputs
        String[] units = {"inches", "pounds"};

        // To display the banner of the program
        System.out.println("Check your body mass index");
        // To collect input from user keyboard
        Scanner input =  new Scanner(System.in);

        // To determine if program should ask the user for appropriate input
        while (askUser){
            try{
                // To ask user to input either weight or height depending on the question index
                System.out.printf("\nPlease enter your %s in %s: ",
                                  askUserDetails[questionIndex], units[questionIndex]);
                // To determine if the user input was for height
                if(askUserDetails[0].equals(askUserDetails[questionIndex])){
                    // To collect user input, validate it and store as a double
                    height = input.nextDouble();
                    // To determine if the height is between 24 and 120
                    if(height >= HEIGHT_MIN_RANGE && height <= HEIGHT_MAX_RANGE){
                        // Update the question index and notify the program that the
                        // height has been collected
                        questionIndex += 1;
                    } else{
                        // To inform user the input wasn't between the range and prompt to input again
                        System.out.printf("Please enter input between %d inches and %d inches",
                                           HEIGHT_MIN_RANGE, HEIGHT_MAX_RANGE);
                    }
                }else {
                    // To collect the user input, validate it and store as a double
                    weight = input.nextDouble();
                    // To determine if the weight is above 25 pounds
                    if(weight >= WEIGHT_MIN_RANGE){
                        // Update the question index to notify the program that the weight has been collected
                        questionIndex += 1;
                    } else {
                        // To inform user the input wasn't between the range and prompt to input again
                        System.out.printf("Please enter input be from %d pounds and above",
                                           WEIGHT_MIN_RANGE);
                    }
                }
                // To ensure that all the input details has been collected
                if(questionIndex == askUserDetails.length) {
                    // To store the result of the BMI calculation
                    bodyMassIndex = (BMI_CONSTANT) * weight/(Math.pow(height, 2));
                    // To convert the BMI result to One decimal place
                    bodyMassIndex = (Math.round(bodyMassIndex * 10)/10.0);
                    // To compare the BMI to know which BMI level it falls on
                    if(bodyMassIndex >= OBESE_MIN){
                        outputCategory = "Obese";
                    } else if (bodyMassIndex >= OVERWEIGHT_MIN) {
                        outputCategory = "Overweight";
                    } else if (bodyMassIndex >= HEALTHY_MIN) {
                        outputCategory = "Healthy";
                    } else if (bodyMassIndex >= UNDERWEIGHT_MIN) {
                        outputCategory = "Underweight";
                    } else {
                        outputCategory = "Severely Underweight";
                    }
                    // To display the desired output consisting of user inputs, BMI and BMI level it falls on
                    System.out.printf("A height of %.1f inches and a body weight of %.1f pounds" +
                                      " give a BMI of %.1f you are considered %s",
                                      height, weight, bodyMassIndex, outputCategory);
                    // To determine the amount of weight the user needs to gain if needed
                    if (bodyMassIndex < HEALTHY_MIN ){
                       double massIndexLoss = HEALTHY_MIN - bodyMassIndex;
                       double weightToAdd = (massIndexLoss/BMI_CONSTANT) * Math.pow(height,2);
                       System.out.printf("\nGain %.1f pounds to be healthy", weightToAdd);
                    }
                    // To determine the amount of weight the user needs to lose if needed
                    if (bodyMassIndex >= OVERWEIGHT_MIN ){
                        double massIndexAdded = bodyMassIndex - OVERWEIGHT_MIN;
                        double weightToLoss = (massIndexAdded/BMI_CONSTANT) * Math.pow(height,2);
                        System.out.printf("\nLose %.1f pounds to be healthy", weightToLoss);
                    }
                    // To establish a variable to determine if the user will try the calculation again
                    boolean tryAgain = true;
                    while (tryAgain){
                        try{
                            // To ask user if they want to try again
                            System.out.println("\nDo you want to try again?\nEnter 1 or 2\n1. Yes\n2. No");
                            int optionSelected = input.nextInt();
                            // To determine if user chose yes
                            if(optionSelected == optionYes){
                                // To exit the loop for try again and start the program afresh
                                tryAgain = false;
                                // To ensure the program asks user for height then weight
                                questionIndex = 0;
                                // To determine if the user chose no
                            } else if (optionSelected == optionNo) {
                                // To ensure the program does not repeat after desired output is achieved
                                askUser = false;
                                tryAgain = false;
                            } else {
                                // To tell user to enter a valid option between 1 and 2
                                System.out.println("Please enter a option between 1 and 2");
                            }
                        } catch (Exception ex){
                            // To display error message due to data type from user input
                            System.out.println("Please enter a valid number");
                            // To clear the input on the keyboard after data type error has occurred
                            input.next();
                        }
                    }
                }
            } catch(Exception ex){
                // To display error message due to data type from user input
                System.out.printf("Please enter a valid number for %s", askUserDetails[questionIndex]);
                // To clear the input on the keyboard after data type error has occurred
                input.next();
            }
        }

    }
}
