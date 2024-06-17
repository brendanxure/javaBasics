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

public class Cypher {
    // Declaration and initialization of all constants and variables needed
    // To establish a variable that holds the value for phrase to display
    public String phrase;
    // To establish a variable that holds the value for user input phrase
    public String inputPhrase;
    // To establish a variable that holds the value for user input complexity key
    private int complexityKey;
    // To establish a variable that holds the value for user input for shift value
    private int shiftValue;
    // To establish a constant that holds the value for invalid complexity boundary
    private final int INVALID_COMPLEXITY_KEY = 0;
    // To establish a boolean variable to hold an exception for perfect circular pattern
    private boolean circularPattern = false;

    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    final String COSC_ALPHABET = "YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop";

    // To establish a string builder that can accept my output phrase to display
    StringBuilder result = new StringBuilder();

    // To call the scanner class to collect input from keyboard
    Scanner input = new Scanner(System.in);

    // To accept user input and validate input to encrypt
    public void encryptProcedure(){
        // To establish a variable that keeps asking user for input till correct input is collected
        boolean initialInput = true;
        while(initialInput){
            try{
                // To ask user for input
                System.out.print("Please enter the word to encrypt: ");
                // To collect user input and store input in a variable
                phrase = input.nextLine();
                // To retains the original user input throughout the program
                inputPhrase = phrase;
                // To ensure the user input is not an empty value
                if(phrase.trim().isEmpty()){
                    System.out.println("Input cant be empty");
                } else {
                    // To ensure the program does not ask user for encryption word again
                    initialInput = false;
                }
            } catch (Exception ex){
                // To display an error through encryption procedure
                System.out.println("Sorry -" + ex.getMessage());
                input.nextLine();
            }
        }
        // To start complexity key collection procedure
        getComplexity();
        // To ensure program encrypts according to the complexity key
        while(complexityKey > INVALID_COMPLEXITY_KEY){
            // To start the encryption process
            getEncryption();
        }
        // To display to the user the encryption result
        System.out.printf("Your input \"%s\" has been encrypted to: %s", inputPhrase, phrase);
    }

    // To start the encryption process by asking user for input and validating
    public void decryptProcedure(){
        // To establish a variable that keeps asking user for input
        // till valid input is collected
        boolean initialInput = true;
        while(initialInput) {
            try {
                // To ask user for input
                System.out.print("Please enter the word to decrypt: ");
                // To collect user input and store input in a variable
                phrase = input.nextLine();
                // To retains the original user input throughout the program
                inputPhrase = phrase;
                // To ensure the user input is not an empty value
                if (phrase.trim().isEmpty()) {
                    System.out.println("Input cant be empty");
                } else {
                    // To ensure the program does not ask user for decryption word again
                    initialInput = false;
                }
            } catch (Exception ex) {
                // To display an error through encryption procedure
                System.out.println("Sorry -" + ex.getMessage());
                // To clear invalid input from the keyboard
                input.nextLine();
            }
        }
        // To start complexity key collection process
       getComplexity();
        // To ensure program decrypts according to the complexity key
        while(complexityKey > INVALID_COMPLEXITY_KEY){
            // To start the decryption process
            getDecryption();
        }
        // To display to the user the decryption result
        System.out.printf("Your input \"%s\" has been decrypted to: %s", inputPhrase, phrase);
    }

    public void getComplexity(){
        // To establish a variable that holds the boolean value to decide if user should input complexity key
        boolean askComplexity;
        // To initialize a variable that keeps asking user for complexity key
        // till valid input is collected
        askComplexity = true;
        while (askComplexity){
            try{
                // To ask user for complexity key input
                System.out.print("Please enter the complexity key: ");
                // To collect user input, validate and store input in a variable
                complexityKey = input.nextInt();
                // To ensure the user input is within the valid range
                if(complexityKey > INVALID_COMPLEXITY_KEY){
                    // To ensure the program will not ask the user for same input again
                    askComplexity = false;
                } else {
                    // To tell user the expected range for input
                    System.out.println("Complexity Key must be an integer greater than 0");
                }
            } catch (Exception ex){
                // To get all error and display to user
                System.out.println("Sorry - Please enter correct integer for complexity key");
                // To clear the keyboard from invalid input
                input.nextLine();
            }
        }
    }

