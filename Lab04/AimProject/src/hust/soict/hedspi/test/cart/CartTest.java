package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Tạo các đối tượng Media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 90, "John Musker");

        Book book1 = new Book(4, "Harry Potter", "Fantasy", 12.5f);
        book1.addAuthor("J.K. Rowling");

        Track track1 = new Track("Intro", 2);
        Track track2 = new Track("Lo-fi Chill", 3);
        CompactDisc cd1 = new CompactDisc(5, "Chill Beats", "Lo-fi", 15.99f, 40, "Lo-fi Studio", "DJ Chill");
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        // Thêm các media vào giỏ
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book1);
        cart.addMedia(cd1);

        // In ra giỏ hàng
        System.out.println("\n=== Initial Cart ===");
        cart.printCart();

        // Kiểm tra tìm kiếm
        System.out.println("\n=== Search by title 'Star Wars' ===");
        Media found = cart.searchByTitle("Star Wars");
        System.out.println(found != null ? found.toString() : "Not found");

        // Lọc theo tiêu đề
        System.out.println("\n=== Filter by title contains 'the' ===");
        cart.filterByTitle("the");

        // Sắp xếp theo tiêu đề rồi giá
        System.out.println("\n=== Sort by Title then Cost ===");
        cart.sortByTitleCost();
        cart.printCart();

        // Sắp xếp theo giá rồi tiêu đề
        System.out.println("\n=== Sort by Cost then Title ===");
        cart.sortByCostTitle();
        cart.printCart();

        // Xóa một media
        System.out.println("\n=== Remove DVD 'Aladdin' ===");
        cart.removeMedia(dvd3);
        cart.printCart();

        // Đặt hàng
        System.out.println("\n=== Place Order ===");
        cart.placeOrder();
        cart.printCart();
    }
}
