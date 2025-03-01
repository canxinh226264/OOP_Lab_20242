import java.util.Scanner;

public class TwoDouble
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 double number(a b): ");
        Double a = sc.nextDouble();
        Double b = sc.nextDouble();
        Double quotient = (b != 0) ? (a / b) : null;
        System.out.println("Sum = "+(a+b));
        System.out.println("Difference = "+(a-b));
        System.out.println("Product = "+(a*b));
        System.out.println("Quotient = "+quotient);
    }
}