    // To start the encryption process with user entered input
    public void getEncryption(){
        // To compare each character entered by the user with
        // the characters in the string of ALPHABET, if any one matches
        // it will switch the character with the character from the COSC ALPHABET
        // using the index of the alphabets and appends to the string builder
        for (int i = 0; i < phrase.length(); i++){
            for (int j = 0; j < ALPHABET.length(); j++){
                if(phrase.charAt(i) == ALPHABET.charAt(j)){
                    result.append(COSC_ALPHABET.charAt(j));
                }
            }
            if(ALPHABET.indexOf(phrase.charAt(i)) == -1){
                result.append(phrase.charAt(i));
            }
        }
        // To convert the string builder to string and update the phrase variable
        phrase = result.toString();
        // To clear the string builder in case the encryption wants to repeat
        result.setLength(0);
        // To update the complexity key to ensure it ensure for the required amount of time
        complexityKey -= 1;
    }

    // To start the encryption process with user entered input
    public void getDecryption(){
        // To compare each character entered by the user with
        // the characters in the string of COSC ALPHABET, if any one matches
        // it will switch the character with the character from the ALPHABET
        // using the index of the COSC ALPHABET and appends to the string builder
        for (int i = 0; i < phrase.length(); i++){
            for (int j = 0; j < COSC_ALPHABET.length(); j++){
                if(phrase.charAt(i) == COSC_ALPHABET.charAt(j)){
                    result.append(ALPHABET.charAt(j));
                }
            }
            if(COSC_ALPHABET.indexOf(phrase.charAt(i)) == -1){
                result.append(phrase.charAt(i));
            }
        }
        // To convert the string builder to string and update the phrase variable
        phrase = result.toString();
        // To clear the string builder in case the decryption wants to repeat
        result.setLength(0);
        // To update the complexity key to ensure it ensure for the required amount of time
        complexityKey -= 1;
    }


    // To start the translation procedure and ask user for input to validate
    public void translateProcedure(){
        // To establish a variable that keeps asking user for input till valid input is collected
        boolean initialInput = true;
        while(initialInput){
            try{
                // To collect user input to translate
                System.out.print("Please enter the word to translate: ");
                // To collect user input and store input in a variable
                phrase = input.nextLine();
                // To retains the original user input throughout the program
                inputPhrase = phrase;
                // To ensure the user input is not an empty value
                if(phrase.trim().isEmpty()){
                    // To display to user that input cannot be empty
                    System.out.println("Input cant be empty");
                }
                // To ensure the user entered an input value
                else {
                    // To ensure the program does not ask user for input value again
                    // after collecting valid input
                    initialInput = false;
                }
            }
            // To catch all error that occur during this translation procedure
            catch (Exception ex){
                System.out.println("Sorry - " + ex.getMessage());
                // To clear the keyboard of invalid input
                input.nextLine();
            }
        }
        // To establish a variable that keeps asking user for shift value till valid input is collected
        boolean askShiftValue = true;
        while (askShiftValue){
            // To establish a variable that holds the minimum shift value
            // to ensure that user enters within the range expected
            int MINIMUM_SHIFT_VALUE = -52;
            try {
                // To collect user input
                System.out.print("Please enter the shift value: ");
                // To store user input in the variable after validation
                shiftValue = input.nextInt();
                // To ensure the user input is within range
                if(shiftValue < MINIMUM_SHIFT_VALUE){
                    // To tell user the input is not within range
                    System.out.println("The minimum shift value should be -52");
                }
                // To ensure that it is within range and proceed further
                else {
                    // To start the translation with user input
                    getTranslation();
                    // To ensure the program does not ask user for shift value again
                    askShiftValue = false;
                }
            }
            // To catch all error from the translation procedure and tell user
            catch (Exception ex){
                System.out.println("Sorry - Please enter correct integer for Shift Value");
                // To clear the keyboard invalid input
                input.nextLine();
            }
        }
    }

