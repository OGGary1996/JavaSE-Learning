package training.tutorial;

public class u_wrapper_class {
    public static void main(String[] args){
        // 包装类将基本数据类型封装成对象，使得基本数据类型具有对象的特性，因为对象可以调用方法，所以基本数据类型也可以调用方法
        // 基本数据类型和包装类之间的转换
        // 基本数据类型转换为包装类
        int a = 10;
        Integer b = new Integer(a); // 通过构造方法，不推荐使用构造方法，因为会产生多余的对象
        Integer c = Integer.valueOf(a);// 显式：通过valueOf方法,是一个static方法，返回一个Integer对象
        Integer d = a; // 隐式：自动装箱 auto-boxing

        // 包装类转换为基本数据类型
        int e = d.intValue();// 显式：通过intValue方法，是一个object方法，返回一个int类型的值
        int f = e; // 隐式：自动拆箱 auto-unboxing

        // 包装类转换为字符串类
        String str = d.toString(); // 通过toString方法,toString()方法在Integer类中被重写，返回的是一个String对象
        // 字符串类转换为包装类
        Integer h = Integer.parseInt(str); // 通过parseInt方法，是一个static方法，返回一个Integer对象

        // 字符串转换为基本数据类型
        int i = Integer.parseInt(str); // 通过parseInt方法，先转换为包装类 然后再隐式转换为基本数据类型

        // 基本数据类型转换为字符串
        String str2 = Integer.toString(i); // 通过toString方法，先转换为包装类 然后再调用toString方法
    }
}
