package hust.soict.hedspi.swing;

import java.awt.*;               // Import AWT components
import java.awt.event.*;          // Import AWT event classes

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));   // 2 hàng 2 cột

        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        tfInput.addActionListener(new TFInputListener());

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}
