package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "input.txt";  // Đường dẫn tới file văn bản lớn

        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line;
            StringBuilder text = new StringBuilder();

            long start = System.currentTimeMillis();
            while ((line = in.readLine()) != null) {
                text.append(line).append("\n");  // Dùng StringBuilder → ít "garbage"
            }
            long end = System.currentTimeMillis();

            System.out.println("Finished reading file with StringBuilder in: " + (end - start) + " ms");
            in.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
