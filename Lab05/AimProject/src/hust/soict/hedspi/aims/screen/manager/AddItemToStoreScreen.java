package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField tfTitle, tfCategory, tfCost;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new GridLayout(5, 2, 5, 5));

        cp.add(new JLabel("Title: "));
        tfTitle = new JTextField(20);
        cp.add(tfTitle);

        cp.add(new JLabel("Category: "));
        tfCategory = new JTextField(20);
        cp.add(tfCategory);

        cp.add(new JLabel("Cost: "));
        tfCost = new JTextField(20);
        cp.add(tfCost);

        // Các field đặc biệt (thêm ở subclass)
        addSpecificFields(cp);

        JButton btnSubmit = new JButton("Submit");
        cp.add(btnSubmit);
        btnSubmit.addActionListener(e -> submitForm());

        setTitle("Add Item To Store");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    protected abstract void addSpecificFields(Container cp);

    protected abstract void submitForm();
}
