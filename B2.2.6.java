import java.util.Scanner;

public class Multipurpose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Make your choice:");
        System.out.println("1. The first-degree equation (linear equation) with one variable");
        System.out.println("2. The system of first-degree equations (linear system) with two variables");
        System.out.println("3. The second-degree equation with one variable");
        System.out.print("Your choice: ");
        
        int n = sc.nextInt();
        
        if (n == 1) {
            System.out.println("a*x + b = 0");
            System.out.print("Enter the value of a: ");
            double a = sc.nextDouble();
            System.out.print("Enter the value of b: ");
            double b = sc.nextDouble();
            
            if (a == 0) {
                System.out.println("No solution");
            } else {
                System.out.println("x = " + (-b / a));
            }
        } else if (n == 2) {
            System.out.println("a11 * x1 + a12 * x2 = b1");
            System.out.println("a21 * x1 + a22 * x2 = b2");
            
            System.out.print("Enter the value of a11, a12, b1: ");
            double a11 = sc.nextDouble();
            double a12 = sc.nextDouble();
            double b1 = sc.nextDouble();
            
            System.out.print("Enter the value of a21, a22, b2: ");
            double a21 = sc.nextDouble();
            double a22 = sc.nextDouble();
            double b2 = sc.nextDouble();
            
            double determinant = a11 * a22 - a12 * a21;
            
            if (determinant == 0) {
                if (a11 * b2 == a21 * b1 && a12 * b2 == a22 * b1) {
                    System.out.println("Infinite solutions");
                } else {
                    System.out.println("No solution");
                }
            } else {
                double x1 = (b1 * a22 - b2 * a12) / determinant;
                double x2 = (a11 * b2 - a21 * b1) / determinant;
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        } else if (n == 3) {
            System.out.println("a*x^2 + b*x + c = 0");
            System.out.print("Enter the value of a, b, c: ");
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            
            double d = b * b - 4 * a * c;
            
            if (d < 0) {
                System.out.println("No solution");
            } else if (d == 0) {
                System.out.println("x1 = x2 = " + (-b / (2 * a)));
            } else {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
