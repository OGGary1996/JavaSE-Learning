package exercise;

import java.util.Scanner;

public class midtermQuestion2 {
    public static void main(String[] args){

        int num1;
        int num2;
        int num3;
        while (true) {
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Input number 1: ");
            num1 = scan2.nextInt();
            scan2.close();
            if (num1 > 0 ){
                break;
            }
            else{
                System.out.println("Invalid input");
                continue;
            }
        }

        while (true) {
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Input number 2: ");
            num2 = scan2.nextInt();
            scan2.close();
            if (num2 > 0 ){
                 break;
            }
            else{
                System.out.println("Invalid input");
                continue;
            }
        }

        while (true) {
            Scanner scan2 = new Scanner(System.in);
            System.out.println("Input number 3: ");
            num3 = scan2.nextInt();
            scan2.close();
            if (num3 > 0 ){
                 break;
            }
            else{
                System.out.println("Invalid input");
                continue;
            }
        }

        if (num1 < num2 && num1 < num3){
            System.out.println("The smallest of the numbers "+ num1 + "," + num2 + "," + num3 + " is the number " + num1 + ".");
        }
        else if (num2 < num1 && num2 < num3){
            System.out.println("The smallest of the numbers "+ num1 + "," + num2 + "," + num3 + " is the number " + num2 + ".");  
        }
        else{
            System.out.println("The smallest of the numbers "+ num1 + "," + num2 + "," + num3 + " is the number " + num3 + ".");
        }
    }
}
