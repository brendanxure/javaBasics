/*
  Program title:         Cypher GUI
  Program Author:        Brendan Obilo
                         100952871
  Date:                  16/08/2024

  Description:           A graphical user interface that is used to Encrypt and decrypt messages entered by user
                         by typing the message or opening a text file and populating its content on a message
                         and also saves the content on the message area on a text file in the computer.
 */

// java imports
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SwingUtilities.invokeLater((() -> {
            // To create the object that will be used to run the show the window application
            MyWindow main = new MyWindow();
            // To Make the window visible by calling the `show()` method on the `MyWindow` instance
            main.show();
        }));
    }
}