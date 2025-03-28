package training.tutorialAdvanced.e_exception;


// 异常分为两种：
// 1. Checked Exception：编译时异常，必须处理，否则编译不通过
    // 1.1 Checked Exception在编译时必须要处理，因为有些操作是有可能失败的，比如文件操作、网络操作等
// 2. Unchecked Exception：运行时异常，编译时不检查，但运行时会抛出异常
    // 2.1 Unchecked Exception在编译时不检查，但运行时会抛出异常，比如除数为0、数组越界等
    // 2.2 这些操作也可以失败，但编译器不强制要求处理；但是失败之后不会运行后续的代码
public class a_Exceptions {
    public static void main(String[] args) {
        // JVM默认处理异常的方式（即不手动处理异常）
        System.out.println(2/0); // 0会抛出ArithmeticException异常
        // 后续的代码不会执行
        System.out.println("Hello World"); // 这行代码不会执行
    }
}
