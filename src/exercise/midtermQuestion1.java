package exercise;
import java.util.Scanner;
public class midtermQuestion1 {
    public static void main(String[] args){
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Please input the dgrees of fahrenheit :");
        double fahrenheit = scan1.nextDouble();
        double celsius = (fahrenheit - 32) * ( 5.0 / 9.0 );
        System.out.printf("%.0f degrees Fahrenheit is %.2f degrees Celsius.%n",fahrenheit,celsius);
    }
}
