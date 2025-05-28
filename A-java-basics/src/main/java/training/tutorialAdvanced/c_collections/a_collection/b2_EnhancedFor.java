package training.tutorialAdvanced.c_collections.a_collection;

public class b2_EnhancedFor {
    public static void main(String[] args) {
        // 使用增强for循环遍历集合
        // 1.创建一个集合
        java.util.List<String> list = new java.util.ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        // 2.使用增强for循环遍历集合
        for (String s : list) {
            System.out.println("Element: " + s);
        }
        /*
          方法：
         * 增强for循环是Java5引入的，语法上更简洁
         * 适用于所有Collection
         * 语法：for(元素类型 元素名 : 集合名)
         细节：
         * 增强for循环底层使用了Iterator，所以在遍历的过程中不能修改集合的元素
         * 如果需要修改元素，需要使用Iterator
         */
    }
}
