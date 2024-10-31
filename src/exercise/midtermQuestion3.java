package exercise;

public class midtermQuestion3 {
    public static void main(String[] args){
        int i = 1;
        int j = 0;
        int result = 0;
        do {
            if (i % 2 != 0){
                result += i;
                j++;
            }
            i++;
        }
        while ( i <= 20 );
        System.out.println("There are " + j + " odd numbers from 1 to 20 and the sum is :" + result);
    }
}
