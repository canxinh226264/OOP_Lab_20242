package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Integer:"));
        tfInput = new JTextField(10);
        cp.add(tfInput);

        cp.add(new JLabel("The Accumulated Sum is:"));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numberIn = Integer.parseInt(tfInput.getText());
                    sum += numberIn;
                    tfInput.setText("");
                    tfOutput.setText(String.valueOf(sum));
                } catch (NumberFormatException ex) {
                    tfInput.setText("");
                    tfOutput.setText("Invalid input");
                }
            }
        });

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }
}
