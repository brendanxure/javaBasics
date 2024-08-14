/*
  Program title:         Swing GUI
  Program Author:        Brendan Obilo
                         100952871
  Date:                  09/08/2024

  Description:           A graphical user interface that is used to open a text file
                         and populate its content on a textarea and also saves what is
                         typed on the text area on a text file in the computer.
 */

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                // To create the object that will be used to run the show the window application
                MyWindow main = new MyWindow();
                // To Make the window visible by calling the `show()` method on the `MyWindow` instance
                main.show();
            }
        }));
    }
}