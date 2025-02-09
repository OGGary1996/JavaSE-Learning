package a_build_inAnnotation;

class test02{
    @Deprecated // This annotation indicates that the method is deprecated now
    public void oldMethod(){
        System.out.println("This method is deprecated");
    }
}

public class b_Deprecated { // use oldMethod() in this class
    public static void main(String[] args) {
        test02 obj = new test02();
        obj.oldMethod(); // 编译器会警告这个方法已经过时
    }
}
