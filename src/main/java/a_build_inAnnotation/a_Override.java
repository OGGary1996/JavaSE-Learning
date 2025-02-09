package a_build_inAnnotation;

class test01{
    public void printMSG(){
        System.out.println("Hello");
    }
}

public class a_Override extends test01{
    @Override
    public void printMSG(){
        System.out.println("Hi");
    }
}
