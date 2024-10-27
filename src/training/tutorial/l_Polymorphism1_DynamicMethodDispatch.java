package training.tutorial;
// 多态有两种表现形式 1:method overloading(compile-time polymorphism),2:method overriding(run-time polymorphism)
// method overriding 
//  在java中每一个child class都可以作为parent class的一个object实例，可以在引用parent class是指向其中一个Child class
//  通过这个方式，可以使用同一个parent class指向任意一个child class被overriding的method来实现不同的行为。
//  (无论这个object前面的类型是parent class还是child class，最终创建的new object本身是最重要的关键，这个object决定了要调用哪个class的method)

import training.exampleclass.Animal;
import training.exampleclass.AnimalCat;
import training.exampleclass.AnimalDog;

public class l_Polymorphism1_DynamicMethodDispatch {


    public static void main(String[] args){
        Animal animalDefault = new Animal(""); // 引用父类 指向这个父类
        Animal cat = new AnimalCat("cat1"); // 引用父类 指向其中一个子类Cat()
        Animal dog = new AnimalDog("dog1"); // 引用父类 指向其中一个子类Dog()
        
        Animal.makeSound(animalDefault); // 调用之前的static method
        Animal.makeSound(cat);    // 可以通过集合批量处理多个子类对象
        Animal.makeSound(dog);    
        // static method不是必须的操作，可以直接调用方法，只是需要给每个子类对象单独调用方法
        animalDefault.sound();
        cat.sound();
        dog.sound();
        // ！！！如果是父类引用子类的实例，无法调用子类特有的方法，只能调用父类中的方法或者子类重写的方法

        // 通过对象数组来批量处理多个子类对象
        Animal animals[] = new Animal[2];
        animals[0] = new AnimalCat("cat2");
        animals[1] = new AnimalDog("dog2");

        for (Animal animal : animals){
            Animal.makeSound(animal);
        }
    }
}
