package training.tutorialAdvanced.b_API;

public class h_WrapperClass {
    public static void main(String[] args) {
        // 手动装箱和拆箱
        // Integer a = new Integer("10"); // 已经过时
        Integer classA = Integer.valueOf(10); // 手动装箱,静态方法
        int intA = classA.intValue(); // 手动拆箱，对象方法

        // 自动装箱和拆箱
        Integer classB = 10; // 自动装箱
        int intB = classB; // 自动拆箱

        // 常用方法：
        // 1.将包装类或者基本数据类型转换为字符串，toString()
        String str1 = Integer.toString(classB); // "100"
        String str2 = Integer.toBinaryString(classB); // "1100100" 二进制
        String str3 = Integer.toHexString(intB); // "64" 十六进制
        String str4 = Integer.toOctalString(intB); // "144" 八进制
        // 2. 将String转换为包装类, valueOf()
        Integer classC = Integer.valueOf("100");
        // 3. 将String转换为基本数据类型, parseXxx();
        int intC = Integer.parseInt("100");

    }

}
