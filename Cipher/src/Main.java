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
public class Main {
    public static void main(String[] args) {

//  To create an object to have access to validate user input
    Validation userCipherValidation = new Validation();
//  To create an object to have access to substitute or translate
    Cypher cypherProcedure = new Cypher();
//  To ask user for input and validate their option selection
    userCipherValidation.getCipherInitialInput();
   try {
//     To ensure user input is for substitution
       if(userCipherValidation.substitutionMode){
//         To collect the next input for validation on substitution option
           userCipherValidation.getSubstitutionInput();
//         To ensure the user selection was encryption
           if(userCipherValidation.encryptMode){
//             To collect user input for encryption, validate and encrypt
               cypherProcedure.encryptProcedure();
           // To ensure user selection was decryption
           } else if (userCipherValidation.decryptMode) {
           // To collect user input for decryption, validate and encrypt
               cypherProcedure.decryptProcedure();
           }
         // To ensure the user input is for translation
       } else if (userCipherValidation.translationMode) {
           // To collect user input for translation, validate and translate
           cypherProcedure.translateProcedure();
       } else {
           // To ensure user selected either substitution or translation mode
           System.out.println("Please ensure you are in a program mode");
       }
   } catch (Exception ex){
       // To catch all error in the program
       System.out.println("Sorry- " + ex.getMessage());
   }

    }
}