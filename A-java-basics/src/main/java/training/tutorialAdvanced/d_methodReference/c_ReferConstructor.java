package training.tutorialAdvanced.d_methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Actor{
    private String name;
    private int age;
    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Actor (String str){
        String[] arr = str.split(",");
        this.name = arr[0];
        this.age = Integer.parseInt(arr[1]);
    }
}

public class c_ReferConstructor {
    public static void main(String[] args) {
        // 引用构造方法来创建新对象
        // Example，将集合中的元素封装到对象中，并且存储在另外一个集合中
        List<String> actorList = new ArrayList<>();
        Collections.addAll(actorList,"Jony,20","Tom,30","Jerry,40");
        // 使用Lambda创建Actor对象
        List<Actor> actors = actorList.stream().map(s -> {
            String[] arr = s.split(",");
            return new Actor(arr[0], Integer.parseInt(arr[1]));
        }).collect(Collectors.toList());

        // 使用方法引用创建Actor对象
        List<Actor> actors2 = actorList.stream().map(Actor::new).collect(Collectors.toList());
    }
}
