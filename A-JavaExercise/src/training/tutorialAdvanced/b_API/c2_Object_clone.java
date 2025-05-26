package training.tutorialAdvanced.b_API;

/*
Java 没有提供默认的深拷贝，所以如果想让一个对象可以被克隆，必须：
* 实现 Cloneable 接口（否则会抛 CloneNotSupportedException）
    * Cloneable接口中没有抽象方法，仅仅作为一个标识符，表示类实现了这个接口的话才能被克隆
* 重写 clone() 方法，并且调用父类的super.clone（）方法。
    * 因为clone方法在Object中被protected修饰，可以在子类的内部使用这个方法，但是如果要在子类的外部使用这个方法，
    需要在子类内部重写这个方法并提升权限等级。
*/


import java.io.*;

class User implements Cloneable,Serializable {
    String name;
    int age;
    int[] progress;
    public User(){

    }
    public User(String name, int age, int[] progress) {
        this.name = name;
        this.age = age;
        this.progress = progress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.name).append(", Age: ").append(this.age).append(", Progress: ");
        for (int i : this.progress) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
    // 重写clone方法
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 使用序列化与反序列化实现深拷贝
    public User deepClone() throws IOException, ClassNotFoundException {
        // 1. 创建一个字节数组输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 2. 创建一个对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        // 3. 将当前对象写入到对象输出流中
        oos.writeObject(this);
        // 4. 创建一个字节数组输入流,需要传递字节数组输出流的字节数组 也就是baos.toByteArray()
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        // 5. 创建一个对象输入流
        ObjectInputStream ois = new ObjectInputStream(bais);
        // 6. 读取对象
        return (User)ois.readObject();
    }
}

class DeepUser extends User implements Cloneable {
    public DeepUser(){
        super();
    }
    public DeepUser(String name,int age,int[] progress){
        super(name,age,progress);
    }

    @Override
    public DeepUser clone() throws CloneNotSupportedException{
        // 先进行浅拷贝
        DeepUser deepUser = (DeepUser) super.clone();
        // 再进行深拷贝，手动创建新的对象
        int[] newProgress = new int[this.progress.length];
        System.arraycopy(this.progress,0,newProgress,0,newProgress.length);
        deepUser.progress = newProgress;
        return deepUser;
    }
}



public class c2_Object_clone {
    public static void main(String[] args) {
        // 1. 浅拷贝
        User user1 = new User("Gary",18,new int[]{1,2,3,4,5,6});
        try {
            Object obj = user1.clone();
            User user2 = (User) obj;
            System.out.println(user2);
            System.out.println(user1 == user2); // false,不同的对象

            // 浅拷贝的印证
            // 修改user2中的非基本数据类型的值，user1中的值也会改变
            // 例外：String类型的值不会改变，因为String是不可变类，如果修改了String，会创建一个新的对象
            user2.name = "Tom";
            user2.progress[0] = 100;
            System.out.println(user1); // Name: Gary, Age: 18, Progress: 100 2 3 4 5 6
            System.out.println(user2); // Name: Tom, Age: 18, Progress: 100 2 3 4 5 6

        }catch (CloneNotSupportedException e){
            System.err.println("CloneNotSupportedException: " + e.getMessage());
        }

        // 2. 深拷贝的实现
        // 2.1 方法一：在clone方法中，针对引用数据类型直接创建新的对象
        DeepUser user3 = new DeepUser("Gary",18,new int[]{1,2,3,4,5,6});
        try {
            DeepUser user4 = user3.clone();
            user4.progress[0] = 100;
            System.out.println(user3); // Name: Gary, Age: 18, Progress: 1 2 3 4 5 6
            System.out.println(user4); // Name: Gary, Age: 18, Progress: 100 2 3 4 5 6
        }catch (CloneNotSupportedException e){
            System.err.println("CloneNotSupportedException: " + e.getMessage());
        }

        // 2.2 方法二：使用io包中的ObjectInputStream和ObjectOutputStream进行深拷贝，序列化和反序列化
        User user5 = new User("Gary",18,new int[]{1,2,3,4,5,6});
        try {
            User user6 = user5.deepClone();
            user6.progress[0] = 100;
            System.out.println(user5); // Name: Gary, Age: 18, Progress: 1 2 3 4 5 6
            System.out.println(user6); // Name: Gary, Age: 18, Progress: 100 2 3 4 5 6
        }catch (IOException | ClassNotFoundException e){
            System.err.println("IOException | ClassNotFoundException: " + e.getMessage());
        }

    }
}
