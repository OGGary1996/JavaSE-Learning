package Reflection.b_getClassObject;

// 通过不同的方式创建Class对象
// 由于一个类只能有一个Class对象，可以通过对比Hashcode来确认他们是否相同的内存地址

// 创建Example类
class User{
    private String name;
    private int id;
    private int age;
    public User(){
    }
    public User(String name, int id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        System.out.println("Name: " + name + ", ID: " + id + ", Age: " + age);
        return null;
    }
}

public class a_getClassObject {
    public static void main(String[] args) {
        try {
            // 1. 通过Class.forName()创建Class对象
            Class<?> class1 = Class.forName("Reflection.b_getClassObject.User");
            // 2. 通过类名.class创建Class对象
            Class<?> class2 = User.class;
            // 3. 通过对象.getClass()创建Class对象
            User user1 = new User();
            Class<?> class3 = user1.getClass();

            // 通过对比Hashcode来确认他们是否相同的内存地址
            if (class1.hashCode() == class2.hashCode() && class2.hashCode() == class3.hashCode()){
                System.out.println("They are the same object");
            } else {
                System.out.println("They are not the same object");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }
    }
}
