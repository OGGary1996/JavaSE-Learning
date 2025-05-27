package Reflection.f_dynamicProxy;

// 这个接口规定了原始类和代理类都要实现的方法
public interface UserService {
    public abstract void login(String username);
    public abstract void register(String username);

}
