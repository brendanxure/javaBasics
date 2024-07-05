import java.util.Scanner;

public class Validation {
    // To validate for string and ensure the characters are letters
    public static char GetValidCharacter(String prompt, String letters){
        Scanner input = new Scanner(System.in);
        char letter = ' ';
        System.out.print(prompt);
        String userInput = input.next();
        if (userInput.length() != 1){
            System.out.println("That's not a valid option. Please try again.");
            letter = GetValidCharacter(prompt, letters);
        } else if (!letters.contains(userInput)) {
            System.out.println("That's not a valid option. Please try again");
            letter = GetValidCharacter(prompt, letters);
        } else {
            letter = userInput.charAt(0);
        }
        return letter;
    }
}
