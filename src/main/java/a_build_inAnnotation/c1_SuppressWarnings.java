package a_build_inAnnotation;

import java.util.ArrayList;
import java.util.List;

public class c1_SuppressWarnings {
    @SuppressWarnings("unchecked") // 传入参数为"unchecked"，表示忽略未使用泛型的警告
    public static void main(String[] args) {
        // 忽略警告，本例子忽略了List泛型类型的警告
        List list = new ArrayList<>(); // 此处并未使用泛型 <String>
        list.add("Hello");
        list.add("World");
        list.add("!");
        System.out.println(list.get(1));
    }
}
