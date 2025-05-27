package training.tutorialAdvanced.c_collections.b_map;

// 在底层原理中，HashMap是通过数组+链表+红黑树的方式来实现的，与HashSet的底层原理是一样的
// 区别：
    // * 在HashSet中添加元素时，如果底层计算出的HashCode相同，此时索引相同；底层会使用equals方法比较元素的属性是否相同。
    // 如果相同，底层的HashMap返回非null值（即默认的PRESENT value），此时add方法返回值为false，表示添加元素失败。
    // 如果不相同，则底层的HashMap存入新的entry，并且返回null，add方法返回true，表示添加元素成功。

    // * 在HashMap中，添加元素时同样使用key来计算HashCode，如果此时索引相同，底层使用equals方法比较key的属性是否相同。
    // 如果相同，则替换掉原有的value，返回原有的value；如果key不相同，则返回null。


import java.util.*;

public class c_HashMap {
    public static void main(String[] args) {
        // Example: 模拟80次学生投票，选出4个选项中票数最多的选项
        // 将4个选项先存入数组中
        String[] options = {"A", "B", "C", "D"};
        // 模拟80次投票，并且将投票结果存入ArrayList中
        List<String> votes = new ArrayList<>();
        Random r = new Random();
        for (int i = 0 ; i < 80 ;i++){
            int index = r.nextInt(options.length); // 0-3
            votes.add(options[index]);
        }
        // 此时已经获取到80次投票结果，接下来我们需要统计每个选项的票数
        // 利用HashMap不可重复并且选票对应选项的特点，使用HashMap来存储选票
        Map<String,Integer> voteMap = new HashMap<>();
        // 遍历投票结果，将选票存入HashMap中
        for (String vote: votes){
            if (voteMap.containsKey(vote)){ // 如果此时Map中存在这个选项，则需要覆盖其中的票数
                Integer count = voteMap.get(vote); // 获取当前的选票
                count++; // 票数加1
                voteMap.put(vote,count); // 更新Map中的票数
            }else{ // 如果不存在选票，则直接添加选项并且将选票设置为1
                voteMap.put(vote,1);
            }
        }
        // 遍历Map，获取到最高的票数及其对应的选项
        Set<Map.Entry<String,Integer>> entrySet = voteMap.entrySet();
        // 1.使用增强for循环
        String maxOption = null; // 最高票数对应的选项
        int maxCount = 0; // 最高票数
        for (Map.Entry<String,Integer> entry : entrySet){
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                maxOption = entry.getKey();
            }
        }
        System.out.println("选票统计结果：" + maxOption + "的票数为" + maxCount);
    }
}
