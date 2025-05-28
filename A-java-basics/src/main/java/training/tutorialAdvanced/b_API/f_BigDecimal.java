package training.tutorialAdvanced.b_API;

import java.math.BigDecimal;

// BigDecimal类,主要是为了解决浮点数精度问题

public class f_BigDecimal {
    public static void main(String[] args) {
        // 1. 创建BigDecimal对象
            // 1.1 使用字符串创建
        BigDecimal num1 = new BigDecimal("1.2335");
            // 1.2 使用double创建,不推荐，仍然会有精度问题
        BigDecimal num2 = new BigDecimal(1.2335);
            // 1.3 使用valueOf方法创建,推荐
        BigDecimal num3 = BigDecimal.valueOf(1.2335);

        // 2. 使用BigDecimal对象进行运算
        System.out.println("Add: " + num1.add(num2));
        System.out.println("Subtract: " + num1.subtract(num2));
        System.out.println("Multiply: " + num1.multiply(num2));
        System.out.println("Divide: " + num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP)); // 除法需要指定精度和舍入模式
        System.out.println("Power: " + num1.pow(2));
        System.out.println("Max: " + num1.max(num2));
        System.out.println("Min: " + num1.min(num2));

        // 3. 比较BigDecimal对象，不能使用 == ，只能使用compareTo()
        // 返回值：
            // 1：当前对象大于参数对象
            // 0：当前对象等于参数对象
            // -1：当前对象小于参数对象
        int result = num1.compareTo(num2);
        switch (result) {
            case 1 -> System.out.println("num1 > num2");
            case -1 -> System.out.println("num1 < num2");
            case 0 -> System.out.println("num1 = num2");
        }

        // 4. 处理小数的精度
        // 在使用除法时，必须指定精度和舍入模式，否则会抛出ArithmeticException异常
        // BigDecimal num4 = num1.divide(num2); // 会抛出异常
        System.out.println("Divide with precision: " + num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP)); // 指定精度和舍入模式

        BigDecimal num4 = BigDecimal.valueOf(1.235346).setScale(2,BigDecimal.ROUND_HALF_UP);// 保留两位小数,并且四舍五入

        // 5.输出类型
        System.out.println(num3.toString());// 默认
        System.out.println(num3.toPlainString());// 不使用科学计数法
        System.out.println(num3.toEngineeringString());// 科学计数法


    }
}
