package training.tutorialAdvanced.c_collections.c_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class d1_exerciseOfStream {
    public static void main(String[] args) {
        // 将List中的所有元素进行过滤，筛选出男性，年龄20以上，并且最终使用map接收，key为姓名，value为年龄
        List<String> actorList = new ArrayList<>();
        Collections.addAll(actorList,"张无忌-男-25", "赵敏-女-18", "周芷若-女-20", "张三丰-男-80", "小昭-女-19", "张强-男-20", "张伟-男-30");

        // 使用Stream流进行过滤
        Map<String,Integer> resultMap = actorList.stream().
                filter(s -> "男".equals(s.split("-")[1]) && 20 <Integer.parseInt(s.split("-")[2])).
                collect(Collectors.toMap(s -> s.split("-")[0],s -> Integer.parseInt(s.split("-")[2])));

        // 打印结果
        System.out.println(resultMap);
    }
}
