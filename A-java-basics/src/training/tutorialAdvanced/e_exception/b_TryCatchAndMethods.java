package training.tutorialAdvanced.e_exception;

public class b_TryCatchAndMethods {
    public static void main(String[] args) {
        // 通过try-catch语句来捕获异常
        int a = 10 ;
        int b = 0 ;
        try{
            System.out.println(a / b);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        // 执行逻辑：
            // 1. 先执行try语句块中的代码，如果try中的语句没有异常，则catch语句块不会执行，然后执行try-catch之外的语句
            // 2. 如果try中的语句有误，则有误的语句之后的语句不会执行，跳转到catch语句块，然后执行try-catch之外的语句
            // 3. 如果try中的语句有误，并且catch中的异常类型不符合，则默认交给JVM处理，程序中断，并且try-catch之外的语句不会执行
            // 4. 如果try中可能含有多种异常，则可以使用多个catch语句块来捕获不同的异常，适用于不同的处理方式，如果多个异常采用相同的处理方式，则可以使用一个catch语句块来捕获多个异常
        int[] arr = {1,2,3,4,5};
        try {
            System.out.println(a / b);
            System.out.println(arr[5]);
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException ->");
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException ->");
            e.printStackTrace();
        }
        System.out.println("try-catch之外的语句");

        // 通过方法来捕获异常
            // 1.getMessage()：获取异常信息,这个消息是简单的异常信息
            // 2.toString()：获取异常信息,这个消息是详细的异常信息,包含了异常的类名和异常信息
            // 3.printStackTrace()：获取异常信息,这个消息是详细的异常信息,包含了异常的类名和异常信息,并且打印了异常的调用栈
                // 3.1 只是作为打印语句，并不会影响程序的执行，也不会关闭JVM；
                // 3.2 这个方法是打印到控制台的，不能直接获取到异常信息，并且底层使用System.err.println()来打印的
    }
}
