package training.dataStructureAlgorithm;
import java.util.LinkedList;
import training.dataStructureAlgorithm.operationOfLinkedList.*;

public class h_OperationOfLinkedList {
    public static void main(String[] args) {
        // Create a linked list
        // 使用内置的 LinkedListManual 类
        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(5);
        nums.add(10);
        for(Integer num : nums){
            System.out.print(num + " ");
        }
        System.out.println();

        // 使用自己创建的 LinkedListManual 类和 Node 类
        LinkedListManual list = new LinkedListManual();
        list.insertAtStart(5);
        list.insertAtStart(10);
        list.insertAtEnd(15);
        list.insertAt(2, 20);
        list.show();

        list.deleteAtStart();
        list.show();

        list.reverseList();
        list.show();
    }
}
