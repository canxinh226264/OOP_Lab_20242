package hust.soict.hedspi.test.screen.customer;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Store store = new Store();
        Cart cart = new Cart();

        cart.addMedia(new DigitalVideoDisc("Interstellar", "Sci-Fi", 22.0f));
        cart.addMedia(new Book("Clean Code", "Programming", 35.0f));

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
        loader.setController(new CartController(cart,store));

        Parent root = loader.load();
        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
