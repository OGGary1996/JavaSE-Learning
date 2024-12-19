package training.dataStructureAlgorithm.operationOfStack;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StackManualTest {
    StackManual stack;
    @BeforeAll
    void setUp() {
        stack = new StackManual(5);
    }

    @AfterAll
    void tearDown() {
        stack = null;
    }

    @Test
    @Order(1)
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    @Order(8)
    void isFull() {
        assertFalse(stack.isFull());
    }

    @Test
    @Order(2)
    void push() {
       for (int i = 1; i<=5; i++){
           stack.push(i);
       }
       assertTrue(stack.isFull());
    }

    @Test
    @Order(3)
    void pop() {
        stack.pop();
        assertFalse(stack.isFull());
    }

    @Test
    @Order(4)
    void popAndDelete() {
        stack.popAndDelete();
        assertFalse(stack.isFull());
    }

    @Test
    @Order(5)
    void peek() {
        stack.peek();
        assertEquals(3, stack.peek());
    }

    @Test
    @Order(6)
    void searchByData() {
        int index = stack.searchByData(3);
        assertEquals(2, index);
    }

    @Test
    @Order(7)
    void searchByIndex() {
        int data = stack.searchByIndex(2);
        assertEquals(3, data);
    }

    @Test
    @Order(9)
    void show() {
        stack.show();
    }
}