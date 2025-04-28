package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD");
    }

    @Override
    protected void addSpecificFields(Container cp) {
        cp.add(new JLabel("Director: "));
        tfDirector = new JTextField(20);
        cp.add(tfDirector);

        cp.add(new JLabel("Length (minutes): "));
        tfLength = new JTextField(20);
        cp.add(tfLength);
    }

    @Override
    protected void submitForm() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(store.getItemsInStore().size() + 1, title, category, cost, length, director);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please check your fields.");
        }
    }
}
