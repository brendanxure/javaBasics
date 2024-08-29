
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MyWindow {
    private JFrame window;

    public MyWindow() {
        window = new JFrame();
        window.setTitle("Worlds Famous Room Design App!");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);

        JButton btnExit = new JButton("Exit");
        JButton btnReset = new JButton("Reset");
        JButton btnCalculate = new JButton("Calculate");

        JLabel lblLength = new JLabel("Length:");
        lblLength.setBounds(50,50,80,30);
        lblLength.setHorizontalAlignment(SwingConstants.RIGHT);
        window.add(lblLength);
        JTextField txtLength = new JTextField("0");
        txtLength.setBounds(150,50,100,30);
        txtLength.setToolTipText("Please enter the length.");
        window.add(txtLength);

        JLabel lblWidth = new JLabel("Width:", SwingConstants.RIGHT);
        lblWidth.setBounds(50,100,80,30);
        window.add(lblWidth);
        JTextField txtWidth = new JTextField("0");
        txtWidth.setBounds(150,100,100,30);
        txtWidth.setToolTipText("Please enter the width.");
        window.add(txtWidth);

        JRadioButton rbMetric = new JRadioButton("Meters");
        rbMetric.setBounds(275, 50, 100, 30);
        rbMetric.setSelected(true);
        rbMetric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnReset.doClick();
            }
        });
        window.add(rbMetric);

        JRadioButton rbImperial = new JRadioButton("Feet");
        rbImperial.setBounds(275, 100, 100, 30);
        rbImperial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnReset.doClick();
            }
        });
        window.add(rbImperial);

        ButtonGroup uom = new ButtonGroup();
        uom.add(rbMetric);
        uom.add(rbImperial);

        JLabel lblArea = new JLabel("The area is ...");
        lblArea.setBounds(150,200,200,30);
        window.add(lblArea);

        JLabel lblPerimeter = new JLabel("The perimeter is ...");
        lblPerimeter.setBounds(150,250,200,30);
        window.add(lblPerimeter);

        JColorChooser ccMine = new JColorChooser();
        ccMine.setBounds(50,300,300,300);
        window.add(ccMine);

        btnReset.setBounds(50,150,95,30);
        btnReset.setToolTipText("Reset the application to starting values.");
        btnReset.setMnemonic(KeyEvent.VK_R);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtLength.setText("0");
                txtWidth.setText("0");
                lblArea.setText("The area is ....");
                lblPerimeter.setText("The perimeter is ....");
                txtLength.setBackground(ccMine.getColor());
                txtWidth.setBackground(ccMine.getColor());

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(window);
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println(selectedFile);
            }
        });
        window.add(btnReset);


        btnCalculate.setBounds(150,150,95,30);
        btnCalculate.setToolTipText("Calculate and report the area and perimeter.");
        btnCalculate.setMnemonic(KeyEvent.VK_C);
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int iLength = 0;
                int iWidth = 0;
                txtLength.setBackground(Color.WHITE);
                txtWidth.setBackground(Color.WHITE);
                lblArea.setText("The area is ...");
                lblPerimeter.setText("The perimeter is ...");
                try {
                    iLength = Integer.parseInt(txtLength.getText());
                    try {
                        iWidth = Integer.parseInt(txtWidth.getText());
                        int iArea = iLength * iWidth;
                        int iPerimeter = (2*iLength) + (2*iWidth);
                        String sUOMArea = rbMetric.isSelected()? "meters" : "feet";
                        String sUOMPerimeter = rbMetric.isSelected()? "square meters" : "square feet";
                        lblPerimeter.setText(String.format("The perimeter is %d %s", iPerimeter, sUOMPerimeter));
                        lblArea.setText(String.format("The area is %d %s", iArea, sUOMArea));
                    }
                    catch (Exception ex){
                        txtWidth.setBackground(Color.RED);
                    }
                }
                catch (Exception ex) {
                    txtLength.setBackground(Color.RED);
                }
            }
        });
        window.add(btnCalculate);


        btnExit.setBounds(250,150,95,30);
        btnExit.setToolTipText("Exit the application.");
        btnExit.setMnemonic(KeyEvent.VK_X);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });
        window.add(btnExit);

        JLabel lblBlank = new JLabel("");
        lblBlank.setBounds(650,650,5,5);
        window.add(lblBlank);

    }


    public void show() {
        window.setVisible(true);
    }
}
