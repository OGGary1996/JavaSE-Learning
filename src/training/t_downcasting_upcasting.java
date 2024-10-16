package training;

import training.exampleclass.Animal;
import training.exampleclass.Cat;
import training.exampleclass.Dog;

public class t_downcasting_upcasting {
    public static void makesund(Animal animals){ // 创建一个static method来展示多态，
        animals.sund();                          // 这个方法会根据传递进来的值Animal（固定的种类即父类） animals来自动判断应该调用哪个child class中的sund()方法
    }
    
    public static void main(String[] args){
        // upcasting
        // 实际上在实现多态的时候，是通过upcasting来实现的，即将子类对象赋值给父类引用
        Animal animalDefault = new Animal(); // 引用父类 指向这个父类
        Animal animalDog = new Dog(); // 引用父类 指向其中一个子类Dog()
        //  这个写法可以替换为显式的写法
        Cat cat = new Cat();
        Animal animalCat = (Animal) cat; // upcasting
        // 可以通过集合批量处理多个子类对象
        makesund(animalDefault); // 调用之前的static method，因为在同一个class内 方法前面不用写class name
        makesund(animalCat);    
        makesund(animalDog);

        
        // downcasting 向下转型需要前提是已经进行了upcasting，即将子类对象赋值给父类引用，然后再进行downcasting，确保实际类型已经是子类
        // 在downcasting中，需要强制转换，不能使用隐式转换
        Dog dog = (Dog) animalDog; 
        // 子类可以通过集合批量处理多个子类对象
        makesund(dog); // 调用之前的static method，因为在同一个class内 方法前面不用写class name
        // 这里即使dog的类型是Dog，但是因为makesund方法中的参数是Animal类型，所以会自动向上转型为Animal类型
        // 所以不论是子类还是父类 都可以传递给makesund方法
  
    }
}
