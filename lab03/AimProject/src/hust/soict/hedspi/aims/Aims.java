package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Playable;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Thêm media mẫu vào store
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
        store.addMedia(new Book(2, "Harry Potter", "Fantasy", 12.5f));
        store.addMedia(new CompactDisc(3, "Chill Beats", "Lo-fi", 15.99f, 40, "Lo-fi Studio", "DJ Chill"));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    store.displayStore();
                    storeMenu(scanner);
                    break;
                case 2:
                    updateStoreMenu(scanner);
                    break;
                case 3:
                    cart.printCart();
                    cartMenu(scanner);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        System.out.println(media.toString());
                        if (media instanceof Playable) {
                            mediaDetailsMenu(scanner, media);
                        }
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter media title to add to cart: ");
                    String addTitle = scanner.nextLine();
                    Media mediaToAdd = store.searchByTitle(addTitle);
                    if (mediaToAdd != null) {
                        cart.addMedia(mediaToAdd);
                        System.out.println("Media added to cart.");
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    String playTitle = scanner.nextLine();
                    Media mediaToPlay = store.searchByTitle(playTitle);
                    if (mediaToPlay instanceof Playable) {
                        ((Playable) mediaToPlay).play();
                    } else {
                        System.out.println("Media not found or not playable.");
                    }
                    break;
                case 4:
                    cart.printCart();
                    break;
            }
        } while (choice != 0);
    }

    public static void mediaDetailsMenu(Scanner scanner, Media media) {
        int choice;
        do {
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media is not playable.");
                    }
                    break;
            }
        } while (choice != 0);
    }

    public static void updateStoreMenu(Scanner scanner) {
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (choice == 1) {
            if (media != null) {
                System.out.println("Media already exists.");
            } else {
                // Tạm thời thêm DVD cho đơn giản
                store.addMedia(new DigitalVideoDisc(99, title, "Unknown", 9.99f, 100, "Unknown"));
                System.out.println("Media added.");
            }
        } else if (choice == 2) {
            if (media != null) {
                store.removeMedia(media);
                System.out.println("Media removed.");
            } else {
                System.out.println("Media not found.");
            }
        }
    }

    public static void cartMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title to filter: ");
                    String title = scanner.nextLine();
                    cart.filterByTitle(title);
                    break;
                case 2:
                    cart.sortByTitleCost();
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scanner.nextLine();
                    Media mediaToRemove = cart.searchByTitle(removeTitle);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                        System.out.println("Media removed.");
                    } else {
                        System.out.println("Not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String titleToPlay = scanner.nextLine();
                    Media media = cart.searchByTitle(titleToPlay);
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media is not playable.");
                    }
                    break;
                case 5:
                    cart.placeOrder();
                    break;
            }
        } while (choice != 0);
    }
}
