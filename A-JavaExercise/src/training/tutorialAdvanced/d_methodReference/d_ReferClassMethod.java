package training.tutorialAdvanced.d_methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d_ReferClassMethod {
    public static void main(String[] args) {
        List<String> demoList = new ArrayList<>();
        Collections.addAll(demoList," a","b","c","d","e");
        // 引用String类中的方法
            // 1.这种方式有一定的局限性
            // 2.能够被引用的类只能由原本的函数式接口中抽象方法的参数来决定
            // 3.比如在下面的例子中，原本函数式接口中的参数是String类型（也就是Stream中的元素类型是String），那么只能引用String类中的方法
        demoList.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        // 引用String类中的方法
        demoList.stream().map(String::toUpperCase).forEach(System.out::println);


    }
}
