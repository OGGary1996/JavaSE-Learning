package dataStructureAlgorithm;

import dataStructureAlgorithm.operarionOfQueue.CircleQueueManual;

public class l_OperationOfCircleQueue {
    public static void main(String[] args){
        // 通过Circle Queue
        CircleQueueManual queue = new CircleQueueManual(5);
            // Enqueue
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.show1();
            // Dequeue
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        queue.show1();
            // Peek
        System.out.println("Peek: " + queue.peek());

            // Enqueue
        queue.enQueue(6);
        queue.enQueue(7);
        queue.show2(); // 此时6，7将会覆盖之前的数据，实际上6，7会位于0，1位置，但是此时逻辑上的front位于2，rear位于1。

    }

}
