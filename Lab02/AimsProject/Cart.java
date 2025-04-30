import java.util.ArrayList;

public class Cart {
    public static final int Max_NUMBER_ORDER = 20;
    private DigitalVideoDisc Order[] = new DigitalVideoDisc[Max_NUMBER_ORDER];
    private int nbDigitalVideoDiscs = 0;
    private ArrayList<DigitalVideoDisc> items = new ArrayList<>();

    // Phương thức nạp chồng: Thêm nhiều đĩa DVD sử dụng mảng
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    // Thêm hai DVD vào giỏ hàng (Overloaded method)
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (nbDigitalVideoDiscs < Max_NUMBER_ORDER) {
            Order[nbDigitalVideoDiscs] = disc;
            nbDigitalVideoDiscs++;
            return true;
        }
        return false;
    }
    public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < nbDigitalVideoDiscs; i++) {
            if (Order[i].equals(disc)) {
                for (int j = i; j < nbDigitalVideoDiscs - 1; j++) {
                    Order[j] = Order[j + 1];
                }
                Order[nbDigitalVideoDiscs - 1] = null;
                nbDigitalVideoDiscs--;
                DigitalVideoDisc.decreaseNbDigitalVideoDiscs();
                return true;
            }
        }
        return false;
    }
    public float totalCost() {
        int total = 0;
        for (int i = 0; i < nbDigitalVideoDiscs; i++) {
            total += Order[i].getCost();
            }
            return total;
    }

    public void printCart() {
        System.out.println("Cart Items:");
        for (int i = 0; i < nbDigitalVideoDiscs; i++) {
            DigitalVideoDisc disc = Order[i];
            System.out.printf("%d\t%s\t%.2f\n", i + 1, disc.getTitle(), disc.getCost());
        }
        System.out.printf("\nTotal Cost:\t%.2f\n", totalCost());
    }
}
