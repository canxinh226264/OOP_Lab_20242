package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.MediaComparatorByTitleCost;
import hust.soict.hedspi.aims.media.MediaComparatorByCostTitle;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
        } else if (itemsOrdered.contains(media)) {
            System.out.println("Media is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println("Media added to cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index++ + ". " + media.toString());
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("***************************************************");
    }

    public void filterByTitle(String title) {
        System.out.println("Matching items:");
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found.");
        }
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, new MediaComparatorByTitleCost());
        System.out.println("Cart sorted by title then cost.");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, new MediaComparatorByCostTitle());
        System.out.println("Cart sorted by cost then title.");
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                return media;
            }
        }
        return null;
    }

    public void placeOrder() {
        System.out.println("An order has been created.");
        itemsOrdered.clear();
        System.out.println("The cart is now empty.");
    }
}
