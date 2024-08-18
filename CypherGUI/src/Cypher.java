/*
  Program title:         Cypher GUI
  Program Author:        Brendan Obilo
                         100952871
  Date:                  16/08/2024

  Description:           This is a class that will be used to implement an encryption\decryption cipher.
                         This part of the code was gotten from assignment too and refined to do the substitution
                         and translation.
 */

// java imports
import java.util.Objects;

public class Cypher {
    // Declaration and initialization of all constants and variables needed
    // To establish a variable that holds the value for phrase to display
    public String phrase;
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

    // Constructor
    public Cypher(String userPhrase, int optionValue, String option){
        phrase = userPhrase;
        // To establish a variable that selects the option for the substitution
        String passedOption = "S";
        if(Objects.equals(option, passedOption)){
            complexityKey = optionValue;
        } else {
            shiftValue = optionValue;
        }
    }
    // To establish a string builder that can accept my output phrase to display
    StringBuilder result = new StringBuilder();

    // To accept user input and validate input to encrypt
    public String encryptProcedure(){
        String retVal;
        // To start complexity key collection procedure
        getComplexity();
        if(getComplexity()){
            // To ensure program encrypts according to the complexity key
            while(complexityKey > INVALID_COMPLEXITY_KEY){
                // To start the encryption process
                getEncryption();
            }
            System.out.println(phrase);
            retVal = phrase;
        } else {
            retVal = "Complexity key not greater than 0";
        }

        return retVal;
    }

    // To start the encryption process by asking user for input and validating
    public String decryptProcedure(){
        String retVal;
        // To start complexity key collection process
       getComplexity();
       if(getComplexity()) {
           // To ensure program decrypts according to the complexity key
           while (complexityKey > INVALID_COMPLEXITY_KEY) {
               // To start the decryption process
               getDecryption();
           }
           System.out.println(phrase);
           retVal = phrase;
       } else {
           retVal = "Complexity key not greater than 0";
       }
        // To display to the user the decryption result
        return retVal;
    }

    public boolean getComplexity(){
        // To ensure the user input is within the valid range
        // To ensure the program will not ask the user for same input again
        return complexityKey > INVALID_COMPLEXITY_KEY;
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
    public String translateProcedure(){
        // To establish that return the String output
        String retVal;
        // To establish a variable that holds the minimum shift value
        // to ensure that user enters within the range expected
        int MINIMUM_SHIFT_VALUE = -52;
        try {
            // To ensure the user input is within range
            if(shiftValue < MINIMUM_SHIFT_VALUE){
                // To tell user the input is not within range
                retVal = "The maximum shift value to decrypt should be 52";
            }
            // To ensure that it is within range and proceed further
            else {
                // To start the translation with user input
                retVal = getTranslation();
                // To ensure the program does not ask user for shift value again
            }
        }
        // To catch all error from the translation procedure and tell user
        catch (Exception ex){
            retVal = "Sorry - Please enter correct integer for Shift Value";
        }
        return retVal;
    }

    // To start the translation procedure with user input
    public String getTranslation(){
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
        System.out.println(result.toString());
        return result.toString();
    }
}
