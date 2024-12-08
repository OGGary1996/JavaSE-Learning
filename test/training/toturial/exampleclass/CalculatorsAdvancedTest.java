package training.toturial.exampleclass;

import org.junit.jupiter.api.*;
import training.tutorial.exampleclass.CalculatorsAdvanced;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 指定测试方法执行顺序
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 指定测试实例的生命周期，测试类只会实例化一次
class CalculatorsAdvancedTest {
    CalculatorsAdvanced calc;

    @BeforeEach // 为所有方法创建calc对象
    void setUp(){
        calc = new CalculatorsAdvanced();
        System.out.println("This will show before each test method");
    }
    @AfterEach // 为所有方法销毁calc对象
    void tearDown(){
        calc = null;
        System.out.println("This will show after each test method");
    }

    @BeforeAll
    static void init(){ // 在所有测试方法之前执行一次，只能为静态方法
        System.out.println("This will show before all test methods, only once.");
    }
    @AfterAll
    static void clean(){ // 在所有测试方法之后执行一次，只能为静态方法
        System.out.println("This will show after all test methods, only once.");
    }
    @Test
    @Order(3)  // 指定测试方法执行顺序
    void divTest0(){
        // 不使用断言，手动判断
            // 抛出异常时，不会运行try中的fail()方法，测试通过
            // 不抛出异常时，显式声明失败 fail()
        try{
            calc.div(5,0);
            fail("fail manually"); //
        }catch (ArithmeticException e){
            System.out.println(e + "Divided by 0 will throw arithmetic exception.");
        }
    }

    @Test
    @Order(1)  // 指定测试方法执行顺序
    void divTest1(){
     // 异常断言，判断抛出异常则通过
        // 本判断会通过，因为num2 = 0，会抛出异常
     assertThrows(ArithmeticException.class, () -> {
         calc.div(5,0);
     },"Divided by 0 should throw arithmetic exception.");
    }

    @Test
    @Order(2)  // 指定测试方法执行顺序
    void divTest2(){
        // 异常断言，判断不抛出异常则通过
            // 本判断会通过，因为num2 ！= 0，不会抛出异常
        assertDoesNotThrow(() -> {calc.div(5,2);},"should not throw any exception.");
    }

}