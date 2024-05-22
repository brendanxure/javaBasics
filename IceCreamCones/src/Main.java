/*
  Program title:         Ice Cream Amount
  Program Author:        Brendan Obilo
  Date:                  16/05/2024

  Description:           Calculating the amount of ice cream sold weekly in litres
                         by inputting the amount of kiddie cone, small cone, medium
                         cone, and large cone sold
 */

// include
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    // The method that calculates the total amount sold in L
    public static void main(String[] args) {

        // Declare constant
        final double KIDDIE_SCOOP = 0.5;
        final int SMALL_SCOOP = 1;
        final int MEDIUM_SCOOP = 2;
        final int LARGE_SCOOP = 3;
        final int SCOOP_TO_ML = 120;
        final int ML_TO_L_CONVERSION = 1000;

        // Declare variable to hold the user input
        int kiddieCone;
        int smallCone;
        int mediumCone;
        int largeCone;
        double totalAmountOfScoops;
        double totalSoldInMl;
        double totalSoldInL;

        // To accept input from keyboard
        Scanner input = new Scanner(System.in);

        try {
            // To collect user input for kiddie cone
            System.out.print("How many kiddie cone have you sold: ");
            kiddieCone = input.nextInt();

            // To collect user input for small cone
            System.out.print("How many small cone have you sold: ");
            smallCone = input.nextInt();

            // To collect user input for medium cone
            System.out.print("How many medium cone have you sold: ");
            mediumCone = input.nextInt();

            // To collect user input for large cone
            System.out.print("How many large cone have you sold: ");
            largeCone = input.nextInt();

            // To calculate the total amount of scoops
            totalAmountOfScoops = ((double) kiddieCone * KIDDIE_SCOOP)
                    + ((double) smallCone * SMALL_SCOOP)
                    + ((double) mediumCone * MEDIUM_SCOOP)
                    + ((double) largeCone * LARGE_SCOOP);

            // To calculate the total quantity sold in ml
            totalSoldInMl = SCOOP_TO_ML * totalAmountOfScoops;

            // To calculate the total quantity sold in L
            totalSoldInL = totalSoldInMl / ML_TO_L_CONVERSION;

            // To display the required result
            System.out.printf("Total Amount Sold is: %,.2f L", totalSoldInL);

        } catch (InputMismatchException e) {
            System.out.println("Error!!! Invalid input. Please enter a valid integer.");
        } finally {
            input.close(); // Close the scanner to free resources
        }
    }
}
