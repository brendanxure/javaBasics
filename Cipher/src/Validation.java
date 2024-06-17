/*
  Program title:         Cipher
  Program Author:        Brendan Obilo
                         100952871
  Date:                  14/06/2024

  Description:           This program will implement an encryption\decryption cipher.
                         After selecting the mode (encrypt or decrypt) the user will
                         enter a phrase to be acted upon followed by the cipher selection
                         and complexity key. The program will then present the result of
                         the operation and ask if the user wants to repeat the process or
                         exit the program.
 */
import java.util.Scanner;

public class Validation {
    // Declaration and initialization of all constants and variables needed
    // To establish a constant that holds the value for the substitution option
    private final int SUBSTITUTION_OPTION = 1;
    // To establish a variable that holds the value for the translation option
    private final int TRANSLATION_OPTION  = 2;
    // To establish a variable that holds the final outcome of which option selection
    private int outcome;
    // To establish a variable that holds the boolean value for substitution mode
    public boolean substitutionMode;
    // To establish a variable that holds the boolean value for translation mode
    public boolean translationMode;
    // To establish a variable that holds the boolean value for decryption mode
    public boolean decryptMode;
    // To establish a variable that holds the boolean value for encryption mode
    public boolean encryptMode;
    // To establish a variable that holds the integer value for substitution methode selected
    private int encryptDecrypt;

    // To call the scanner class to collect input from keyboard
    Scanner input = new Scanner(System.in);

    // Mutators
    // To ask user for initial input in for substitution and translation, validate and use input
    public void getCipherInitialInput(){
        // To establish a variable that keeps asking user for input till correct input is collected
        boolean initialInput = true;
        while(initialInput){
            try{
                // To display welcome message and ask user for input
                System.out.print("""
                                Welcome to Cypher
                                1. Substitution
                                2. Translation
                                Please select between 1 and 2: \s""");
                // To collect user input and validate as an integer and store input in a variable
                outcome = input.nextInt();
                // To select which actual mode the user choose
                setProgramMode();
                // To ensure the user actually selected a valid mode and exit asking user for input
                if (translationMode | substitutionMode){
                    initialInput = false;
                }
            } catch (Exception ex){
                // To display all error message encounter during validation
                System.out.println("Sorry - Please enter correct integer");
                // To clear the input from keyboard of invalid input
                input.nextLine();
            }

        }
    }


    // To put the program in any mode as selected by the user
    private void setProgramMode(){
        // To ensure the option entered by user is to enter the substitution mode
        if(outcome == SUBSTITUTION_OPTION){
            // To set the program to substitution mode
            substitutionMode = true;
            translationMode = false;
        }
        // To ensure the option entered by user is to enter the translation mode
        else if (outcome == TRANSLATION_OPTION) {
            // To set the program to translation mode
            translationMode = true;
            substitutionMode = false;
        }
        // To ensure the program is not in any mode if user didn't select the right option
        else {
            translationMode = false;
            substitutionMode = false;
            // To display to the user to select the right option to put the program in a mode
            System.out.println("Selection must be between 1 and 2");
        }
    }


    // To collect user substitution input option
    public void getSubstitutionInput(){
        // To establish a variable that keeps asking user for input till correct input is collected
        boolean initialInput = true;
        while(initialInput){
            try{
                // To display welcome message and ask user for input
                System.out.print("""
                        Welcome to Substitution
                        1. Encrypt
                        2. Decrypt
                        Please select between 1 and 2: \s""");
                // To collect user input and validate as an integer and store input in a variable
                encryptDecrypt = input.nextInt();
                // To select which actual substitution mode the user choose
                setEncryptMode();
                // To ensure the user actually selected a valid mode and exit asking user for input
                if(encryptMode | decryptMode){
                    initialInput = false;
                }
            } catch (Exception ex){
                // To display all error message encounter during validation
                System.out.println("Sorry - Please enter correct integer");
                // To clear the input from keyboard of invalid input
                input.nextLine();
            }

        }
    }


    // To set the program to a substitution mode selected by the user
    private void setEncryptMode(){
        // To ensure the option entered by user is to enter the encryption mode
        if(encryptDecrypt == SUBSTITUTION_OPTION){
            // To set the program to encryption mode
            encryptMode = true;
            decryptMode = false;
        }
        // To ensure the option entered by user is to enter the decryption mode
        else if (encryptDecrypt == TRANSLATION_OPTION) {
            // To set the program to decryption mode
            decryptMode = true;
            encryptMode = false;
        }
        // To ensure the program is not in any mode if user didn't select the right option
        else {
            decryptMode = false;
            encryptMode = false;
            // To display to the user to select the right option to put the program in a substitution mode
            System.out.println("Selection must be between 1 and 2");
        }
    }
}
