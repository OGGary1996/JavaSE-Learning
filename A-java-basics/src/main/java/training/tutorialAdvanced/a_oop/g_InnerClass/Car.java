package training.tutorialAdvanced.a_oop.g_InnerClass;

public class Car {
    String carBrand;
    String carColor;
    int carAge;
    Engine engine;

    private class Engine {
        // 内部类可以直接访问外部类的成员变量和方法，包括私有的成员变量和方法
        private String engineBrand;
        private int enginePower;
    }

    public Car(){
        this.engine = new Engine();
    }
    public Car(String carBrand, String carColor, int carAge){
        this.carBrand = carBrand;
        this.carColor = carColor;
        this.carAge = carAge;
        this.engine = new Engine();
    }

    public void carInfo(){
        System.out.println("Car brand: " + carBrand);
        System.out.println("Car color: " + carColor);
        System.out.println("Car age: " + carAge);
    }

    // 无法直接访问内部类的成员变量和方法，必须先创建内部类的对象
    // 提供方法创建内部类的对象
    public Engine createEngine(){
        return new Engine();
    }
    // 提供方法访问内部类的成员变量和方法
    public void setEngineBrand(String engineBrand){
        this.engine.engineBrand = engineBrand;
    }
    public String getEngineBrand(){
        return this.engine.engineBrand;
    }
    public void setEnginePower(int enginePower){
        this.engine.enginePower = enginePower;
    }
    public int getEnginePower(){
        return this.engine.enginePower;
    }
    public void engineInfo(){
        System.out.println("Engine brand: " + engine.engineBrand);
        System.out.println("Engine power: " + engine.enginePower);
    }




}
