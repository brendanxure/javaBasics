/*
  Program title:         Cypher GUI
  Program Author:        Brendan Obilo
                         100952871
  Date:                  16/08/2024

  Description:           A graphical user interface that is used Encrypt and decrypt messages entered by user
                         by typing the message or opening a text file and populating its content on a message
                         and also saves the content on the message area on a text file in the computer.
 */

// java imports
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;


public class MyWindow {
    // To establish the Main JFrame window for the GUI
    private final JFrame window;

    // The Constructor for MyWindow class
    public MyWindow() {
        // To create a window object using the JFrame to design the GUI
        window = new JFrame();
        // To set the title of the window
        window.setTitle("My Cypher GUI");
        // To close the window when 'Exit' is clicked
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // To set the size of the window
        window.setSize(600, 700);
        // To center the window on the screen
        window.setLocationRelativeTo(null);

        // To create buttons for Encrypt, Decrypt, and Exit functionalities
        JButton btnEncrypt = new JButton("Encrypt");
        JButton btnDecrypt = new JButton("Decrypt");
        JButton btnExit = new JButton("Exit");

        // To create buttons for Save, Open functionalities for above and beyond
        JButton btnSave = new JButton("Save");
        JButton btnOpen = new JButton("Open");

        // To Create a ButtonGroup to group the radio buttons
        ButtonGroup radioButtonGroup = new ButtonGroup();

        // To create and add a welcome banner using styled fonts
        JLabel lblWelcomeBanner = getLabel();
        window.add(lblWelcomeBanner);

        // To create a Label for Base Alphabets
        JLabel lblBaseAlphabets = new JLabel("Base Alphabets:");
        // To set the position and size of the Base Alphabets Label
        lblBaseAlphabets.setBounds(10,70,120,30);
        // To align the position of the Label
        lblBaseAlphabets.setHorizontalAlignment(SwingConstants.RIGHT);
        // To add the Base alphabet label to the window
        window.add(lblBaseAlphabets);

        // To create a JTextArea for Base Alphabets Options are listed
        JTextArea textBaseAlphabets = new JTextArea();
        // To set the position and size of the text area
        textBaseAlphabets.setBounds(150, 70, 300, 50);
        // To disable the textarea to avoid editing by user
        textBaseAlphabets.setEnabled(false);
        textBaseAlphabets.setEditable(false);
        // To Set the background colour to be gray
        textBaseAlphabets.setBackground(Color.lightGray);
        // To set the colour of the text information
        textBaseAlphabets.setDisabledTextColor(Color.black);
        // To wrap the default COSC values
        textBaseAlphabets.setWrapStyleWord(true);
        textBaseAlphabets.setLineWrap(true);
        // To create tooltip for text area
        textBaseAlphabets.setToolTipText("List of available Base alphabet options");
        // To input default options for base alphabets
        textBaseAlphabets.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        // To Add padding to the JTextArea using an EmptyBorder
        textBaseAlphabets.setBorder(new EmptyBorder(5, 5, 5, 5));
        // To add the text area to the window
        window.add(textBaseAlphabets);

        // To create a Label for COSC Alphabets
        JLabel lblCoscAlphabets = new JLabel("COSC Alphabets:");
        // To set the position and size of the COSC Alphabets Label
        lblCoscAlphabets.setBounds(10,150,120,30);
        // To align the position of the Label
        lblCoscAlphabets.setHorizontalAlignment(SwingConstants.RIGHT);
        window.add(lblCoscAlphabets);

        // To create a JTextArea for COSC Alphabets Options are listed
        JTextArea textCoscAlphabets = new JTextArea();
        // To set the position and size of the text area
        textCoscAlphabets.setBounds(150, 150, 300, 50);
        // To disable the textarea to avoid editing by user
        textCoscAlphabets.setEnabled(false);
        textCoscAlphabets.setEditable(false);
        // To Set the background colour to be gray
        textCoscAlphabets.setBackground(Color.lightGray);
        // To set the colour of the text information
        textCoscAlphabets.setDisabledTextColor(Color.black);
        // To wrap the default COSC values
        textCoscAlphabets.setWrapStyleWord(true);
        textCoscAlphabets.setLineWrap(true);
        // To create tooltip for text area
        textCoscAlphabets.setToolTipText("List of available COSC alphabet options");
        // To input default options for base alphabets
        textCoscAlphabets.setText("YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop");
        // To Add padding to the JTextArea using an EmptyBorder
        textCoscAlphabets.setBorder(new EmptyBorder(5, 5, 5, 5));
        // To add the text area to the window
        window.add(textCoscAlphabets);

        // To create a substitution radio button
        JRadioButton radioSubstitution = new JRadioButton();
        // To set position and size of the substitution radio button
        radioSubstitution.setBounds(150,200,20,32);
        // To set Tooltip for the substitution radio button
        radioSubstitution.setToolTipText("Select Substitution");
        // To add the radio for substitution to window
        window.add(radioSubstitution);

        // To create Label for the substitution radio button
        JLabel lblSubstitution = new JLabel("Substitution");
        // To set position and size of the substitution Label
        lblSubstitution.setBounds(170,200,120,30);
        // To add the label for substitution to window
        window.add(lblSubstitution);

        // To create a translation radio button
        JRadioButton radioTranslation = new JRadioButton();
        // To set position and size of the translation radio button
        radioTranslation.setBounds(300,200,20,32);
        // To set Tooltip for the translation radio button
        radioTranslation.setToolTipText("Select Translation");
        // To add the radio button for translation  to window
        window.add(radioTranslation);

        // To create Label for the translation radio button
        JLabel lblTranslation = new JLabel("Translation");
        // To set position and size of the translation Label
        lblTranslation.setBounds(320,200,120,30);
        // To add the label for translation  to window
        window.add(lblTranslation);

        // To set the radio substitution to selected by default
        radioSubstitution.setSelected(true);

        // To add the radio buttons to the group
        radioButtonGroup.add(radioSubstitution);
        radioButtonGroup.add(radioTranslation);


        // To create label for the message box
        JLabel lblMessage = new JLabel("Message:");
        // To set position and size of the message label
        lblMessage.setBounds(10,250,120,30);
        // To align the position of the Label to the right
        lblMessage.setHorizontalAlignment(SwingConstants.RIGHT);
        // To add label to window
        window.add(lblMessage);

        // To create message text area
        JTextArea textMessage = new JTextArea();
        // To set position and size of the message text area
        textMessage.setBounds(150,250,300,100);
        // To wrap the message
        textMessage.setWrapStyleWord(true);
        textMessage.setLineWrap(true);
        // To create tooltip for text area
        textMessage.setToolTipText("Please enter message here");
        // To Add padding to the JTextArea using an EmptyBorder
        textMessage.setBorder(new EmptyBorder(5, 5, 5, 5));
        // To add text area to window
        window.add(textMessage);

        // To create a notification for Message input
        JLabel infoMessage = new JLabel("");
        // To set position and size of the Message notification
        infoMessage.setBounds(460,250,70,30);
        // To align the position the info label
        infoMessage.setHorizontalAlignment(SwingConstants.LEFT);
        // To add color to the text
        infoMessage.setForeground(Color.red);
        // To add the label to window
        window.add(infoMessage);

        // To create label for the Complexity Key box
        JLabel lblComplexityKey = new JLabel("Complexity key:");
        // To set position and size of the Complexity Key label
        lblComplexityKey.setBounds(10,380,120,30);
        // To align the position of the Label to the right
        lblComplexityKey.setHorizontalAlignment(SwingConstants.RIGHT);
        // To add label to window
        window.add(lblComplexityKey);

        // To create complexity key text area
        JTextArea textComplexityKey = new JTextArea();
        // To set position and size of the complexity key text area
        textComplexityKey.setBounds(150,380,50,30);
        // To create tooltip for text area
        textComplexityKey.setToolTipText("Complexity key for substitution");
        // To Add padding to the JTextArea using an EmptyBorder
        textComplexityKey.setBorder(new EmptyBorder(5, 5, 5, 5));
        // To set active or inactive to allow the user input the right values in right inputs
        textComplexityKey.setEnabled(radioSubstitution.isSelected());
        // To add text area to window
        window.add(textComplexityKey);

        // To create a notification for complexity input
        JLabel infoComplexityKey = new JLabel("");
        // To set position and size of the Complexity Key notification
        infoComplexityKey.setBounds(205,380,115,30);
        // To align the position the info label
        infoComplexityKey.setHorizontalAlignment(SwingConstants.LEFT);
        // To add color to the text
        infoComplexityKey.setForeground(Color.red);
        // To add the label to window
        window.add(infoComplexityKey);

        // To create label for the Shift value box
        JLabel lblShiftValue = new JLabel("Shift value:");
        // To set position and size of the Shift value label
        lblShiftValue.setBounds(270,380,100,30);
        // To align the position of the Label to the right
        lblShiftValue.setHorizontalAlignment(SwingConstants.RIGHT);
        // To add label to window
        window.add(lblShiftValue);

        // To create Shift value text area
        JTextArea textShiftValue = new JTextArea();
        // To set position and size of the Shift value text area
        textShiftValue.setBounds(380,380,50,30);
        // To create tooltip for text area
        textShiftValue.setToolTipText("Shift value for translation");
        // To Add padding to the JTextArea using an EmptyBorder
        textShiftValue.setBorder(new EmptyBorder(5, 5, 5, 5));
        // To set active or inactive
        textShiftValue.setEnabled(radioTranslation.isSelected());
        // To add text area to window
        window.add(textShiftValue);

        // To create a notification for shift value input
        JLabel infoShiftValue = new JLabel("");
        // To set position and size of the Shift value notification
        infoShiftValue.setBounds(435,380,115,30);
        // To align the position the info label
        infoShiftValue.setHorizontalAlignment(SwingConstants.LEFT);
        // To add color to the text
        infoShiftValue.setForeground(Color.red);
        // To add the label to window
        window.add(infoShiftValue);

        // To create label for the result box
        JLabel lblResult = new JLabel("Result:");
        // To set position and size of the result label
        lblResult.setBounds(10,440,120,30);
        // To align the position of the Label to the right
        lblResult.setHorizontalAlignment(SwingConstants.RIGHT);
        // To add label to window
        window.add(lblResult);

        // To create result text area
        JTextArea textResult = new JTextArea();
        // To set position and size of the result text area
        textResult.setBounds(150,440,300,100);
        // To wrap the result
        textResult.setWrapStyleWord(true);
        textResult.setLineWrap(true);
        // To create tooltip for text area
        textResult.setToolTipText("The result");
        // To make background color transparent
        textResult.setBackground(Color.lightGray);
        // To Add padding to the JTextArea using an EmptyBorder
        textResult.setBorder(new EmptyBorder(5, 5, 5, 5));
        // To add text area to window
        window.add(textResult);

        // To add action to substitution radio button
        radioSubstitution.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // To enable complexity key and clear the text area
                textComplexityKey.setEnabled(radioSubstitution.isSelected());
                textComplexityKey.setText("");
                // To disable shift value and clear text area
                textShiftValue.setEnabled(radioTranslation.isSelected());
                textShiftValue.setText("");
                // To clear result area
                textResult.setText(null);
                // To clear all labels
                infoMessage.setText(null);
                infoShiftValue.setText(null);
                infoComplexityKey.setText(null);
            }
        });

        // To add action to translation radio button
        radioTranslation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // To enable shift value and clear text area
                textShiftValue.setEnabled(radioTranslation.isSelected());
                textShiftValue.setText("");
                // To disable complexity key and clear text area
                textComplexityKey.setEnabled(radioSubstitution.isSelected());
                textComplexityKey.setText("");
                // To clear result area
                textResult.setText(null);
                // To clear all labels
                infoMessage.setText(null);
                infoShiftValue.setText(null);
                infoComplexityKey.setText(null);
            }
        });

        // To set position and size of the Encrypt button
        btnEncrypt.setBounds(230, 560, 95, 30);
        // To set a tooltip text
        btnEncrypt.setToolTipText("Click to Encrypt");
        // To set a hot key for the Encrypt button (Alt + E)
        btnEncrypt.setMnemonic(KeyEvent.VK_E);
        // To enable encrypt button perform an action when clicked
        btnEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // To get both complexity key or shift  value
                    String shiftValue = textShiftValue.getText().trim();
                    String complexityKey = textComplexityKey.getText().trim();
                    // To validate is the message text box is empty
                    if(textMessage.getText().isEmpty()){
                        infoMessage.setText("Required");
                    }
                    // To validate if the complexity key box is empty but user selected substitution
                    else if(radioSubstitution.isSelected() && complexityKey.isEmpty()){
                        infoComplexityKey.setText("Required");
                        infoMessage.setText(null);
                    }
                    // To validate if the shift value box is empty but user selected translation
                    else if (radioTranslation.isSelected() && shiftValue.isEmpty()) {
                        infoShiftValue.setText("Required");
                        infoMessage.setText(null);
                    } // To validate which radio button was called and process the encryption
                    else {
                     boolean decidingFactor = radioSubstitution.isSelected()
                             ? validInteger(complexityKey) : validInteger(shiftValue);
                     // To ensure shift or complexity key is an integer
                     if(decidingFactor){
                         // To ensure if substitution was selected then create an object to do the encryption process
                         if(radioSubstitution.isSelected()){
                            Cypher userInput = new Cypher(textMessage.getText(), Integer.parseInt(complexityKey), "S");
                            textResult.setText(userInput.encryptProcedure());
                             // To clear all labels
                             infoMessage.setText(null);
                             infoShiftValue.setText(null);
                             infoComplexityKey.setText(null);
                         } else {
                             // To perform the translation procedure for encryption by creating an object to call the method
                             Cypher userInput = new Cypher(textMessage.getText(), Integer.parseInt(shiftValue), "T");
                             textResult.setText(userInput.translateProcedure());
                             // To clear all labels
                             infoMessage.setText(null);
                             infoShiftValue.setText(null);
                             infoComplexityKey.setText(null);
                         }
                     } else {
                         // To tell user the complexity or shift value is not an integer
                         if(radioSubstitution.isSelected()){
                             infoComplexityKey.setText("Integer required");
                         } else {
                             infoShiftValue.setText("Integer required");
                         }
                     }
                    }
                } catch (Exception ex){
                    textResult.setText(ex.getMessage());
                }
            }
        });
        window.add(btnEncrypt);

        // To set position and size of the Decrypt button
        btnDecrypt.setBounds(340, 560, 95, 30);
        // To set a tooltip text
        btnDecrypt.setToolTipText("Click to Decrypt");
        // To set a hot key for the Decrypt button (Alt + D)
        btnDecrypt.setMnemonic(KeyEvent.VK_D);
        // To enable encrypt button perform an action when clicked
        btnDecrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // To get both complexity key or shift  value
                    String shiftValue = textShiftValue.getText().trim();
                    String complexityKey = textComplexityKey.getText().trim();
                    // To validate is the message text box is empty
                    if(textMessage.getText().isEmpty()){
                        infoMessage.setText("Required");
                    }
                    // To validate if the complexity key box is empty but user selected substitution
                    else if(radioSubstitution.isSelected() && complexityKey.isEmpty()){
                        infoComplexityKey.setText("Required");
                        infoMessage.setText(null);
                    }
                    // To validate if the shift value box is empty but user selected translation
                    else if (radioTranslation.isSelected() && shiftValue.isEmpty()) {
                        infoShiftValue.setText("Required");
                        infoMessage.setText(null);
                    } // To validate which radio button was called and process the encryption
                    else {
                        boolean decidingFactor = radioSubstitution.isSelected()
                                ? validInteger(complexityKey) : validInteger(shiftValue);
                        // To ensure shift or complexity key is an integer
                        if(decidingFactor){
                            // To ensure if substitution was selected then create an object to do the decryption process
                            if(radioSubstitution.isSelected()){
                                Cypher userInput = new Cypher(textMessage.getText(), Integer.parseInt(complexityKey), "S");
                                textResult.setText(userInput.decryptProcedure());
                                // To clear all labels
                                infoMessage.setText(null);
                                infoShiftValue.setText(null);
                                infoComplexityKey.setText(null);
                            } else {
                            // To ensure if the translation was selected and create an object to do the decryption process
                                Cypher userInput = new Cypher(textMessage.getText(), -(Integer.parseInt(shiftValue)), "T");
                                textResult.setText(userInput.translateProcedure());
                                // To clear all labels
                                infoMessage.setText(null);
                                infoShiftValue.setText(null);
                                infoComplexityKey.setText(null);
                            }
                        } else {
                            // To tell user the complexity or shift value is not an integer
                            if(radioSubstitution.isSelected()){
                                infoComplexityKey.setText("Integer required");
                            } else {
                                infoShiftValue.setText("Integer required");
                            }
                        }
                    }
                } catch (Exception ex){
                    textResult.setText(ex.getMessage());
                }
            }
        });
        window.add(btnDecrypt);

        // To set position and size of the Save button
        btnSave.setBounds(10, 560, 95, 30);
        // To set a tooltip text
        btnSave.setToolTipText("Save result to a txt file");
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
                    // To write the contents of the result to the file
                    textResult.write(br);
                    // To clear the text area after saving
                    textMessage.setText("");
                    // To clear result area
                    textResult.setText(null);
                    // To clear complexity key and shift value field
                    textComplexityKey.setText("");
                    textShiftValue.setText("");
                } catch (Exception ex){
                    // To print error message if saving fails
                    textResult.setText(ex.getMessage());
                }
            }
        });
        // To add Save button to the window
        window.add(btnSave);

        // To set position and size of the Open button
        btnOpen.setBounds(120, 560, 95, 30);
        // To set a tooltip text
        btnOpen.setToolTipText("Copy txt file content to Message");
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
                    textMessage.read(br, null);
                    // To clear complexity key and shift value field
                    textComplexityKey.setText("");
                    textShiftValue.setText("");
                } catch (Exception ex){
                    // Print error message if opening fails
                    textResult.setText(ex.getMessage());
                }
            }
        });
        // To add Open button to the window
        window.add(btnOpen);

        // To set position and size of the Exit button
        btnExit.setBounds(450, 560, 95, 30);
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

        // To create an empty label to fill any space that is not used further in the code
        JLabel lblBlank = new JLabel("");
        // To set position and size of the blank label
        lblBlank.setBounds(650,650,5,5);
        // To add blank label to the window
        window.add(lblBlank);

    }

    // A method that converts a string to integer
    private boolean validInteger(String userInput){
        boolean retVal;
        try {
            // To convert string to integer
            int validatedInput = Integer.parseInt(userInput);
            retVal = true;
        } catch (Exception ex){
            retVal = false;
        }
        return retVal;
    }


    private static JLabel getLabel() {
        JLabel lblWelcomeBanner = new JLabel("Welcome to My Cypher GUI!");
        // To set the position and size of the label
        lblWelcomeBanner.setBounds(150, 20, 500, 50);
        // To set font style
        lblWelcomeBanner.setFont(new Font("Arial", Font.BOLD, 20));
        return lblWelcomeBanner;
    }

    // The method to make the window visible
    public void show() {
        // To set the window visibility to true to enable the window to be visible
        window.setVisible(true);

    }
}
