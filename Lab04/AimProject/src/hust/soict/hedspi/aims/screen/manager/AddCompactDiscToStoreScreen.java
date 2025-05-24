package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist, tfLength;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD");
    }

    @Override
    protected void addSpecificFields(Container cp) {
        cp.add(new JLabel("Artist: "));
        tfArtist = new JTextField(20);
        cp.add(tfArtist);

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
            String artist = tfArtist.getText();
            int length = Integer.parseInt(tfLength.getText());

            CompactDisc cd = new CompactDisc(store.getItemsInStore().size() + 1, title, category, cost, length, "Unknown", artist);
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added successfully!");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please check your fields.");
        }
    }
}
