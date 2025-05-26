package training.tutorialAdvanced.c_collections;

public class d_VarArgs {
    public static void main(String[] args) {
        // 可变参数的底层实际上是数组，但是使用更灵活
        int result = sum(1,2,3,4,5,6,7,8,9);
        System.out.println("result = " + result);
        // 1.可变参数必须放在形参的最后面
        // 2.可变参数的数量只能有1个
        // 2.可变参数可以接收任意数量的参数，包括0个参数

    }

    public static int sum(int...numbers){
        int sum = 0;
        for (int number : numbers){
            sum += number;
        }
        return sum;
    }
}
