package training.dataStructureAlgorithm.algorithmOfArray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuickSortOfArrayTest {
    public static int[] nums;
    public static int[] expected;
    @BeforeEach
    void setUp() {
        nums = new int[]{10, 7, 8, 9, 1, 5};
        expected = new int[]{1, 5, 7, 8, 9, 10};
    }

    @AfterEach
    void tearDown() {
        nums = null;
        expected = null;
    }

    @Test
    void quickSort() {
        QuickSortOfArray.quickSort(nums, 0, nums.length - 1);
        assertArrayEquals(expected, nums);
    }
}