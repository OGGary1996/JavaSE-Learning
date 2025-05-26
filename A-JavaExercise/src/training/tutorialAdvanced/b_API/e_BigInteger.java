package training.tutorialAdvanced.b_API;

import java.math.BigInteger;
import java.util.Random;

public class e_BigInteger {
    public static void main(String[] args) {
        // 1.创建BigInteger对象
            // 1.1 使用字符串创建
        BigInteger bigInt = new BigInteger("1234567890123456789012345678901234567890");
            // 1.2 使用int创建,只能接收long，不能接收int
        BigInteger bigInt2 = BigInteger.valueOf(1098090978);

        // 2.使用BigInteger对象进行运算
        System.out.println("Add: " + bigInt.add(bigInt2));
        System.out.println("Subtract: " + bigInt2.subtract(bigInt));
        System.out.println("Multiply: " + bigInt.multiply(bigInt2));
        System.out.println("Divide: " + bigInt.divide(bigInt2));
        System.out.println("Remainder: " + bigInt.remainder(bigInt2));
        System.out.println("Power: " + bigInt.pow(2));
        System.out.println("Max: " + bigInt.max(bigInt2));
        System.out.println("Min: " + bigInt.min(bigInt2));
        System.out.println("GCD: " + bigInt.gcd(bigInt2));

        // 3.比较BigInteger对象，不能使用 == ，只能使用compareTo()
        // 返回值：
            // 1：当前对象大于参数对象
            // 0：当前对象等于参数对象
            // -1：当前对象小于参数对象
        int result = bigInt.compareTo(bigInt2);
        switch (result) {
            case 1 -> System.out.println("bigInt > bigInt2");
            case -1 -> System.out.println("bigInt < bigInt2");
            case 0 -> System.out.println("bigInt = bigInt2");
        }

        // 4.随机数生成
        // 生成的随机数的底数为0-2，根据传递的参数决定是多少次幂
        BigInteger bigRandom = new BigInteger(10,new Random());
        // 结果是 0 ～ 2^10 - 1
    }

}
