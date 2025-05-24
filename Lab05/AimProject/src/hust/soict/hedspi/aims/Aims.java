package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aims extends Application {

    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));
        ViewStoreController controller = new ViewStoreController(store, cart);
        loader.setController(controller);
        Parent root = loader.load();

        primaryStage.setTitle("AIMS");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        // Thêm media như hình mẫu
        store.addMedia(new DigitalVideoDisc(1, "Harry Potter and the Philosopher's Stone (2001)", "Fantasy", 3.0f, 120, "Chris Columbus"));
        store.addMedia(new DigitalVideoDisc(2, "Harry Potter and the Chamber of Secrets (2002)", "Fantasy", 3.5f, 121, "Chris Columbus"));
        store.addMedia(new DigitalVideoDisc(3, "Harry Potter and the Prisoner of Azkaban (2004)", "Fantasy", 5.0f, 125, "Alfonso Cuarón"));
        store.addMedia(new DigitalVideoDisc(4, "Harry Potter and the Goblet of Fire (2005)", "Fantasy", 4.5f, 130, "Mike Newell"));
        store.addMedia(new DigitalVideoDisc(5, "Harry Potter and the Order of the Phoenix (2007)", "Fantasy", 6.5f, 135, "David Yates"));
        store.addMedia(new DigitalVideoDisc(6, "Harry Potter and the Half-Blood Prince (2009)", "Fantasy", 5.8f, 128, "David Yates"));
        store.addMedia(new DigitalVideoDisc(7, "Harry Potter and the Deathly Hallows – Part 1 (2010)", "Fantasy", 6.3f, 140, "David Yates"));
        store.addMedia(new DigitalVideoDisc(8, "Harry Potter and the Deathly Hallows – Part 2 (2011)", "Fantasy", 7.0f, 141, "David Yates"));
        store.addMedia(new Book(9, "Green Eggs and Ham", "Children", 3.3f));

        launch(args);
    }
}
