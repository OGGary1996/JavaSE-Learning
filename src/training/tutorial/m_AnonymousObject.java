package training.tutorial;

class A{
    A(){ // constructor 
        System.out.println("Object created");
    }
    public void show(){
        System.out.println("A is in show!");
    }
}

public class m_AnonymousObject {
    public static void main(String[] args){
        new A().show();
        new A().show(); // 如果再次调用这个new A(), 则会再次创建一个object，可以从constructor两次运行看出

    }
}
