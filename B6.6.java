import java.util.Scanner;

public class AddMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int a = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int b = sc.nextInt();

        int[][] a1 = new int[a][b];
        int[][] a2 = new int[a][b];
        int[][] sum = new int[a][b];

        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                a1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                a2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                sum[i][j] = a1[i][j] + a2[i][j];
            }
        }

        System.out.print("Sum = ");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
