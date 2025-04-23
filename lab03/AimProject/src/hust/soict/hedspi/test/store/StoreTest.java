package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Tạo các đối tượng media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");
        Book book1 = new Book(3, "Harry Potter", "Fantasy", 12.5f);
        CompactDisc cd1 = new CompactDisc(4, "Lo-fi Chill", "Music", 15.0f, 60, "Studio Chill", "DJ Lo");

        // Thêm media vào store
        System.out.println("=== Adding media to store ===");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);
        store.addMedia(dvd1); // kiểm thử duplicate

        // Hiển thị store
        System.out.println("\n=== Displaying store ===");
        store.displayStore();

        // Tìm kiếm media
        System.out.println("\n=== Searching for 'Harry Potter' ===");
        Media result = store.searchByTitle("Harry Potter");
        if (result != null) {
            System.out.println("Found: " + result.toString());
        } else {
            System.out.println("Not found.");
        }

        // Xoá media
        System.out.println("\n=== Removing 'Star Wars' ===");
        store.removeMedia(dvd2);
        store.removeMedia(dvd2); // kiểm thử remove không tồn tại

        // Hiển thị store sau khi xoá
        System.out.println("\n=== Displaying store after removal ===");
        store.displayStore();
    }
}
