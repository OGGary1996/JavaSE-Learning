package training.tutorialAdvanced.f_interface;

public class Rabbit extends Animal{
    public Rabbit(){
        super();
    }
    public Rabbit(String name, int age){
        super(name,age);
    }

    @Override
    public void eat(){
        System.out.println("Rabbit eat grass");
    }

}
