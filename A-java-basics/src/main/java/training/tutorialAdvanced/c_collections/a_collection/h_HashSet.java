package training.tutorialAdvanced.c_collections.a_collection;
import java.util.Objects;

/*
1.1 HashCode
* 根据hashCode方法计算出来的int类型的正数，代表了这个对象
* 这个方法定义在Object类，所有对象都可以调用，默认使用地址值进行计算
* 一般情况下，会重写hashCode方法，利用对象内部的属性进行计算hashCode；避免相同属性的不同对象的结果是不同的

1.2 对象的hashCode特点
* 如果没有重写hashCode方法，不同对象计算的hashCode是不同的
* 在小部分情况下，不同属性值或者不同地址值计算的hashCode可能也会一样（hash collision 哈希碰撞）；因为int的范围是有限的
*/

class DemoJavaBean {
    private String name;
    private int age;

    public DemoJavaBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DemoJavaBean that = (DemoJavaBean) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "DemoJavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


public class h_HashSet {
    public static void main(String[] args) {
        // Hash Code经过重写的方法计算之后，计算的结果应该是不同的
        DemoJavaBean demo1 = new DemoJavaBean("John Smith", 18);
        DemoJavaBean demo2 = new DemoJavaBean("John Smith", 18);
        System.out.println(demo1.hashCode());
        System.out.println(demo2.hashCode());
            //此时两个对象的hashCode是相同的，即使是两个对象
        // 但是有小概率遇到hash collision
            // String类内部也重写了hashCode方法，但是可能会出现不同的对象hashCode相同
        System.out.println("abc".hashCode());
        System.out.println("acD".hashCode());
    }
}
