package Reflection.f_dynamicProxy;

// 原始类
// 实现了UserService接口
public class UserServiceImpl implements UserService {
    @Override
    public void login(String username) {
        System.out.println("User " + username + " logged in.");
    }
    public void register(String username) {
        System.out.println("User " + username + " registered.");
    }
}
