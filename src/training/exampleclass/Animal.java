package training.exampleclass;

public class Animal {
    public String animalName;
    public void eat(){
        System.out.println(animalName + " is eating.");
    }
    public void sund(){
        System.out.println("Animal makes a sund.");
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
