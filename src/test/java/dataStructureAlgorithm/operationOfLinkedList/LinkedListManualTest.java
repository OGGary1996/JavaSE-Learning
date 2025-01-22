package dataStructureAlgorithm.operationOfLinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinkedListManualTest {
    LinkedListManual list;

    @BeforeAll
    void setUp() {
        list = new LinkedListManual();
    }
    @AfterAll
    void tearDown() {
        list = null;
    }
    @Test
    void insertAtStart() {
        list.insertAtStart(10);
        list.insertAtStart(20);
        assertEquals(20,list.head.data);
    }

    @Test
    void insertAtEnd() {
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        assertEquals(40,list.head.next.next.data);
    }

    @Test
    void insertAt() {
        list.insertAt(0,50);
        list.insertAt(1,60);
        assertEquals(60,list.head.next.data);
    }

    @Test
    void deleteAtStart() {
        list.deleteAtStart();
        assertEquals(10,list.head.data);
    }

    @Test
    void deleteAtEnd() {
        list.deleteAtEnd();
        assertEquals(20,list.head.data);
    }

    @Test
    void deleteAt() {
        list.deleteAt(1);
        assertEquals(50,list.head.data);
    }

    @Test
    void show() {
        list.show();
    }

    @Test
    void reverseList() {
        list.reverseList();
        assertEquals(40,list.head.data);
    }

}