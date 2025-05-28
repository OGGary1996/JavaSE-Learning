package dataStructureAlgorithm.algorithmOfArray;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 指定测试方法执行顺序
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortOfArrayTest {

    public int[] nums;
    public int[] expected;

    @BeforeEach
    void setUp() {
        nums = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @AfterEach
    void tearDown() {
        nums = null;
        expected = null;
    }

    @Test
    @Order(1)
    void isSorted() {
        assertFalse(SortOfArray.isSorted(nums)); // if the array is not sorted, return false, test pass
    }

    @Test
    @Order(2)
    void bobbleSort() {
        SortOfArray.bobbleSort(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    @Order(3)
    void selectionSort() {
        SortOfArray.selectionSort(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    @Order(4)
    void insertionSort() {
        SortOfArray.insertionSort(nums);
        assertArrayEquals(expected, nums);
    }
}