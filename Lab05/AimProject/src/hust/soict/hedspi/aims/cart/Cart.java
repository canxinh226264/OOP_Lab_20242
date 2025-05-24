package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED =20;

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    private FilteredList<Media> filteredItemsOrdered = new FilteredList<>(itemsOrdered, p -> true);

    public void addMedia(Media media) throws LimitExceededException {
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added item" + media.getTitle() +  "to the cart");

        }else{
            throw new LimitExceededException("ERROR : The cart has reached the maximum number of items");
        }
    }

    public void removeMedia(Media media) {
        if(itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed item" + media.getTitle() +  "from the cart");
        }else{
            System.out.println("The cart has no item" + media.getTitle());
        }
    }



    public void printCart(){
        System.out.println("***********************CART***********************\n");
        for(int i = 0; i < itemsOrdered.size(); i++){
            System.out.println((i+1) + ". "  + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost : " + totalCost() + "\n");
        System.out.println("***********************CART***********************\n");

    }




    public float totalCost(){
        float  total = 0;
        for(Media media : itemsOrdered){
            total+=media.getCost();
        }
        return total;
    }


    public Media searchByTitle(String title){
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void searchById(int id){
        boolean found = false;
        for(int i=0; i< itemsOrdered.size() ;i++){
            if(itemsOrdered.get(i).getId() == id){
                System.out.println("We found your DVD :  " + itemsOrdered.get(i).toString());
                found = true;
            }
        }
        if(!found){
            System.out.println("The cart has no DVD with id " + id);
        }
    }
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("Cart is empty!");
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }


    public FilteredList<Media> getFilteredItemsOrdered() {
        return filteredItemsOrdered;
    }

    public void setFilteredItemsOrdered(FilteredList<Media> filteredItemsOrdered) {
        this.filteredItemsOrdered = filteredItemsOrdered;
    }

    // Lọc và in ra media theo tiêu đề chứa từ khóa
    public void filterByTitle(String keyword) {
        System.out.println("Filtered items containing '" + keyword + "':");
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(media.toString());
            }
        }
    }

    // "Đặt hàng" = in giỏ và xóa hết
    public void placeOrder() {
        System.out.println("Order placed successfully!");
        itemsOrdered.clear();
    }
}