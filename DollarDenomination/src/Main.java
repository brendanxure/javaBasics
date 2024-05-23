import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        final int HUNDRED  = 100;
        final int FIFTY = 50;
        final int TWENTY = 20;
        final int TEN = 10;
        final int FIVE = 5;
        final int TWO = 2;
        final int ONE = 1;
        int userInput;
        int hundreds;
        int fifties;
        int twenties;
        int tens;
        int fives;
        int twos;
        int ones;
        System.out.println("Hello and welcome!");

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter dollar amount: ");
        userInput = input.nextInt();
        if (userInput >= HUNDRED){
            hundreds = userInput / HUNDRED;
            System.out.printf("%d hundreds\n", hundreds);
            userInput %= HUNDRED;
        }
        if (userInput >= FIFTY){
            fifties = userInput / FIFTY;
            System.out.printf("%d fifties\n", fifties);
            userInput %= FIFTY;
        }
        if (userInput >= TWENTY){
            twenties = userInput / TWENTY;
            System.out.printf("%d twenties\n", twenties);
            userInput %= TWENTY;
        }
        if (userInput >= TEN){
            tens = userInput / TEN;
            System.out.printf("%d tens\n", tens);
            userInput %= TEN;
        }
        if (userInput >= FIVE){
            fives = userInput / FIVE;
            System.out.printf("%d fives\n", fives);
            userInput %= FIVE;
        }
        if (userInput >= TWO){
            twos = userInput / TWO;
            System.out.printf("%d twos\n", twos);
            userInput %= TWO;
        }
        if (userInput == ONE){
            ones = userInput / ONE;
            System.out.printf("%d ones\n", ones);
        }
    }
}