package exercise;
import java.util.Scanner;
public class midtermQuestion4 {
    public static void main(String[] args){
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Please input the String: ");
        String str1 = scan4.next();
        String str2 = "";
        if (str1.length() >= 10){
            str1 = str1.toLowerCase();
            for (int i = str1.length()-1 ; i >= 0 ; i-- ){
                str2 += str1.charAt(i);
            }
        }
        else if (str1.length() < 10){
            str2 = str1.toUpperCase();
        }
        System.out.println("The original String is " + str1 + ", and the processed String is " + str2);
    }
}
