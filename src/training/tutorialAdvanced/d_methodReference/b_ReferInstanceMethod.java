package training.tutorialAdvanced.d_methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class ParentClass{
    public void printMSG(String msg) {
        System.out.println(msg);
    }
}

class ChildClass extends ParentClass{
    public void printUpperCase(String msg) {
        System.out.println(msg.toUpperCase());
    }

    public void processing(){
        List<String> demoList = new ArrayList<>();
        Collections.addAll(demoList," a","b","c","d","e");
        // 1. 引用本类的实例方法
        demoList.forEach(this::printUpperCase);
        // 2. 引用父类的实例方法
        demoList.forEach(super::printMSG);
    }
}


public class b_ReferInstanceMethod extends ParentClass{

    public static void main(String[] args) {
        // 3. 引用类的实例方法
        List<String> demoList = new ArrayList<>();
        Collections.addAll(demoList," a","b","c","d","e");
        demoList.forEach(new ParentClass()::printMSG);

    }
}
