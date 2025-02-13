package Reflection.a_loadAndInitial;

// 本例子模拟展示类创建时的初始化过程

/*
1. 加载：ClassInitial 和a_ClassInitialDemo 被加载到内存中，形成他们对应的Class对象
2. 链接：为两个类的静态变量和final常量分配内存空间，初始化静态变量，此时m=0
3. 初始化：将变量赋值的操作和静态代码块的操作按照顺序合并，按照代码顺序执行
        <clint>(){
            System.out.println("ClassInitial static block");
            m = 100;
            m = 200;
        }
*/

class ClassInitial{
    static{
        System.out.println("ClassInitial static block");
        m = 100;
    }
    static int m = 200;
    public ClassInitial(){
        System.out.println("ClassInitial constructor");
    }
}

public class ClassInitialDemo {
    public static void main(String[] args) {
        ClassInitial classInitial = new ClassInitial();
        System.out.println(ClassInitial.m);
    }
}