    // To start the translation procedure with user input
    public void getTranslation(){
        // To establish a variable that holds the max ascii value for letters of alphabet
        int asciiNumberMax = 122;
        // To establish a variable that holds the number of ascii value for letters of alphabet
        int asciiNumberRange = 52;
        // To establish a variable that holds the min ascii value for letters of alphabet
        int asciiNumberMin = 65;
        // To establish a variable that holds the ascii value lower boundary for letters of alphabet
        int asciiNumberLower = 64;
        // To establish a variable that holds the ascii value upper boundary for letters of alphabet
        int asciiNumberUpper = 123;
        // To establish variable that holds the ascii value for capital letter upper boundary
        int asciiCapitalUpper = 90;
        // To establish variable that holds the ascii value for small letter lower boundary
        int asciiSmallLetterLower = 97;
        // To establish the variable the hold the range in gap from Z to a
        int asciiNumberSkipValue = 6;

        // To check each letter for from the phrase entered from the user
        for (int i = 0; i < phrase.length(); i++){
            // To ensure the spaces within words are maintained
            if(phrase.charAt(i) == ' '){
                result.append(phrase.charAt(i));
            }
            // To ensure the characters between 91-96 involved in the translation
            else if ((int) phrase.charAt(i) > asciiCapitalUpper &
                    (int) phrase.charAt(i) < asciiSmallLetterLower) {
                result.append(phrase.charAt(i));
            }
            // To ensure the character are just within the letters of the alphabet
            else if ((int) phrase.charAt(i) < asciiNumberMin  |
                    (int) phrase.charAt(i) > asciiNumberMax) {
                result.append(phrase.charAt(i));
            } else {
                // To get the ascii number for the letter
                int asciiValue =  phrase.charAt(i);
                // To shift to the required ascii number and get new ascii number
                int newAsciiValue = asciiValue + shiftValue;
                // To check if the new ascii number is within 91 to 96 and shifting forward
                // so to modify and skip non alphabets in that range
                if(newAsciiValue > asciiCapitalUpper && asciiValue <= asciiCapitalUpper){
                    newAsciiValue += asciiNumberSkipValue;
                }
                // To check if the new ascii number is within 91 to 96 and shifting backward
                // if shift value is negative so to modify and skip non alphabets in that range
                if(newAsciiValue < asciiSmallLetterLower && asciiValue >= asciiSmallLetterLower){
                    newAsciiValue -= asciiNumberSkipValue;
                }
                // To check if the new ascii number is above 122
                // so to rotate the shifting in a circular pattern starting from ascii number 65
                while (newAsciiValue > asciiNumberMax){
                    // Get the overage of the new ascii value considering skipping 91-97
                    int cycleRemainder = newAsciiValue - asciiNumberMax;
                    // To check if the overage is more than the range of number of all alphabets
                    if (cycleRemainder >= asciiNumberRange){
                        // To maintain a circular rotation in shifting
                        // get the remainder by dividing by its range
                        cycleRemainder %= asciiNumberRange;
                        // Check if there is no remainder to determine if it is a perfect circular pattern
                        if(cycleRemainder ==  0){
                            // To get new ascii value of a perfect circular pattern from the last
                            newAsciiValue = asciiNumberMax;
                            circularPattern = true;
                        } else {
                            // To get the new ascii value if there is a remainder
                            newAsciiValue = cycleRemainder + asciiNumberLower;
                        }
                    } else {
                        // To get the new ascii value when the overage is not more
                        // than the range of alphabet
                        newAsciiValue = cycleRemainder + asciiNumberLower;
                    }
                    // To ensure the ascii value put into consideration to skip between 91-97
                    // if the new value exceeded 90
                    if(newAsciiValue > asciiCapitalUpper & !circularPattern){
                        newAsciiValue += asciiNumberSkipValue;
                    }
                }
                // To check if the new ascii number is below 65
                // so to rotate the shifting in a circular pattern and continue from ascii number 122
                while (newAsciiValue < asciiNumberMin) {
                    // Get the deficit of the new ascii value
                    int cycleDifference = asciiNumberMin - newAsciiValue;
                    // To check the difference is to know if it is a perfect circular pattern
                    // because the maximum difference is 52 which is due to the shift value minimum limit
                    if (cycleDifference == asciiNumberRange){
                        // To set the value to the initial value because it is a perfect circular pattern
                        newAsciiValue = asciiNumberMin;
                        circularPattern = true;
                    } else {
                        // To determine the circular pattern from the difference
                        newAsciiValue = asciiNumberUpper - cycleDifference;
                    }
                    // To consider skipping between 96-91
                    if(newAsciiValue < asciiSmallLetterLower & !circularPattern){
                        newAsciiValue -= asciiNumberSkipValue;
                    }
                }
                // To convert the ascii number to character value
                char translatedLetter = (char) newAsciiValue;
                result.append(translatedLetter);
                circularPattern = false;
            }
        }
        // To display required results
        System.out.printf("Your input \"%s\" has been translated to: %s", inputPhrase, result);
    }
}
