package training.tutorialAdvanced.a_oop.d_final;

public class a_final {
    public static void main(String[] args) {
        // 1. final修饰的类无法被继承
        // 2. final修饰的方法无法被重写
        // 3. final修饰的变量无法被修改
            // 无法被修改指的是无法修改变量名引用的地址值，但是此时这个变量内部的属性是可以改变的；
            // 这也是为什么String类不可变的原因，在String类中，实际上有一个数组来存储字符串的值，这个数组被private final修饰，private使得无法获取到这个地址，final使得无法更换这个地址
            // 1.example:
        final People P1 = new People("Ke", 20);
        P1.setName("Zhang");
        P1.setAge(30);
        // P1 = new People("Li", 25); // 错误，final修饰的变量无法被修改,不能指向新的对象
            // 2.example2:
        final int[] ARR = {1, 2, 3};
        ARR[0] = 10;
        ARR[1] = 20;
        // ARR = new int[]{4, 5, 6}; // 错误，final修饰的变量无法被修改,不能指向新的对象



    }
}
