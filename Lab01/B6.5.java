import java.util.Scanner;

public class Sum_Average {
    public static void swap(Double[] a, int i, int j) {
        Double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Double a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static double sum(Double a[], int n) {
        double t = 0;
        for (int i = 0; i < n; i++) {
            t += a[i];
        }
        return t;
    }

    public static double average(Double a[], int n) {
        double t = sum(a, n);
        return t / n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Double a[] = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        sc.close();
        
        sort(a, n);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        System.out.println("Sum=" + sum(a, n));
        System.out.println("Average=" + average(a, n));
    }
}
