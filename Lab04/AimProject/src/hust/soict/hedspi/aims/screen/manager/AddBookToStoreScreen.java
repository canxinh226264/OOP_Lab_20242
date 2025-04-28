package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthor;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book");
    }

    @Override
    protected void addSpecificFields(Container cp) {
        cp.add(new JLabel("Author: "));
        tfAuthor = new JTextField(20);
        cp.add(tfAuthor);
    }

    @Override
    protected void submitForm() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String author = tfAuthor.getText();

            Book book = new Book(store.getItemsInStore().size() + 1, title, category, cost);
            book.addAuthor(author);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please check your fields.");
        }
    }
}
