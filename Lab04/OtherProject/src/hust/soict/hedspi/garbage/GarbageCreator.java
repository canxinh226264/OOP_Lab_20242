package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "input.txt";  // Đường dẫn tới file văn bản lớn

        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line;
            String text = "";

            long start = System.currentTimeMillis();
            while ((line = in.readLine()) != null) {
                text += line + "\n";  // Sử dụng '+' → tạo nhiều đối tượng String
            }
            long end = System.currentTimeMillis();

            System.out.println("Finished reading file with + in: " + (end - start) + " ms");
            in.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
