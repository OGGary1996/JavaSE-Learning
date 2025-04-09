package b_byteStream.c_serializationStream;

// 定义需要进行序列化的类

import java.io.Serial;
import java.io.Serializable;

public class Player implements Serializable { // 实现Serializable接口
    @Serial
    private static final long serialVersionUID = -8897935598901067205L; // 序列化版本号，建议显式声明
    private String name;
    private int age;
    // transient 关键字表示该属性不需要序列化
    private transient String password;

    public Player() {};
    public Player(String name, int age , String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password +
                '}';
    }
}
