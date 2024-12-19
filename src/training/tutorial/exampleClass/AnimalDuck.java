package training.tutorial.exampleclass;

import training.tutorial.exampleinterface.Flyable;
import training.tutorial.exampleinterface.Swimmable;

public class AnimalDuck implements Flyable ,Swimmable { // 一个class继承多个interface，用逗号隔开
    public void fly(){
        System.out.println("Duck can fly");
    }

    public void swim(){
        System.out.println("Duck can swim");
    }
};
