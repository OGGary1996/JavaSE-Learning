package training.tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import training.tutorial.exampleClass.PersonInfo;

// 使用Collections类中的方法
// Collections 类是一个包装类，它包含有各种有关集合操作的静态方法。
public class x_CollectionAPI3_Collections {
    public static void main(String args[]){
    // .sort()方法
        /* Comparator：
        *   用于对 List 集合中的元素进行排序,但是如果collection中的元素是自定义类的对象
        *   那么可以将Comparator class的实例作为参数传递给.sort()方法，以便对自定义类的对象进行排序，
        *   Comparator class中的compare方法定义了比较的逻辑。
        */

        //example 1: 使用常规的匿名内部类
        List<PersonInfo> people = new ArrayList<PersonInfo>();
        people.add(new PersonInfo("Tom", 25, 'F'));
        people.add(new PersonInfo("Bob", 36, 'M'));
        people.add(new PersonInfo("Gary", 32, 'M'));
        people.add(new PersonInfo("Alice", 23, 'F'));
        // 如果需要对集合中元素的age进行排序，可以使用.sort()方法+Comparator class
        // 1.1 创建一个Comparator class的实例（使用普通匿名内部类）
        Comparator<PersonInfo> ageComparator1 = new Comparator<PersonInfo>(){
            public int compare(PersonInfo people1, PersonInfo people2){
                if (people1.getAge() > people2.getAge()){ // 如果people1的age大于people2的age，返回1,表示people1排在people2后面
                    return 1;
                } else if (people1.getAge() < people2.getAge()){ // 如果people1的age小于people2的age，返回-1,表示people1排在people2前面
                    return -1;
                } else {
                    return 0; // 如果people1的age等于people2的age，返回0
                }
            }
        };
        // 1.2 使用.sort()方法对集合进行排序
        Collections.sort(people, ageComparator1);
        // 1.3 遍历集合查看排序结果
        for (PersonInfo people_n : people){
            people_n.print_info();
        }

        //example 2: 使用Lambda表达式对年龄排降序
        Comparator <PersonInfo> ageComparator2 = (people1,people2) -> people1.getAge() < people2.getAge() ? 1:-1;
        Collections.sort(people, ageComparator2);
        for (PersonInfo people_n : people){
            people_n.print_info();
        }
        /* Comparable接口
        *   Comparable 接口是一个包含一个方法的接口，该方法用于对类的对象进行自然排序。
        *   我们使一个class 继承 Comparable 接口，并实现 compareTo() 方法，在conpareTo方法中定义排序的逻辑以便对类的对象进行排序。
        */

        //example 3: 使用Comparable接口对name进行排序
        // 3.1 使用一个实现了Comparable接口的类 PersonInfo
        Collections.sort(people); // 可以直接使用.sort()方法对实现了Comparable接口的类进行排序
        for (PersonInfo people_n : people){
            people_n.print_info();
        }

    }
}
