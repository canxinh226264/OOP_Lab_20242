package hust.soict.hedspi.test.screen.customer;

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

public class TestViewStoreScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Tạo store và thêm media
        Store store = new Store();
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f));
        store.addMedia(new Book("Harry Potter", "Fantasy", 12.5f));
        store.addMedia(new CompactDisc("Lo-fi Beats", "Music", 15.0f));

        // Load giao diện
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));
        loader.setController(new ViewStoreController(store));

        Parent root = loader.load();
        primaryStage.setTitle("AIMS Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
