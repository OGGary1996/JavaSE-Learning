package training.tutorialAdvanced.c_collections.a_collection;
// 泛型接口
interface Processor<T> {
    void process(T t);
}

// 实现方式1: 实现类给出具体类型
class StringProcessor implements Processor<String> {
    @Override
    public void process(String str){
        System.out.println("Processing: " + str);
    }
}
// 实现方式2：使用泛型类实现
class DataProcessor<T> implements Processor<T>{
    @Override
    public void process(T t) {
        System.out.println("Processing: " + t);
    }
}

public class f2_GenericsInterface {
    public static void main(String[] args) {
        new StringProcessor().process("Hello");

        new DataProcessor<Integer>().process(100);
    }
}
