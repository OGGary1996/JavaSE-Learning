package training.tutorialAdvanced.d_methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyUtils {
    public static void printUpperCase(String str){
        System.out.println(str.toUpperCase());
    }
}

public class a_ReferStaticMethod {
    public static void main(String[] args) {
        List<String> namesList = new ArrayList<>();
        Collections.addAll(namesList,"John", "Jane", "Jack", "Jill");
        // 使用Lambda表达式的写法
        namesList.forEach(n -> MyUtils.printUpperCase(n));
        // 使用方法引用的写法
        namesList.forEach(MyUtils::printUpperCase);
    }
}
