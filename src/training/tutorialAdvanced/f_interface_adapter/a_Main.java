package training.tutorialAdvanced.f_interface_adapter;

// 适配器设计模式：
    // 如果一个接口中有很多的方法，但是我们只想实现一部分方法，我们可以使用适配器设计模式。（不能使用接口继承接口的方式，因为实现子接口也必须实现父接口）
    // 实现方式：增加一个中间层作为适配器，这个中间层是一个抽象类，用于实现接口的所有方法（空方法）；然后通过继承这个抽象类来重写我们需要的方法。
    // 命名规则：接口的名字+Adapter。
    // 如果我们想要做方法实现的类已经继承了其他类，那么我们可以使用组合的方式来实现适配器设计模式。

public class a_Main extends ImpleAdapter {
    // 使用适配器模式，只需要实现我们需要的方法
    @Override
    public void method4() {
        System.out.println("method4 is all I need");
    }
}
