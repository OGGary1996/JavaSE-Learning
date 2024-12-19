package training.toturial.exampleclass;

import org.junit.jupiter.api.*;
import training.tutorial.exampleclass.CarInfo;
import training.tutorial.exampleclass.CarInfoStreamAPI;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarInfoStreamAPITest {
    CarInfoStreamAPI carInfoStreamAPI;
    List<CarInfo> carGroup;

    @BeforeEach // 为所有方法创建carGroup对象
    void setUp(){
        carInfoStreamAPI = new CarInfoStreamAPI();
        carGroup = new ArrayList<>();
        carGroup.add(new CarInfo(2009,"Mazda"));
        carGroup.add(new CarInfo(2019,"Audi"));
        carGroup.add(new CarInfo(2024,"Subaru"));
        System.out.println("This will show before each test method");
    }
    @AfterEach // 为所有方法销毁carGroup对象
    void tearDown(){
        carGroup = null;
        carInfoStreamAPI = null;
        System.out.println("This will show after each test method");
    }

    @Test
    @Order(1) // 指定测试方法执行顺序
    void yearFilter() {
        // 超时断言，判断超时则测试失败
        assertTimeout(Duration.ofMillis(10),() -> {
            carInfoStreamAPI.yearFilter(carGroup);
        } ,"Time out");
    }

    @Test
    @Order(2) // 指定测试方法执行顺序
    void changeToUppercase() {
        // 超时断言，判断超时则测试失败，与上面的区别是如果判断失败，则立即终止测试的代码
        assertTimeoutPreemptively(Duration.ofMillis(10),() -> {
            carInfoStreamAPI.changeToUppercase(carGroup);
        },"Time out");
    }
}