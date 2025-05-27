package Reflection.f_dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    private final Object target;
    public LogHandler(Object target) {
        this.target = target;
    }
    // 这个方法作为代理类的核心逻辑
    // 定义了方法“被拦截”之后的处理逻辑
    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Throwable {
        System.out.println("[Log] Method " + method.getName() + " is called with args: " + args[0]);
        Object result = method.invoke(this.target, args);
        System.out.println("[Log] Method " + method.getName() + " executed successfully.");
        return result;
    }
}
