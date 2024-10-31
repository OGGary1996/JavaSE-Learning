package training.tutorial;
// 在创建child class 的object时会先调用parent class的constructor 然后再调用子类的constructor
//  super()；所有的constructor中第一句都是一个默认的语句 super()；
//  1、super()的意思是调用当前class的parent class中的constructor，默认super()，无参数 所以会默认调用parent class中的default constructor
//  2、如果parent class中只有一个parameterized constructor，那么必须要指定child class中的constructor中的super()中的参数 不然就会报错。
//  this(); this()方法会调用一次当前class中的constructor,
//  1、同样 如果this()为空 则调用当前class的中default constructor，
//  2、如果this()有参数，则会调用当前class中的parameterized constructor
class AAA{
    public AAA(){
        super();
        System.out.println("In AAA's default constructor.");
    }
    
    public AAA(int n){
        super();
        System.out.println("In AAA's parameterized constructor.");
    }
}

class BBB extends AAA{
    public BBB(){
        super();
        System.out.println("In BBB's default constructor.");
    }
    public BBB(int n){
        super(n);
        System.out.println("In BBB's parameterized constructor.");
    }
}
public class l_Inheritance3_super_this {
    public static void main(String[] args){
        BBB object1 = new BBB(); // 不传递参数 此时会调用class B中default constructor，其中因为是super()， 又会调用A中的default constructor
       
        System.out.println("");
       
        BBB object2 = new BBB(5); // 传递参数 此时会调用class B中的parameterized constructor，因为其中有super(n)，又会调用A中的parameterized constructor

    }
}
