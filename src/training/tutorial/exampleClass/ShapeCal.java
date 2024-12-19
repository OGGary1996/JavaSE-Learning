package training.tutorial.exampleclass;

public abstract class ShapeCal {
    protected String name; // protected修饰符，只有本类和子类可以访问
    private String author; //  private修饰符，只有本类可以访问

    public ShapeCal(String name){ // 抽象类也可以有构造函数，因为可以有自己的普通的方法
        this.name = name;
        this.author = "KE";
    }

    public void name(){ // 抽象类中可以有普通方法
        System.out.println("This is a shape calculator: "+name);
    }

    public void author(){ // 本类可以访问private修饰符的变量
        System.out.println("Author: "+author);
    }

    public abstract double area(); // 抽象方法，只有方法名，没有方法体，没有{}

}
