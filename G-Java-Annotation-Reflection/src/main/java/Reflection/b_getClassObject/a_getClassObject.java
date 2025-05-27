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
    public static void main(String[] args) throws ClassNotFoundException {
        // 方法一：通过Class类的精要方法获取
            // 对应类加载的第一阶段，此时编译完成，生成了.class文件
            // 此时并不知道类的具体类型，采用？泛型
        Class<?> userClass1 = Class.forName("Reflection.b_getClassObject.User");
        // 方法二：通过类名.class获取
            // 对应类加载的第二阶段，此时.class文件被加载到方法区，生成了Class对象
            // 此时知道类的具体类型，采用具体类型
        Class<User> userClass2 = User.class;
        // 方法三：通过对象的getClass()方法获取
            // 对应类加载的第三阶段，此时类的实例化完成，生成了对象，直接通过对象的方法获取
            // 此时知道类的具体类型，采用具体类型；但是，无法确定这个对象是User类还是他的子类，所以也需要使用泛型
        User user = new User();
        Class<? extends User> userClass3 = user.getClass();

        // 对比三个Class对象的hashcode
        if (userClass1.hashCode() == userClass2.hashCode() &&
                userClass1.hashCode() == userClass3.hashCode()) {
            System.out.println("三个Class对象的hashcode相同，说明它们是同一个对象");
        }else{
            System.out.println("三个Class对象的hashcode不同，说明它们不是同一个对象");
        }
    }
}
