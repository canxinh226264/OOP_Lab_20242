package hust.soict.hedspi.garbage;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        int n = 10000;

        // Dùng String ( + operator )
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("Time using String (+): " + (end - start) + " ms");

        // Dùng StringBuilder
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Time using StringBuilder: " + (end - start) + " ms");

        // Dùng StringBuffer
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Time using StringBuffer: " + (end - start) + " ms");
    }
}
