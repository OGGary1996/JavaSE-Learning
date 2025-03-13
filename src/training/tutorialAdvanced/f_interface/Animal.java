package training.tutorialAdvanced.f_interface;

public abstract class Animal {
    private String name;
    private int age;
    private long id;
    // 在无参构造方法中调用二参构造方法，目的是为了不必重复验证逻辑，并且不用手动传递id
    public Animal(){
        this("Unknown",0);
    }
    // 在二参构造方法中调用三参构造方法，目的是为了不必重复验证逻辑，并且不用手动传递id
    public Animal(String name, int age){
        this(name,age,System.currentTimeMillis());
    }
    // 在三参构造方法中体现完整的验证逻辑
    public Animal(String name, int age, long id){
        if (name == null){
            throw new NullPointerException("name is null");
        }
        if (age < 0){
            throw new IllegalArgumentException("age is less than 0");
        }
        if (id < 0){
            throw new NullPointerException("id is null");
        }
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public abstract void eat();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
