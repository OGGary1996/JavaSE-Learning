package training.tutorial.exampleClass;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 指定测试方法执行顺序
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 指定测试实例的生命周期，测试类只会实例化一次
class CalculatorsTest {
    Calculators calc;
    @BeforeEach // 为所有方法创建calc对象
    void setUp(){
        calc = new Calculators();
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
    @Order(1)  // 指定测试方法执行顺序
     void testAdd() {
        int result = calc.add(1, 2);
        // assertEquals 断言，判断相等则通过
        assertEquals(3, result);
    }

    @Test
    @Order(2)  // 指定测试方法执行顺序
     void testDiv(){
        double result1 = calc.div(10, 5);
        double result2 = calc.div(5, 2);
        // assertNotEquals 断言,判断不相等则通过
        assertNotEquals(result1, result2,"should be not equal");
    }
}
