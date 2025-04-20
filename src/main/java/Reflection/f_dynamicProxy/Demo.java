package Reflection.f_dynamicProxy;

import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        // 首先创建一个原始类的实例
            // 应该避免创建原始类的实例，而是面向接口，创建接口实现类的实例
        UserService userService = new UserServiceImpl();

        // 然后创建一个代理类的实例
            // 同样，这里创建的不是UserServiceImpl的实例，而是UserService接口的实现类的实例
            // 相当于，原始类和代理类都实现了UserService接口，接口作为了约束
        UserService userProxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),// 类加载器
                userService.getClass().getInterfaces(),// 代理类要实现的接口
                new LogHandler(userService)// 代理类的核心逻辑
        );

        // 通过代理类来调用原始类的方法
        userProxy.login("admin");
        userProxy.register("admin");
    }
}
