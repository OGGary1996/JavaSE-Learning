package training.tutorial.exampleclass;

public class Animal {
    public String animalName;
 
    public Animal(String animalName){
        this.animalName = animalName;
    }

    public void eat(){
        System.out.println(animalName + " is eating."); 
    }

    public void sound(){
        System.out.println("Animal makes a sund.");
    }
    public void sleep(){
        System.out.println("Animal is sleeping.");
    }

    public static void makeSound(Animal animals){ // 创建一个static method来展示多态，
        animals.sound();                          // 这个方法会根据传递进来的值Animal（固定的种类即父类） animals来自动判断应该调用哪个child class中的sund()方法
    }
    
    @Override
    public String toString(){ // 重写Object class中的默认的toString()方法
        return "made by KE";
    }
    @Override
    public boolean equals(Object obj){ // 重写Object class中的默认的equals()方法
        if (this.animalName.equals(animalName)){ // 传递进来的参数animalName，与本身object的变量进行对比
            return true;
        }
        else{
            return false;
        }
    }
}
