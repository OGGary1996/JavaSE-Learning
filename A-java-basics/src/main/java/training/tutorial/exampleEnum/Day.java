package training.tutorial.exampleEnum;
// enum中的每个元素都是Day类型的对象，它们是Day类型的实例，这些实例是在Day类中定义的。
public enum Day {
    MONDAY("Start of the work week"),
    TUESDAY("Second day of the work week"), 
    WEDNESDAY("Middle of the work week"), 
    THURSDAY("Fourth day of the work week"),
    FRIDAY("End of the work week"), 
    SATURDAY, // 因为使用了默认构造器，所以这里不需要传入参数
    SUNDAY; // 因为使用了默认构造器，所以这里不需要传入参数

    private String description;

    private Day(){ // 通过默认构造函数使得SATURDAY和SUNDAY的初始化description为Weekend
        this.description = "Finally Weekend";
    }
    private Day(String description){
        this.description = description;
    }

    public String getDescriptiopn(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
