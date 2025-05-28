package training.tutorial.exampleClass;

public class PersonalInfo {
    private String name;
    private int age;
    public PersonalInfo(String name, int age){ //虽然是private变量 但是仍然可通过constructor在new object时传递参数并初始化变量
        this.name = name;               // 在之后就无法直接传递并修改变量了
        this.age = age;                 // 也可以不设置constructor，因为在后面会设置setter方法来传递参数
    }
    
    public void setname(String name){ //设置setter方法来进行受控制的name参数传递，因为无法在class外部传递参数了
        if(name != null && !name.trim().isEmpty()){ //控制传递的name不为null 且不为空
          this.name = name;
          System.out.println("Set name to:" + this.name);
        }
        else{
            System.out.println("invalid name");
        }
    }
    public void setage(int age){ //控制age参数传递的格式
        if (age >= 0 && age <= 100){ 
            this.age = age;
            System.out.println("Set age to:"+ this.age);
        } 
        else {
            System.out.println("invalid age");
        }
    }

    public String getname(){ //通过设置getter来进行受控制的访问
        return name.toUpperCase(); // 只输出大写的结果
    }
    public int getage(){
        return age;
    }
}
