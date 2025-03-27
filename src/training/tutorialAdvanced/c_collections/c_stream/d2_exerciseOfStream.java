package training.tutorialAdvanced.c_collections.c_stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
* 有两个List集合，其中一个存储6个男演员的名字，年龄；第二个集合存储6个女演员的名字，年龄；
* 要求如下：
* 1. 男演员只要名字是3个字的，并且只要前2个。
* 2. 女演员只要姓杨的，并且不要姓杨的第一个。
* 3. 把过滤后的结果合并到一起，存储到一个新的List集合中。
* 4. 将上一步的演员信息封装成一个对象，包含姓名和年龄两个属性。
* 5. 将所有的演员对象储存在List集合中。
* */

class Actor {
    private String name;
    private int age;
    public Actor(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return age == actor.age && Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class d2_exerciseOfStream {
    public static void main(String[] args) {
        List<String> maleActorList = new ArrayList<>(Arrays.asList("张伟,30","梁朝伟,60","周杰伦,40","刘德华,50","阿杰,25","刘星,30"));
        List<String> famaleActorList = new ArrayList<>(Arrays.asList("杨幂,30","杨紫,25","李冰冰,40","范冰冰,35","刘亦菲,28","杨洋,20"));

        // 1.创建一个List用于保存所有的演员对象
        List<String> actorList = new ArrayList<>();
        // 2. 过滤男演员
        List<String> maleSubList = maleActorList.stream().filter(n -> n.split(",")[0].length() == 3).
                limit(2).collect(Collectors.toList());
        // 3. 过滤女演员
        List<String> famaleSubList = famaleActorList.stream().filter(n -> n.split(",")[0].startsWith("杨"))
                .skip(1).collect(Collectors.toList());
        // 4. 合并两个List
        actorList.addAll(maleSubList);
        actorList.addAll(famaleSubList);

        // 5.创建Actor对象，并且提供方法来设置姓名和年龄
        // 6.再次使用Stream流对上一步获取到的List进行处理，将所有的演员信息封装成一个对象，包含姓名和年龄两个属性，并且返回一个List集合
        List<Actor> resultList = actorList.stream().
                map(a -> {
                    String[] actor = a.split(",");
                    return new Actor(actor[0],Integer.parseInt(actor[1]));
                }).collect(Collectors.toList());

        // 7.打印结果
        System.out.println(resultList);

    }
}
