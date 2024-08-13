/*
  Program title:         Swing GUI
  Program Author:        Brendan Obilo
                         100952871
  Date:                  09/08/2024

  Description:           A class named MyWindow that is used to open a text file
                         and populate its content on a textarea and also saves what is
                         typed on the text area on a text file in the computer.
                         Additional features like word count is also implemented here
 */

// java imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class MyWindow {
    // To establish the Main JFrame window for the GUI
    private JFrame window;
    // To establish a variable that holds the number of words on text area
    private JLabel lblWordCount;

    // The Constructor for MyWindow class
    public MyWindow() {
        // To create a window object using the JFrame to design the GUI
        window = new JFrame();
        // To set the title of the window
        window.setTitle("My Swing GUI");
        // To close the window when 'Exit' is clicked
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // To set the size of the window
        window.setSize(600, 700);
        // To center the window on the screen
        window.setLocationRelativeTo(null);

        // To create buttons for Save, Open, and Exit functionalities
        JButton btnSave = new JButton("Save");
        JButton btnOpen = new JButton("Open");
        JButton btnExit = new JButton("Exit");
        
        // To create and add a welcome banner using styled fonts
        JLabel lblWelcomeBanner = getLabel();
        window.add(lblWelcomeBanner);

        // To create a JTextArea where users can input text
        JTextArea textArea = new JTextArea();
        // To set the position and size of the text area
        textArea.setBounds(50, 80, 300, 200);
        // To add the text area to the window
        window.add(textArea);

        // To set position and size of the Save button
        btnSave.setBounds(50, 300, 95, 30);
        // To set a tooltip text
        btnSave.setToolTipText("Save file to a txt file");
        // To set a hot key for the Save button (Alt + S)
        btnSave.setMnemonic(KeyEvent.VK_S);
        // To allow Save button perform an action when clicked
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // To enable user access to select the computer's files
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(window);
                // To get the path of the selected file
                File selectedFile = fileChooser.getSelectedFile();
                try{
                    // To create a FileWriter to write to the selected file
                    FileWriter writer = new FileWriter(selectedFile);
                    // To ensure the file is written well by using an object created from a BufferedWriter class
                    BufferedWriter br = new BufferedWriter(writer);
                    // To write the contents of the text area to the file
                    textArea.write(br);
                    // To clear the text area after saving
                    textArea.setText("");
                } catch (Exception ex){
                    // To print error message if saving fails
                    System.out.println(ex.getMessage());
                } finally {
                    // To get the number of words on the text area
                    updateWordCount(textArea.getText());
                }
            }
        });
        // To add Save button to the window
        window.add(btnSave);

        // To set position and size of the Open button
        btnOpen.setBounds(150, 300, 95, 30);
        // To set a tooltip text
        btnOpen.setToolTipText("Copy txt file content to textarea");
        // To set a hot key for the Open button (Alt + C)
        btnOpen.setMnemonic(KeyEvent.VK_C);
        // To allow Open button perform an action when clicked
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // To enable user access to select the computer's files
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(window);
                // To get the path of the selected file
                File selectedFile = fileChooser.getSelectedFile();
                try{
                    // To read the selected file
                    FileReader reader = new FileReader(selectedFile);
                    // To enable efficient reading of file
                    BufferedReader br = new BufferedReader(reader);
                    // To read the contents of the file into the text area
                    textArea.read(br, null);
                } catch (Exception ex){
                    // Print error message if opening fails
                    System.out.println(ex.getMessage());
                } finally {
                    // To get the number of words on the text area
                    updateWordCount(textArea.getText());
                }
            }
        });
        // To add Open button to the window
        window.add(btnOpen);

        // To set position and size of the Exit button
        btnExit.setBounds(250, 300, 95, 30);
        // To set a tooltip text
        btnExit.setToolTipText("Exit application");
        // Set a Hot key for the Exit button (Alt + X)
        btnExit.setMnemonic(KeyEvent.VK_X);
        // To allow Exit button perform an action when clicked
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // To close the window when Exit button is clicked
                window.dispose();
            }
        });
        // To add Exit button to the window
        window.add(btnExit);

        // To Add a KeyListener to update word count as the user types
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // To get the number of words on the text area
                updateWordCount(textArea.getText());
            }
        });

        // An extra feature added To create and add a label for word count
        lblWordCount = new JLabel("Word Count: 0");
        // To set position and size of the label
        lblWordCount.setBounds(50, 350, 300, 50);
        window.add(lblWordCount);

        // To create an empty label to fill any space that is not used further in the code
        JLabel lblBlank = new JLabel("");
        // To set position and size of the blank label
        lblBlank.setBounds(650,650,5,5);
        // To add blank label to the window
        window.add(lblBlank);
    }

    private static JLabel getLabel() {
        JLabel lblWelcomeBanner = new JLabel("Welcome to My Swing GUI!");
        // To set the position and size of the label
        lblWelcomeBanner.setBounds(50, 20, 500, 50);
        // To set font style
        lblWelcomeBanner.setFont(new Font("Arial", Font.BOLD, 20));
        return lblWelcomeBanner;
    }

    // The Method to update the word count label
    private void updateWordCount(String text) {
        // To split the words and put them in an array of strings
        String[] words = text.trim().split("\\s+");
        // To get the count if the array has words or get zero if there is nothing
        int wordCount = (text.isEmpty()) ? 0 : words.length;
        // To update the word count label
        lblWordCount.setText("Word Count: " + wordCount);
    }

    // The method to make the window visible
    public void show() {
        // To set the window visibility to true to enable the window to be visible
        window.setVisible(true);

    }
}
