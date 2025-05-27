package Annodation.a_build_inAnnotation;

@FunctionalInterface
interface test04{
    public void execute();
}

public class d_FunctionalInterface {
    public static void main(String[] args) {
        // 使用Lambda表达式实现函数式接口
        test04 obj = () -> System.out.println("Hello");
        obj.execute();
    }
}
