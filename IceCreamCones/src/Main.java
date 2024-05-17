/*
  Program title:         Ice Cream Amount
  Program Author:        Brendan Obilo
  Date:                  16/05/2024

  Description:           Calculating the amount of ice cream sold weekly by inputing the
                        amount of kiddie cone, small cone, medium cone and large cone sold
 */

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // The method that calculates the total amount sold in ml
    public static void main(String[] args) {

        // Declare constant
        final double KIDDIE_SCOOP = 0.5;
        final int SMALL_SCOOP = 1;
        final int MEDIUM_SCOOP = 2;
        final int LARGE_SCOOP = 3;
        final double SCOOP_TO_L = 0.12;

        // Declare variable to hold the user input
        // to hold the amount of kiddie cone input by user
        int kiddieCone;
        // To hold the amount of small cone input by user
        int smallCone;
        // To hold the amount of medium cone input by user
        int mediumCone;
        // To hold the amount of large cone input by user
        int largeCone;
        // To hold the total amount of scoops after conversion
        double totalAmountOfScoops;
        // To hold the total amount in ml after conversion
        double totalSoldInL;

        // To accept input from keyboard
        Scanner input = new Scanner(System.in);

        // To collect user input for kiddie cone
        System.out.print("How many kiddie cone have to sold: ");
        // To store the input to the variable and validate the input
        kiddieCone = input.nextInt();

        // To collect user input for small cone
        System.out.print("How many small cone have to sold: ");
        // To store the input to the variable and validate the input
        smallCone = input.nextInt();

        // To collect user input for medium cone
        System.out.print("How many medium cone have to sold: ");
        // To store the input to the variable and validate the input
        mediumCone = input.nextInt();

        // To collect user input for large cone
        System.out.print("How many large cone have to sold: ");
        // To store the input to the variable and validate the input
        largeCone = input.nextInt();

        // To calculate the total amount of scoops
        totalAmountOfScoops = ((double) kiddieCone * KIDDIE_SCOOP)
                            + ((double) smallCone * SMALL_SCOOP)
                            + ((double) mediumCone * MEDIUM_SCOOP)
                            + ((double) largeCone * LARGE_SCOOP);

        // To calculate the total quantity sold in ml
        totalSoldInL = SCOOP_TO_L * totalAmountOfScoops;

        // To display the required result
        System.out.printf("Total Amount Sold is: %,.2f L", totalSoldInL);
    }
}