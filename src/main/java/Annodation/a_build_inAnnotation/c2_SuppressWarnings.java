package Annodation.a_build_inAnnotation;

class test03{
    @Deprecated
    public static void oldMethod(){
        System.out.println("This method is outdated, IDE will throw a warning");
    }
}

public class c2_SuppressWarnings {
    @SuppressWarnings("deprecation") // 传入参数为"deprecation"，表示忽略过时方法的警告
    public static void main(String[] args) {
        test03.oldMethod();
    }
}
