package hust.soict.hedspi.aims.screen.customer.controller;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;


public class CartController {
    private final Store store;
    private final Cart cart;
    public CartController(Cart cart, Store store){
        this.cart = cart;
        this.store = store;
    }



    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;


    @FXML
    private TextField tfFilter;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterGroup;

    @FXML
    private TableView<Media> tblMedia;



    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                dvd.play();

                // Display the dialog pane
                javafx.scene.control.Dialog<Button> dialog = new javafx.scene.control.Dialog<>();
                DialogPane dialogPane = new DialogPane();
                dialogPane.setHeaderText("Playing: " + dvd.getTitle());
                dialogPane.setContentText("Media is now playing...");

                Label details = new Label(
                        "Length: " + dvd.getLength() + " minutes\n" +
                                "Director: " + dvd.getDirector() + "\n" +
                                "Category: " + dvd.getCategory()
                );
                dialogPane.setExpandableContent(details);
                ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
                dialogPane.getButtonTypes().add(closeButton);
                dialog.setDialogPane(dialogPane);
                dialog.showAndWait();

            } else if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                cd.play();

                // Display the dialog pane
                javafx.scene.control.Dialog<Button> dialog = new javafx.scene.control.Dialog<>();
                DialogPane dialogPane = new DialogPane();
                dialogPane.setHeaderText("Playing: " + cd.getTitle());
                dialogPane.setContentText("Media is now playing...");

                Label details = new Label(
                        "Length: " + cd.getLength() + " minutes\n" +
                                "Director: " + cd.getDirector() + "\n" +
                                "Category: " + cd.getCategory()
                );
                dialogPane.setExpandableContent(details);
                ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
                dialogPane.getButtonTypes().add(closeButton);
                dialog.setDialogPane(dialogPane);
                dialog.showAndWait();
            }
        }
    }


    void updateCostLabel(){
        float totalCost = 0;
        for (Media media: cart.getItemsOrdered()){
            totalCost += media.getCost();
        }
        costLabel.setText( totalCost + "$");
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateCostLabel();

    }

    @FXML
    void viewStorebtnPressed(ActionEvent event) {
        try{
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));
            ViewStoreController controller = new ViewStoreController(store,cart);
            fxmlloader.setController(controller);

            Parent root = fxmlloader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    @FXML
    public void initialize(){
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        SortedList<Media> sortedList = new SortedList<>(filteredList);

        // Cài đặt filter khi thay đổi text hoặc radio button
        tfFilter.textProperty().addListener((obs, oldVal, newVal) -> {
            filteredList.setPredicate(media -> {
                if (newVal == null || newVal.isEmpty()) return true;
                String filter = newVal.toLowerCase();
                if (radioBtnFilterId.isSelected()) {
                    return String.valueOf(media.getId()).contains(filter);
                } else {
                    return media.getTitle().toLowerCase().contains(filter);
                }
            });
        });

        ChangeListener<Boolean> radioListener = (obs, oldVal, newVal) -> {
            if (newVal) {
                // Khi radio thay đổi, cập nhật filter và comparator
                String filter = tfFilter.getText().toLowerCase();
                filteredList.setPredicate(media -> {
                    if (filter.isEmpty()) return true;
                    if (radioBtnFilterId.isSelected()) {
                        return String.valueOf(media.getId()).contains(filter);
                    } else {
                        return media.getTitle().toLowerCase().contains(filter);
                    }
                });

                // Cập nhật comparator theo radio được chọn
                if (radioBtnFilterId.isSelected()) {
                    sortedList.setComparator((m1, m2) -> Integer.compare(m1.getId(), m2.getId()));
                } else {
                    sortedList.setComparator((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
                }
            }
        };

        radioBtnFilterId.selectedProperty().addListener(radioListener);
        radioBtnFilterTitle.selectedProperty().addListener(radioListener);

        // Set comparator mặc định
        if (radioBtnFilterId.isSelected()) {
            sortedList.setComparator((m1, m2) -> Integer.compare(m1.getId(), m2.getId()));
        } else {
            sortedList.setComparator((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
        }

        tblMedia.setItems(sortedList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldMedia, newMedia) -> {
            updateButtonBar(newMedia);
        });

        updateCostLabel();
    }



    @FXML


    void updateButtonBar(Media media){
        if (media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }else{
            btnRemove.setVisible(true);
            if (media instanceof Playable){
                btnPlay.setVisible(true);
            }else{
                btnPlay.setVisible(false);
            }

        }
    }



    void showFilteredMedia(String filter) {
        if (radioBtnFilterId.isSelected()) {
            // Filter by ID
            cart.getFilteredItemsOrdered().setPredicate(media -> String.valueOf(media.getId()).contains(filter));
        } else if (radioBtnFilterTitle.isSelected()) {
            // Filter by Title
            cart.getFilteredItemsOrdered().setPredicate(media -> media.getTitle().toLowerCase().contains(filter.toLowerCase()));
        }
    }


    @FXML
    void placeOrderbtnPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty. Please add items before placing an order.");
            alert.showAndWait();
        } else {
            cart.emptyCart();
            updateCostLabel();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Placed");
            alert.setHeaderText(null);
            alert.setContentText("Your order has been successfully placed!");
            alert.showAndWait();
        }
    }





}